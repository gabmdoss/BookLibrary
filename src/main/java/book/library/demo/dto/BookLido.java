package book.library.demo.dto;

import book.library.demo.model.Status;

public record BookLido(String titulo, String autor, String isbn, Status status) {
}
