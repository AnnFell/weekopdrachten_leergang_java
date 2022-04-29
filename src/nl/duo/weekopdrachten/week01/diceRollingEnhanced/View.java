package nl.duo.weekopdrachten.week01.diceRollingEnhanced;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class View {
    private Scanner spelScanner;

    public View() {
        // Start input scanner
        spelScanner = new Scanner(System.in);
        System.out.println("*** *** *** Yahtzee! *** *** ***");
    }

    public ArrayList<String> namenSpelersVerzamelen() {

        System.out.println("Hoeveel spelers doen mee? Typ een getal in en druk op enter.");
        ArrayList<String> spelers = new ArrayList<>();

        String aantalSpelers = spelScanner.nextLine();

        while (!Pattern.matches("[0-9]+", aantalSpelers)) {
            System.err.println("Voer aub. een getal in.");
            aantalSpelers = spelScanner.nextLine();
        }

        for (int i = 1; i <= Integer.parseInt(aantalSpelers); i++) {
            System.out.println("\nWat is de naam van speler " + i + "? Typ deze in en druk op enter.");
            String naamSpeler = spelScanner.nextLine();

            while (!Pattern.matches("[a-zA-Z]{3,}", naamSpeler)) {
                System.err.println("Voer aub. een naam in van 3 of meer tekens.");
                naamSpeler = spelScanner.nextLine();
            }

            System.out.println("Bedankt. Speler " + i + " heet: " + naamSpeler);
            spelers.add(naamSpeler);
        }
        return spelers;
    }

    public boolean startSpel() {
        System.out.println("Druk op enter om het spel te starten");
        String key = spelScanner.nextLine();

        if (key.equals("")) {
            System.out.println("Het spel is gestart! De eerste speler kan op enter drukken voor de eerste worp.");
            return true;
        } else {
            return startSpel();
        }
    }

    public String luisterNaarInput() {
        String input = spelScanner.nextLine();
        return input;
    }

    public void sluitSpelAf() {
        System.out.println("Het spel sluit af! Bedankt voor het spelen.");
    }

    public void geefDeBeurtAan(String naamSpeler) {
        System.out.println("\nDe beurt is aan " + naamSpeler
                + ". Druk op enter om de dobbelstenen te gooien of typ q + enter om het spel te sluiten.");
    }

    public String invullenKaart(ArrayList<String> keuzes){
        // Weergeven keuzes
        StringBuilder optiesString = new StringBuilder();
        if (keuzes.size() > 0) {
            optiesString.append("De volgende opties kun je kiezen om in te vullen bij deze worp:");
            for (String keuze : keuzes) {
                optiesString.append(keuzes.indexOf(keuze) + ": " + keuze + " ");
            }
            optiesString.append("\nMaak uw keuze: typ een nummer of kies voor PAS.");
            System.out.println(optiesString);

            // keuze invoeren
            String inputKeuze = spelScanner.nextLine();
            if (inputKeuze.equalsIgnoreCase("PAS")) {
                System.out.println("Ok, u vult deze beurt niets in.");
                return "";
            } else {
                int index = Integer.parseInt(inputKeuze);
                System.out.println("Ok, uw keuze voor " + keuzes.get(index) + " is ingevuld.");
                return inputKeuze;
            }
        } else {
            // geen keuzes mogelijk
            System.out.println("U heeft geen open opties meer om in te vullen bij deze worp. U moet passeren.");
            return "";
        }
    }

    public String vraagWelkeDobbelstenenVasthouden(){
        System.out.println("Welke posities wilt u vasthouden? 0 voor geen, anders bv. 124.");
        String input = spelScanner.nextLine();

        // Valideer input
        while (!vasthoudenInputIsValide(input)) {
            input = spelScanner.nextLine();
        }
        return input;
    }

    private boolean vasthoudenInputIsValide(String input) {
        switch (input) {
            case "":
                System.err.println("Voer een waarde in: 0 voor geen, anders bv. 124.");
                return false;
            case "q":
                System.out.println("U heeft het spel gestopt");
                System.exit(0);
                return false;
            default:
                if (!Pattern.matches("[0-5]{1,5}", input)) {
                    System.err.println("Voer een waarde in: 0 voor geen, anders bv. 124. U kunt maximaal 5 dobbelstenen blokkeren. ");
                    return false;
                }
        }
        return true;
    }

}
