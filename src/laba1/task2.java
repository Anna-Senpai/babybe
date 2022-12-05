package laba1;

import java.util.ArrayList;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i<n; i++){
            arr.add((int) (Math.random()*10));
        }
        System.out.println(arr);
        for (int i = 1; i< arr.size(); i+=2){
            if (arr.get(i)%2==0) x++;
        }
        System.out.println(x);
    }
}
