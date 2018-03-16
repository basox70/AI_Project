package com.aiproject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Random;

public class AddChar {

    // Test Value
    private double [] TestInput = new double[2];
    private double [] TestWeight = new double[3];
    private int TestNbNeuron = 2;

    public double [] inputs;
    public double [] weights;
    public int nbPixels;
    private Map<Double,double[]> neurons = new HashMap<>();
    private int nbNeurons = 200;

    public AddChar(String image, String character){
        if (image.length() == 0 && character.length() == 0){
            System.out.println("Impossible to add unknown char with unknown image");
        } else if (character.length() == 0){
            System.out.println("Impossible to add unknown char");
        } else if (image.length() == 0){
            System.out.println("Impossible to add char with unknown image");
        } else {
            try {
                getInputs(image);
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < nbNeurons; i++) {

            }

            neuronCalculation();
            /*getWeights();
            TestInput[0]=0.8;
            TestInput[1]=0.2;

            TestWeight[0]=0.3;
            TestWeight[1]=0.8;
            TestWeight[2]=0.2;

            HiddenNeuron neuron = new HiddenNeuron();
            neuron.neuron(TestInput,TestWeight);
            neuron.neuron(inputs,weights);
            System.out.println(neuron);*/
        }
        /*System.out.println("Image : "+image);
        System.out.println("Character : "+character + " | " +character.length());*/
    }

    private void getInputs(String image) throws IOException {
        BufferedImage picture = ImageIO.read(new File(image));
        int nbPixels = picture.getWidth()*picture.getHeight();
        this.inputs = new double[nbPixels];

        String img = "";
        // Getting pixel color by position x and y
        int counter = 0;
        for (int x = 0 ; x < picture.getWidth(); x++) {
            for (int y = 0 ; y < picture.getHeight(); y++) {
                int clr = picture.getRGB(x, y);
                int red = (clr & 0x00ff0000) >> 16;
                int green = (clr & 0x0000ff00) >> 8;
                int blue = clr & 0x000000ff;
                System.out.println("RGB = (" + red + "," + green + ","  + blue + ") | " + clr);
                if (red*green*blue > 350000) {
                    img = img + "0";
                    this.inputs[counter] = 0;
                } else {
                    img = img + "1";
                    this.inputs[counter] = 1;
                }
                counter = counter + 1;
            }
            img = img + "\n";
        }

        System.out.println(img);
        this.nbPixels = nbPixels;
    }

    private void getWeights(int size) {
        this.weights = new double[size+1];
        for (int i = 0; i < size+1; i++) {
            Random rand = new Random();
            weights[i] = rand.nextDouble();
        }
    }

    private void neuronCalculation() {
        /*
        * neurons = [ value, weights[] ]
        * output = [ value, weights[] ]
        * target value = 1
        * Model:
        * I*inputs  ----> N*neurons ----> 1*output
        */
        double n;
        HiddenNeuron neuron = new HiddenNeuron();
        double[] neuronValue = new double[nbNeurons];
        for (int i = 0 ; i < nbNeurons ; i++) {
            getWeights(nbPixels);
            n = neuron.neuron(inputs,weights);
            neuronValue[i] = n;
            neurons.put(n,weights);
            System.out.println(neurons.size());
        }

        // output calculation
        double output;
        getWeights(nbNeurons);
        output = neuron.neuron.neuron(neuronValue,weights);
        System.out.println("output: " + output);
    }

}
