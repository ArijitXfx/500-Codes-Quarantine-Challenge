public class BinaryTree{
	public static Tree cloneTree(Tree tree){
       		HashMap<Tree, Tree> map = new HashMap<Tree, Tree>();
       		Queue<Tree> oq = new LinkedList<Tree>();
       Queue<Tree> nq = new LinkedList<Tree>();
       Tree newTree = new Tree(tree.data);
       oq.add(tree);
       nq.add(newTree);
       
       while(!oq.isEmpty()){
        Tree oc = oq.poll();
        map.put(oc,oc.random);
        Tree nc = nq.poll();
        if(oc.left!=null){
            nc.left = new Tree(oc.left.data);
            oq.add(oc.left);
            nq.add(nc.left);
        }
        if(oc.right!=null){
            nc.right = new Tree(oc.right.data);
            oq.add(oc.right);
            nq.add(nc.right);
        }
       }
       
       oq.add(newTree);
       while(!oq.isEmpty()){
           Tree curr = oq.poll();
           curr.random = map.get(curr);
           if(curr.left!=null) oq.add(curr.left);
           if(curr.right!=null) oq.add(curr.right);
       }
       return newTree;
     }
}
