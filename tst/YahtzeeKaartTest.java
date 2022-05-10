import nl.duo.weekopdrachten.diceRollingEnhanced.YahtzeeKaart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class YahtzeeKaartTest {
    private YahtzeeKaart yahtzeeKaart;

    @BeforeEach
    public void init() {
        this.yahtzeeKaart = new YahtzeeKaart();
    }

    @Test
    public void test() {
        ArrayList<String> referentieWaarde = new ArrayList<>(Arrays.asList("Eenen", "Chance", "Yahtzee!"));
        ArrayList<String> testWaarde = yahtzeeKaart.optiesVoorInvullen(new int[]{1, 1, 1, 1, 1});
        Assertions.assertEquals(referentieWaarde, testWaarde);
    }
}
