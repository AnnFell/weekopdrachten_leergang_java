import nl.duo.weekopdrachten.diceRollingEnhanced.YahtzeeKaart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YahtzeeKaartTest {
    private YahtzeeKaart yahtzeeKaart;

    @BeforeEach
    public void init() {
        this.yahtzeeKaart = new YahtzeeKaart();
    }

    @Test
    public void test() {
        ArrayList<String> testResultaat = yahtzeeKaart.optiesVoorInvullen(new int[]{1, 1, 1, 1, 1});
        System.out.println(testResultaat);
        assertEquals("[Eenen, Chance, Yahtzee!]", testResultaat);
    }
}
