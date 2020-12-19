import java.util.*;

public class SmallestDistinctWindow{
	
	public static int noOfDistinctCharacters(String str){
		Set<Character> set = new HashSet<Character>();
		for(int i=0;i<str.length();i++){
			set.add(str.charAt(i));
		}
		return set.size();
	}
	
	public static int solver(String str){
		
		int K = noOfDistinctCharacters(str);
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		int start = 0;
		int end = 0;
		
		int min = Integer.MAX_VALUE;
		while(true){
			if(end==str.length() && map.size()<K) {
			//	System.out.println(start+" "+end+" "+K);	
				break;
			}
			if(start==str.length()) break;
			map.put(str.charAt(end),map.getOrDefault(str.charAt(end),0)+1);
			while(map.size()==K){
				min = Math.min(min,end-start+1);
			//	System.out.println(start+" "+end);
				map.put(str.charAt(start),map.get(str.charAt(start))-1);
				if(map.get(str.charAt(start))==0)
					map.remove(str.charAt(start));
				start++;
			}
			end++;
		}
		return min;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-->0){
			String str = sc.next();
			System.out.println(solver(str));
		}
	}
}