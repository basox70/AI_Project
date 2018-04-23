package com.aiproject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.System.out;

public class AddChar {

    // Test Value
    private double [] TestInput = new double[2];
    private double [] TestWeight = new double[3];
    private int TestNbNeuron = 2;

    public Integer [] inputs;
    public double [] weights;
    public int nbPixels;
    private Map<Double,double[]> neurons = new HashMap<>();
    private String charToAdd;
    private int nbNeurons = 20;

    public AddChar(String image, String character){
        this.charToAdd = character;
        if (image.length() == 0 && character.length() == 0){
            out.println("Impossible to add unknown char with unknown image");
        } else if (character.length() == 0){
            out.println("Impossible to add unknown char");
        } else if (image.length() == 0){
            out.println("Impossible to add char with unknown image");
        } else if (character.length() > 1) {
            out.println("Impossible to add string, only char accepted");
        } else {
            try {
                getInputs(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void getInputs(String image) throws IOException {
        BufferedImage picture = ImageIO.read(new File(image));
        int nbPixels = picture.getWidth()*picture.getHeight();
        this.inputs = new Integer[nbPixels];

        String img = "";
        // Getting pixel color by position x and y
        int counter = 0;
        for (int x = 0 ; x < picture.getWidth(); x++) {
            for (int y = 0 ; y < picture.getHeight(); y++) {
                int clr = picture.getRGB(x, y);
                int red = (clr & 0x00ff0000) >> 16;
                int green = (clr & 0x0000ff00) >> 8;
                int blue = clr & 0x000000ff;
                //out.println("RGB = (" + red + "," + green + ","  + blue + ") | " + clr);
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

        out.println(img);
        this.nbPixels = nbPixels;

        RWDatas data = new RWDatas();
        data.toJSON(this.charToAdd,inputs);
    }
}
