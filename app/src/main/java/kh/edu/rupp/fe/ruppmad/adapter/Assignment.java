package kh.edu.rupp.fe.ruppmad.adapter;

/**
 * Created by KIMvHAI on 5/9/2017.
 */

public class Assignment {

    private int id;
    private String title;
    private String dateLine;
    private String thumbnailUrl;

    public Assignment(int id, String title, String dateLine, String thumbnailUrl) {
        this.id = id;
        this.title = title;
        this.dateLine = dateLine;
        this.thumbnailUrl = thumbnailUrl;
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

    public String getDateLine() {
        return dateLine;
    }

    public void setDateLine(String dateLine) {
        this.dateLine = dateLine;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
