package WRP;

public class Node {
    int src;
    DistanceTable dt;
    RoutingTable rt;
    LinkCostTable lt;
    MessageRetransmissionList mrt;

    public Node(DistanceTable dt, RoutingTable rt, LinkCostTable lt, MessageRetransmissionList mrt) {
        this.dt = dt;
        this.rt = rt;
        this.lt = lt;
        this.mrt = mrt;
    }

    public Node(int src,int[][]graph){
        this.src=src;
    }


}
