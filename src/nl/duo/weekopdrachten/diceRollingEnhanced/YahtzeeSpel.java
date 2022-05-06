package nl.duo.weekopdrachten.diceRollingEnhanced;

import java.util.ArrayList;

public class YahtzeeSpel {

    private final ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<>();
    private final View view;
    private final ArrayList<Speler> spelers = new ArrayList<>();
    private final static int MAX_AANTAL_RONDES = 9; // TODO: ophogen wanneer regex compleet is
    private int spelerDieAanDeBeurtIs = 0;
    private int aantalRondes = 0;

    public YahtzeeSpel() {
        // Maak dobbelstenen aan
        for (int i = 0; i < 5; i++) {
            Dobbelsteen steen = new Dobbelsteen();
            dobbelstenen.add(steen);
        }

        // Maak een view
        view = new View();
    }

    public void spelen() {
        //spelers toevoegen
        setSpelers(view.namenSpelersVerzamelen());

        //start spel loop
        if (view.startSpel()) {
            boolean qPress = false;
            while (!qPress) {
                String isKeyPressed = view.luisterNaarInput();

                if (isKeyPressed.equalsIgnoreCase("q")) {
                    view.sluitSpelAf();
                    qPress = true;
                } else if (isKeyPressed.equals("")) {
                    beurt(getSpelerDieAanDeBeurtIs());
                    beurtBijhouden();
                }
            }
        }
    }

    private void setSpelers(ArrayList<String> namen) {
        for (String naam : namen) {
            Speler speler = new Speler(naam);
            spelers.add(speler);
        }
    }

    private void beurtBijhouden() {
        if (aantalRondes >= MAX_AANTAL_RONDES - 1) {
            berekenUitslag();
            // Stop het spel
            System.exit(0);
        } else {
            // alleen speler wijzigen als er meer dan 1 speler is
            if (spelers.size() > 1 && spelerDieAanDeBeurtIs < spelers.size() - 1) {
                spelerDieAanDeBeurtIs++;
            }
            aantalRondes++;
            view.geefDeBeurtAan(getSpelerDieAanDeBeurtIs().getNaam());
        }
    }

    private void beurt(Speler speler) {
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
            worp.printUitslag(i);
            if (i != 3) {
                blokkeerArray = vasthouden();
            }
        }

        // speler vult kaart in
        kaartInvullen(speler, worp.getUitslag());
    }

    private void kaartInvullen(Speler speler, int[] worp) {
        ArrayList<String> keuzes = speler.beschikbareOptiesVanSpeler(worp);
        String inputKeuze = view.invullenKaart(keuzes);

        // Als er een optie is gekozen, vul deze in
        if (inputKeuze.length() > 0) {
            int index = Integer.parseInt(inputKeuze);
            String keuzeNaam = keuzes.get(index);
            speler.vulKeuzeIn(keuzeNaam, worp);
        }
    }

    private int[] vasthouden() {
        String input = view.vraagWelkeDobbelstenenVasthouden();

        // Bereken blokkeerArray
        int[] blokkeerArray = new int[5];
        if (!"0".equals(input)) {
            for (int i = 0; i < input.length(); i++) {
                int index = Character.getNumericValue(input.charAt(i));
                blokkeerArray[index - 1] = 1;
            }
        }
        return blokkeerArray;
    }

    private Speler getSpelerDieAanDeBeurtIs() {
        return spelers.get(spelerDieAanDeBeurtIs);
    }

    private void berekenUitslag() {
        Speler winnaar = spelers.get(0);
        int hoogsteScore = 0;
        for (Speler speler : spelers) {
            int[] score = speler.getEindscore();
            if (score[2] > hoogsteScore) {
                winnaar = speler;
                hoogsteScore = score[2];
            }
            view.printScoreVanSpeler(speler.getNaam(), score);
        }
        // Winnaar weergeven
        view.printWinnaar(winnaar.getNaam());
    }
}
