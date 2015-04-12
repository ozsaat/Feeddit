package com.ozsaat.feeddit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ozsaat.feeddit.R;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private NavigationAdapter adapter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NavigationAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setRedditItems(getRedditItems());
        adapter.setFeedlyItems(getFeedlyItems());
    }

    public ArrayList<NavigationAdapter.NavigationItem> getFeedlyItems() {
        ArrayList<NavigationAdapter.NavigationItem> items = new ArrayList<>();
        items.add(new NavigationAdapter.SimpleNavigationItem("S1-A"));
        items.add(new NavigationAdapter.SimpleNavigationItem("S1-B"));
        items.add(new NavigationAdapter.SimpleNavigationItem("S1-C"));
        return items;
    }

    public ArrayList<NavigationAdapter.NavigationItem> getRedditItems() {
        ArrayList<NavigationAdapter.NavigationItem> items = new ArrayList<>();
        items.add(new NavigationAdapter.SimpleNavigationItem("S2-A"));
        items.add(new NavigationAdapter.SimpleNavigationItem("S2-B"));
        items.add(new NavigationAdapter.SimpleNavigationItem("S2-C"));
        items.add(new NavigationAdapter.SimpleNavigationItem("S2-D"));
        return items;
    }
}
