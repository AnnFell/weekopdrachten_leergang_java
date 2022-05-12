package nl.duo.weekopdrachten.carcase.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < 15; i++) {
            list.add(i);
        }

        // prints the square numbers of an element of the List
        list.stream().map(e -> e * e).forEach(e -> {
            System.out.println(e);
        });

        //maps the list to the square list
        list = list.stream().map(e -> e * e).collect(Collectors.toList());

        System.out.println(list);

        list = new ArrayList<>();

        int range = 100;

        for (int i = 0; i < range; i++) {
            int randomNumberBelowRange = (int) (Math.random() * range);
            list.add(randomNumberBelowRange);
        }

        System.out.println(list.toString());

        //removes any duplicates in the list (if applicable) than sorts the list and then assigns it to list
        list = list.stream().distinct().sorted().collect(Collectors.toList());

        System.out.println(list);

    }

}