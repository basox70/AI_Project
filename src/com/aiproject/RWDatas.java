package com.aiproject;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class RWDatas {

    private FileReader database;
    private String fileName = System.getenv("APPDATA") + "\\Char_Recognition\\data.json";

    public void toJSON (char character, Map<String, double[]> map) {
        verifyFile();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double[] fromJSON(char character) {
        verifyFile();

        return null;
    }

    public JSONObject fromJSON() {
        verifyFile();
        try {
            database =  new FileReader(fileName);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(database);
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);
            return jsonObject;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Function used to verify/create the data file
     */
    private void verifyFile() {
        File file = new File(fileName);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e1) {
                System.out.println("Could not create file");
                //e1.printStackTrace();
            }
        }
    }

}
