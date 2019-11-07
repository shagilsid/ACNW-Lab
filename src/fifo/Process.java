package fifo;

import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Process implements Comparable<Process>,Runnable{
	public int arrivalTime;
	public int burstTime;
	public int priority;
	public int startTime;
	public int completeTime;
	public int turnAroundTime;
	public int waitingTime;
	public Process(int arrivalTime, int burstTime, int priority) {
		super();
		this.arrivalTime = arrivalTime;
		this.burstTime = burstTime;
		this.priority = priority;
	}
	
	public Process() {}
	@Override
	public int compareTo(Process p1) {
		if(this.arrivalTime<p1.arrivalTime)
			return -1;
		else if(this.arrivalTime==p1.arrivalTime&&this.priority>p1.priority)
			return -1;
		else
			return 1;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

		
}