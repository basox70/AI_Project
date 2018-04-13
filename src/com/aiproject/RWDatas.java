package com.aiproject;


/*import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;*/

/*import flexjson.JSONDeserializer;*/
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

import java.io.*;
import java.util.*;

public class RWDatas {

    private FileReader database;
    private String fileName = System.getenv("APPDATA") + "\\Char_Recognition\\data.json";

    public void toJSON(String character, Integer[] inputs) {
        verifyFile();
        Map datas =  fromJSON();
        System.out.println("datas : " + datas);

        try {
            // TODO output weights in json
            // see example of json in data.json

            FileWriter dataFile = new FileWriter(fileName);
            Map<Character, List> data = new HashMap<Character, List>();

            if (datas != null) {
                System.out.println("datas ok");
                System.out.println(datas.keySet());

                for (Object key : datas.keySet()){
                    if (character.equals(key)) {
                        System.out.println(key);
                        System.out.println(datas.get(key));
                        List array = (List) datas.get(key);
                        String newValue = inputToString(inputs);
                        boolean addValue = true;
                        for (Object value : array) {
                            if (value.equals(newValue)){
                                System.out.println("Value already exist");
                                addValue = false;
                            }
                        }
                        if (addValue) {
                            array.add(inputToString(inputs));
                        }
                        data = new HashMap<Character, List>() {{
                            put( key.toString().charAt(0),array);
                        }};
                    } else {
                        List array = (List) datas.get(key);
                        data = new HashMap<Character, List>() {{
                            put(key.toString().charAt(0),array);
                        }};
                    }
                }

            }else {
                System.out.println("datas ko");
                data = new HashMap<Character, List>() {{
                    put(character.charAt(0), inputToList(inputs));
                }};
            }

            //TODO ecrase les valeurs 
            if (!datas.containsKey(character.charAt(0))) {
                System.out.println("new value");
                data = new HashMap<Character, List>() {{
                    put(character.charAt(0), inputToList(inputs));
                }};
            }

            /*data = new HashMap<Character, List>() {{
                put(character.charAt(0), inputToList(inputs));
            }};*/
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
            Map<Character, List> obj = new JSONDeserializer<Map<Character, List>>().deserialize(database);
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

