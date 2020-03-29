package net.codejava.ProductManager.Repository;

import net.codejava.ProductManager.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Long> {



}
