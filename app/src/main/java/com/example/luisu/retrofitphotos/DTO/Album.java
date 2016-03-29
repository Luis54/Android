package com.example.luisu.retrofitphotos.DTO;

/**
 * Created by luisu on 28/03/2016.
 */
public class Album {

    private int albumdId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;

    public int getAlbumdId() {
        return albumdId;
    }

    public void setAlbumdId(int albumdId) {
        this.albumdId = albumdId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
