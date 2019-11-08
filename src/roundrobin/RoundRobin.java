package roundrobin;

import java.util.ArrayList;
import java.util.Collections;

public class RoundRobin {

	public static void main(String[] args) {
		int processes[] = { 1, 2, 3};
		int arrivaltime[] = { 1, 1, 1 }; 
        int n = processes.length;

        // Burst time of all processes
        int bursttime[] = {10, 5, 8};
        int priority[] = { 3, 3, 3, };

        // Time quantum
        int quantum = 2;
        ArrayList<fifo.Process> procList=new ArrayList<fifo.Process>();
		
		for(int i=0;i<arrivaltime.length;i++) {			
			fifo.Process p=new fifo.Process(arrivaltime[i],bursttime[i],priority[i]);
			procList.add(p);
		}
		
		int rem_bt[]=new int[procList.size()];
		for(int i=0;i<procList.size();i++) {
			rem_bt[i]=procList.get(i).burstTime;
		}
		
		Collections.sort(procList);
				
		int clock=procList.get(0).arrivalTime;;
		while(true) {
			boolean done=true;
			for(int i=0;i<procList.size();i++) {
				if(rem_bt[i]>0) {
					done=false;
					if(rem_bt[i]>quantum) {
						clock+=quantum;
						rem_bt[i]-=quantum;
					}else {
						clock+=rem_bt[i];
						rem_bt[i]=0;
						procList.get(i).completeTime=clock;
					}
				}
			}
			if(done==true)
				break;
		}
		
		for(int i=0;i<procList.size();i++) {
			fifo.Process p=procList.get(i);
			p.turnAroundTime=p.completeTime-p.arrivalTime;
			p.waitingTime=p.turnAroundTime-p.burstTime;
			
			System.out.println(" turn around time "+(p.turnAroundTime)+
					" waiting time "+(p.waitingTime));
		}

	}

}
