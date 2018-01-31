package fitstic.gianlucaamoroso.appspotsoftware;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fitstic.gianlucaamoroso.appspotsoftware.adapters.ForecastAdapter;
import fitstic.gianlucaamoroso.appspotsoftware.interfaces.DownloadCallback;

import fitstic.gianlucaamoroso.appspotsoftware.models.DownloadTask;
import fitstic.gianlucaamoroso.appspotsoftware.models.UserModel;
import fitstic.gianlucaamoroso.appspotsoftware.models.domain.Forecasts;

public class MainActivity extends AppCompatActivity implements DownloadCallback {
    Button mBtnAction, mBtnListActivity, mBtnDownload;
    EditText mEditTextNumber;

    RecyclerView mRecyclerViewResponse;
    ForecastAdapter mAdapter;

    private DownloadTask mDownloadTask;

    static final String K_USER_MODEL = "kUserModel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //region Codice generato automaticamente
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //endregion

        //myTextView = findViewById(R.id.txvProva);
        //myTextView.setText(R.string.course);
        final String TAG = "AttivitaPrincipale";
        Log.d(TAG, "Qualcosa");

        mEditTextNumber = (EditText)findViewById(R.id.editTextNumber);
        mBtnAction = (Button)findViewById(R.id.btnAction);
        mBtnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBtnActionPressed();
            }
        });

        mBtnListActivity = (Button)findViewById(R.id.btnListActivity);
        mBtnListActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBtnListActivityPressed();
            }
        });

        mBtnDownload = (Button)findViewById(R.id.btnDownloadFromUrl);
        mBtnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { startDownload(); }
        });

        mRecyclerViewResponse = (RecyclerView)findViewById(R.id.recyclerViewResponse);
        mAdapter = new ForecastAdapter();
        mRecyclerViewResponse.setAdapter(mAdapter);
    }

    private void onBtnActionPressed() {
        // Avvio una seconda activity passandogli 2 parametri: una stringa semplice ed un oggetto
        // di una classe personalizzata
        Intent intentPersonalActivity = new Intent(this, PersonalActivity.class);

        String txtNumber = mEditTextNumber.getText().toString();
        intentPersonalActivity.putExtra("Number", txtNumber);

        UserModel user = new UserModel("Luca", 32);
        //l'approccio con la variabile statica e finalizzata è consigliato rispetto alla stringa hardcoded
        intentPersonalActivity.putExtra(K_USER_MODEL, user);

        startActivity(intentPersonalActivity);
    }

    private void onBtnListActivityPressed() {
        Intent intentListActivity = new Intent(this, ListActivity.class);
        startActivity(intentListActivity);
    }

    private void onBtnDownloadPressed() {
        DownloadTask dt = new DownloadTask(MainActivity.this);

    }

    private void startDownload() {

        mDownloadTask = new DownloadTask(this);
        mDownloadTask.execute("https://api.openweathermap.org/data/2.5/forecast");
    }

    /**
     * Indicates that the callback handler needs to update its appearance or information based on
     * the result of the task. Expected to be called from the main thread.
     *
     * @param result
     */
    @Override
    public void updateFromDownload(Object result) {
        Forecasts forecasts = (Forecasts)result;
        mAdapter.setForecasts(forecasts.getList());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public NetworkInfo getActiveNetworkInfo() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo;
    }

    @Override
    public void onProgressUpdate(int progressCode, int percentComplete) {
        switch(progressCode) {
            // You can add UI behavior for progress updates here.
            case Progress.ERROR:

                break;
            case Progress.CONNECT_SUCCESS:

                break;
            case Progress.GET_INPUT_STREAM_SUCCESS:

                break;
            case Progress.PROCESS_INPUT_STREAM_IN_PROGRESS:

                break;
            case Progress.PROCESS_INPUT_STREAM_SUCCESS:

                break;
        }
    }

    @Override
    public void finishDownloading() {}
}
