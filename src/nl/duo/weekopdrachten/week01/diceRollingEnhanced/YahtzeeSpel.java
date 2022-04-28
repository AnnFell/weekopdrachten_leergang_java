package nl.duo.weekopdrachten.week01.diceRollingEnhanced;

import java.util.ArrayList;
import java.util.Scanner;

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

        // Maak spelers aan
        System.out.println("****** Yahtzee! ******");
        System.out.println("Hoeveel spelers doen mee? Typ een getal in en druk op enter.");
        int aantalDeelnemers = Integer.parseInt(spelScanner.nextLine());
        for (int i = 1; i <= aantalDeelnemers; i++) {
            System.out.println("\nWat is de naam van speler " + i + "? Typ deze in en druk op enter.");
            String naamSpeler1 = spelScanner.nextLine();
            System.out.println("Bedankt. Speler " + i + " heet: " + naamSpeler1);
            spelers.add(new Speler(naamSpeler1));
        }
    }

    public void spelen() {
        System.out.println("Druk op enter om het spel te starten");
        String key = spelScanner.nextLine();

        boolean qPress = false;

        if (key.equals("")) {
            System.out.println("____________________________________");
            System.out.println("Het spel is gestart! " + geefSpelerDieAanDeBeurtIs().getNaam() + " kan op enter drukken voor de eerste worp.");
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
        int[] filter = new int[5];
        Worp worp = new Worp(speler.getNaam());

        // TODO: stop als filter alles blokkeert

        // 3x gooien, uitslag wordt gelijk opgeslagen in worp
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < dobbelstenen.size(); j++) {
                if (filter[j] == 0) {
                    dobbelstenen.get(j).werpen();
                    int uitslag = dobbelstenen.get(j).getWaarde();
                    worp.setUitslagPerDobbelsteen(j, uitslag);
                }
            }

            worp.geefUitslag(i);

            // zolang het niet de laatste beurt is, krijg je de optie om dobbelstenen vast te houden
            if (i != 3) {
                filter = vasthouden();
            }
        }

        speler.voegWorpToe(worp);

        // TODO: yahtzee check?

        System.out.println("Dit is het einde van je beurt, " + speler.getNaam() + ". Je worp wordt bewaard.");
    }

    private int[] vasthouden() {
        int[] blokkeerArray = new int[5];
        System.out.println("Welke posities wilt u vasthouden? 0 voor geen, anders bv 124.");
        String input = spelScanner.nextLine();

        // TODO: valideer input (alleen cijfers 1-5), q uitfilteren, te vroege enter

        System.out.println("Invoer: " + input);
        if (!input.equals("0")) {
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
}
