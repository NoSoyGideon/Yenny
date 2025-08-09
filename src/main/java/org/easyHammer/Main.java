package org.easyHammer;

import org.easyHammer.Yenny.Yenny;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Yenny yenny = new Yenny();
        List<Double> datosList = Arrays.asList(
                3.4, 2.5, 4.8, 2.9, 3.6,
        2.8, 3.3, 5.6, 3.7, 2.8,
        4.4, 4.0, 5.2, 3.0, 4.8
        );

        System.out.println(yenny.mean(datosList,0.2));


    }
}