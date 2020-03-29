package net.codejava.ProductManager.Service;

import net.codejava.ProductManager.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> getAll();

    public Product saveProduct(Product product);

    public Optional<Product> getProduct(Long id);

    public void deleteById(Long id);

}
