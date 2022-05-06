package nl.duo.weekopdrachten.miniweekopdrachten.opdr8;

public class MainOpdr8 {
    public static void main(String[] args) {
        Kapitein haak = new Kapitein();
        Boot sloepje = new Boot();
        Speedboot zodiac = new Speedboot();
        haak.varen(sloepje);
        haak.varen(zodiac);
    }
}
