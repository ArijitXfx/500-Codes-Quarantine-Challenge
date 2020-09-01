public class DeleteWithoutHead{
	void deleteNode(Node node){
         	if(node.next==null) node = null;
         	else{
            		node.data = node.next.data;
            		node.next = node.next.next;
         	}
    	}
}
