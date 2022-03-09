package pl.piotr.pizzaapplication.remote.rest.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piotr.pizzaapplication.domain.model.OrderStatusType;
import pl.piotr.pizzaapplication.remote.rest.dto.request.AddOrderDto;
import pl.piotr.pizzaapplication.remote.rest.dto.request.UpdateOrderDto;
import pl.piotr.pizzaapplication.remote.rest.dto.response.OrderCollectionDto;
import pl.piotr.pizzaapplication.remote.rest.dto.response.OrderDto;
import pl.piotr.pizzaapplication.remote.rest.dto.response.OrderStatusDto;
import pl.piotr.pizzaapplication.remote.rest.dto.response.TokenDto;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "/api/v1/orders", produces = APPLICATION_JSON_VALUE)
@RestController
public class OrderController {

    @PostMapping
    public ResponseEntity<TokenDto> addOrder(@RequestBody AddOrderDto addOrderDto){

        return ResponseEntity.ok(null);
    }

    @GetMapping("/status/{token}")
    public ResponseEntity<OrderStatusDto> getStatus(@PathVariable("token") String token){
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity<OrderCollectionDto> getOrders(@RequestParam("status")OrderStatusType orderStatus,
                                                        @RequestHeader("Access-Token") String token) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{order-id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("order-id") Integer orderId,
                                            @RequestHeader("Access-Token") String token) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{order-id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable("order-id") Integer orderId,
                                                @RequestHeader("Access-Token") String token,
                                                @RequestBody UpdateOrderDto updateOrderDto){
        return ResponseEntity.ok(null);
    }

}
