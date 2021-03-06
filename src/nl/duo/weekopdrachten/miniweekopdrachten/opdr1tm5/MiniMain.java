package nl.duo.weekopdrachten.miniweekopdrachten.opdr1tm5;

import java.util.Arrays;

public class MiniMain {
    public static void main(String[] args) {
        // Opdracht 1: Strings aan elkaar plakken
        Utility.printAssignmentHeader(1);
        String word1 = "Hello";
        String word2 = "how";
        String word3 = "are";
        String word4 = "you";
        String sentence = word1 + ", " + word2 + " " + word3 + " " + word4 + "?";
        System.out.println(sentence);
        Utility.printBorder();

        // Opdracht 2: Hoeveel E's?
        Utility.printAssignmentHeader(2);
        int result2 = getAmountOfACharInWord('e', "regenen");
        System.out.println("Amount of e in regenen: " + result2);
        Utility.printBorder();

        // Opdracht 3: Tel het array op
        Utility.printAssignmentHeader(3);
        int[] numbers = {1, 2, 3, 4};
        int result3 = 0;
        for (int number : numbers) {
            result3 += number;
        }
        System.out.println("The array is: " + Arrays.toString(numbers));
        System.out.println("The addition of all the numbers is: " + result3);
        Utility.printBorder();

        // Opdracht 4: Array Sorteren
        Utility.printAssignmentHeader(4);
        int[] unsortedArray = {4, 6, 2, 8, 9, 0, 1, 3, 5, 7};
        System.out.println("At the start: " + Arrays.toString(unsortedArray));
        int[] result4 = sortArray(unsortedArray);
        System.out.println("Result: " + Arrays.toString(result4));
        Utility.printBorder();

        // Opdracht 5: Repareer de auto
        Utility.printAssignmentHeader(5);
        Auto nieuweAuto = new Auto();
        Monteur nieuweMonteur = new Monteur();
        nieuweMonteur.repareerAuto(nieuweAuto);
        Utility.printBorder();
    }

    private static int getAmountOfACharInWord(char letter, String wordToSearch) {
        int totalLetters = 0;
        for (int i = 0; i < wordToSearch.length(); i++) {
            if (wordToSearch.charAt(i) == letter) {
                totalLetters++;
            }
        }
        return totalLetters;
    }

    private static int[] sortArray(int[] arrayToSort) {
        boolean hasFinished = true;
        for (int i = 0; i < arrayToSort.length - 1; i++) {
            // compare a and b
            // rewrite a and b in correct order
            int a = arrayToSort[i];
            int b = arrayToSort[i + 1];

            if (a > b) {
                arrayToSort[i] = b;
                arrayToSort[i + 1] = a;
                hasFinished = false; // if there is something to sort, the algorithm has not reached final pass
            } else {
                arrayToSort[i] = a;
                arrayToSort[i + 1] = b;
            }
        }

        // if hasFinished is true, the array is sorted, so stop and print result
        // if not, call function again
        if (hasFinished) {
            return arrayToSort;
        } else {
            return sortArray(arrayToSort);
        }
    }
}
