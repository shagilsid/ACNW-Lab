package WRP;

public class LinkCostTable {
    int hopsCount[];
    int updatesPassed[];

    public LinkCostTable(int nodesCount) {
        this.hopsCount = new int[nodesCount];
        this.updatesPassed = new int[nodesCount];
    }
}
