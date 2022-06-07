package com.example;

public class Menu {
    private final int qty;
    private final String menu;
    private final int price;
    
    Menu (int cqty, String cmenu, int cprice) {
        this.qty = cqty;
        this.menu = cmenu;
        this.price = cprice;
    }

    public int getQty() {
        return qty;
    }

    public String getMenu() {
        return menu;
    }

    public int getPrice() {
        return price;
    }

    public void setText(String string) {
    }    
}
