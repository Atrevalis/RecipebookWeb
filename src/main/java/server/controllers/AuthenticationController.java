package server.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String createAuthToken(@RequestParam String login, @RequestParam String password, Model model){
        Authentication authentication;
        try{
            authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, password));
            System.out.println(authentication);
            return "notes";
        } catch (BadCredentialsException e) {
            model.addAttribute("warning","Что-то пошло не так! Повторите попытку");
            return "login";
        }

    }
}
