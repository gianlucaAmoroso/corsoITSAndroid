package fitstic.gianlucaamoroso.appspotsoftware.models;

/**
 * Created by GIANLUCA.AMOROSO on 10/01/2018.
 */

public class LocationModel {
    private String mName;
    private int mId;

    public LocationModel(int id, String name) {
        mId = id;
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public int getId() {
        return mId;
    }
}
