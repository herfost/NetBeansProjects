package parser;

public class InvalidFileTypeException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidFileTypeException(String message) {
        super(message);
    }

    public InvalidFileTypeException() {
    }

}
