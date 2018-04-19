package com.pertuz.cardviewer;

/**
 * Created by UCA on 19/04/2018.
 */

public class Serie {


    private String name;
    private String caps;
    private String desc;
    private int img;

    public Serie(String name, String caps, String desc, int img) {
        this.name = name;
        this.caps = caps;
        this.desc = desc;
        this.img = img;
    }

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
