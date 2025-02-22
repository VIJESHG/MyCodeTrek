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
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stk = new Stack<>();
        int i = 0;
        while(i < traversal.length()){
            int currDepth = 0;
            while(i < traversal.length() && traversal.charAt(i) == '-'){
                currDepth++;
                i++;
            }

            int numStartIndex = i;
            while(i < traversal.length() && Character.isDigit(traversal.charAt(i))){
                i++;
            }
            int nodeVal = Integer.parseInt(traversal.substring(numStartIndex, i));
            TreeNode node = new TreeNode(nodeVal);
            while(stk.size() > currDepth){
                stk.pop();
            }
            if(!stk.isEmpty()){
                if(stk.peek().left == null){
                    stk.peek().left = node;
                }
                else{
                    stk.peek().right = node;
                }
            }
            stk.push(node);
        }
        while(stk.size() > 1){
            stk.pop();
        }
        return stk.pop();
    }
}