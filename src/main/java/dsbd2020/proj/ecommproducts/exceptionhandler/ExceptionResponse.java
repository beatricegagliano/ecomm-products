package dsbd2020.proj.ecommproducts.exceptionhandler;

public class ExceptionResponse {
    private String errorMessage;
    private String requestedURI;
    private int status;

    public ExceptionResponse() {
    }

    public ExceptionResponse(String errorMessage, String requestedURI) {
        this.errorMessage = errorMessage;
        this.requestedURI = requestedURI;

    }

    public int getStatus() {
        return status;
    }

    public ExceptionResponse setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getRequestedURI() {
        return requestedURI;
    }

    public void callerURL(final String requestedURI) {
        this.requestedURI = requestedURI;
    }
}
