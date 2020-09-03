public class ConstructBSTPRE{
    static int index;
    int[] preorder;
    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        index = 0;
        return util(preorder[index],Integer.MIN_VALUE, Integer.MAX_VALUE, preorder.length);    
    }
    
    public TreeNode util(int key, int min, int max, int size){
        if(index>=size) return null;
        if(key>min && key<max){
            TreeNode root = new TreeNode(key);
            index++;
            if(index<size){
                root.left = util(preorder[index],min,key,size);
                
            }
            if(index<size){
                root.right = util(preorder[index],key,max,size);
            }
            return root;
        }
        return null;
    }
}
