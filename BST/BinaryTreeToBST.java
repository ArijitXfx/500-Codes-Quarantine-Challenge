import java.util.*;

class Node{
	int data;
	Node left, right;
	
	public Node(int data){
		this.data = data;
	}
}

public class BinaryTreeToBST{
	
	private HashMap<Integer, Integer> nodeIndex = new HashMap<Integer, Integer>();
    
    void getNodeIndex(List<Integer> list){
        for(int i=0;i<list.size();i++)
            nodeIndex.put(list.get(i), i);
    }
    
    Node buildTree(Node root, List<Integer> list){
        if(root==null) return null;
        Node curr = new Node(list.get(nodeIndex.get(root.data)));
        curr.left = buildTree(root.left, list);
        curr.right = buildTree(root.right, list);
        return curr;
    }
    
    Node binaryTreeToBST(Node root)
    {
       // Your code here
       List<Integer> list = new ArrayList<Integer>();
       inorder(root, list);
	   System.out.println(list);
       getNodeIndex(list);
       Collections.sort(list);
       return buildTree(root, list);
    }
    
    void inorder(Node root, List<Integer> list){
        if(root==null) return;
        inorder(root.left,list);
        list.add(root.data);
        inorder(root.right,list);
    }
	
	public static void main(String[] args){
		BinaryTreeToBST obj = new BinaryTreeToBST();
		Node node = new Node(10);
		node.left = new Node(2);
		node.left.left = new Node(7);
		node.left.left.left = new Node(8);
		node.left.left.left.left = new Node(4);
		
		Node newTree = obj.binaryTreeToBST(node);
		List<Integer> list = new ArrayList<Integer>();
		obj.inorder(newTree, list);
		System.out.println(list);
	}
}