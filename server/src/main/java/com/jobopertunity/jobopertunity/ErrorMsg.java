package com.jobopertunity.jobopertunity;

public class ErrorMsg {
    private int statusCode;
    private String reason;

    public ErrorMsg() {}

    public int getStatusCode() {
        return statusCode;
    }

    public String getReason() {
        return reason;
    }

    public void setErrorMsg(int statusCode, String reason) {
        this.statusCode = statusCode;
        this.reason = reason;
    }
}
