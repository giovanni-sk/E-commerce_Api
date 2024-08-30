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

import bj.highfiveuniversity.ecommerce.models.Order;
import bj.highfiveuniversity.ecommerce.repository.OrderRepository;

/**
 * OrderController
 */
@RestController
@RequestMapping("/api/order")

public class OrderController {
@Autowired
              private OrderRepository orderRepository;
              //Recuperer tout les Orders
              @GetMapping 
              public List<Order> getAllOrders(){
               return orderRepository.findAll();
              }
              //Recuperer un Order pas son id
              @GetMapping("/{id}")
              public ResponseEntity<Order> getOrderById(@PathVariable Long id){
                              Order order = orderRepository
                              .findById(id)
                              .orElseThrow(
                                             ()->new RuntimeException("Order non trouvé")
                                             );
                              return ResponseEntity.ok(order);
              }


              //Créer un Order

              @PostMapping
              public ResponseEntity<Order> createOrder(@RequestBody Order order){
               Order newOrder = orderRepository.save(order);
               return ResponseEntity.ok(newOrder);
              }


              //Modifier 

              @PutMapping("/{id}")
              public ResponseEntity<Order> updateOrder(@PathVariable Long id , @RequestParam Order order){
               Order orderToUpdate = orderRepository
               .findById(id)
               .orElseThrow(
                              ()-> new RuntimeException("Order avec l'id"+id+"non trouvé")
                              );

                              orderToUpdate.setOrderItems(order.getOrderItems());
                              orderToUpdate.setStatus(order.getStatus());
                              orderToUpdate.setTotalAmount(order.getTotalAmount());
                              return ResponseEntity.ok(orderToUpdate);
              }
              //Supprimer

              @DeleteMapping("/{id}")
              public ResponseEntity<Void> deleteOrder(@PathVariable Long id  ){
               orderRepository.deleteById(id);
               return ResponseEntity.noContent().build();
              }
              
              
}