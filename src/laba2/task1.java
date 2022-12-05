package laba2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        byte arr[] = new byte[3];

        for (int i = 0; i<arr.length; i++){
            try{
                arr[i] = sc.nextByte();
            }catch (InputMismatchException e){
                System.out.println("Incorrect data");
                System. exit(0);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }catch (Exception e){
                System.out.println("Mama break");
            }
        }
        byte max = arr[0];
        try{

            for(int i = 1; i< 3; i++){
                if(arr[i]>max) max = arr[i];
            }

        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            System. exit(0);
        }catch (Exception e){
            System.out.println("Mama break");
        }

        if(max>0) System.out.println(max);
        else System.out.println("No positive elements");

    }

}
