package fitstic.gianlucaamoroso.appspotsoftware.models;

import java.util.ArrayList;

/**
 * Created by GIANLUCA.AMOROSO on 20/12/2017.
 */

public class CountryList {
    private ArrayList<String> mCountries = new ArrayList<>();

    public CountryList() {
        mCountries = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mCountries.add("Country_" + i);
        }
    }

    public ArrayList<String> getCountries() {
        return mCountries;
    }
}
