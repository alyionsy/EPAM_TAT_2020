package com.bsu.framework.model;

import java.util.Objects;

public class Item {
    private String url;
    private String xpath;
    private String name;

    public Item(String url, String xpath, String name) {
        this.url = url;
        this.xpath = xpath;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(url, item.url) &&
                Objects.equals(xpath, item.xpath) &&
                Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, xpath, name);
    }
}
