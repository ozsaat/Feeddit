package com.ozsaat.feeddit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.ViewHolder> {
    private final ArrayList<String> items = new ArrayList<>();
    private int feedlyItemsSize = 0;
    private int staticItemsSize = 0;

    public NavigationAdapter() {
        items.add("Header");
        items.add("Settings");
        staticItemsSize = items.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_navigation_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = this.items.get(position);
        holder.titleTextView.setText(item);
    }

    @Override
    public int getItemCount() {
        return items.size();

    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
        }
    }

    public void setFeedlyItems(ArrayList<String> feedlyItems) {
        List<? extends String> tempStaticList = new ArrayList<>(items.subList(0, staticItemsSize));
        List<? extends String> tempRedditList = new ArrayList<>(items.subList(staticItemsSize+feedlyItemsSize, getItemCount()));
        items.clear();
        items.addAll(tempStaticList);
        if (feedlyItems != null) {
            items.addAll(feedlyItems);
            feedlyItemsSize = feedlyItems.size();
        } else {
            feedlyItemsSize = 0;
        }
        items.addAll(tempRedditList);
        notifyDataSetChanged();
    }

    public void setRedditItems(ArrayList<String> redditItems) {
        List<? extends String> tempList = new ArrayList<>(items.subList(0, staticItemsSize+feedlyItemsSize));
        items.clear();
        items.addAll(tempList);
        if (redditItems != null) {
            items.addAll(redditItems);
        }
        notifyDataSetChanged();
    }

}
