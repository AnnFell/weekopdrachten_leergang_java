package nl.duo.weekopdrachten.carcase.strings;

public class StringsApp {
    public static void main(String[] args) {
        String myName = "Annelotte";
        System.out.println("The 4th character: " + myName.charAt(3));

        String piet = "Piet";
        System.out.println("Is piet empty? " + piet.isEmpty());
        String nothing = "";
        System.out.println("Is nothing empty? " + nothing.isEmpty());
        String space = " ";
        System.out.println("Is space empty? " + space.isEmpty());
    }
}
