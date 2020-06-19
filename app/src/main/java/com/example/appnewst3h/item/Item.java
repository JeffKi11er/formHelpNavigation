package com.example.appnewst3h.item;

public class Item {
    private String linkImage;
    private String title;
    private String linkDetail;
    private String Content;

    public Item(String linkImage, String title, String linkDetail, String content) {
        this.linkImage = linkImage;
        this.title = title;
        this.linkDetail = linkDetail;
        this.Content = content;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLinkDetail() {
        return linkDetail;
    }

    public void setLinkDetail(String linkDetail) {
        this.linkDetail = linkDetail;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
