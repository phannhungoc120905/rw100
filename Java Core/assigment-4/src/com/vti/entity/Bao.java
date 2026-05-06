package com.vti.entity;

public class Bao extends TaiLieu {
    private String ngay;

    public Bao(int ma, String nxb, int soBan,
               String ngay) {

        super(ma, nxb, soBan);
        this.ngay = ngay;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Ngày: " + ngay);
    }
}