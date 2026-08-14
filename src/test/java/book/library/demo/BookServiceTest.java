package book.library.demo;

import book.library.demo.dto.BookLido;
import book.library.demo.model.Book;
import book.library.demo.model.Status;
import book.library.demo.repository.BookRepository;
import book.library.demo.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

	@Mock
	private BookRepository repository;

	@InjectMocks
	private BookService service;

	@Test
	void deveCriarUmNovoLivroQuandoIsbnNaoExistir() {
		BookLido dados = new BookLido(
				"Dom Casmurro",
				"Machado de Assis",
				"9788535910663",
				Status.LIDO
		);

		when(repository.findByIsbn(dados.isbn()))
				.thenReturn(Optional.empty());

		service.salvar(dados);

		verify(repository).save(any(Book.class));
	}
}