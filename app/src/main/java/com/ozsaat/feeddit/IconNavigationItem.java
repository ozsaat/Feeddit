package com.ozsaat.feeddit;

public class IconNavigationItem extends NavigationItem {

    private final int iconResId;

    public IconNavigationItem(String title, int iconResId) {
        super(title, NavigationAdapter.ViewType.ICON);
        this.iconResId = iconResId;
    }

    public int getIconResId() {
        return iconResId;
    }
}
