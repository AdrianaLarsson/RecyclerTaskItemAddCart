package com.example.recyclerview;

import org.json.JSONException;
import org.json.JSONObject;

// class för the decription and title, get and set
public class ItemActivity {

    private String mTitle;
    private String mDescription;
    private int mCountItem;

    private static final String JSON_TITLE = "title";
    private static final String JSON_DESCRIPTION = "description";

    private static final String JSON_COUNTITEM = "countItem";

    public ItemActivity(JSONObject jsonObject) throws JSONException {

        mTitle = jsonObject.getString(JSON_TITLE);
        mDescription = jsonObject.getString(JSON_DESCRIPTION);
        mCountItem = jsonObject.getInt(JSON_COUNTITEM);

    }

    public ItemActivity(){}


    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public void setCountItem(int mCountItem) {
        this.mCountItem = mCountItem;
    }

    public void getCountItem(int mCountItem) {
        this.mCountItem= mCountItem;
    }

    public JSONObject convertToJSON() throws JSONException{


        JSONObject jsonObject = new JSONObject();

        jsonObject.put(JSON_TITLE, mTitle);
        jsonObject.put(JSON_DESCRIPTION, mDescription);
        jsonObject.put(JSON_COUNTITEM, mCountItem);
        

        return  jsonObject;
    }
}
