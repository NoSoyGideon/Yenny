package org.easyHammer.Yenny;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Yenny {
    public Yenny() {
    }

    public double mean(List<? extends Number> list) {

        return sum(list)/list.size();
    }
    public double mean(List<? extends Number> list, double trim) {
        // Copia mutable de la lista original
        List<Number> copy = new ArrayList<>(list);

        // Ordenar para poder recortar extremos
        copy.sort(Comparator.comparingDouble(Number::doubleValue));

        // Calcular cuántos elementos quitar de cada extremo
        int index = (int) Math.round(copy.size() * trim);

        // Eliminar de los extremos
        for (int i = 0; i < index; i++) {
            copy.remove(0); // remover menor
            copy.remove(copy.size() - 1); // remover mayor
        }

        // Calcular la media
        return copy.stream()
                .mapToDouble(Number::doubleValue)
                .average()
                .orElse(Double.NaN);
    }





    public int round(double number) {
        double rest = number%1;
        if(rest>= 0.5){
            return roundUp(number);
        }else {
            return roundDown(number);
        }

    }
    public int roundUp(double number) {
        double rest = number%1;
        return (int)(number-rest)+1;
    }

    public int roundDown(double number) {
        double rest = number%1;
        return (int)(number-rest);
    }





    public double sum() {
       return 0;
    }


    public double sum(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }





}
