package com.aiproject;


/*import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;*/

/*import flexjson.JSONDeserializer;*/
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class RWDatas {

    private FileReader database;
    private String fileName = System.getenv("APPDATA") + "\\Char_Recognition\\data.json";
    private boolean check = true;

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
                System.out.println("Tableau des caractères déjà indexés : "+datas.keySet());
                System.out.println("Caractère à indexer : "+character);
                System.out.println("Nombre de caractères déjà indexés : "+datas.keySet().size());

                int nbrOfIndexedChar = datas.keySet().size();
                int checkKey = 0;

                    for (Object key : datas.keySet()) {
                        if (character.equals(key)) {
                            System.out.println(key);
                            System.out.println(datas.get(key));
                            List array = (List) datas.get(key);
                            String newValue = inputToString(inputs);
                            boolean addValue = true;
                            for (Object value : array) {
                                if (value.equals(newValue)) {
                                    System.out.println("Value already exist");
                                    addValue = false;
                                }
                            }
                            if (addValue) {
                                array.add(inputToString(inputs));
                            }
                            data = new HashMap<Character, List>() {{
                                put(key.toString().charAt(0), array);
                            }};
                        } else {
                            checkKey++;
                        }
                    }

                //Si aucun des caractères déjà indexés ne correspond au caractère à indexer
                if(checkKey == nbrOfIndexedChar && datas.keySet().size()!=0){
                    System.out.println("Le tableau ne contient pas encore la valeur à ajouter à la base");
                    datas.put(character.charAt(0), inputToList(inputs));
                }

                if (datas.keySet().size()==0){
                    data = new HashMap<Character, List>() {{
                        put(character.charAt(0), inputToList(inputs));
                    }};
                    check=false;
                }

            }else {
                System.out.println("datas ko");
                data = new HashMap<Character, List>() {{
                    put(character.charAt(0), inputToList(inputs));
                }};
                check=false;
            }

            JSONSerializer json = new JSONSerializer();
            json.prettyPrint(true);
            if(check) {
                dataFile.write(json.deepSerialize(datas));
            }else{
                dataFile.write(json.deepSerialize(data));
            }
            dataFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double[] fromJSON(char character) {
        verifyFile();

        return null;
    }

    public HashMap fromJSON() {
        verifyFile();
        try {
            database = new FileReader(fileName);
            HashMap<Character, List> obj = new JSONDeserializer<HashMap<Character, List>>().deserialize(database);
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

