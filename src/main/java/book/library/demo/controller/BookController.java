package book.library.demo.controller;

import book.library.demo.model.Book;
import book.library.demo.dto.BookLido;
import book.library.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public void cadastrar(@RequestBody BookLido book) {
        service.salvar(book);
    }

    @GetMapping
    public Page<Book> listar(Pageable pageable) {
        return service.listar(pageable);
    }
}
