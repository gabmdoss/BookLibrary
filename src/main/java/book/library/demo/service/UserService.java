package book.library.demo.service;

import book.library.demo.dto.UserRequestDTO;
import book.library.demo.exception.BusinessException;
import book.library.demo.model.User;
import book.library.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    public User cadastrar(UserRequestDTO dados) {

        boolean usernameExiste =
                repository.findByUsername(dados.username()).isPresent();

        boolean emailExiste =
                repository.findByEmail(dados.email()).isPresent();

        if (usernameExiste && emailExiste) {
            throw new BusinessException(
                    "Username e e-mail já cadastrados."
            );
        }

        if (usernameExiste) {
            throw new BusinessException(
                    "Username já cadastrado. Insira outro."
            );
        }

        if (emailExiste) {
            throw new BusinessException(
                    "E-mail já cadastrado. Insira outro."
            );
        }


        User user = new User(
                null,
                dados.username(),
                dados.password(),
                dados.nome(),
                dados.email(),
                new Date()
        );
        return repository.save(user);
    }

}
