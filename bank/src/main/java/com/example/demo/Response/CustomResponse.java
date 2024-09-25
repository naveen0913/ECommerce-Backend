package com.example.demo.Response;

public class CustomResponse {
    private final int code;
    private final String message;
    private final Object Data;
    public CustomResponse(int code, String message,Object Data) {
        this.code = code;
        this.message = message;
        this.Data = Data;
    }
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
    public Object getData(){
        return Data;
    }
}
