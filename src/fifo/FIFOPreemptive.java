package fifo;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class FIFOPreemptive {
	public static void main(String[] args) {
		int arrivaltime[] = { 1, 2, 2, 4, 4 }; 
		int bursttime[] = { 3, 5, 1, 7, 4 }; 
		int priority[] = { 3, 4, 1, 7, 8 }; 
		LinkedList<Process> procList=new LinkedList<Process>();
		
		for(int i=0;i<arrivaltime.length;i++) {			
			Process p=new Process(arrivaltime[i],bursttime[i],priority[i]);
			procList.add(p);
		}
		
		Collections.sort(procList);
		
		Iterator<Process> it=procList.listIterator();
		int clock=procList.getFirst().arrivalTime;
		
		while(it.hasNext()) {
			Process p=it.next();
			Process p2=it.next();
			
			p.startTime=clock;
			clock++;
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
