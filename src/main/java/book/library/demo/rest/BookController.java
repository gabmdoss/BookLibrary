package book.library.demo.rest;

import book.library.demo.model.Book;
import book.library.demo.dto.BookRequestDTO;
import book.library.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public void cadastrar(@RequestBody BookRequestDTO book) {
        service.salvar(book);
    }

    @GetMapping
    public Page<Book> listar(Pageable pageable) {
        return service.listar(pageable);
    }
}
