/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;

        while(root != null){
            if(pVal < root.val && qVal < root.val){
                root = root.left;
            }
            else if(pVal > root.val && qVal > root.val){
                root = root.right;
            }
            else{
                return root;
            }
        }
        return null;
    }
}