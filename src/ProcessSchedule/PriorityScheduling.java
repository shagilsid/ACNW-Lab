package ProcessSchedule;

import java.util.*;

public class PriorityScheduling {
    List<Packet> packetList;

    public PriorityScheduling(List<Packet> packetList) {
        this.packetList = packetList;
    }

    void runProcesses(){
        Stack<Packet> queue=new Stack<>();
        int processIndex=0;
        int nextProcess=1;
        Packet runningPacket=packetList.get(processIndex++);
        Packet nextPacket=packetList.get(nextProcess);

        do{
            if (packetList.size()<=processIndex)
            runningPacket=packetList.get(processIndex++);
            nextPacket=packetList.get(nextProcess);


            for (int i = 1; i <=runningPacket.burst_time; i++) {
                runningPacket.burst_time--;
                if (i==nextPacket.arrival_time) {
                    if (nextPacket.priority > runningPacket.priority) {
                        queue.add(runningPacket);
                        runningPacket=nextPacket;
                    }
                    if (packetList.size()<=nextProcess)
                    nextPacket=packetList.get(++nextProcess);
                }

            }
            packetList.remove(runningPacket);
        }while (!packetList.isEmpty());
    }

    void findWaitingTime(){
        Iterator<Packet> iterator=packetList.iterator();
        while (iterator.hasNext()){

        }
    }

    void startProcess(){

        Packet currentPacket=packetList.get(0);
        packetList.get(0).start_time=0;
        List<Packet> queue=new ArrayList<>();
        int nextIndex=1;
        Packet nextProcess=packetList.get(nextIndex);

        for (int i = 0; i <currentPacket.burst_time; i++) {

            currentPacket.end_time++;

            if (i==nextProcess.arrival_time&&currentPacket.end_time!=0){
                queue.add(nextProcess);
                if (nextProcess.priority>currentPacket.priority) {
                    //queue.add(currentPacket);
                    currentPacket=nextProcess;
                    if (packetList.size()<=nextIndex)
                        nextProcess=packetList.get(++nextIndex);
                    i=0;
                }
            }


        }

    }

    void startProcess1(){
        Packet currentPacket=packetList.get(0);
        packetList.get(0).start_time=0;
        int nextIndex=1;
        Packet nextProcess=packetList.get(nextIndex);

        List<Packet> waitingQueue=new ArrayList<>();
        while(!packetList.isEmpty()){
            if (!waitingQueue.isEmpty())
                //add code to check priority
                currentPacket=packetList.get(0);
            for (int i = 1; i <= currentPacket.burst_time; i++) {
                currentPacket.end_time++;
                if (i==nextProcess.arrival_time&&i!=currentPacket.burst_time){

                    if (nextProcess.priority>currentPacket.priority){
                        waitingQueue.add(currentPacket);
                        currentPacket=nextProcess;
                        if (packetList.size()>=nextIndex)
                            nextProcess=packetList.get(++nextIndex);
                        i=1;

                    }
                }
            }
            packetList.remove(currentPacket);
        }
    }
}
