package ma.enset.orderservice;

import ma.enset.orderservice.entites.Order;
import ma.enset.orderservice.entites.ProductItem;
import ma.enset.orderservice.enums.OrderStatus;
import ma.enset.orderservice.model.Customer;
import ma.enset.orderservice.model.Product;
import ma.enset.orderservice.repository.OrderRepository;
import ma.enset.orderservice.repository.ProductItemRepository;
import ma.enset.orderservice.services.CustomerRestClientService;
import ma.enset.orderservice.services.InventoryRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(
			OrderRepository orderRepository,
			ProductItemRepository productItemRepository,
			CustomerRestClientService customerRestClientService,
			InventoryRestClientService inventoryRestClientService
	){
		return args -> {
			List<Customer> customers = customerRestClientService.allCustomers().getContent().stream().toList();
			List<Product> products = inventoryRestClientService.allProducts().getContent().stream().toList();

			Long customerId = 1L;
			Customer customer = customerRestClientService.customerById(customerId);
			Random random = new Random();

			for (int i = 0; i < 10; i++) {
				Order order = Order.builder()
						.status(Math.random()>0.5? OrderStatus.CREATED:OrderStatus.PENDING)
						.customerId(customers.get(random.nextInt(customers.size())).getId())
						.createdAt(new Date())
						.build();

				Order savedOrder = orderRepository.save(order);

				for (int j = 0; j < products.size(); j++) {
					if(Math.random() > 0.7){
						ProductItem productItem = ProductItem.builder()
								.productId(products.get(j).getId())
								.order(savedOrder)
								.price(products.get(j).getPrice())
								.quantity(1 + random.nextInt(100))
								.discount(random.nextDouble(10))
								.build();
						productItemRepository.save(productItem);
					}
				}
			}



		};
	}

}
