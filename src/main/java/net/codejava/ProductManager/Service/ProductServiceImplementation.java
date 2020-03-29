package net.codejava.ProductManager.Service;

import net.codejava.ProductManager.Product;
import net.codejava.ProductManager.Repository.ProductRepository;
import net.codejava.ProductManager.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getAll() {
        return productRepository.findAll();    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
