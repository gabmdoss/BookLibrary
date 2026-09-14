package book.library.demo.dto;

import book.library.demo.model.Status;

public record BookRequestDTO(String titulo, String autor, String isbn, Status status) {
}
