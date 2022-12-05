package laba1;
//стовець |
import java.util.Scanner;

public class task4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n+1][m];
        int tempArr[] = new int[n+1];

        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = (int) (Math.random() * 20 - 10);
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i<m; i ++){
            for (int j = 0; j<n; j++){
                if ((arr[j][i]<0) && (arr[j][i])%2!=0){
                    sum+=arr[j][i];
                }
            }
            arr[n][i] = sum*(-1);
            System.out.print(arr[n][i]+ " ");
            sum = 0;
        }
        System.out.println();

        for (int i = 0; i < m; i++) {
            int min = arr[n][i];
            int minId = i;
            for (int j = i+1; j < m; j++) {
                if (arr[n][j] < min) {
                    min = arr[n][j];
                    minId = j;
                }
            }
            for (int j = 0; j<n+1; j++){
                tempArr[j] = arr[j][i];
            }
            for (int j = 0; j<n+1; j++){
                arr[j][i] = arr[j][minId];
            }
            for (int j = 0; j<n+1; j++){
                arr[j][minId] = tempArr[j];
            }
        }

        System.out.println();
        for (int i = 0; i<n+1; i++){
            for (int j = 0; j<m; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }




    }
}
