package nl.duo.weekopdrachten.week01.miniweekopdrachten.opdr6;

import java.util.Arrays;
import java.util.Scanner;

public class MainOpdr6 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Typ een woord en druk op enter.");

        String word = myObj.nextLine();
        System.out.println("U heeft ingevoerd: " + word);

        char[] letterArray = word.toLowerCase().toCharArray();
        Arrays.sort(letterArray);
        System.out.println("Op alfabetische volgorde is dat " + Arrays.toString(letterArray));
    }
}
