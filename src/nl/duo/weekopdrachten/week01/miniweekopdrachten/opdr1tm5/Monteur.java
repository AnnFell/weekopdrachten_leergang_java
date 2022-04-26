package nl.duo.weekopdrachten.week01.miniweekopdrachten.opdr1tm5;

public class Monteur {
    private int reparatiekosten;

    public void repareerAuto(Auto auto) {
        System.out.println("Eens kijken hoe het met de auto is.");
        auto.printStatusOnderdelen();

        // Bereken kosten
        for(int i = 0; i < auto.getOnderdelenKapot().length; i++){
            if (auto.getOnderdelenKapot()[i]){
                addReparatiekosten();
            }
        }
        System.out.println("Reparatiekosten zijn: " + getReparatiekosten());

        // Repareer auto
        auto.setOnderdelenKapot(new boolean[]{false, false, false, false});

        System.out.println("Reparatie compleet.");
        auto.printStatusOnderdelen();
    }

    public int getReparatiekosten() {
        return reparatiekosten;
    }

    public void addReparatiekosten() {
        this.reparatiekosten += 25;
    }
}
