package com.vti.entity;

public class TapChi extends TaiLieu {
    private int soPhatHanh;
    private int thang;

    public TapChi(int ma, String nxb, int soBan,
                  int soPhatHanh, int thang) {

        super(ma, nxb, soBan);
        this.soPhatHanh = soPhatHanh;
        this.thang = thang;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Số PH: " + soPhatHanh +
                ", Tháng: " + thang);
    }
}