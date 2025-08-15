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

    public double median(List<? extends Number> list) {
        // Copia mutable de la lista original
        List<Number> copy = new ArrayList<>(list);
        // Ordenar para poder recortar extremos
        copy.sort(Comparator.comparingDouble(Number::doubleValue));
        if(isEvenNumber(list.size())){
            int index = (copy.size() / 2)-1;
            return (copy.get(index).doubleValue()+copy.get(index+1).doubleValue())/2;
        }else {
            int index = ((copy.size()+1)/2)-1;
            return copy.get(index).doubleValue();
        }

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
    public int getUnit(Number number,int times) {
        if(times == 0 ){
            return roundDown(number.doubleValue());
        }

        if(times>=0) {
            int divisor = 1;
            for (int i = 1; i < times; i++) {
                divisor *= 10;
            }
            return (number.intValue() / divisor) % 10;
        }else{
            times *= -1;
            // 1. Obtener la parte decimal
            double decimalPart = number.doubleValue() - number.intValue();

            // 2. Mover la coma decimal a la derecha según la posición (times)
            double multiplied = decimalPart * Math.pow(10, Math.abs(times));

            // 3. Obtener el dígito deseado
            return (int) (multiplied % 10);
        }
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

    public boolean isEvenNumber(int number) {
        return number % 2 == 0;

    }


//-----------------measures of dispersion-----------------

    public double range(List<? extends Number> list){
        // Copia mutable de la lista original
        List<Number> copy = new ArrayList<>(list);
        // Ordenar para poder recortar extremos
        copy.sort(Comparator.comparingDouble(Number::doubleValue));
        return copy.get(copy.size()-1).doubleValue()-copy.get(0).doubleValue();

    }

    public double variance(List<? extends Number> list) {
            double sampleVariance = mean(list);
            double sampleSum = 0;

            for (Number n : list) {
                //potencia
                sampleSum += (n.doubleValue()-sampleVariance)*(n.doubleValue()-sampleVariance);
            }



            return sampleSum/(list.size()-1);
    }

    public double standardDeviation(List<? extends Number> list) {
        double variance = variance(list);
        return Math.sqrt(variance);
    }


}
