import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 10/9/13
 * Time: 9:24 PM
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

    public int getHeight(TreeNode root){

        if( root == null ){

            return 0;
        }

        return 1 + Math.max(getHeight(root.getLeft()),getHeight(root.getRight()));
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

    ArrayList<Integer> inorderTraversalIterative(){

        TreeNode current = root;

        Stack<TreeNode> stack = new Stack<TreeNode>();

        if( current == null)
            return null;

        ArrayList<Integer> inorderPath = new ArrayList<Integer>();
        while(!stack.isEmpty() || current != null ){


            while(current != null ){


                stack.push(current);
                current = current.getLeft();
            }

            if(!stack.isEmpty()){


                  TreeNode temp = stack.pop();
                  inorderPath.add(temp.getData());
                    if(temp.getRight() != null)
                    current = temp.getRight();
            }
        }
        return inorderPath;
    }
    ArrayList<Integer> inorderTraversal(TreeNode root){

        return inorderTraversal(root, new ArrayList<Integer>());
    }

    public ArrayList<ArrayList<Integer>> levelOrder() {

        TreeNode current = root;
        ArrayList<ArrayList<Integer>> levelOrderPath = new ArrayList<ArrayList<Integer>>();
        Map<TreeNode, Integer> levelMap = new HashMap<TreeNode, Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null)
            return levelOrderPath;

        queue.add(current);
        levelMap.put(current,0);

        while(!queue.isEmpty()){

            TreeNode head = queue.remove();

            int index =  levelMap.get(head);
            ArrayList<Integer> currentLevel = null;

            if(levelOrderPath.size() <= index){

                currentLevel = new ArrayList<Integer>();

                currentLevel.add(head.getData());
                levelOrderPath.add(currentLevel);
            }

            else{

                 currentLevel = levelOrderPath.get(index);
                 currentLevel.add(head.getData());

            }

            if(head.getLeft() != null ){

                queue.add(head.getLeft());
                levelMap.put(head.getLeft(), index +1);
            }


            if(head.getRight() != null ){

                queue.add(head.getRight());
                levelMap.put(head.getRight(), index +1);

            }
        }
        return levelOrderPath;

    }
    ArrayList<Integer> inorderTraversal(TreeNode root, ArrayList<Integer> inorder){

        if( root == null ){

           return inorder;
        }

        inorderTraversal(root.getLeft(), inorder);
        inorder.add(root.getData());
        inorderTraversal(root.getRight(), inorder);
        return inorder;

    }


    void levelOrderTraversalTopDown(TreeNode root, ArrayList<ArrayList<Integer>> levelOrder, int level){

            ArrayList<Integer> tempNode = null;

            if( root == null)
                return;
            if( levelOrder.size() == level){

                    tempNode = new ArrayList<Integer>();
                    tempNode.add(root.getData());
                    levelOrder.add(tempNode);
            }
            else{

                tempNode = levelOrder.get(level);
                tempNode.add(root.getData());
                levelOrder.set(level, tempNode);

            }

            levelOrderTraversalTopDown(root.getLeft(), levelOrder, level + 1) ;
            levelOrderTraversalTopDown(root.getRight(), levelOrder, level + 1);


    }

    void zigZaglevelOrderTraversalTopDown(TreeNode root, ArrayList<ArrayList<Integer>> levelOrder, int level){

        ArrayList<Integer> tempNode = null;

        if( root == null)
            return;
        if( levelOrder.size() == level){

            tempNode = new ArrayList<Integer>();
            tempNode.add(root.getData());
            levelOrder.add(tempNode);
        }
        else{

            tempNode = levelOrder.get(level);
            tempNode.add(root.getData());
            levelOrder.set(level, tempNode);

        }
        if(level %2 == 0){

            zigZaglevelOrderTraversalTopDown(root.getRight(), levelOrder, level + 1);
            zigZaglevelOrderTraversalTopDown(root.getLeft(), levelOrder, level + 1) ;

        }
        else{

            zigZaglevelOrderTraversalTopDown(root.getLeft(), levelOrder, level + 1) ;
            zigZaglevelOrderTraversalTopDown(root.getRight(), levelOrder, level + 1);

        }

    }

    ArrayList<ArrayList<Integer>> levelOrderTraversalTopDown(){


        ArrayList<ArrayList<Integer>> levelOrder = new ArrayList<ArrayList<Integer>>();

        levelOrderTraversalTopDown(root, levelOrder, 0);
        return levelOrder;
    }

    ArrayList<ArrayList<Integer>> levelOrderTraversalBottomUp(){

        ArrayList<ArrayList<Integer>> levelOrderPath = new ArrayList<ArrayList<Integer>>();
        levelOrderTraversalBottomUpHelper(root, levelOrderPath, 0);

        //Reverse levelorder
        return levelOrderPath;
    }

    private void levelOrderTraversalBottomUpHelper(TreeNode root, ArrayList<ArrayList<Integer>> levelOrderPath, int level) {

        if(root == null)
            return ;

        if(level == levelOrderPath.size()){

            ArrayList<Integer> newLevel = new ArrayList<Integer>();
            levelOrderPath.add(newLevel);
        }


        levelOrderTraversalBottomUpHelper(root.getLeft(), levelOrderPath, level +1);
        levelOrderTraversalBottomUpHelper(root.getRight(), levelOrderPath, level+1);

        levelOrderPath.get(levelOrderPath.size()-level-1).add(root.getData());
    }

    ArrayList<ArrayList<Integer>> zigZagLevelOrderTraversalTopDown(){

        ArrayList<ArrayList<Integer>> levelOrder = new ArrayList<ArrayList<Integer>>();

        ArrayList<TreeNode> currentLevel = new ArrayList<TreeNode>();

        if(root!=null){

            currentLevel.add(root);
        }

        ArrayList<TreeNode> parent = null;
        ArrayList<Integer> currentLevelData = null;
        while(currentLevel.size() > 0){

            parent = currentLevel;
            currentLevelData  = new ArrayList<Integer>();
            currentLevel = new ArrayList<TreeNode>();
            if(levelOrder.size() %2 == 0){

                for(int i = 0; i < parent.size(); i++){

                    currentLevelData.add(parent.get(i).getData());

                }

            }
            else{

                for(int i = parent.size()-1; i >= 0; i--){

                    currentLevelData.add(parent.get(i).getData());

                }
            }
            levelOrder.add(currentLevelData);

            for(TreeNode parents: parent){




                if(parents.getLeft()!=null){

                    currentLevel.add(parents.getLeft());
                }

                if(parents.getRight()!=null){

                    currentLevel.add(parents.getRight());
                }
            }


        }

        return levelOrder;
    }

}
public class TreeTraversal {

     public static void main(String args[]){

         Tree tree = new Tree();
         tree.insert(8);
         tree.insert(3);
         tree.insert(10);
         tree.insert(1);
         tree.insert(6);
         tree.insert(4);
         tree.insert(7);
         tree.insert(14);
         tree.insert(13);

         System.out.println(tree.levelOrder());

         System.out.println(tree.levelOrderTraversalBottomUp());

     }

}
