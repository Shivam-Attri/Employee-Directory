package com.shivam.Employee.Directory.Exception;

public class EmployeeCustomError {
    private int httpStatus;
    private String message;
    private long timestamp;

    public EmployeeCustomError() {
    }

    public EmployeeCustomError(int httpStatus, String message, long timestamp) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
