package com.aiproject;

public class neuron {

    public double neuron (double [] inputs, double [] weights){
        double  result = inputs[0]*weights[0] + inputs[1]*weights[1] + 1*weights[2];
        double  n = 1 / (1 + Math.exp(-result));
        return n;
    }

}
