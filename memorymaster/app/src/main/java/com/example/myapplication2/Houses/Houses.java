package com.example.myapplication2.Houses;

public class Houses {
    public double katsayi;
    public Object image;
    public String isim;
    public int puan;

    public Houses(double katsayi, Object image, String isim, int puan) {
        this.katsayi = katsayi;
        this.image = image;
        this.isim = isim;
        this.puan = puan;
    }

    public double getKatsayi() {
        return katsayi;
    }

    public void setKatsayi(double katsayi) {
        this.katsayi = katsayi;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }
}
