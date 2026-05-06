package com.vti.entity;

public class TaiLieu {
    private int maTaiLieu;
    private String nhaXuatBan;
    private int soBan;

    public TaiLieu(int ma, String nxb, int soBan) {
        this.maTaiLieu = ma;
        this.nhaXuatBan = nxb;
        this.soBan = soBan;
    }

    public int getMaTaiLieu() {
        return maTaiLieu;
    }

    public void display() {
        System.out.println("Mã: " + maTaiLieu +
                ", NXB: " + nhaXuatBan +
                ", Số bản: " + soBan);
    }
}