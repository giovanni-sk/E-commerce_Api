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
import bj.highfiveuniversity.ecommerce.services.ProductService;



/**
 * ProductController
 */
@RestController
@RequestMapping("/api/product")

public class ProductController {
                 @Autowired
             private ProductService productService;

              
           
              @GetMapping 
              public List<Product> getAllProducts(){
               return productService.getAllProducts();
              }
        
              @GetMapping("/{id}")
              public ResponseEntity<Product> getProductById(@PathVariable Long id){
                              Product product = productService.getProductById(id);
                            
                              return ResponseEntity.ok(product);
              }


            

              @PostMapping
              public ResponseEntity<Product> createProduct(@RequestBody Product product){
               Product newProduct = productService.createProduct(product);
               return ResponseEntity.ok(newProduct);
              }


              //Modifier 

              @PutMapping("/{id}")
              public ResponseEntity<Product> updateProduct(@PathVariable Long id , @RequestParam Product product){
               Product productToUpdate = productService.updateProduct(id, product);
                              return ResponseEntity.ok(productToUpdate);
              }
              //Supprimer

              @DeleteMapping("/{id}")
              public ResponseEntity<Void> deleteProduct(@PathVariable Long id  ){
             productService.deleteProduct(id);
               return ResponseEntity.noContent().build();
              }
              
               
}