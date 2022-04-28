package nl.duo.weekopdrachten.week01.diceRollingEnhanced;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class YahtzeeSpel {
    private ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<>();
    private Scanner spelScanner;
    private ArrayList<Speler> spelers = new ArrayList<>();
    private int beurtTeller;

    public YahtzeeSpel() {
        // Maak dobbelstenen aan
        for (int i = 0; i < 5; i++) {
            Dobbelsteen steen = new Dobbelsteen();
            dobbelstenen.add(steen);
        }
        // Start input scanner
        spelScanner = new Scanner(System.in);
    }

    public void spelen() {
        maakSpelers();

        System.out.println("Druk op enter om het spel te starten");
        String key = spelScanner.nextLine();


        if (key.equals("")) {
            System.out.println("Het spel is gestart! " + geefSpelerDieAanDeBeurtIs().getNaam() + " kan op enter drukken voor de eerste worp.");

            // Spel loop
            boolean qPress = false;
            while (!qPress) {
                String isKeyPressed = spelScanner.nextLine();
                if (isKeyPressed.equalsIgnoreCase("q")) {
                    System.out.println("Het spel sluit af! Bedankt voor het spelen.");
                    qPress = true;
                } else if (isKeyPressed.equals("")) {
                    worp(geefSpelerDieAanDeBeurtIs());
                    setBeurtTeller();
                    System.out.println("\nDe beurt is aan " + geefSpelerDieAanDeBeurtIs().getNaam()
                            + ". Druk op enter om de dobbelstenen te gooien of typ q + enter om het spel te sluiten.");
                }
            }
        }
    }

    private void worp(Speler speler) {
        int[] blokkeerArray = new int[5];
        Worp worp = new Worp(speler.getNaam());

        // 3x gooien, uitslag wordt opgeslagen in worp
        // zolang het niet de laatste beurt is, krijg je de optie om dobbelstenen vast te houden
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < dobbelstenen.size(); j++) {
                if (blokkeerArray[j] == 0) {
                    dobbelstenen.get(j).werpen();
                    int uitslag = dobbelstenen.get(j).getWaarde();
                    worp.setUitslagPerDobbelsteen(j, uitslag);
                }
            }
            worp.geefUitslag(i);
            if (i != 3) {
                blokkeerArray = vasthouden();
            }
        }

        // Worp toekennen aan speler
        speler.voegWorpToe(worp);
        // TODO: yahtzee check?

        System.out.println("Dit is het einde van je beurt, " + speler.getNaam() + ". Je worp wordt bewaard.");
    }

    private int[] vasthouden() {
        int[] blokkeerArray = new int[5];
        System.out.println("Welke posities wilt u vasthouden? 0 voor geen, anders bv. 124.");
        String input = spelScanner.nextLine();

        // Valideer input
        while (!vasthoudenInputIsValide(input)) {
            input = spelScanner.nextLine();
        }

        // Bereken blokkeerArray
        if (!"0".equals(input)) {
            for (int i = 0; i < input.length(); i++) {
                int index = Character.getNumericValue(input.charAt(i));
                blokkeerArray[index - 1] = 1;
            }
        }

        return blokkeerArray;
    }

    private Speler geefSpelerDieAanDeBeurtIs() {
        return spelers.get(beurtTeller);
    }

    private void setBeurtTeller() {
        if (beurtTeller < spelers.size() - 1) {
            beurtTeller++;
        } else {
            beurtTeller = 0;
        }
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

    private void maakSpelers() {
        System.out.println("****** Yahtzee! ******");
        System.out.println("Hoeveel spelers doen mee? Typ een getal in en druk op enter.");
        String aantalDeelnemers = spelScanner.nextLine();

        while (!Pattern.matches("[0-9]+", aantalDeelnemers)) {
            System.err.println("Voer aub. een getal in.");
            aantalDeelnemers = spelScanner.nextLine();
        }

        for (int i = 1; i <= Integer.parseInt(aantalDeelnemers); i++) {
            System.out.println("\nWat is de naam van speler " + i + "? Typ deze in en druk op enter.");
            String naamSpeler = spelScanner.nextLine();

            while (!Pattern.matches("[a-zA-Z]{3,}", naamSpeler)) {
                System.err.println("Voer aub. een naam in van 3 of meer tekens.");
                naamSpeler = spelScanner.nextLine();
            }

            System.out.println("Bedankt. Speler " + i + " heet: " + naamSpeler);
            spelers.add(new Speler(naamSpeler));
        }
    }
}
