package pl.piotr.pizzaapplication.domain.service;

import pl.piotr.pizzaapplication.domain.exception.UnauthorizedException;

public class AuthorizationService {

    public static void checkToken(String token){
        if (token == null || !token.equals("xyz")){
            throw new UnauthorizedException("Błędny token");
        }
    }
}
