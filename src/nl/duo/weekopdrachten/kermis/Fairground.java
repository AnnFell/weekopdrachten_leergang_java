package nl.duo.weekopdrachten.kermis;

import java.util.ArrayList;

public class Fairground {
    public static void main(String[] args) {
        ArrayList<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction("Bumper Cars", 1.5, 2));
        attractions.add(new Attraction("Merry-Go-Round", 2, 6));
        attractions.add(new Attraction("Haunted Mansion", 1, 10));
        attractions.add(new Attraction("The Rotor", 3, 1));
        attractions.add(new Attraction("Ferris Wheel", 1.5, 3));
        attractions.add(new Attraction("Whirligig", 1.2, 2));
        attractions.add(new Attraction("Shooting Gallery", 2, 14));
        attractions.add(new Attraction("Hook-A-Duck", 0.5, 20));
        attractions.add(new Attraction("Claw Grabber", 5, 1));
        attractions.add(new Attraction("The Octopus", 2.6, 4));

        int turns = 1;
        while (turns <= 3) {
            System.out.println("*** WHOOP WHOOP starting round " + (turns) + "! ***");
            for (Attraction ride : attractions) {
                boolean wantToEnter = Math.random() > 0.5;
                System.out.printf("The fee for %s is %.2f, do you want to enter? - %s%n",
                        ride.getName(), ride.getPrice(), wantToEnter ? "Yes" : "No");
                if (wantToEnter) {
                    ride.perform();
                }
            }
            turns++;
            System.out.println();
        }

        double totalRevenue = 0;
        for (Attraction ride : attractions) {
            printTicketLine(ride.getName(), ride.getRevenue());
            totalRevenue += ride.getRevenue();
        }
        System.out.println("-------------------------");
        printTicketLine("Total revenue", totalRevenue);
        printTicketLine("Taxes 21%", totalRevenue * 0.21);
    }

    private static void printTicketLine(String description, double amount) {
        System.out.printf("|%-16s|%6.2f|%n", description, amount);
    }
}
