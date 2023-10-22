package ma.enset.customerservice;

import ma.enset.customerservice.entites.Customer;
import ma.enset.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.saveAll(List.of(
					Customer.builder().name("Hicham").email("him@gmail.com").build(),
					Customer.builder().name("Amine").email("amine@gmail.com").build(),
					Customer.builder().name("Nour eddine").email("nour@gmail.com").build(),
					Customer.builder().name("Mohammed").email("med@gmail.com").build()
			));

			customerRepository.findAll().forEach(System.out::println);
		};
	}

}
