package com.example.thuyhien.signinapplication.utils;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * Created by thuyhien on 11/13/17.
 */

public class AuthenticationUtils {

    public static boolean checkValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean checkValidPassword(String password) {
        return !TextUtils.isEmpty(password);
    }
}
