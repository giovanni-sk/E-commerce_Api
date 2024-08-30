package bj.highfiveuniversity.ecommerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bj.highfiveuniversity.ecommerce.models.Product;
import bj.highfiveuniversity.ecommerce.repository.ProductRepository;

/**
 * ProductController
 */
@RestController
@RequestMapping("/api/product")

public class ProductController {

              @Autowired
              private ProductRepository productRepository;
              //Recuperer tout les Products
              @GetMapping 
              public List<Product> getAllProducts(){
               return productRepository.findAll();
              }
              //Recuperer un Product pas son id
              @GetMapping("/{id}")
              public ResponseEntity<Product> getProductById(@PathVariable Long id){
                              Product product = productRepository
                              .findById(id)
                              .orElseThrow(
                                             ()->new RuntimeException("Product non trouvé")
                                             );
                              return ResponseEntity.ok(product);
              }


              //Créer un Product

              @PostMapping
              public ResponseEntity<Product> createProduct(@RequestBody Product product){
               Product newProduct = productRepository.save(product);
               return ResponseEntity.ok(newProduct);
              }


              //Modifier 

              @PutMapping("/{id}")
              public ResponseEntity<Product> updateProduct(@PathVariable Long id , @RequestParam Product product){
               Product productToUpdate = productRepository
               .findById(id)
               .orElseThrow(
                              ()-> new RuntimeException("Product avec l'id"+id+"non trouvé")
                              );

                              productToUpdate.setName(product.getName());
                              productToUpdate.setDescription(product.getDescription());
                              productToUpdate.setCategories(product.getCategories());
                              return ResponseEntity.ok(productToUpdate);
              }
              //Supprimer

              @DeleteMapping("/{id}")
              public ResponseEntity<Void> deleteProduct(@PathVariable Long id  ){
               productRepository.deleteById(id);
               return ResponseEntity.noContent().build();
              }
              
               
}