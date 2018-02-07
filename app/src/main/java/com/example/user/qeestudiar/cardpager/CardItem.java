package com.example.user.qeestudiar.cardpager;


public class CardItem {

    private String mTextResource;
    private String mTitleResource;
    private String url;

    public CardItem(String title, String text, String url) {
        mTitleResource = title;
        mTextResource = text;
        this.url = url;
    }

    public String getText() {
        return mTextResource;
    }

    public String getTitle() {
        return mTitleResource;
    }

    public String getUrl() {
        return url;
    }
}
