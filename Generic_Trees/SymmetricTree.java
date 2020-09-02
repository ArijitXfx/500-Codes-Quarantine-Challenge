public class SymmetricTree{
	public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.add(root);
        s2.add(root);
        
        while(!s1.isEmpty()){
            TreeNode c1 = s1.pop();
            TreeNode c2 = s2.pop();
            // System.out.println(c1.val+" "+c2.val);
            if(c1==null || c2==null){
                if(c1==null && c2==null) continue;
                else return false;
            }
            if(c1.val!=c2.val) 
                return false;
            s1.push(c1.left);
            s1.push(c1.right);
            s2.push(c2.right);
            s2.push(c2.left);
        }
        return true;
    }
}
