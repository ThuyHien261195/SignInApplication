package com.example.thuyhien.signinapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thuyhien.signinapplication.R;
import com.example.thuyhien.signinapplication.SignInApplication;
import com.example.thuyhien.signinapplication.dagger.module.SignInModule;
import com.example.thuyhien.signinapplication.exception.GeneralException;
import com.example.thuyhien.signinapplication.network.exception.AuthenticationException;
import com.example.thuyhien.signinapplication.presenter.SignInPresenter;
import com.example.thuyhien.signinapplication.view.SignInView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInActivity extends AppCompatActivity implements SignInView{

    @BindView(R.id.edit_text_email)
    EditText editTextEmail;

    @BindView(R.id.edit_text_password)
    EditText editTextPassword;

    @Inject
    SignInPresenter signInPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        ((SignInApplication) getApplication()).getAppComponent()
                .createSignInComponent(new SignInModule(this))
                .inject(this);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_sign_in)
    public void onClickSignInButton() {
        signInPresenter.signIn(editTextEmail.getText().toString(),
                editTextPassword.getText().toString());
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this, R.string.message_sign_in_success, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage(Exception ex) {
        if (ex == null) {
            Toast.makeText(this, R.string.message_unknown_error, Toast.LENGTH_SHORT).show();
        } else {
            if (ex instanceof AuthenticationException) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            } else if (ex instanceof GeneralException) {
                Toast.makeText(this, getErrorInvalidInput(ex), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, R.string.message_unknown_error, Toast.LENGTH_SHORT).show();
            }
        }
    }

    private String getErrorInvalidInput(Exception ex) {
        if (ex != null) {
            return getString(((GeneralException) ex).getErrorCode());
        }

        return getString(R.string.message_unknown_error);
    }
}
