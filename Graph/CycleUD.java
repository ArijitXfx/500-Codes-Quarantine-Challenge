import java.util.*;
import java.awt.*;

class Graph{
	int v;
	LinkedList<Integer>[] adj;
	
	public Graph(int v){
		this.v = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i] = new LinkedList<Integer>();
	}
	
	public void addEdge(int src, int dest){
		adj[src].add(dest);
		adj[dest].add(src);
	}
}

public class CycleUD{
	
	private Graph graph;
	
	public int find(int[] parent, int i){
		return parent[i]==-1?i:find(parent,parent[i]);
	}
	
	public void union(int[] parent, int x, int y){
		int xSet = find(parent,x);
		int ySet = find(parent,y);
		parent[xSet] = ySet;
	}
	
	public boolean findCycle(){
		int[] parent = new int[graph.v];
		for(int i=0;i<graph.v;i++)
			parent[i] = -1;
		
		Set<Point> vis = new HashSet<Point>();
		for(int i=0;i<graph.v;i++){
			for(int j:graph.adj[i]){
				Point p1 = new Point(i,j);
				Point p2 = new Point(j,i);
				if(!vis.contains(p1) && !vis.contains(p2)){
					int xSet = find(parent, i);
					int ySet = find(parent, j);
					if(xSet==ySet) 
						return true;
					union(parent,xSet,ySet);
					vis.add(p1);
					vis.add(p2);
				}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args){
		CycleUD obj = new CycleUD();
		obj.graph = new Graph(5);
		obj.graph.adj[0].addAll(Arrays.asList(1,2));
		obj.graph.adj[1].addAll(Arrays.asList(3,4));
		obj.graph.adj[2].addAll(Arrays.asList(0));
		obj.graph.adj[3].addAll(Arrays.asList(4,1));
		obj.graph.adj[4].addAll(Arrays.asList(3,1));
		
		System.out.println(obj.findCycle());
	}
}