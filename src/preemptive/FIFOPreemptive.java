package preemptive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

import fifo.Process;

public class FIFOPreemptive {
	public static void main(String[] args) {
		int arrivaltime[] = { 1, 2, 2, 4, 4 }; 
		int bursttime[] = { 3, 5, 1, 7, 4 }; 
		int priority[] = { 3, 4, 1, 7, 8 }; 
		ArrayList<Process> procList=new ArrayList<Process>();
		
		for(int i=0;i<arrivaltime.length;i++) {			
			Process p=new Process(arrivaltime[i],bursttime[i],priority[i]);
			procList.add(p);
		}
		
		Collections.sort(procList);
		int[] rem_bt=new int[procList.size()];
		
		Iterator<Process> it=procList.iterator();
		for(int i=0;i<procList.size();i++) {
			rem_bt[i]=it.next().burstTime;
		}
		int t=procList.get(0).arrivalTime;
		it=procList.iterator();
		
		while(it.hasNext()) {
			boolean done=true;
			Process p1=it.next();
			Process p2=it.next();
			if(p2.priority>p1.priority) {
				
			}else {
				
				int diff=p2.arrivalTime-p1.startTime;
				t+=diff;
				p1.completeTime=t+diff;
			}
			
		}
	}

}
