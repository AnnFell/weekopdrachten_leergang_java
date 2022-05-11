package nl.duo.weekopdrachten.miniweekopdrachten.opdr10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VakantieSpel {
    Scanner scanner = new Scanner(System.in);
    List<String> koffer = new ArrayList<>();

    public void spelen() {
        System.out.printf("*** *** Ik ga op vakantie en neem mee...*** ***%n" +
                "> Let op: elk nieuw stuk bagage dat je toevoegt,%n" +
                "> moet beginnen met de laatste letter van de vorige!%n");
        System.out.println("> Stop het spel door op q + enter te drukken");
        beurt();
    }

    public void beurt() {
        // Eerste beurt? bepaal startwoord
        if (koffer.isEmpty()) {
            System.out.println("> Je gaat op vakantie, de koffer is nog leeg. " +
                    "Wat neem je mee? Voer een woord in!");
            String antwoord = haalSpelerInputOp();
            koffer.add(antwoord);
        }

        // Normale beurt
        System.out.println("> Die hadden we nog niet! Wat wil je nog meer meenemen?");
        String input = haalSpelerInputOp();
        // Bereken score
        boolean geefNieuweBeurt = scoreBerekenen(input);
        if (geefNieuweBeurt) {
            beurt();
        } else {
            System.out.println("> Bedankt voor het spelen!");
            System.exit(0);
        }
    }

    public String haalSpelerInputOp(String... string) {
        String input = scanner.nextLine();
        if (!valideer(input)) {
            return haalSpelerInputOp(scanner.nextLine());
        }
        return input;
    }

    public boolean scoreBerekenen(String input) {
        // Check of input toegevoegd kan worden in de koffer
        String bagageItem = input.toLowerCase();
        String lastAddedItem = koffer.get(koffer.size() - 1);
        char lastLetter = lastAddedItem.charAt(lastAddedItem.length() - 1);
        if (!koffer.contains(bagageItem) && bagageItem.charAt(0) == lastLetter) {
            // Bagage item geaccepteerd!
            koffer.add(bagageItem);
            return true;
        }

        // Helaas, game over! Geef feedback over de prestatie
        if (koffer.contains(bagageItem)) {
            System.out.println("> Helaas, dat zat al in de koffer!");
        } else {
            System.out.printf("> %s begint niet met een %s!%n",
                    bagageItem,
                    lastAddedItem.charAt(lastAddedItem.length() - 1)
            );
        }
        System.out.print("> Ik ga op vakantie en ik neem mee: ");
        System.out.println(koffer.toString());
        System.out.printf("> Game over, score: %d stuks bagage%n",
                koffer.size());
        return false;
    }

    public boolean valideer(String input) {
        if (input.equalsIgnoreCase("q")) {
            boolean stoppen = echtStoppen();
            if (stoppen) {
                System.exit(0);
            }
        } else if (input.length() <= 2) {
            System.out.println("> Voer een woord in van ten minste 3 letters");
            return false;
        }
        return true;
    }

    public boolean echtStoppen() {
        System.out.println("> Weet u het zeker? Typ 'Y' + enter");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("y");
    }
}
