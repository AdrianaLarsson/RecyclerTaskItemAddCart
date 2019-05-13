package com.example.recyclerview;

import android.app.Notification;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    NotificationCompat notificationCompat;
    Notification notification;
    TextView textCartItemCount;

    private List<ItemActivity> mItemList;

    private int value = 0;

   // private List<ItemActivity> itemActivityList = new ArrayList<>();
    private List<ItemActivity> itemActivityList;
    private RecyclerView recyclerView;
    private ItemAdapterActivity mAdapter;

    private JSONSeriallizer mSeriallizer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.cartshopping);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_main);


       mSeriallizer = new JSONSeriallizer("RecyclerView.json",
                getApplicationContext());

        try {
            itemActivityList = mSeriallizer.load();

        } catch (Exception e) {
            itemActivityList = new ArrayList<ItemActivity>();


            Log.i("Error loading notes: ", "", e);

        }


        recyclerView = (RecyclerView)
                findViewById(R.id.recyclerView);


        mAdapter = new ItemAdapterActivity(this, itemActivityList);

        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Add a neat dividing line between items in the list
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // set the adapter
        recyclerView.setAdapter(mAdapter);

        FloatingActionButton floatingActionButtonItem = findViewById(R.id.floatingActionButtonItem);

        textCartItemCount = (TextView) findViewById(R.id.badge_notification_1);

        value = itemActivityList.size();

       // value++;
        textCartItemCount.setText("ITEM!!" + itemActivityList.size());

        textCartItemCount.setText("" + value );
        //Toast.makeText(this, "New item added to cart" ,Toast.LENGTH_SHORT).show();

        mAdapter.notifyDataSetChanged();

        floatingActionButtonItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemActivityList.remove(0);
                textCartItemCount.setText("" + itemActivityList.size());
                mAdapter.notifyDataSetChanged();
            }
        });

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewItemActivity dialog = new NewItemActivity();
                dialog.show(getSupportFragmentManager(), "");



            }
        });

    }

    public void showItem(int adapterPosition) {

       ShowItemActivity dialog = new ShowItemActivity();

        dialog.sendNoteSelected(itemActivityList.get(adapterPosition));

        dialog.show(getSupportFragmentManager(), "");

        value = itemActivityList.size();

       value++;
        textCartItemCount.setText("ITEM!!" + itemActivityList.size());
        //value++;
       textCartItemCount.setText("" + value);
        Toast.makeText(this,  "position " + adapterPosition + "Existing item added to cart "  ,Toast.LENGTH_SHORT).show();


        mAdapter.notifyDataSetChanged();

    }

    public void newItem(ItemActivity itemActivity) {

       value = itemActivityList.size();

        value++;
        textCartItemCount.setText("ITEM!!" + itemActivityList.size());

        textCartItemCount.setText("" + value );

        Toast.makeText(this, "New item added to cart" ,Toast.LENGTH_SHORT).show();

        itemActivityList.add(itemActivity);

        mAdapter.notifyDataSetChanged();

    }


    public void saveItems(){
        try{
           mSeriallizer.save(itemActivityList);


        }catch(Exception e){
            Log.e("Error Saving Notes","", e);
        }


    }
    protected void onPause(){
        super.onPause();

        saveItems();

    }

    /*public int getItemCount() {


        int value = 0;

        value = mItemList.size();

        textCartItemCount.setText( "" + value);
        return value;

        //mItemList.size();

    }
*/

}
