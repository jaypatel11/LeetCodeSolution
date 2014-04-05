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
        return constructBSTInorderPostorderHelper(inorder, postorder, inorderStart, inorderEnd, postOrderStart, postOrderEnd);

    }

    public TreeNode constructBSTInorderPreorder(int[] inorder, int[] preorder){

        int inorderStart = 0;
        int inorderEnd = inorder.length -1;
        int preOrderStart = 0 ;
        int preOrderEnd =  preorder.length-1;
        return constructBSTInorderPreorderHelper(inorder, preorder, inorderStart, inorderEnd, preOrderStart, preOrderEnd);

    }

    private TreeNode constructBSTInorderPreorderHelper(int[] inorder, int[] preorder, int inorderStart, int inorderEnd, int preOrderStart, int preOrderEnd) {


        if(inorderStart > inorderEnd || preOrderStart > preOrderEnd)
            return null;

        int currentRootValue = preorder[preOrderStart];


        TreeNode root = new TreeNode();
        root.setData(currentRootValue);

        int split = inorderStart;

        for(int i = inorderStart; i <= inorderEnd;i++){

            if(currentRootValue == inorder[i]){

                split = i;
                break;

            }

        }

        root.setLeft(constructBSTInorderPreorderHelper(inorder, preorder, inorderStart, split-1, preOrderStart+1, preOrderStart+ split- inorderStart));
        root.setRight(constructBSTInorderPreorderHelper(inorder, preorder, split +1, inorderEnd, preOrderStart + split -inorderStart +1, preOrderEnd));
        return root;
    }

    private TreeNode constructBSTInorderPostorderHelper(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int postOrderStart, int postOrderEnd) {

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

        root.setLeft(constructBSTInorderPostorderHelper(inorder, postorder, inorderStart, split - 1, postOrderStart, postOrderStart + split - inorderStart - 1));
        root.setRight(constructBSTInorderPostorderHelper(inorder, postorder, split + 1, inorderEnd, postOrderStart + split - inorderStart, postOrderEnd - 1));

        return root;

    }

}
