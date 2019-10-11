package InterLeaving;

import java.util.Scanner;

public class InterLeaving {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter number of data packets and each packet size");
        int packetCount=scan.nextInt();
        int packetSize=scan.nextInt();
        int originalStream[][]=new int[packetCount][packetSize];

        int k=1;
        for (int i = 0; i < packetCount; i++) {
            for (int j = 0; j < packetSize; j++) {
                originalStream[i][j]=k++;
            }
        }

        System.out.println("Original Stream is:");
        for (int i = 0; i < packetCount; i++) {
            for (int j = 0; j < packetSize; j++) {
                System.out.print(originalStream[i][j]+" ");
            }
            System.out.println();
        }

        int interLeavedStream[][]= new int[packetCount][packetSize];
        for (int i = 0; i < packetCount; i++) {
            for (int j = 0; j < packetSize; j++) {
                interLeavedStream[j][i]=originalStream[i][j];
            }
        }

        System.out.println("Interleaved Stream is");
        for (int i = 0; i < packetCount; i++) {
            for (int j = 0; j < packetSize; j++) {
                System.out.print(interLeavedStream[i][j]+" ");

            }
            System.out.println();
        }


        System.out.println("Enter packet to be lost");
        int lossNumber=scan.nextInt();
        for (int i = 0; i < packetSize; i++) {
            interLeavedStream[lossNumber-1][i]='\u0000';
        }

        System.out.println("Recieved stream is");
        for (int i = 0; i < packetCount; i++) {
            for (int j = 0; j < packetSize; j++) {
                System.out.print(interLeavedStream[i][j]+" ");

            }
            System.out.println();
        }
    }
}
