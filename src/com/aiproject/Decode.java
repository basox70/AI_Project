package com.aiproject;

public class Decode {

    private int nbNeurons = 200;

    private HiddenNeuron neurons;


    public Decode(String image){
        RWDatas data = new RWDatas();
        data.fromJSON();
        System.out.println(image);
    }
}
