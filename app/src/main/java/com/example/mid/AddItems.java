package com.example.mid;

import android.content.Intent;

public class AddItems {
    String itemName;

    public AddItems(String itemName) {
        this.itemName = itemName;
    }

    public AddItems() {
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "AddItems{" +
                "itemName='" + itemName + '\'' +
                '}';
    }
}
