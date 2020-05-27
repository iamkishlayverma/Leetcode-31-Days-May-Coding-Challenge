class Solution {
    public boolean check(HashMap<Integer, Integer> hmap, ArrayList<Integer> graph[], int persons, int val) {
        if (hmap.containsKey(persons))
            return hmap.get(persons) == val;
        hmap.put(persons, val);
        for (int neighbour: graph[persons])
            if (!check(hmap, graph, neighbour, val^1))
                return false;
        return true;
    }
    public boolean possibleBipartition(int N, int[][] dislikes) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        ArrayList<Integer> graph[] = new ArrayList[N+1];
        int i, persons;
        for (i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int edge[] : dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        for (persons=1; persons<=N; persons++)
            if (!hmap.containsKey(persons) && !check(hmap, graph, persons, 0))
                return false;
        return true;
    }
}
