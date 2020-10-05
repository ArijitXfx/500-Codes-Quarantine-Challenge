import java.util.*;

public class GenerateBinaryStr{
	
	public static void solver(String str){
		Queue<String> q = new LinkedList<String>();
		q.add(str);
		StringBuffer out = new StringBuffer();
		while(!q.isEmpty()){
			String curr = q.poll();
			int index = curr.indexOf("?");
			if(index!=-1){
				q.add(curr.substring(0,index)+"0"+curr.substring(index+1));
				q.add(curr.substring(0,index)+"1"+curr.substring(index+1));
			}else{
				out.append(curr);
				out.append(" ");
			}
		}
		System.out.println(out.toString());
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-->0){
			solver(sc.next());
		}
	}
}