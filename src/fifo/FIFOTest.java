package fifo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class FIFOTest {
	/* This is first in first out with priority
	 * non preemptive */


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
		
		Iterator<Process> it=procList.iterator();
		int clock=procList.get(0).arrivalTime;
		while(it.hasNext()) {
			Process p=it.next();
			p.startTime=clock;
			p.completeTime=clock+p.burstTime;
			p.turnAroundTime=p.completeTime-p.arrivalTime;
			p.waitingTime=p.turnAroundTime-p.burstTime;
			clock=clock+p.burstTime;
			System.out.println("Start Time "+p.startTime+" complete time "+p.completeTime+" turn around time "+p.turnAroundTime+
					" waiting time "+p.waitingTime);
		}	
		
		
	}
	
	class ProcessComparator implements Comparator<Process>{

		@Override
		public int compare(Process arg0, Process arg1) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}

}
