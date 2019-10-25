package ProcessSchedule;

import java.util.*;

public class Process {
    int at, bt, pr, pno;
    Process(int pno, int at, int bt, int pri)
    {
        this.pno = pno;
        this.pr = pri;
        this.at = at;
        this.bt = bt;
    }
}

/// Gantt chart structure
class GChart {
    // process number, start time, complete time,
    // turn around time, waiting time
    int pno, stime, ctime, wtime, ttime;
}

// user define comparative method (first arrival first serve,
// if arrival time same then heigh priority first)
class MyComparator implements Comparator<Process> {

    public int compare(Process o1, Process o2)
    {

        Process p1 = o1;
        Process p2 = o2;
        if (p1.at < p2.at)
            return (-1);

        else if (p1.at == p2.at && p1.pr > p2.pr)
            return (-1);

        else
            return (1);
    }
}


// class to find Gantt chart
class FindGantChart {
    static void findGc(LinkedList<Process> queue)
    {

        // initial time = 0
        int time = 0;

        // priority Queue sort data according
        // to arrival time or priority (ready queue)
        TreeSet<Process> prique = new TreeSet(new MyComparator());

        // link list for store processes data
        LinkedList<GChart> result = new LinkedList<>();

        // process in ready queue from new state queue
        while (queue.size() > 0)
            prique.add(queue.removeFirst());

        Iterator<Process> it = prique.iterator();

        // time set to according to first process
        time = ((Process)prique.first()).at;

        // scheduling process
        while (it.hasNext()) {

            // dispatcher dispatch the
            // process ready to running state
            Process obj =it.next();

            GChart gc1 = new GChart();
            gc1.pno = obj.pno;
            gc1.stime = time;
            time += obj.bt;
            gc1.ctime = time;
            gc1.ttime = gc1.ctime - obj.at;
            gc1.wtime = gc1.ttime - obj.bt;

            /// store the exxtreted process
            result.add(gc1);
        }

        // create object of output class and call method
        new ResultOutput(result);
    }

    static class ResultOutput{

        ResultOutput(LinkedList<GChart> result){
            int total_wt=0;
            int total_tat=0;
            System.out.println("Process_no\t Start_time\t Complete_Time\t TurnAround_time\t Waiting_time");
            Iterator<GChart> iterator=result.iterator();
            while (iterator.hasNext()){
                GChart gc=iterator.next();
                System.out.printf("%7d %14d %9d %15d %18d",gc.pno,gc.stime,gc.ctime,gc.ttime,gc.wtime);
                total_tat+=gc.ttime;
                total_wt+=gc.wtime;
                System.out.println();
            }
            System.out.println("Average waiting time = " +
                    (float)total_wt / (float)result.size());
            System.out.println("Average turn around time = " +
                    (float)total_tat / (float)result.size());

        }
    }

    public static void main(String[] args) {
        int arrivaltime[] = { 1, 2, 3, 4, 5 };
        int bursttime[] = { 3, 5, 1, 7, 4 };
        int priority[] = { 3, 4, 1, 7, 8 };
        LinkedList<Process> processes=new LinkedList<>();
        for(int i=0;i<arrivaltime.length;i++)
        {   Process proc=new Process(i+1,arrivaltime[i],bursttime[i],priority[i]);
            processes.add(proc);
        }

        Collections.sort(processes,new MyComparator());
        findGc(processes);


    }

}