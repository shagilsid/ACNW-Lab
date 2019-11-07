package fifo;

import java.util.Comparator;

class Process implements Comparable<Process>{
	int arrivalTime;
	int burstTime;
	int priority;
	int startTime;
	int completeTime;
	int turnAroundTime;
	int waitingTime;
	public Process(int arrivalTime, int burstTime, int priority) {
		super();
		this.arrivalTime = arrivalTime;
		this.burstTime = burstTime;
		this.priority = priority;
	}
	@Override
	public int compareTo(Process p1) {
		if(this.arrivalTime<p1.arrivalTime)
			return -1;
		else if(this.arrivalTime==p1.arrivalTime&&this.priority>p1.priority)
			return -1;
		else
			return 1;
	}

	
		
}