package book.library.demo.service;

import book.library.demo.dto.BookLido;
import book.library.demo.model.Book;
import book.library.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book salvar(BookLido dados) {

        Optional<Book> livroExistente = repository.findByIsbn(dados.isbn());

        if (livroExistente.isPresent()) {
            Book livro = livroExistente.get();

            livro.setTitulo(dados.titulo());
            livro.setAutor(dados.autor());
            livro.setStatus(dados.status());

            return repository.save(livro);
        }

        Book novoLivro = new Book(dados);

        return repository.save(novoLivro);
    }
}
