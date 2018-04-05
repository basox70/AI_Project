package com.aiproject;


/*import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;*/

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RWDatas {

    private FileReader database;
    private String fileName = System.getenv("APPDATA") + "\\Char_Recognition\\data.json";

    public void toJSON(String character, Integer[] inputs, Map<Double, double[]> map) {
        verifyFile();
        Object datas =  fromJSON();
        try {
            // TODO output weights in json

            FileWriter dataFile = new FileWriter(fileName);

            Map<Character, Object> data = new HashMap<Character, Object>() {{
                put(character.charAt(0), new Object[]{new HashMap<String, Integer[]>() {
                    {
                        put("inputs", inputs);
                    }}
                });
            }};
            JSONSerializer json = new JSONSerializer();
            json.prettyPrint(true);
            dataFile.write(json.deepSerialize(data));
            dataFile.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double[] fromJSON(char character) {
        verifyFile();

        return null;
    }

    public Object fromJSON() {
        verifyFile();
        try {
            database = new FileReader(fileName);
            JSONDeserializer parser = new JSONDeserializer();
            Map<Character,Map<String,Map<Integer,Double>>> obj = new JSONDeserializer<Map<Character,Map<String,Map<Integer,Double>>>>().deserialize(database);
            System.out.println(obj.get("0"));
            return obj;
        } catch (Exception e) {
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
