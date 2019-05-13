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

    private String mFileName;
    private Context mContext;


    public JSONSeriallizer(String fn, Context context){


        mFileName = fn;
        mContext = context;



    }


    public void save(List<ItemActivity> itemActivity) throws IOException, JSONException{

        JSONArray jsonArray = new JSONArray();

        for (ItemActivity itemActivity1 : itemActivity)
        jsonArray.put(itemActivity1.convertToJSON());

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
