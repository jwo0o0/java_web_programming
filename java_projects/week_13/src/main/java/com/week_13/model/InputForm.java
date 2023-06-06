package com.week_13.model;

public class InputForm {
    private String title;
    private String attr;

    public InputForm(String title, String attr) {
        this.title = title;
        this.attr = attr;
    }

    public InputForm(String title) {
        this.title = title;
        this.attr = new String(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }
}
