package com.example.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.BitSet;
import java.util.List;

import static com.example.recyclerview.ItemActivity.*;

public class ItemAdapterActivity extends RecyclerView.Adapter<ItemAdapterActivity.ListItemHolder> {



    private RecyclerView recyclerView;

    //Itemadapter constuct, pass in prameter maincticity an lit itemactivity

    public ItemAdapterActivity(MainActivity mainActivity,
                               List<ItemActivity> itemlist) {

        mMainActivity = mainActivity;
        mItemList = itemlist;
    }

    private List<ItemActivity> mItemList;
    private MainActivity mMainActivity;



    //this method needs because to show listobject with inflater and layout by referens it with id
    // Layout inflater expands layout by filling it with views
       @NonNull
       @Override
       public ItemAdapterActivity.ListItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


           View view = LayoutInflater.from(viewGroup.getContext())
                   .inflate(R.layout.list_items, viewGroup, false);

           return new ListItemHolder(view);


       }

       //updates the contents on items view and display the data at the specified position

       @Override
       public void onBindViewHolder(@NonNull ItemAdapterActivity.ListItemHolder listItemHolder, int position) {

           //gets the position
           ItemActivity itemActivity = mItemList.get(position);

           //gets the title and the text
           listItemHolder.mTitle.setText(itemActivity.getTitle());


           /* if(itemActivity.getDescription().length() > 70) {

               listItemHolder.mDescription.setText(itemActivity.getDescription()
                       .substring(0, 15));
           }
           else{
               listItemHolder.mDescription.setText(itemActivity.getDescription()
                       .substring(0, itemActivity.getDescription().length() /2 ));

           }

           */


           listItemHolder.mDescription.setText(itemActivity.getDescription()
                   .substring(0, itemActivity.getDescription().length() /2 ));

       }

       //returns the item size/number of the array of items
       @Override
       public int getItemCount() {

           return mItemList.size();

                   //Log.i("info", "Itemlist!!!" + mItemList.size() );

                   //mItemList.size();

       }

       //inner class extends recyclerview.viewholder and implements on clicklistener, becuse onclicklistener it uses by so the user can cliks on teh etxt
       public class ListItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

           TextView mTitle;
           TextView mDescription;
           TextView mCountItem;

           private int value = 0;

           public ListItemHolder(View itemView) {

               super(itemView);

               mTitle = (TextView)
                       itemView.findViewById(R.id.textViewTitle);

               mDescription = (TextView)
                       itemView.findViewById(R.id.textViewDescription);

               mCountItem = (TextView) itemView.findViewById(R.id.badge_notification_1);

               recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);



               itemView.setClickable(true);

               itemView.setOnClickListener(this);



           }


          //show item when clicks on the item and gets the adapterposition
           @Override
           public void onClick(View v) {

               mMainActivity.showItem(getAdapterPosition());


           }



       }


   }
