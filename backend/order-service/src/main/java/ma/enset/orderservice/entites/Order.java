package ma.enset.orderservice.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.orderservice.enums.OrderStatus;
import ma.enset.orderservice.model.Customer;

import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private OrderStatus status;
    @Transient
    private Customer customer;
    private Long customerId;
    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;
}
