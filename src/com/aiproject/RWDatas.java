package com.aiproject;


import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RWDatas {

    private FileReader database;
    private String fileName = System.getenv("APPDATA") + "\\Char_Recognition\\data.json";

    public void toJSON (String character, Map<Double, double[]> map) {
        verifyFile();
        try {
            // TODO output weights in json
            Map<String, Map> test = new HashMap<>();
            test.put(character,map);
            Object transition = test;
            JSONValue obj = new JSONValue();
            String output = obj.toJSONString(map);
            String output2 = obj.toJSONString(test);
            Iterator<Double> iter = map.keySet().iterator();
            System.out.println("output3");
            while (iter.hasNext()) {
                Double arrayName = iter.next();
                double[] array;
                array = map.get(arrayName);

                String output3 = obj.toJSONString(array);
                System.out.println(output3);
            }
            System.out.println("output");
            System.out.println(output);
            System.out.println("output2");
            System.out.println(output2);
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
