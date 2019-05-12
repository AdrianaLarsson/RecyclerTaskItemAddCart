package com.example.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static com.example.recyclerview.ItemActivity.*;

public class ItemAdapterActivity extends RecyclerView.Adapter<ItemAdapterActivity.ListItemHolder> {



    private RecyclerView recyclerView;

    public ItemAdapterActivity(MainActivity mainActivity,
                               List<ItemActivity> itemlist) {

        mMainActivity = mainActivity;
        mItemList = itemlist;
    }

    private List<ItemActivity> mItemList;
    private MainActivity mMainActivity;



       @NonNull
       @Override
       public ItemAdapterActivity.ListItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


           View view = LayoutInflater.from(viewGroup.getContext())
                   .inflate(R.layout.list_items, viewGroup, false);

           return new ListItemHolder(view);





       }

       @Override
       public void onBindViewHolder(@NonNull ItemAdapterActivity.ListItemHolder listItemHolder, int position) {

           ItemActivity itemActivity = mItemList.get(position);

           listItemHolder.mTitle.setText(itemActivity.getTitle());





           if(itemActivity.getDescription().length() > 15) {

               listItemHolder.mDescription.setText(itemActivity.getDescription()
                       .substring(0, 15));
           }
           else{
               listItemHolder.mDescription.setText(itemActivity.getDescription()
                       .substring(0, itemActivity.getDescription().length() /2 ));



           }



       
       }

       //get the item size in the recyclerview
       @Override
       public int getItemCount() {
           return mItemList.size();
       }

       public class ListItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

           TextView mTitle;
           TextView mDescription;


           public ListItemHolder(View itemView) {

               super(itemView);

               mTitle = (TextView)
                       itemView.findViewById(R.id.textViewTitle);

               mDescription = (TextView)
                       itemView.findViewById(R.id.textViewDescription);

               recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);


               itemView.setClickable(true);

               itemView.setOnClickListener(this);





           }


//show item when clicks on the item
           @Override
           public void onClick(View v) {

               mMainActivity.showItem(getAdapterPosition());




           }





       }
   }
