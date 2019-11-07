package preemptive;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import fifo.Process;

public class FIFOMultiThread{
	
	
	public static void main(String[] args) {
		int i=0;
		boolean stop=false;
		int arrivaltime[] = { 1, 2, 2, 4, 4 }; 
		int bursttime[] = { 3, 5, 1, 7, 4 }; 
		int priority[] = { 3, 4, 1, 7, 8 }; 
		LinkedList<Process> procList=new LinkedList<Process>();
		
		for(i=0;i<arrivaltime.length;i++) {			
			Process p=new Process(arrivaltime[i],bursttime[i],priority[i]);
			procList.add(p);
		}
		
		Collections.sort(procList);
		
		Iterator<Process> it=procList.iterator();
		
		while(it.hasNext()) {
			Process p=it.next();
			Thread t=new Thread(p);
			while(true) {
				if(i++==p.arrivalTime) {
					t.start();
					break;
				}
			}
			
		}
	}
	
}
