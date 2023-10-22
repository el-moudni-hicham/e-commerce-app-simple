package ma.enset.inventoryservice.entites;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullProduct", types = Product.class)
public interface ProductProjection {
    public Long getId();
    public String getName();
    public Double getPrice();
    public int getQuantity();
}
