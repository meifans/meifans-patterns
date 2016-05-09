package github.meifans.hello.exception;

import lombok.Data;

@Data
public class CustomErrorType {

    private long timestamp;
    private int code;

    private String message;
    private String data;

    public CustomErrorType() {
    }

    public CustomErrorType(int code, String message) {
        this.code = code;
        this.message = message;
        timestamp = System.currentTimeMillis();
    }

    public CustomErrorType(int code, String message, String data) {
        this.code = code;
        this.message = message;
        this.data = data;
        timestamp = System.currentTimeMillis();
    }
}
