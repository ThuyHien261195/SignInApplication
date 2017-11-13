package com.example.thuyhien.signinapplication.exception;

import com.example.thuyhien.signinapplication.R;

/**
 * Created by thuyhien on 11/13/17.
 */

public class GeneralException extends Exception {
    private int errorCode;

    public GeneralException(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
