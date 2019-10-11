package ProcessSchedule;

public class FIFO {

    void findWaitingTime(int[] processes,int n, int bt[], int wt[]){
        wt[0]=0;

        for (int i = 1; i < n; i++) {
            wt[i]=bt[i-1]+wt[i-1];
        }
    }

    void findTurnAroundTime(int processes[],int n, int[] bt, int wt[], int tat[]){
        for (int i = 0; i < n; i++) {
            tat[i]=bt[i]+wt[i];
        }
    }

    void findAvgTime(int processes[], int n, int bt[]){
        int wt[]=new int[n], tat[]=new int[n];
        int total_wt=0, total_tat=0;

        findWaitingTime(processes, n, bt, wt);

        findTurnAroundTime(processes,n,bt,wt,tat);

        System.out.printf("Processes\tBurst time\t Waiting"
                +" time\t Turn around time\n");

        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
            System.out.printf(" %d", (i + 1));
            System.out.printf(" %15d", bt[i]);
            System.out.printf(" %10d", wt[i]);
            System.out.printf(" %15d", tat[i]);
            System.out.println();
        }

        float avg_waiting = (float)total_wt /(float) n;
        int avg_tat = total_tat / n;
        System.out.printf("Average waiting time = %f", avg_waiting);
        System.out.printf("\n");
        System.out.printf("Average turn around time = %d ", avg_tat);

    }
}
