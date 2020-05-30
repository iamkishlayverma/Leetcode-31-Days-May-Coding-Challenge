class Pair {
    public int index;
    public long distance;
    Pair(int i, long dist) {
        index = i;
        distance = dist;
    }
    public int getIndex() {
        return index;
    }
}
class PairComparator implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        if (p1.distance > p2.distance)
            return 1;
        else if (p1.distance < p2.distance)
            return -1;
        else
            return 0;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int i, j, len = points.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        for (i=0; i<len; i++) {
            long dist = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            Pair pair = new Pair(i, dist);
            pq.add(pair);
        }
        int res[][] = new int[K][2];
        i = 0;
        while (!pq.isEmpty()) {
            if (i == K)
                break;
            res[i] = points[pq.poll().getIndex()];
            i++;
        }
        return res;
    }
}
