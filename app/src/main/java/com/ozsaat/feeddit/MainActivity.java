package com.ozsaat.feeddit;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends Activity {

    RecyclerView recyclerView;
    NavigationAdapter adapter;

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
        adapter.setFeedlyItems(getFeedlyItems());
        adapter.setRedditItems(getRedditItems());
        adapter.setFeedlyItems(null);
        adapter.setFeedlyItems(getFeedlyItems());
        adapter.setRedditItems(getRedditItems());
        adapter.setFeedlyItems(getFeedlyItems());
        adapter.setFeedlyItems(getFeedlyItems());
        adapter.setRedditItems(getRedditItems());
        adapter.setRedditItems(getRedditItems());
        adapter.setRedditItems(getRedditItems());
        adapter.setFeedlyItems(getFeedlyItems());
    }

    public ArrayList<String> getFeedlyItems() {
        ArrayList<String> items = new ArrayList<>();
        items.add("S1-A");
        items.add("S1-B");
        items.add("S1-C");
        return items;
    }

    public ArrayList<String> getRedditItems() {
        ArrayList<String> items = new ArrayList<>();
        items.add("S2-A");
        items.add("S2-B");
        items.add("S2-C");
        items.add("S2-D");
        return items;
    }
}
