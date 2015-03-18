package com.ozsaat.feeddit;


import android.graphics.drawable.Drawable;

public class IconNavigationItem extends NavigationItem {
    public IconNavigationItem(String title) {
        super(title);
    }

    private int iconResId;
    private String title;

    public IconNavigationItem(int iconResId, String title) {
        this.iconResId = iconResId;
        this.title = title;
    }

    public int getIconResId() {
        return iconResId;
    }



    @Override
    public String getTitle() {
        return title;
    }
}
