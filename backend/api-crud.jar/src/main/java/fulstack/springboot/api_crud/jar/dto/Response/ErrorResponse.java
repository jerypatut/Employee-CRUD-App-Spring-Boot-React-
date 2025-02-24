package fulstack.springboot.api_crud.jar.dto.Response;

public class ErrorResponse {

    private String status;
    private String message;

    // Constructor
    public ErrorResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getter dan Setter
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
