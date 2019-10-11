package WRP;

public class DistanceTable {
    int src;
    int dest[];
    int pred[];
    int dist[];


    public DistanceTable(int src, int nodesCount) {
        this.src = src;
        this.dest = new int[nodesCount];
        this.pred = new int[nodesCount];
        this.dist = new int[nodesCount];
    }


}
