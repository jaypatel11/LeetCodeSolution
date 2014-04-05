/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 4/4/14
 * Time: 8:56 PM
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

public class ConstructBST {

    public TreeNode constructBSTInorderPostorder(int[] inorder, int[] postorder){

        int inorderStart = 0;
        int inorderEnd = inorder.length -1;
        int postOrderStart = 0 ;
        int postOrderEnd =  postorder.length-1;
        return constructBSTHelper(inorder, postorder, inorderStart, inorderEnd, postOrderStart, postOrderEnd);

    }

    private TreeNode constructBSTHelper(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int postOrderStart, int postOrderEnd) {

        if(inorderStart > inorderEnd || postOrderStart > postOrderEnd)

            return null;

        int currentRootValue = postorder[postOrderEnd];

        TreeNode root = new TreeNode();
        root.setData(currentRootValue);
        int split = inorderStart;

        for(int i = inorderStart; i <= inorderEnd;i++){

            if(currentRootValue == inorder[i]){

                split = i;
                break;

            }

        }

        root.setLeft(constructBSTHelper(inorder, postorder, inorderStart, split -1, postOrderStart, postOrderStart +split- inorderStart -1));
        root.setRight(constructBSTHelper(inorder, postorder, split+1, inorderEnd, postOrderStart + split - inorderStart, postOrderEnd-1));

        return root;

    }

}
