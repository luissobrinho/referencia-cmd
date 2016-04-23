package br.com.ddsw.app.sssixtyfour;

/**
 * Created by Ewellyn on 18/04/2016.
 */
public class Reference {
    Integer id;
    String title, content;

    public Reference(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Reference() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
