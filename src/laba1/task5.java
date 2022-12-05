package laba1;

public class task5 {
    public static void main(String[] args) {

        String x = "zxcursed";
        String y = "mama break";

        char ch [] = x.toCharArray();

        for (char c : ch){
            if (y.indexOf(c)!=-1) System.out.print(c);
        }
    }
}
