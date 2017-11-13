package com.example.thuyhien.signinapplication.network.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by thuyhien on 11/13/17.
 */

public class AuthenticateError {
    private String message;

    @SerializedName("error_code")
    private String errorCode;
    private String status;

    public AuthenticateError(String message, String errorCode, String status) {
        this.message = message;
        this.errorCode = errorCode;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}