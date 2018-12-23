package com.cyberoxi.selectablelist.model;

import java.util.List;

public class items {
    private String name;
    private List<subItems> listSubItem;
    private int icon;

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getIcon() {
        return icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListSubItem(List<subItems> listSubItem) {
        this.listSubItem = listSubItem;
    }

    public String getName() {
        return name;
    }

    public List<subItems> getListSubItem() {
        return listSubItem;
    }


}

