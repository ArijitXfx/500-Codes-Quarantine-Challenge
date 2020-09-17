import java.util.*;

public class FirstNonRepeating{
	Queue<Character> q;
	int[] vis;
	
	public FirstNonRepeating(){
		q = new LinkedList<Character>();
		vis = new int[26];
	}
	
	public void solver(char ch, StringBuffer sb){
		vis[ch-'a']++;
		if(vis[ch-'a']==1) q.add(ch);
		while(!q.isEmpty() && vis[q.peek()-'a']>1){
			q.poll();
		}
		sb.append(q.isEmpty()?"-1":q.peek());
		sb.append(" ");
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringBuffer out = new StringBuffer();
		int test = sc.nextInt();
		while(test-->0){
			int N = sc.nextInt();
			FirstNonRepeating obj = new FirstNonRepeating();
			while(N-->0){
				obj.solver(sc.next().charAt(0),out);
			}
			out.append("\n");
		}
		sc.close();
		System.out.println(out.toString());
	}
}