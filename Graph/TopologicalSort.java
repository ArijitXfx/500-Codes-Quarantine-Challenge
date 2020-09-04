public class TopologicalSort{
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) {
        boolean[] vis = new boolean[N];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<N;i++){
            if(!vis[i]){
                util(i,adj,vis,stack);
            }
        }
        int[] res = new int[N];
        int index = 0;
        while(!stack.isEmpty()){
            res[index++] = stack.pop();
        }
        return res;
    }
    
    static void util(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> stack){
        vis[v] = true;
        for(int i:adj.get(v)){
            if(!vis[i]){
                util(i, adj, vis, stack);
            }
        }
        stack.push(v);
    }
}
