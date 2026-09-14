package book.library.demo.model;

import book.library.demo.dto.BookRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "livros")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String titulo;
    @Setter
    private String autor;
    private String isbn;

    @Setter
    @Enumerated(EnumType.STRING)
    private Status status;

    public Book(BookRequestDTO book) {
        this.titulo = book.titulo();
        this.autor = book.autor();
        this.isbn = book.isbn();
        this.status = book.status();
    }

}
