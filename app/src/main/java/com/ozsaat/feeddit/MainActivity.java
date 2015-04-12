package com.ozsaat.feeddit;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

    public ArrayList<NavigationItem> getFeedlyItems() {
        ArrayList<NavigationItem> items = new ArrayList<>();
        items.add(new NavigationItem("S1-A", NavigationAdapter.ViewType.SIMPLE));
        items.add(new NavigationItem("S1-B", NavigationAdapter.ViewType.SIMPLE));
        items.add(new NavigationItem("S1-C", NavigationAdapter.ViewType.SIMPLE));
        return items;
    }

    public ArrayList<NavigationItem> getRedditItems() {
        ArrayList<NavigationItem> items = new ArrayList<>();
        items.add(new NavigationItem("S2-A", NavigationAdapter.ViewType.SIMPLE));
        items.add(new NavigationItem("S2-B", NavigationAdapter.ViewType.SIMPLE));
        items.add(new NavigationItem("S2-C", NavigationAdapter.ViewType.SIMPLE));
        items.add(new NavigationItem("S2-D", NavigationAdapter.ViewType.SIMPLE));
        return items;
    }
}
