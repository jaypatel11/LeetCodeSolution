/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 10/8/13
 * Time: 5:13 PM
 * To change this template use File | Settings | File Templates.
 */
class TreeNode{

    TreeNode right,left;
    int info;
    void setData(int d)
    {
        info=d;
    }

    int getData()
    {
        return info;
    }

    void setLeft(TreeNode n)
    {
        left=n;
    }

    TreeNode getLeft()
    {
        return left;
    }

    void setRight(TreeNode n)
    {
        right=n;
    }

    TreeNode getRight()
    {
        return right;
    }


}

class Tree{


    TreeNode root=null;
    void insert(int data)
    {
            TreeNode t=new TreeNode();
            t.setData(data);
            if(root==null)
                root=t;
            else
            {
                TreeNode temp=root,prev=null;
                while(temp!=null)
                {
                    prev=temp;
                    if(data<temp.getData())
                        temp=temp.getLeft();
                    else
                        temp=temp.getRight();
                }
                if(data<prev.getData())
                    prev.setLeft(t);
                else
                    prev.setRight(t);
            }

    }

    boolean delete(int data)
    {
        TreeNode temp=root,prev=null;
        while(temp!=null)			//finding node
        {
            if(temp.getData()==data)
                break;
            prev=temp;
            if(data<temp.getData())
                temp=temp.getLeft();
            else
                temp=temp.getRight();
        }
        if(temp==null)
        {
            System.out.println("Node not found");	//node not found
            return false;
        }

        //node has left and right subtrees
        else if(temp.getLeft()!=null&&temp.getRight()!=null)
        {
            prev=temp;
            TreeNode succ=temp.getRight();
            while(succ.getLeft()!=null)
            {
                prev=succ;
                succ=succ.getLeft();
            }
            temp.setData(succ.getData());
            temp=succ;
        }

        else if(temp==root)				//node=root and has only one subtree
        {
            if(temp.getLeft()!=null)
                root=temp.getLeft();
            else
                root=temp.getRight();
        }

        else if(temp.getLeft()==null&&temp.getRight()==null)		//node=leaf
        {
            if(prev.getLeft()==temp)
                prev.setLeft(null);
            else
                prev.setRight(null);
        }

        // node has only one subtree
        else if(temp.getRight()!=null&&temp.getLeft()==null)
        {
            if(prev.getRight()==temp)
                prev.setRight(temp.getRight());
            else
                prev.setLeft(temp.getRight());
        }

        else if(temp.getRight()==null&&temp.getLeft()!=null)
        {
            if(prev.getLeft()==temp)
                prev.setLeft(temp.getLeft());
            else
                prev.setRight(temp.getLeft());
        }
        System.out.println("Node has been deleted");
        return true;
    }

    private int checkHeight(TreeNode root){


        if( root == null ){

            return 0;
        }

        int leftHeight = checkHeight(root.getLeft());

        if(leftHeight == -1)
            return  -1;

        int rightHeight = checkHeight(root.getRight());

        if(rightHeight == -1)
            return  -1;


        if(Math.abs(leftHeight - rightHeight) > 1){

            return  -1;
        }

        return 1+ Math.max(leftHeight, rightHeight);

    }

    boolean isBalanced(){

            if( checkHeight(root) == -1)
                return false;
            return true;
    }

}
public class TreeHeight {


    public static void main(String args[]){

        Tree tree = new Tree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(0);
        tree.insert(-1);tree.insert(-2);

        System.out.println(tree.isBalanced());

    }
}


