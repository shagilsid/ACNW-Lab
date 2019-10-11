package FEC2;

import java.util.Scanner;

public class FEC2 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter number of data packets and each packet size");
        int originalStream[][]={{0,1,0,0},
                {1,1,0,0},
                {0,1,0,1},
                {1,1,1,1},
                {0,0,0,0}}; /*for xor bits*/



        System.out.println("Original Stream is:");
        for (int i = 0; i < originalStream.length-1; i++) {
            for (int j = 0; j < originalStream[i].length; j++) {
                System.out.print(originalStream[i][j]+" ");
            }
            System.out.println();
        }

        for (int i = 0; i < originalStream.length - 1; i++) {
            int count=0;
            for (int j = 0; j < originalStream[i].length; j++) {
                if (originalStream[j][i]==1)
                    count++;
            }
            if (isEven(count))
                setBit(originalStream,0);
            else
                setBit(originalStream,1);
        }

        System.out.println("Sent stream is");
        for (int i = 0; i < originalStream.length; i++) {
            for (int j = 0; j < originalStream[i].length; j++) {
                System.out.print(originalStream[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("Enter packet number to loss");
        int losspacket=scan.nextInt()-1;
        int count=0;
        System.out.println("Recieved stream is");
        for (int i = 0; i < originalStream.length; i++) {
            for (int j = 0; j < originalStream[i].length; j++) {
                if (i==losspacket) {
                    originalStream[i][j]=0;
                    System.out.print(0 + " ");
                }
                else
                System.out.print(originalStream[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("Lost Packet is");
        for (int i = 0; i < originalStream[1].length; i++) {
            count=0;
            for (int j = 0; j < originalStream.length; j++) {

                if (originalStream[j][i]==1)
                    count++;
            }
            if (isEven(count))
                System.out.print(0+" ");
            else
                System.out.print(1+" ");
        }
    }

    static int index=0;
    private static void setBit(int[][] originalStream, int i) {
        originalStream[originalStream.length-1][index++]=i;
    }

    private static boolean isEven(int count) {
        if(count %2!=0)
            return false;
    else
        return true;
    }

}
