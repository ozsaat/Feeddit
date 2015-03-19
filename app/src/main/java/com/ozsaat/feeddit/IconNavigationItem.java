package com.ozsaat.feeddit;


import android.graphics.drawable.Drawable;

public final class IconNavigationItem extends NavigationItem {

    private int iconResId;

    public IconNavigationItem(String title) {
        super(title);
    }

    public int getIconResId() {
        return iconResId;
    }
}
