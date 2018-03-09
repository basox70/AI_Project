package com.aiproject;

public class Neuron {

    public double neuron (double [] inputs, double [] weights){
        double result = 0;
        System.out.println(inputs.length + " | " + weights.length);
        int nb = inputs.length;
        for (int i = 0; i < nb; i++){
            result += inputs[i]*weights[i];
        }
        result += 1*weights[nb];
        double n = 1 / (1 + Math.exp(-result));
        System.out.println("Neuron :" + n);
        return n;
    }

}
