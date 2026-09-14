package book.library.demo.rest;

import book.library.demo.dto.UserRequestDTO;
import book.library.demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public void cadastrar(@RequestBody UserRequestDTO dados) {
        service.cadastrar(dados);
    }
}
