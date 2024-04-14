package com.dyj.web.domain;

/**
 * item和value
 */
public class ItemValue {


    private String item;

    private Long value;

    public String getItem() {
        return item;
    }

    public ItemValue setItem(String item) {
        this.item = item;
        return this;
    }

    public Long getValue() {
        return value;
    }

    public ItemValue setValue(Long value) {
        this.value = value;
        return this;
    }
}
