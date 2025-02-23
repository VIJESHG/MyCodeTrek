/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Map<Integer, Integer> postIndexMap;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        postIndexMap = new HashMap<>();
        
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }

        return construct(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd) return null; 
        TreeNode root = new TreeNode(preorder[preStart]);

        if (preStart == preEnd) return root;

        int leftChildVal = preorder[preStart + 1]; 
        int leftChildIndex = postIndexMap.get(leftChildVal); 
        int leftSize = leftChildIndex - postStart + 1;

        root.left = construct(preorder, postorder, preStart + 1, preStart + leftSize, postStart, leftChildIndex);
        root.right = construct(preorder, postorder, preStart + leftSize + 1, preEnd, leftChildIndex + 1, postEnd - 1);

        return root;
    }
}