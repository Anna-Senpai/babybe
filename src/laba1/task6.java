package laba1;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task6 {
    public static void main(String[] args) {
        String text = "serega 228 100 1001 pirat 1488, 10,1";

        ArrayList<String> arr = new ArrayList<>();

        Pattern pattern = Pattern.compile("(?<![.])\\b[0-1]+\\b(?![.])");;
        Matcher matcher = pattern.matcher(text);


            while(matcher.find()){
                StringTokenizer stringTokenizer = new StringTokenizer(matcher.group(), " ");
                while(stringTokenizer.hasMoreTokens()){
                    arr.add(String.valueOf(stringTokenizer.nextToken()));
                }

            }
            System.out.println(arr);

            for (String i : arr){
                System.out.print(Integer.parseInt(i, 2)+ " ");
            }
    }
}
