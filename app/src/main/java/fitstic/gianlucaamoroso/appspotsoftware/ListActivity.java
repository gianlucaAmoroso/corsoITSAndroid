package fitstic.gianlucaamoroso.appspotsoftware;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import fitstic.gianlucaamoroso.appspotsoftware.adapters.LocationAdapter;
import fitstic.gianlucaamoroso.appspotsoftware.models.LocationModel;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<LocationModel> arrayList = new ArrayList<>();
        arrayList.add(new LocationModel(1, "Cesena"));
        arrayList.add(new LocationModel(2, "Rimini"));
        arrayList.add(new LocationModel(3, "Bologna"));


        ListView lsvCitta = findViewById(R.id.lsvCitta);

        LocationAdapter adapter = new LocationAdapter(this, arrayList);
        lsvCitta.setAdapter(adapter);
    }
}
