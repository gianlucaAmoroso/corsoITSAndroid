package fitstic.gianlucaamoroso.appspotsoftware;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class LoginActivity extends AppCompatActivity {
    EditText mEdtUsername, mEdtPassword;
    Button mBtnLogin;
    TextView mTxvErrore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEdtUsername = (EditText)findViewById(R.id.edtUsername);
        mEdtUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onEditTextPressed();
            }
        });

        mEdtPassword = (EditText)findViewById(R.id.edtPassword);
        mEdtPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onEditTextPressed();
            }
        });

        mTxvErrore = (TextView)findViewById(R.id.txvErrore);

        mBtnLogin = (Button)findViewById(R.id.btnLogin);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBtnLoginPressed();
            }
        });
    }

    private void onEditTextPressed() {
        mTxvErrore.setVisibility(View.GONE);
    }

    private void onBtnLoginPressed() {
        if(mEdtPassword.getText().toString().equals("1234")) {
            Intent intentMainActivity = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intentMainActivity);
        }
        else {
            mTxvErrore.setVisibility(View.VISIBLE);
        }
    }

}
