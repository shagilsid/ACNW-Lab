package ProcessSchedule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProcessScheduleTest {
    public static void main(String[] args) {
        /*int processes[] = {1, 2, 3};
        int n = processes.length;

        //Burst time of all processes
        int burst_time[] = {10, 5, 8};

        FIFO fifo=new FIFO();
        fifo.findAvgTime(processes, n, burst_time);*/

       Packet p1=new Packet(1,1,20,2);
       Packet p2=new Packet(2,3,13,1);
       Packet p3=new Packet(3,2,10,3);
       List<Packet> packetList=new ArrayList<>();
       packetList.add(p1);
       packetList.add(p2);
       packetList.add(p3);
       Collections.sort(packetList);

       System.out.println(packetList.get(2));

       PriorityScheduling schedule1=new PriorityScheduling(packetList);
       schedule1.startProcess1();


    }
}
