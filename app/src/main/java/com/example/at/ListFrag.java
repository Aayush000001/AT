package com.example.at;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;

public class ListFrag extends ListFragment {

    ItemSelected activity;

     public interface ItemSelected //interface is used to setup connection between Frag.java, ListFrag.java, DetailsFrag.java
    {
        Void onItemSelected(int index);  // method created, void does not return any value.
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String [] data = getResources().getStringArray(R.array.pieces);

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data));
        activity.onItemSelected(0);  //clicks the first item.

    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
         activity.onItemSelected(position); // returns the int value of the list item clicked.
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (ItemSelected) context;   // we need to cast this method
    }

}