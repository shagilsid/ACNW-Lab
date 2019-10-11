package WRP;

public class WRPTest {
    static int nodesCount=7;
    static int INF=9999;
    public static void main(String[] args) {
        int graph[][]={{0,4,2,INF,INF,INF,INF},
                {4,0,INF,2,3,INF,3},
                {2,INF,3,0,1,4,INF},
                {INF,2,3,0,2,INF,2},
                {INF,INF,1,2,0,7,3},
                {INF,INF,4,INF,7,0,INF},
                {INF,3,INF,2,3,INF,0}};

        RoutingTable[] allRoutingTables=new RoutingTable[nodesCount];
        for (int i = 0; i < nodesCount; i++) {
            RoutingTable r=new RoutingTable(i,nodesCount);
            allRoutingTables[i]=r;
        }

        DistributedBellmanFord df=new DistributedBellmanFord(graph,allRoutingTables);




//        Node one=new Node();

    }
}
