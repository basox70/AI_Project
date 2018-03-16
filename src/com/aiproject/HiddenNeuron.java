package com.aiproject;

import java.util.ArrayList;

public class HiddenNeuron {

    private ArrayList<Neuron> neurons;

    public HiddenNeuron() {
        neurons = new ArrayList<>();
    }

    public void addNeurons(int nbNeurons) {
        for (int i = 0; i < nbNeurons; i++)
            neurons.add(new Neuron());
    }

}
