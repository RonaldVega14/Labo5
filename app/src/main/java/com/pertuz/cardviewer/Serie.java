package com.pertuz.cardviewer;


import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint("ParcelCreator")
public class Serie implements Parcelable {
    private String name;
    private String caps;
    private int img;
    private String desc;
    private boolean favoritos;

    public Serie(String name, String caps, String desc, int img, boolean favoritos) {
        this.name = name;
        this.caps = caps;
        this.img = img;
        this.desc = desc;
        this.favoritos = favoritos;
    }

    protected Serie(Parcel in) {
        name = in.readString();
        caps = in.readString();
        img = in.readInt();
        desc = in.readString();
        favoritos = in.readByte() != 0;
    }

    public static final Creator<Serie> CREATOR = new Creator<Serie>() {
        @Override
        public Serie createFromParcel(Parcel in) {
            return new Serie(in);
        }

        @Override
        public Serie[] newArray(int size) {
            return new Serie[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaps() {
        return caps;
    }

    public void setCaps(String caps) {
        this.caps = caps;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isFavoris() {
        return favoritos;
    }

    public void setFavoritos(boolean favoritos) {
        this.favoritos = favoritos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(caps);
        dest.writeInt(img);
        dest.writeString(desc);
        dest.writeByte((byte) (favoritos ? 1 : 0));
    }
}
