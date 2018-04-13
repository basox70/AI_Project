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
import java.util.*;

public class RWDatas {

    private FileReader database;
    private String fileName = System.getenv("APPDATA") + "\\Char_Recognition\\data.json";

    public void toJSON(String character, Integer[] inputs) {
        verifyFile();
        Map datas =  fromJSON();
        try {
            // TODO output weights in json
            // see example of json in data.json


            FileWriter dataFile = new FileWriter(fileName);

            System.out.println(datas.keySet());
            for (Object key : datas.keySet()){
                if (character.equals(key)) {
                    System.out.println(key);
                }
            }

            Map<Character, List> data = new HashMap<Character, List>() {{
                put(character.charAt(0), inputToList(inputs));
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

    public Map fromJSON() {
        verifyFile();
        try {
            database = new FileReader(fileName);
            JSONDeserializer parser = new JSONDeserializer();
            Map<Character, List> obj = new JSONDeserializer<Map<Character, List>>().deserialize(database);
            //System.out.println("F");
            //System.out.println(obj);
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

    private List inputToList(Integer[] inputs) {
        List<String> strList = new ArrayList<String>();
        String strInputs = new String();
        for (int i : inputs){
            strInputs += String.valueOf(i);
        }
        strList.add(strInputs);

        return strList;
    }

    private String inputToString(Integer[] inputs) {
        String strInputs = new String();
        for (int i : inputs){
            strInputs += String.valueOf(i);
        }

        return strInputs;
    }

}

