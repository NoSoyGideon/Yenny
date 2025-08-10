package org.easyHammer;

import org.easyHammer.Yenny.Yenny;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Yenny yenny = new Yenny();
        List<Integer> datosList = Arrays.asList(
         1,2,3,4,5,6,7,8,9,10
        );

        System.out.println(yenny.median(datosList));


    }
}