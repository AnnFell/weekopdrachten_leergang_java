package nl.duo.weekopdrachten.miniweekopdrachten.opdr1tm5;

public class Auto {
    private boolean[] onderdelenKapot = new boolean[4];
    private final String[] onderdelenLabels = {"motor","deur","voorruit","uitlaat"};


    public Auto() {
        for (int i =0; i < onderdelenKapot.length; i++){
            onderdelenKapot[i]= 1 == Math.round(Math.random());
        }
    }

    public void printStatusOnderdelen(){
        System.out.println("Statusrapport auto. Zijn de volgende onderdelen kapot?");
        for (int i = 0; i< onderdelenKapot.length; i++){
            System.out.println("Onderdeel: "+ onderdelenLabels[i]+" " + onderdelenKapot[i]);
        }
    }

    public boolean[] getOnderdelenKapot() {
        return onderdelenKapot;
    }

    public void setOnderdelenKapot(boolean[] onderdelenKapot) {
        this.onderdelenKapot = onderdelenKapot;
    }
}
