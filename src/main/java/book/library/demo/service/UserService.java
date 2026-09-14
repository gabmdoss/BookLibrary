package book.library.demo.service;

import book.library.demo.dto.UserRequestDTO;
import book.library.demo.exception.BusinessException;
import book.library.demo.model.User;
import book.library.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
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

        String senhaCriptografada = passwordEncoder.encode(dados.password());

        User user = new User(
                null,
                dados.username(),
                senhaCriptografada,
                dados.nome(),
                dados.email(),
                new Date()
        );
        return repository.save(user);
    }

}
