package book.library.demo.controller;

import book.library.demo.model.Book;
import book.library.demo.dto.BookLido;
import book.library.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public void cadastrar(@RequestBody BookLido book) {
        service.salvar(book);
    }
}
