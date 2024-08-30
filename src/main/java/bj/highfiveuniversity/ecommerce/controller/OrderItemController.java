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

import bj.highfiveuniversity.ecommerce.models.OrderItem;
import bj.highfiveuniversity.ecommerce.repository.OrderItemRepository;

/**
 * OrderItemController
 */
@RestController
@RequestMapping("/api/order_items")

public class OrderItemController {
@Autowired
              private OrderItemRepository orderItemRepository;
              //Recuperer tout les OrderItems
              @GetMapping 
              public List<OrderItem> getAllOrderItems(){
               return orderItemRepository.findAll();
              }
              //Recuperer un OrderItem pas son id
              @GetMapping("/{id}")
              public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id){
                              OrderItem orderItem = orderItemRepository
                              .findById(id)
                              .orElseThrow(
                                             ()->new RuntimeException("OrderItem non trouvé")
                                             );
                              return ResponseEntity.ok(orderItem);
              }


              //Créer un OrderItem

              @PostMapping
              public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem){
               OrderItem newOrderItem = orderItemRepository.save(orderItem);
               return ResponseEntity.ok(newOrderItem);
              }


              //Modifier 

              @PutMapping("/{id}")
              public ResponseEntity<OrderItem> updateOrderItem(@PathVariable Long id , @RequestParam OrderItem orderItem){
               OrderItem orderItemToUpdate = orderItemRepository
               .findById(id)
               .orElseThrow(
                              ()-> new RuntimeException("OrderItem avec l'id"+id+"non trouvé")
                              );

                              orderItemToUpdate.setOrder(orderItem.getOrder());
                              orderItemToUpdate.setPrice(orderItem.getPrice());
                              orderItemToUpdate.setProduct(orderItem.getProduct());
                              orderItemToUpdate.setQuantity(orderItem.getQuantity());
                              return ResponseEntity.ok(orderItemToUpdate);
              }
              //Supprimer

              @DeleteMapping("/{id}")
              public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id  ){
               orderItemRepository.deleteById(id);
               return ResponseEntity.noContent().build();
              }
              
              
               
}