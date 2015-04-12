package com.ozsaat.feeddit;

public class NavigationItem {

    private final String title;
    private final NavigationAdapter.ViewType viewType;

    public NavigationItem(String title, NavigationAdapter.ViewType viewType) {
        this.title = title;
        this.viewType = viewType;
    }

    public String getTitle() {
        return title;
    }

    public NavigationAdapter.ViewType getViewType() {
        return viewType;
    }
}
