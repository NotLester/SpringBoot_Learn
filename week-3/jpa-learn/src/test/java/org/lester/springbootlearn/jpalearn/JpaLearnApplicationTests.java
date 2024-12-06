package org.lester.springbootlearn.jpalearn;

import org.junit.jupiter.api.Test;
import org.lester.springbootlearn.jpalearn.entities.Product;
import org.lester.springbootlearn.jpalearn.repositories.ProductRepository;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class JpaLearnApplicationTests {
	ProductRepository productRepository;

	public JpaLearnApplicationTests(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository() {
		Product product = Product.builder()
				.sku("nestle234")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(123.45))
				.quantity(12)
				.build();

		Product savedProduct = productRepository.save(product);
		System.out.println("Saved Product: " + savedProduct);
	}

	@Test
	void getRepository() {
		List<Product> products = productRepository.findAll();
		products.forEach(System.out::println);

		List<Product> products1 = productRepository.findAllById(List.of(1L, 2L));
		products1.forEach(System.out::println);

		List<Product> productTitleList = productRepository.findByTitle("Nestle Chocolate");
		productTitleList.forEach(System.out::println);

		List<Product> productDateList = productRepository.findByDateCreatedBetween(LocalDateTime.now(), LocalDateTime.now());
		productDateList.forEach(System.out::println);


	}

}
