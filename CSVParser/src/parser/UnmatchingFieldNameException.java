package parser;

public class UnmatchingFieldNameException extends Exception {

    private static final long serialVersionUID = 1L;

    public UnmatchingFieldNameException() {
    }

    public UnmatchingFieldNameException(String message) {
        super(message);
    }
}
