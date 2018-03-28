package rest_server.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Author implements Serializable{


    private String id;
    private String firtName;
    private String lastName;
    private String blogUrl;


    public Author(String id, String firtName, String lastName, String blogUrl) {
        this.id = id;
        this.firtName = firtName;
        this.lastName = lastName;
        this.blogUrl = blogUrl;
    }

    public Author()
    {

    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", firtName='" + firtName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", blogUrl='" + blogUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (id != null ? !id.equals(author.id) : author.id != null) return false;
        if (firtName != null ? !firtName.equals(author.firtName) : author.firtName != null) return false;
        if (lastName != null ? !lastName.equals(author.lastName) : author.lastName != null) return false;
        return blogUrl != null ? blogUrl.equals(author.blogUrl) : author.blogUrl == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firtName != null ? firtName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (blogUrl != null ? blogUrl.hashCode() : 0);
        return result;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }



}
