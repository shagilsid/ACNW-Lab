package HammingCode;

import java.util.Scanner;

public class HammingCode {
    static void print(int ar[])
    {
        for (int i = 1; i < ar.length; i++) {
            System.out.print(ar[i]);
        }
        System.out.println();
    }

    // calculating value of redundant bits
    static int[] calculation(int[] ar, int r)
    {
        for (int i = 0; i < r; i++) {
            int x = (int)Math.pow(2, i); //calculate position of redundant bit
            for (int j = 1; j < ar.length; j++) {
                if (((j >> i) & 1) == 1) {
                    if (x != j)
                        ar[x] = ar[x] ^ ar[j]; //XOR 
                }
            }
            System.out.println("r" + x + " = "
                    + ar[x]);
        }

        return ar;
    }

    static int[] generateCode(String str, int M, int r)
    {
        int[] ar = new int[r + M + 1];
        int j = 0;
        for (int i = 1; i < ar.length; i++) {
			/* (Math.log(i) / Math.log(2) changes the base to 2 
			 * Setting 0 at redundant bits position
			 * or setting data bits at other position*/
            if ((Math.ceil(Math.log(i) / Math.log(2))
                    - Math.floor(Math.log(i) / Math.log(2)))
                    == 0) {

                // if i == 2^n for n in (0, 1, 2, .....)
                // then ar[i]=0
                // codeword[i] = 0 ----
                // redundant bits are intialized
                // with value 0
                ar[i] = 0;
            }
            else {

                // codeword[i] = dataword[j]
                ar[i] = (int)(str.charAt(j) - '0');
                j++;
            }
        }
        return ar;
    }

    // Driver code
    public static void main(String[] args)
    {

        // input message
        String str = "1011";
        int M = str.length();
        int r = 1;

        while (Math.pow(2, r) < (M + r + 1)) {
            // r is number of redundant bits
            r++;
        }
        int[] ar = generateCode(str, M, r);

        System.out.println("Generated hamming code ");
        ar = calculation(ar, r);
        print(ar);
        
        ar[7]=0;
        System.out.println("Bit at this position is changed");
        
        print(calculatePosition(ar,r));
    }

	private static int[] calculatePosition(int[] ar, int r) {
		int[] pos=new int[r];
		int k=r-1;
		for (int i = 0; i < r; i++) {
            int x = (int)Math.pow(2, i); //calculate position of redundant bit
            for (int j = 1; j < ar.length; j++) {
                if (((j >> i) & 1) == 1) {
                    if (x != j)
                        ar[x] = ar[x] ^ ar[j]; //XOR 
                }
            }
            pos[k--]=ar[x];
            
        }
		return pos;
		
	}
}
