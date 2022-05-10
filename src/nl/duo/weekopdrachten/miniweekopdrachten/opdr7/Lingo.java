package nl.duo.weekopdrachten.miniweekopdrachten.opdr7;

import java.util.Scanner;

public class Lingo {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE_BG = "\u001B[45m";
    public static final String ANSI_YELLOW_BG = "\u001B[43m";
    public static final String ANSI_GREEN_BG = "\u001B[42m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_GREEN = "\u001B[32m";

    private final String oplossing;
    private final char[] voortgang;
    private int aantalPogingen;

    public Lingo() {
        String[] woorden = {"fiets", "varen", "etuis", "gelul"};
        oplossing = woorden[(int) (Math.random() * woorden.length)];
        voortgang = new char[oplossing.length()];
    }

    public void startLingo() {
        System.out.println(ANSI_GREEN_BG + ANSI_BLACK + " ******* Welkom bij Lingo ******* " + ANSI_RESET);
        System.out.println("Raad het woord! Je kunt een woord raden door te typen en op enter te drukken.");
        System.out.println("Als een letter paars is, staat de goede letter op de goede plek.");
        System.out.println("Als een letter geel is, is het een goede letter, maar op de verkeerde plek.");
        System.out.println("Geen gekleurde achtergrond? Dan zit de letter niet in het te raden woord.");
        System.out.println("De lengte van het te raden woord is " + oplossing.length() + ".");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        beurt(scanner);
    }

    private void beurt(Scanner scanner) {
        System.out.println(ANSI_GREEN_BG + ANSI_BLACK + "Typ je woord in:" + ANSI_RESET);
        String woord = scanner.nextLine();

        int validateResult;
        if ((validateResult = validate(woord)) != 0) {
            if (validateResult < 0) {
                System.err.println("Je woord is te kort: er zijn " + oplossing.length() + " letters nodig. Probeer opnieuw.");
            } else {
                System.err.println("Je woord is te lang: er zijn " + oplossing.length() + " letters nodig. Probeer opnieuw.");
            }
            // herstart beurt als invoer niet valide is
            beurt(scanner);
            return;
        }

        evalueerScore(woord);
        aantalPogingen++;

        String score = String.copyValueOf(voortgang);
        if (score.equals(oplossing)) { // geraden!
            System.out.println(ANSI_PURPLE_BG + ANSI_BLACK + " ****** Het woord was inderdaad " + oplossing + "!" + ANSI_RESET);
            System.out.println(ANSI_PURPLE_BG + ANSI_BLACK + " Geraden in " + aantalPogingen + " keer, gefeliciteerd! ****** " + ANSI_RESET);
        } else {
            // nieuwe poging, recursieve aanroep:
            printVoortgang();
            beurt(scanner);
        }
    }

    private void printVoortgang() {
        System.out.print(ANSI_GREEN);
        System.out.print("De huidige stand: ");
        for (int i = 0; i < oplossing.length(); i++) {
            if (voortgang[i] == 0) {
                System.out.print("_");
            } else {
                System.out.print(voortgang[i]);
            }
        }
        System.out.println(ANSI_RESET);
    }

    private void evalueerScore(String woord) {
        for (int i = 0; i < oplossing.length(); i++) {
            char letter = woord.charAt(i);
            if (letter == oplossing.charAt(i)) { // goede letter op goede plek
                voortgang[i] = letter;
                System.out.print(ANSI_PURPLE_BG + ANSI_BLACK + letter + ANSI_RESET);
            } else if (oplossing.indexOf(letter) != -1) { // goede letter op de verkeerde plek
                System.out.print(ANSI_YELLOW_BG + ANSI_BLACK + letter + ANSI_RESET);
            } else {
                System.out.print(letter);
            }
        }
        System.out.println();
    }

    private int validate(String woord) {
        return woord == null ? -1 : woord.length() - oplossing.length();
    }
}