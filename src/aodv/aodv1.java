package aodv;

class Route_Request
{
    int rreq_ID;
    int reserved;
    int hop_count;
    int seq_num;
    String dest_IP;
    String source_IP;
	public Route_Request(int rreq_ID, int reserved, int hop_count, int seq_num, String dest_IP, String source_IP) {
		super();
		this.rreq_ID = rreq_ID;
		this.reserved = reserved;
		this.hop_count = hop_count;
		this.seq_num = seq_num;
		this.dest_IP = dest_IP;
		this.source_IP = source_IP;
	}
	@Override
	public String toString() {
		return "[RREQ ID=" + rreq_ID + ", Reserved=" + reserved + ", Hop Count=" + hop_count
				+ ", seq_num=" + seq_num + ", Destination IP Address:=" + dest_IP + ", Source IP Address:" + source_IP + "]";
	}
} 
class Route_Reply
{
    int reserved;
    int hop_count;
    int seq_num;
    String dest_IP;
    String source_IP;
    int lifetime;
	public Route_Reply(int reserved, int hop_count, int seq_num, String dest_IP, String source_IP, int lifetime) {
		super();
		this.reserved = reserved;
		this.hop_count = hop_count;
		this.seq_num = seq_num;
		this.dest_IP = dest_IP;
		this.source_IP = source_IP;
		this.lifetime = lifetime;
	}
	@Override
	public String toString() {
		return "[Reserved=" + reserved + ", Hop Count:" + hop_count + ", seq_num=" + seq_num + ", Destination IP Address:"
				+ dest_IP + ", Source IP Address" + source_IP + ", Lifetime in milliseconds=" + lifetime + "]";
	}
} 



public class aodv1 {

	public static void main(String[] args) {
		
		Route_Request rreq= new Route_Request(3024, 0,3,23,"192.168.1.1","192.168.1.4");
		System.out.println("==========================================================\n");
	    System.out.println("Route Request packet:");
	    System.out.println( rreq);
	    System.out.println("==========================================================\n");
    
	    Route_Reply rrep = new Route_Reply(0,1,23,"192.168.1.4", "192.168.1.1",30);
	    System.out.println("Route Reply packet:");
	    System.out.println(rrep);
	    System.out.println("=========================================================\n");
	}
}