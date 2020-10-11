import java.util.*;

class Graph{
	
	int v;
	List<Integer> adjList[];
	
	public Graph(int v){
		this.v = v;
		adjList = new ArrayList[v];
		for(int i=0;i<v;i++){
			adjList[i] = new ArrayList<Integer>();
		}
	}
}

public class MotherVertex{
	
	public static void addEdge(Graph graph, int src, int dest){
		graph.adjList[src].add(dest);
	}
	
	public static boolean isMotherVertext(boolean[] vis){
		for(boolean v:vis){
			if(!v) return false;
		}
		return true;
	}
	
	public static int findMotherVertex(Graph graph){
		boolean[] vis = new boolean[graph.v];
		int suspectMother = -1;
		for(int i=0;i<graph.v;i++){
			if(!vis[i]){
				dfs(i,graph,vis);
				suspectMother = i;
			}
		}
		vis = new boolean[graph.v];
		dfs(suspectMother,graph,vis);
		return isMotherVertext(vis)?suspectMother:-1;
	}
	
	public static void dfs(int v, Graph graph, boolean[] vis){
		vis[v] = true;
		for(int i:graph.adjList[v]){
			if(!vis[i]){
				dfs(i,graph,vis);
			}
		}
	}
	
	public static void main(String[] args){
		Graph graph = new Graph(7);
		addEdge(graph, 0,1);
		addEdge(graph, 0,2);
		addEdge(graph, 1,3);
		addEdge(graph, 4,1);
		addEdge(graph, 5,2);
		addEdge(graph, 5,6);
		addEdge(graph, 6,4);
		addEdge(graph, 6,0);
		System.out.println(findMotherVertex(graph));
	}
}