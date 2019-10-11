package WRP;

public class RoutingTable {
    int src;
    int shortDistance[];
    int prede[];
    int successor[];
    int pathStatus[];

    public RoutingTable(int src,int nodesCount) {
        this.shortDistance = new int[nodesCount];
        this.prede = new int[nodesCount];
        this.successor = new int[nodesCount];
        this.pathStatus = new int[nodesCount];
        this.src=src;
        this.shortDistance[src]=0;

    }


}
