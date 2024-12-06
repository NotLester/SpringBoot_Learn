package org.lester.springbootlearn.jpalearn.repositories;

import org.lester.springbootlearn.jpalearn.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);

    List<Product> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);

    List<Product> findByQuantityAndPrice(Integer quantity, BigDecimal price);

    List<Product> findByQuantityGreaterThanAndPriceLessThan(Integer quantity, BigDecimal price);

    List<Product> findByTitleLike(String title);

    List<Product> findByTitleContaining(String title);

    Optional<Product> findByTitleAndPrice(String title, BigDecimal price);

    @Query("SELECT p.title FROM Product p WHERE p.title=?1 AND p.price<?2")
    List<String> findByTitleAndPriceLowerThan(String title, BigDecimal price);

    List<Product> findByTitleOrderByPriceDesc(String title);

    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> findAllProductsAsc();

    List<Product> findBy(Sort sort);

    Page<Product> findByTitle(String title, Pageable pageable);
}
