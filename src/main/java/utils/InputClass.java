package utils;/*
Reference: This class is based on Francisco Gomez's lecture material in DIT042.
It's available in the course page on Canvas.
 */

import java.util.Scanner;

public class InputClass {

    public static Scanner input = new Scanner(System.in);


    public static double readDouble( String messageToUser) throws Exception{
        System.out.print( messageToUser );
        double decimalValue = input.nextDouble();
        input.nextLine();


        return decimalValue;
    }

    public static String readLine(String messageToUser ) {
        System.out.print( messageToUser );
        String sentence = input.nextLine();

        return sentence;

    }

    public static int readInt( String messageToUser) throws Exception{
        System.out.print( messageToUser );
        int number = input.nextInt();
        input.nextLine();

        return number;
    }

    public static void closeScanner() {
        input.close();
    }

}
