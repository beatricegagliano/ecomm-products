package dsbd2020.proj.ecommproducts.exceptionhandler;



public class ErrorResponse {

    private String message;

  

    public ErrorResponse(Throwable ex) {
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
