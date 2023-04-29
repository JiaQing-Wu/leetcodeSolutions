class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] state = new int[graph.length];
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < graph.length; i++){
            if(graph[i].length > 0){
                if(dfs(graph, state, i)){
                    state[i] = 1;
                }else{
                    state[i] = 2;
                }
            }else{
                state[i] = 1;
            }
        }
        for(int i = 0; i < state.length; i++){
            if(state[i] == 1)
                res.add(i);
        }return res;
           
    }

    private boolean dfs(int[][] graph, int[] state, int i){
        if(state[i] != 0)
            return state[i] == 1;
        
        state[i] = 2;
        for(int k = 0; k < graph[i].length; k++){
            int j = graph[i][k];
            if(!dfs(graph, state, j)){
                state[j] = 2;
                return false;
            }
        }state[i] = 1;
        return true;
    }
}