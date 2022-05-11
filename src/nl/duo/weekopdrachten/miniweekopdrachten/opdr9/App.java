package nl.duo.weekopdrachten.miniweekopdrachten.opdr9;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Vliegend> vliegtHet = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            vliegtHet.add(geefNieuwVliegendObject());
        }

        for (Vliegend object : vliegtHet) {
            System.out.printf("Dit object is een %s, kan het vliegen? %b%n",
                    object.geefType(),
                    object.kanVliegen()
                    );
        }
    }

    public static Vliegend geefNieuwVliegendObject() {
        Vliegend object;
        switch ((int) (1 + Math.random() * 3)) {
            case (1):
                object = new Spreeuw();
                break;
            case (2):
                object = new Vliegtuig();
                break;
            default:
                object = new Leeuw();
        }
        return object;
    }
}
