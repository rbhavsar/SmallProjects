package RestSample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("products")
public class ProductResourse {

    @GET
    @Produces("application/json")
    @Path("saearchProduct")
    public Product searchProducts()
    {
        Product product = new Product();
        product.setPid(101);
        product.setPname("mouse");
        product.setPrice(300.00);
        return product;
    }

}
