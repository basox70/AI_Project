package com.aiproject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import static java.lang.System.out;

public class Decode {

    private int nbNeurons = 200;
    public Integer [] inputs;
    public double [] weights;
    public int nbPixels;
    private String output[];

    private HiddenNeuron neurons;


    public Decode(String image) {
        RWDatas data = new RWDatas();
        Map datas = data.fromJSON();
        System.out.println(image);
        this.output = new String[datas.keySet().size()];
        int i = 0;
        for (Object key : datas.keySet()) {
            this.output[i] = key.toString();
            i++;
        }
        try {
            getInputs(image);

        }catch (Exception e){
            e.printStackTrace();
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
                out.println("RGB = (" + red + "," + green + ","  + blue + ") | " + clr);
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
    }
}
