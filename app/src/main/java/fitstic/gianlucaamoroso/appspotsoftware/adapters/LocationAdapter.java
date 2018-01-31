package fitstic.gianlucaamoroso.appspotsoftware.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import fitstic.gianlucaamoroso.appspotsoftware.R;
import fitstic.gianlucaamoroso.appspotsoftware.models.LocationModel;

/**
 * Created by GIANLUCA.AMOROSO on 10/01/2018.
 */

public class LocationAdapter extends ArrayAdapter<LocationModel> {
    private Context mContext;
    private ArrayList<LocationModel> mArrayLocation;

    public LocationAdapter(Context context, ArrayList<LocationModel> array) {
        super(context, R.layout.row, array);
        mContext = context;
        mArrayLocation = array;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        TextView txvName = rowView.findViewById(R.id.txvCitta);
        LocationModel model = mArrayLocation.get(position);
        txvName.setText("CITTA:" + model.getName());
        return rowView;
    }
}
