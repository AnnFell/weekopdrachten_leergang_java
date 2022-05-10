package nl.duo.weekopdrachten.carcase.strings;

public class Application {

    public static void main(String[] args) {

        String c = "Compute";
        String d = "r";

        String result = "Computer";

        String concat = c + d;

        System.out.println(concat);

        System.out.println(concat.equals(result));

        StringBuilder b = new StringBuilder();

        // ASSIGNMENT !!!!!!!!!!!
        // create the String "Computer" using this StringBuilder instance
        b.append(c).append(d);

        String computer = b.toString();

        System.out.println(computer.equals("Computer"));
        // SHOULD BE true!!!

        //Bonus
        // Explain why this prints "false"
        System.out.println(computer == result);
        // == compares the references to String objects. They are two different String objects
        // that happen to have the same value. Sometimes this does result in true,
        // as Java uses the heap memory to reuse similarly created string literals.
        // this cannot be the case here, so always false (build using concatenation and stringbuilder).

        // Explain why it is invalid / VERY BAD to compare two Strings with the '=='- operator

    }

}
