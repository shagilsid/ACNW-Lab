package aodv;

import java.util.ArrayList;
import java.util.List;

public class aodv2 {

	public static void main(String[] args) {

		List<String> rt = new ArrayList<String>();
		String check_addr;
		Route_Request rreq = new Route_Request(3024, 0, 3, 23, "10.0.0.6", "10.0.0.4");

		check_addr = rreq.dest_IP;
		rt.add("10.0.0.2");
		rt.add("10.0.0.3");
		rt.add("10.0.0.4");
		rt.add("10.0.0.5");
		rt.add("10.0.0.6");
		rt.add("10.0.0.7");
		rt.add("10.0.0.8");
		rt.add("10.0.0.9");
		rt.add("10.0.0.10");
		rt.add("10.0.0.11");
		rt.add("10.0.0.12");
		System.out.println("Routing Table for intermediate node:");
		System.out.println(rt);

		
		if (rt.contains(check_addr)) {
			System.out.println("The destination IP is present, packet will be forwarded!\n");
		} else
			System.out.println("The destination IP is not present in the network");
	}

}