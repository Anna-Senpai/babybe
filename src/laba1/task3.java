package laba1;

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum=0, k=0;

        int m[][] = new int[n][n];

        for (int i = 0; i<n; i++){
            for (int j = 0; j < n; j++)
                m[i][j] = (int) (Math.random()*20 - 10);
        }

        for (int i = 0; i<n; i++){
            for (int j = 0; j < n; j++)
                System.out.print(m[i][j]+" ");
            System.out.println();
        }

        for (int i = 0; i<n; i++){
            for (int j = i+1; j<n; j++){
                if (m[i][j]>0) {
                    k++;
                    sum+=m[i][j];
                }
            }
        }
        System.out.println();
        System.out.println(sum + " " + k);

    }


}
