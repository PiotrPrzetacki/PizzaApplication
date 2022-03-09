package pl.piotr.pizzaapplication.remote.rest.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piotr.pizzaapplication.remote.rest.dto.request.AddPizzaDto;
import pl.piotr.pizzaapplication.remote.rest.dto.response.PizzaDto;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "/pizzas", produces = APPLICATION_JSON_VALUE)
@RestController
public class PizzaController {

    @PostMapping
    public ResponseEntity<PizzaDto> addPizza(@RequestHeader("Access-Token") String token,
                                             @RequestBody AddPizzaDto addPizzaDto){
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PizzaDto> updatePizza(@PathVariable("id") Integer pizzaId,
                                                @RequestHeader("Access-Token") String token,
                                                @RequestBody PizzaDto pizzaDto){
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id")
    public ResponseEntity<Void> deletePizza(@RequestHeader("Access-Token") String token,
                                            @PathVariable("id") Integer pizzaId){
        return ResponseEntity.ok().build();
    }
}
