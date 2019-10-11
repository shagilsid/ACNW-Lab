package DSR;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DSRMain {
    static Scanner scan;
    public static void main(String[] args) {
        scan=new Scanner(System.in);
        int[][] matrix= {{0,1,1,0,1},
                {1,0,0,1,0},
                {1,0,0,0,1},
                {0,1,0,0,0},
                {1,0,1,0,0}};

        Node[] nodes=new Node[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            nodes[i]=new Node(i);
        }

//        PathPacket pathPacket=new PathPacket();

        System.out.println("Enter source node");
        int src=scan.nextInt();
//        pathPacket.nodeList.add(nodes[src]);
        System.out.println("Enter destination node");
        int dest=scan.nextInt();
//        pathPacket.dest=dest;
        nodes[src].sequenceNumber=1;


        List<Node> routeList=getPath(matrix,nodes,src,dest);
        System.out.print("Route is: "+src+" ");
        for (Node n :
                routeList) {
            System.out.print(n+" ");
        }
    }

    private static List<Node> getPath(int[][] matrix, Node[] nodes, int src, int dest) {
        List<Node> list=new ArrayList<>();

        for (int i = 0; i < matrix.length&&!list.contains(nodes[dest]); i++) {
            if (matrix[src][i]==1){
                Node neighbour=nodes[i];
                if (neighbour.sequenceNumber!=1){
                    list.add(neighbour);
                    neighbour.sequenceNumber=1;
                    if (neighbour.src==dest)
                        return list;
                    else
                        list.addAll(getPath(matrix,nodes,i,dest));

                }

            }
        }
        return list;
    }
}

