package server.controllers;


import org.springframework.web.bind.annotation.RequestParam;
import server.entity.User;
import server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public String registration(@RequestParam String login, @RequestParam String password, HttpServletResponse response, Model model) {
        try {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            userService.createUser(user);
            response.setStatus(HttpServletResponse.SC_CREATED);
            model.addAttribute("submit", "Регистрация прошла успешно");
            return "login";
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            model.addAttribute("warning", "Что-то пошло не так! Повторите попытку");
            return "registration";
        }
    }

    @GetMapping("/")
    public String registrationForm(Model model) {
        return "login";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        return "login";
    }
}