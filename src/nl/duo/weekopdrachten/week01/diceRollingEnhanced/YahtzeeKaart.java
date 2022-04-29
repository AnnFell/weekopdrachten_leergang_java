package nl.duo.weekopdrachten.week01.diceRollingEnhanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class YahtzeeKaart {
    private static final int DEEL_1_BONUS = 35;
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

    public void vulKeuzeIn(String naamKeuze, int[] worp) {
        for (KaartItem item : vakjes) {
            if (item.getNaam().equals(naamKeuze)) {
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

    public int[] berekenEindscore() {
        int[] score = new int[3];
        int deel1 = 0;
        int deel2 = 0;
        for (KaartItem vakje : vakjes) {
            if (vakje.getTeBehalenPunten() > 0 && vakje.getTeBehalenPunten() <= 6) {
                deel1 += vakje.getWaarde();
            } else {
                deel2 += vakje.getWaarde();
            }
        }
        // Deel 1 bonus (waarde behaald boven 63)
        if (deel1 > 63) {
            deel1 += DEEL_1_BONUS;
        }
        score[0] = deel1;
        score[1] = deel2;
        score[2] = deel1 + deel2;
        return score;
    }
}
