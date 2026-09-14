package book.library.demo.dto;

public record UserRequestDTO(
        String username,
        String password,
        String nome,
        String email
) {
}