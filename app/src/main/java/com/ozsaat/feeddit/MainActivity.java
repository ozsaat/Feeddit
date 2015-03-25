package com.ozsaat.feeddit;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends Activity  {

    private RecyclerView recyclerView;
    private NavigationAdapter adapter;
    private NavigationItem items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NavigationAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setRedditItems(getRedditItems());
        adapter.setFeedlyItems(getFeedlyItems());

    }


    public ArrayList<NavigationItem> getFeedlyItems() {
        ArrayList<NavigationItem> items = new ArrayList<>();
        items.add("S1-A");
        items.add("S1-B");
        items.add("S1-C");
        return items;
    }

    public ArrayList<NavigationItem> getRedditItems() {
        ArrayList<NavigationItem> items = new ArrayList<>();
        items.add("S2-A");
        items.add("S2-B");
        items.add("S2-C");
        items.add("S2-D");
        return items;
    }
}
