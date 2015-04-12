package com.ozsaat.feeddit.ui;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ozsaat.feeddit.R;

import java.util.ArrayList;
import java.util.List;

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.ViewHolder> {
    private final ArrayList<NavigationItem> items = new ArrayList<>();
    private int feedlyItemsSize = 0;
    private int staticItemsSize = 0;

    public NavigationAdapter() {
        items.add(new HeaderNavigationItem());
        items.add(new IconNavigationItem(R.drawable.ic_launcher, "Settings"));
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
        item.bind(holder);
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
        },

        ICON {
            @Override public int getLayoutId() {
                return R.layout.item_navigation_icon;
            }
        },

        HEADER {
            @Override public int getLayoutId() {
                return R.layout.item_navigation_header;
            }
        };

        public abstract int getLayoutId();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView coverImageView;
        private final ImageView iconImageView;
        private final TextView titleTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.coverImageView = (ImageView) itemView.findViewById(R.id.coverImageView);
            this.iconImageView = (ImageView) itemView.findViewById(R.id.iconImageView);
            this.titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
        }
    }

    public abstract static class NavigationItem {
        private final ViewType viewType;

        public NavigationItem(ViewType viewType) {
            this.viewType = viewType;
        }

        public ViewType getViewType() {
            return viewType;
        }

        public abstract void bind(ViewHolder viewHolder);
    }

    public static class SimpleNavigationItem extends NavigationItem {
        private final String title;

        public SimpleNavigationItem(String title) {
            super(ViewType.SIMPLE);
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        @Override public void bind(ViewHolder viewHolder) {
            viewHolder.titleTextView.setText(title);
        }
    }

    public static class IconNavigationItem extends NavigationItem {
        private final int iconResId;
        private final String title;

        public IconNavigationItem(int iconResId, String title) {
            super(ViewType.ICON);
            this.iconResId = iconResId;
            this.title = title;
        }

        @Override public void bind(ViewHolder viewHolder) {
            viewHolder.titleTextView.setText(title);
            viewHolder.iconImageView.setImageResource(iconResId);
        }

        public int getIconResId() {
            return iconResId;
        }

        public String getTitle() {
            return title;
        }
    }

    public static class HeaderNavigationItem extends NavigationItem {
        public HeaderNavigationItem() {
            super(ViewType.HEADER);
        }

        @Override public void bind(ViewHolder viewHolder) {
            viewHolder.coverImageView.setBackgroundColor(Color.RED);
        }
    }
}
