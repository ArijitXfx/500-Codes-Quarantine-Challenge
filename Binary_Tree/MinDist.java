public class MinDist{
	int d1, d2, dist;
    
    Node findLca(Node root, int a, int b, int lvl){
        if(root==null) 
            return null;
        if(root.data == a){
            d1 = lvl;
            return root;
        }
        if(root.data == b) {
            d2 = lvl;
            return root;            
        }

        Node left = findLca(root.left,a,b,lvl+1);
        Node right = findLca(root.right,a,b,lvl+1);
        if(left!=null && right!=null){
            dist = d1+d2-2*lvl;
            return root;
        }
        return left!=null?left:right;
    }
    
    int findLevel(Node root, int item, int lvl){
        if(root==null) return -1;
        if(root.data==item) return lvl;
        int left = findLevel(root.left,item,lvl+1);
        return left!=-1?left:findLevel(root.right,item,lvl+1);
    }
    
    int findDist(Node root, int a, int b) {
        d1 = -1;
        d2 = -1;
        Node lca = findLca(root,a,b,0);
        // System.out.println(lca.data+" "+d1+" "+d2);
        if(d1!=-1 && d2!=-1) return dist;
        else if(d1==-1) return findLevel(lca,a,0);
        return findLevel(lca,b,0);
    }
}