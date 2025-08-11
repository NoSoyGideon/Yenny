package org.easyHammer;

import org.easyHammer.Yenny.Yenny;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Yenny yenny = new Yenny();
        List<Integer> envejecimiento = Arrays.asList(
               4,24,1,70,27
        );


        System.out.println(yenny.range(envejecimiento));





    }
}