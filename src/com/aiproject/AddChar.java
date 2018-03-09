package com.aiproject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class AddChar {

    // Test Value
    private double [] TestInput = new double[2];
    private double [] TestWeight = new double[3];
    private int TestNbNeuron = 2;

    public double [] inputs;
    public double [] weights;
    public int nbPixels;
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
            getWeights();
            TestInput[0]=0.8;
            TestInput[1]=0.2;

            TestWeight[0]=0.3;
            TestWeight[1]=0.8;
            TestWeight[2]=0.2;

            Neuron neuron = new Neuron();
            neuron.neuron(TestInput,TestWeight);
            System.out.println(neuron);
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
        for (int x = 0 ; x < picture.getWidth(); x++){
            for (int y = 0 ; y < picture.getHeight(); y++) {
                int clr = picture.getRGB(x, y);
                int red = (clr & 0x00ff0000) >> 16;
                int green = (clr & 0x0000ff00) >> 8;
                int blue = clr & 0x000000ff;
                System.out.println("RGB = (" + red + "," + green + ","  + blue + ") | " + clr);
                if (red*green*blue > 350000){
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

    public void getWeights() {
        this.weights = new double[nbPixels+1];
        for (int i = 0; i < nbPixels+1; i++) {
            Random rand = new Random();
            weights[i] = rand.nextDouble();
        }
    }
}
