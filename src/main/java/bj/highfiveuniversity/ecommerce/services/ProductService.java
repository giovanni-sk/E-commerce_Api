package bj.highfiveuniversity.ecommerce.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import bj.highfiveuniversity.ecommerce.models.Product;
import bj.highfiveuniversity.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
               @Autowired
               private ProductRepository productRepository;

               @GetMapping
               public List<Product> getAllProducts() {
                              return productRepository.findAll();
               }

               @GetMapping("/{id}")
               public Product getProductById(Long id) {
                              Product product = productRepository
                                                            .findById(id)
                                                            .orElseThrow(
                                                                                          () -> new RuntimeException("Product non trouvé"));
                              return product;
               }

               @PostMapping
               public Product createProduct(Product product) {
                              Product newProduct = productRepository.save(product);
                              return newProduct;
               }

               @PutMapping("/{id}")
               public Product updateProduct(Long id, Product product) {
                              Product productToUpdate = productRepository
                                                            .findById(id)
                                                            .orElseThrow(
                                                                                          () -> new RuntimeException("Product avec l'id"
                                                                                                                        + id
                                                                                                                        + "non trouvé"));

                              productToUpdate.setName(product.getName());
                              productToUpdate.setDescription(product.getDescription());
                              productToUpdate.setCategories(product.getCategories());
                              return productToUpdate;
               }

               @DeleteMapping("/{id}")
               public void deleteProduct(Long id) {
                              productRepository.deleteById(id);

               }
}
