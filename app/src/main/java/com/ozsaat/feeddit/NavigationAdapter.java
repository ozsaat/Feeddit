package com.ozsaat.feeddit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.ViewHolder> {
    private final ArrayList<NavigationItem> items = new ArrayList<>();
    private int feedlyItemsSize = 0;
    private int staticItemsSize = 0;

    public NavigationAdapter() {
        items.add(new HeaderNavigationItem("Header"));
        items.add(new IconNavigationItem("Settings", R.drawable.ic_launcher));
        staticItemsSize = items.size();
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(ViewType.values()[viewType].getLayoutId(), parent, false);
        return new ViewHolder(view);
    }

    @Override public int getItemViewType(int position) {
        return items.get(position).getViewType().ordinal();
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        NavigationItem item = this.items.get(position);
        holder.titleTextView.setText(item.getTitle());
    }

    @Override public int getItemCount() {
        return items.size();
    }

    public void setFeedlyItems(ArrayList<NavigationItem> feedlyItems) {
        List<? extends NavigationItem> tempStaticList = new ArrayList<>(items.subList(0, staticItemsSize));
        List<? extends NavigationItem> tempRedditList = new ArrayList<>(items.subList(staticItemsSize + feedlyItemsSize, getItemCount()));
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

    public void setRedditItems(ArrayList<NavigationItem> redditItems) {
        List<? extends NavigationItem> tempList = new ArrayList<>(items.subList(0, staticItemsSize + feedlyItemsSize));
        items.clear();
        items.addAll(tempList);
        if (redditItems != null) {
            items.addAll(redditItems);
        }
        notifyDataSetChanged();
    }

    enum ViewType {
        SIMPLE {
            @Override public int getLayoutId() {
                return R.layout.item_navigation;
            }
        }, ICON {
            @Override public int getLayoutId() {
                return R.layout.item_navigation_icon;
            }
        };

        public abstract int getLayoutId();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
        }
    }
}
