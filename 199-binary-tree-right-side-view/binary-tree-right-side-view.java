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
    public List<Integer> rightSideView(TreeNode root) {
           if(root == null) {
            return new ArrayList<>();
         }
          List<Integer> result = new ArrayList<>();
            Queue<TreeNode> que= new LinkedList<>();
           que.offer(root);

            while(!que. isEmpty()) {
                int n = que.size();
                TreeNode node = null;

                while(n-->0){
                    node= que.poll();
                   

                    if(node.left !=null)
                    que.offer(node.left);
                    if(node.right !=null)
                      que.offer(node.right);
                }
                result.add(node.val);
            }
            return result;
    }
}