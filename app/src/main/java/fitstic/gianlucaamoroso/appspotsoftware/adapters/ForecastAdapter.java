package fitstic.gianlucaamoroso.appspotsoftware.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import fitstic.gianlucaamoroso.appspotsoftware.models.domain.List;

import fitstic.gianlucaamoroso.appspotsoftware.R;
import fitstic.gianlucaamoroso.appspotsoftware.models.ForecastModel;

/**
 * Created by GIANLUCA.AMOROSO on 31/01/2018.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {

    private java.util.List<List> forecasts = new ArrayList<>();

    public ForecastAdapter() {}

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_forecast, parent, false);
        return new ForecastViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return forecasts.size();
    }

    public void setForecasts(java.util.List<List> forecasts) {
        this.forecasts = forecasts;
    }

    public class ForecastViewHolder extends RecyclerView.ViewHolder {
        private TextView txtCity;
        private TextView txtData;

        public ForecastViewHolder(View view) {
            super(view);
            txtCity = (TextView)view.findViewById(R.id.txvCityName);
            txtData = (TextView)view.findViewById(R.id.txvData);
        }
    }
}
