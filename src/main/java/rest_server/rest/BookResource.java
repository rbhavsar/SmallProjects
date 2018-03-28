package rest_server.rest;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.xml.ws.Response;

@Stateless
@Path("/books")
public class BookResource {

    @EJB
    //private BookRepository bookRepository;

    @GET
    public Response getAllBooks()
    {

        System.out.println();
        return null;
    }
}
