package fitstic.gianlucaamoroso.appspotsoftware;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import fitstic.gianlucaamoroso.appspotsoftware.fragments.CountryFragment;
import fitstic.gianlucaamoroso.appspotsoftware.models.UserModel;

public class PersonalActivity extends AppCompatActivity implements View.OnClickListener{
    TextView mTxvFromIntent, mTxvUserFromIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        Intent intent = getIntent();
        String numberFromIntent = intent.getStringExtra("Number");
        mTxvFromIntent = (TextView)findViewById(R.id.txvFromIntent);
        mTxvFromIntent.setText("Numero ricevuto: " + numberFromIntent);

        UserModel userModel = (UserModel) intent.getParcelableExtra(MainActivity.K_USER_MODEL);
        mTxvUserFromIntent = (TextView)findViewById(R.id.txvUserFromIntent);
        mTxvUserFromIntent.setText(userModel.toString());

        // TODO: CODICE NON FUNZIONANTE PER IL FRAGMENT: STUDIARNE IL FUNZIONAMENTO E CORREGGERLO
        /*if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.frameContainer, new CountryFragment()).commit();
        }*/
    }

    @Override
    public void onClick(View view) {

    }
}
