package WRP;

public class DistributedBellmanFord {
    int[][] graph;
    RoutingTable[] allRoutingTable;

    DistributedBellmanFord(int[][]graph,RoutingTable[] routingTable){
        this.graph=graph;
        this.allRoutingTable=routingTable;
    }

    RoutingTable[] createRoutingtables(){
        for (int i = 0; i < allRoutingTable.length; i++) {
//            int cost=graph[allRoutingTable[i].src][]
            for (int j = 0; j < allRoutingTable.length; j++) {

            }
        }
        return null;
    }



}
