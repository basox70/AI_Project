package com.aiproject;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class RWDatas {

    private FileReader database;
    private String fileName = System.getenv("APPDATA") + "\\Char_Recognition\\data.json";

    public void toJSON (String character, Map<Double, double[]> map) {
        verifyFile();
        try {
            // TODO output weights in json
            Iterator<Double> iter = map.keySet().iterator();
            JSONObject JSONneurons = new JSONObject();
            JSONArray weights = new JSONArray();
            while (iter.hasNext()) {
                double key = iter.next();
                double[] array = map.get(key);
                for (int i = 0; i < array.length; i++) {
                    weights.add(array[i]);
                }
                JSONneurons.put(key,weights);
            }
            /*JSONneurons.put("key1","test1");
            JSONneurons.put("key1","test2");
            JSONneurons.put("key1","test3");
            JSONneurons.put("key2","test1");
            JSONneurons.put("key3","test2");
            JSONneurons.put("key4","test3");*/
            //System.out.println(JSONneurons);
            FileWriter dataFile = new FileWriter(fileName);
            dataFile.write(JSONneurons.toJSONString());
            dataFile.flush();

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
