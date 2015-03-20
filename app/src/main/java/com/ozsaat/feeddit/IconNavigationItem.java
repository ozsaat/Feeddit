package com.ozsaat.feeddit;


import android.graphics.drawable.Drawable;

public class IconNavigationItem extends NavigationItem {

    private final int iconResId;

    public IconNavigationItem(int iconResId) {
        super();
        this.iconResId = iconResId;
    }

    public int getIconResId() {
        return iconResId;
    }
}
