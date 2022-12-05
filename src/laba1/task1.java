package laba1;

import java.util.Scanner;

//var2
public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b,c;
        double d, x1, x2;

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        d = b*b - 4*a*c;
        if(d<0) System.out.println("Коренів немає");
        else {
            if (d==0) System.out.println("Корінь рівняння: "+ (-b) / (2 * a));
            else {
                x1 = (-b + Math.sqrt(d)) / (2 * a);
                x2 = (-b - Math.sqrt(d)) / (2 * a);
                System.out.println("Корені рівняння: "+ x1 + ", " + x2);
            }
        }

    }
}
