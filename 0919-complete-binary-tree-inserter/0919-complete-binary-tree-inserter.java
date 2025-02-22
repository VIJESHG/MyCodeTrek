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
class CBTInserter {
    private TreeNode root = null;
    private Queue<TreeNode> queue;
    public CBTInserter(TreeNode root) {
        this.root = root;
    }
    
    public int insert(int val) {
        int result = 0;
        queue = new LinkedList<>();
        if(root == null){
            this.root = new TreeNode(val);
            return val;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            result = node.val;
            if(node.left != null) queue.offer(node.left);
            else{
                node.left = new TreeNode(val);
                return result;
            }
            if(node.right != null) queue.offer(node.right);
            else{
                node.right = new TreeNode(val);
                return result;
            }
        }
        return result;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */