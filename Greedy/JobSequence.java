import java.util.*;

class Job{
	int deadline;
	int profit;
	
	public Job(int deadline, int profit){
		this.deadline = deadline;
		this.profit = profit;
	}
}

public class JobSequence{
	
	public static void maxProfit(List<Job> jobs){
		Collections.sort(jobs,(j1,j2)->{
			return j2.profit - j1.profit;
		});
		
		int profit = 0;
		int N = jobs.size();
		Set<Integer> set = new HashSet<Integer>();
		for(Job job:jobs){
			for(int i = Math.min(N-1,job.deadline-1);i>=0;i--){
				if(!set.contains(i)){
					profit+=job.profit;
					set.add(i);
					break;
				}
			}
		}
		System.out.println(set.size()+" "+profit);
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-->0){
			int N = sc.nextInt();
			List<Job> jobs = new ArrayList<Job>();
			for(int i=0;i<N;i++){
				int id = sc.nextInt();
				int deadline = sc.nextInt();
				int profit = sc.nextInt();
				jobs.add(new Job(deadline,profit));
			}
			maxProfit(jobs);
		}
	}
}