package book.library.demo.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String mensagem) {
        super(mensagem);
    }
}