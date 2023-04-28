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
    public List<TreeNode> generateTrees(int n) {
        
        return helper(1, n);

    }

    private List<TreeNode> helper(int lowerBound, int upperBound){
        List<TreeNode> res = new ArrayList<>();
        if(lowerBound > upperBound){
            return null;
        }
        if(lowerBound == upperBound){
            res.add(new TreeNode(upperBound));
            return res;
        }
        for(int i = lowerBound; i <= upperBound; i++){
            List<TreeNode> leftSubTreeList = helper(lowerBound, i - 1);
            List<TreeNode> rightSubTreeList = helper(i+ 1, upperBound);
            if(leftSubTreeList == null && rightSubTreeList == null){
                res.add(new TreeNode(i));
            }else if(leftSubTreeList == null){
                for(TreeNode n : rightSubTreeList){
                    res.add(new TreeNode(i, null, n));
                }
            }else if(rightSubTreeList == null){
                for(TreeNode n : leftSubTreeList){
                    res.add (new TreeNode(i, n, null));
                }
            }else{
                for(TreeNode l : leftSubTreeList){
                    for(TreeNode r : rightSubTreeList){
                        res.add(new TreeNode(i, l, r));
                    }
                }
            }
    
        }return res;

    }
}