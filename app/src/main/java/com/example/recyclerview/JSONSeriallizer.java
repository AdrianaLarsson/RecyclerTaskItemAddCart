package com.example.recyclerview;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class JSONSeriallizer {

    // filename where the data will be saved
    private String mFileName;
    //for writing data to a file.
    private Context mContext;

     //json contructor
    public JSONSeriallizer(String fn, Context context){


        mFileName = fn;
        mContext = context;
    }


    public void save(List<ItemActivity> itemActivity) throws IOException, JSONException{

        //makes an arraylist of json. ArrayList for handling JSON objects.
        JSONArray jsonArray = new JSONArray();

        //for loop to go through all the items objects in item and convert them to JSON objects using the convertToJSON method from the ItemAcitvity class
        for (ItemActivity itemActivity1 : itemActivity)
        jsonArray.put(itemActivity1.convertToJSON());

        //write the data to an a file
        Writer writer = null;
        try {
            OutputStream outputStream = mContext.openFileOutput(mFileName, mContext.MODE_PRIVATE);
            writer = new OutputStreamWriter(outputStream);
            writer.write(jsonArray.toString());
        }finally {
            if (writer != null){
                writer.close();
            }
        }

    }

    //opens and load and reads the data from file, takes the lenght of array

    public ArrayList<ItemActivity> load() throws  IOException, JSONException{


        ArrayList<ItemActivity> itemActivityArrayList = new ArrayList<ItemActivity>();

        BufferedReader reader = null;

        try {
            InputStream inputStream = mContext.openFileInput(mFileName);
            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder jsonString = new StringBuilder();

            String line = null;

            while ((line = reader.readLine()) != null){
                jsonString.append(line);
            }

            JSONArray jsonArray= (JSONArray) new JSONTokener(jsonString.toString()).nextValue();

            for (int i = 0; i < jsonArray.length(); i++){


                itemActivityArrayList.add(new ItemActivity( jsonArray.getJSONObject(i)));
            }


        }catch (FileNotFoundException e){


        }finally {
            if (reader != null){
                reader.close();
            }
            return itemActivityArrayList;
        }
    }
}
