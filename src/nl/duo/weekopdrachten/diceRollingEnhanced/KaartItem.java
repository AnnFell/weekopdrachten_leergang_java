package nl.duo.weekopdrachten.diceRollingEnhanced;

public class KaartItem {
    private final String naam;
    private final String regex;
    private int teBehalenPunten;
    private int waarde;

    public KaartItem(String naam, String regex) {
        this.naam = naam;
        this.regex = regex;
    }

    public KaartItem(String naam, String regex, int teBehalenPunten) {
        this.naam = naam;
        this.regex = regex;
        this.teBehalenPunten = teBehalenPunten;
    }

    public void invullen(int[] worp) {
        if (teBehalenPunten > 6) {
            // Gebruik de officiele punten
            waarde = teBehalenPunten;
        } else if (teBehalenPunten == 0) {
            // Geef het totaal van alle ogen
            for (int steen : worp) {
                waarde += steen;
            }
        } else {
            // Tel alleen de waarde van de stenen die het corresponderende aantal ogen hebben
            for (int steen : worp) {
                if (steen == teBehalenPunten) {
                    waarde += steen;
                }
            }
        }
    }

    public boolean isIngevuld() {
        return waarde > 0;
    }

    public String getNaam() {
        return naam;
    }

    public String getRegex() {
        return regex;
    }

    public int getTeBehalenPunten() {
        return teBehalenPunten;
    }

    public int getWaarde() {
        return waarde;
    }
}
