package com.aiproject;


/*import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;*/

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RWDatas {

    private FileReader database;
    private String fileName = System.getenv("APPDATA") + "\\Char_Recognition\\data.db";

    public void toDB(String character, double[] inputs, Map<Double, double[]> map) {
        verifyDB();
        Object datas =  fromDB();
        try {
            // TODO output weights in json

            FileWriter dataFile = new FileWriter(fileName);
            dataFile.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double[] fromDB(char character) {
        verifyDB();

        return null;
    }

    public Object fromDB() {
        verifyDB();
        try {
            database = new FileReader(fileName);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Function used to verify/create the data file
     */
    private void verifyDB() {
        File file = new File(fileName);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            String url = "jdbc:sqlite:" + fileName;
            try (Connection conn = DriverManager.getConnection(url)) {
                if (conn != null) {
                    DatabaseMetaData meta = conn.getMetaData();
                    System.out.println("The driver name is " + meta.getDriverName());
                    initDB();
                    System.out.println("A new database has been created.");
                }
            } catch (Exception e1) {
                System.out.println("Could not create file");
                e1.printStackTrace();
            }
        }
    }

    private void initDB() {
        File file = new File(fileName);
        System.out.println("Used Space : " + file.getTotalSpace());

    }
}
