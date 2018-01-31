package fitstic.gianlucaamoroso.appspotsoftware.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by GIANLUCA.AMOROSO on 20/12/2017.
 */

public class UserModel implements Parcelable {
    private String mName;
    private Integer mAge;

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }

        @Override
        public UserModel createFromParcel(Parcel source) {
            return new UserModel(source);
        }
    };

    public UserModel(String name, Integer age) {
        mName = name;
        mAge = age;
    }

    public UserModel(Parcel parcel) {
        // Devo mantenere l'ordine indicato nel
        // metodo writeToParcel
        mName = parcel.readString();
        mAge = parcel.readInt();
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Integer getAge() {
        return mAge;
    }

    public void setAge(Integer age) {
        mAge = age;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeInt(mAge);
    }

    @Override
    public String toString() {
        return "Nome: " + mName + " Età: " + mAge;
    }
}
