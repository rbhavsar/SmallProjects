package rest_server.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@XmlRootElement
public class Book implements Serializable {



    public Book(String id, String title, String description, List<Author> authors, Float price, String imageFileName, String link, Date published) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.authors = authors;
        this.price = price;
        this.imageFileName = imageFileName;
        this.link = link;
        this.published = published;
    }

    public Book()
    {

    }

    private String id;
    private String title;
    private String description;
    private List<Author> authors;
    private Float price;
    private String imageFileName;
    private String link;
    private Date published;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }


}
