package nl.duo.weekopdrachten.week01.diceRollingEnhanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class YahtzeeKaart {
    ArrayList<KaartItem> vakjes = new ArrayList<>();

    public YahtzeeKaart() {
        // TODO check regex deel 1
        vakjes.add(new KaartItem("Eenen", "(?=1)", 1));
        vakjes.add(new KaartItem("Tweeen", "(?=2)", 2));
        vakjes.add(new KaartItem("Drieen", "(?=3)", 3));
        vakjes.add(new KaartItem("Vieren", "(?=4)", 4));
        vakjes.add(new KaartItem("Vijfen", "(?=5)", 5));
        vakjes.add(new KaartItem("Zessen", "(?=6)", 6));
        vakjes.add(new KaartItem("Three of a kind", "([1-5])\1{2,}"));
        vakjes.add(new KaartItem("Carre", "([1-5])\1{3,}"));
        vakjes.add(new KaartItem("Kleine straat", "1234|2345|3456", 30));
        vakjes.add(new KaartItem("Grote straat", "12345|23456", 40));
        vakjes.add(new KaartItem("Full House", "(.)\1{2}(.)\2|(.)\3(.)\4{2}"));
        vakjes.add(new KaartItem("Chance", ".*"));
        vakjes.add(new KaartItem("Yahtzee!", "([1-5])\1{4,}", 50));
    }


    // bekijk worp (welke kan? & is nog niet ingevuld?), geef een lijstje terug met opties
    public ArrayList<String> optiesVoorInvullen(int[] worp) {
        String test = worpArrayNaarString(worp);

        ArrayList<String> mogelijkheden = new ArrayList<>();
        for (KaartItem item : vakjes) {
            if (Pattern.matches(item.getRegex(), test) && !item.isIngevuld()) {
                mogelijkheden.add(item.getNaam());

            }
        }
        return mogelijkheden;
    }

    public void vulKeuzeIn(String naamKeuze, int[] worp){
        for(KaartItem item : vakjes){
            if(item.getNaam().equals(naamKeuze)){
                item.invullen(worp);
            }
        }
    }

    private String worpArrayNaarString(int[] worp) {
        int[] inputWorp = Arrays.copyOf(worp, worp.length);
        Arrays.sort(inputWorp);
        StringBuilder builder = new StringBuilder();
        for (int x : inputWorp) {
            builder.append(x);
        }
        return builder.toString();
    }

    public void berekenEindscore() {
        // TODO afmaken score
        // vakjesboven bonus (waarde boven 63)
        // Waarde benedenvakjes
    }
}
