package ProcessSchedule;

public class Packet implements Comparable<Packet>{
    int id;
    int arrival_time;
    int burst_time;
    int priority;
    int wait_time;
    int tat;
    int start_time;
    int end_time;

    public Packet(int id,int arrival_time, int burst_time, int priority) {
        this.id=id;
        this.arrival_time = arrival_time;
        this.burst_time = burst_time;
        this.priority = priority;
        wait_time=0;
        tat=0;
        start_time=0;
        end_time=0;
    }

    @Override
    public int compareTo(Packet o) {
        return this.arrival_time-o.arrival_time;
    }

    @Override
    public String toString() {
        return String.format("Process id %d, arrival time %d\n",id, arrival_time);
    }
}
