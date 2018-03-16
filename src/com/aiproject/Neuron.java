package com.aiproject;

public class Neuron {

    public double [] inputs;
    public double [] weights;
    private double output;
    private double e1, e2, e3;
    private double expectedOutput = 1;

    public double neuron (double [] inputs, double [] weights){
        double result = 0;
        System.out.println(inputs.length + " | " + weights.length);
        int nb = inputs.length;
        for (int i = 0; i < nb; i++){
            result += inputs[i]*weights[i];
        }
        result += 1*weights[nb];
        double n = activation(result);
        System.out.println("HiddenNeuron :" + n);
        return n;
    }

    private double activation(double x){
        return 1 / (1 + Math.exp(-x));
    }

    public double udpateWeight (double output){
        /*
        *
        * f(x) => activation
        * f'(x)=f(x)*[1-f(x)]
        * output =>
        *
        */
        return 0;
    }

    public void error(){
        /*
        *
        * e3 => last output
        * e3 = expectedOutput - output
        * error for each neuron :
        * error = HiddenNeuron.weight * e3
        *
         */
        this.e3 = this.expectedOutput - this.output;
    }


}
