class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int preLen = prerequisites.length;
        int i;
        LinkedList<Integer> adj[] = new LinkedList[numCourses];
        int indegree[] = new int[numCourses];
        for (i=0; i<numCourses; i++)
            adj[i] = new LinkedList();
        for (i=0; i<preLen; i++) {
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (i=0; i<numCourses; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int node : adj[u]) {
                if (--indegree[node] == 0)
                    q.add(node);
            }
            count++;
        }
        if (count == numCourses)
            return true;
        return false;
    }
}
