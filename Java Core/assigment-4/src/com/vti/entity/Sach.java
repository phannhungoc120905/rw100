package com.vti.entity;

public class Sach extends TaiLieu {
    private String tacGia;
    private int soTrang;

    public Sach(int ma, String nxb, int soBan,
                String tacGia, int soTrang) {

        super(ma, nxb, soBan);
        this.tacGia = tacGia;
        this.soTrang = soTrang;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Tác giả: " + tacGia +
                ", Số trang: " + soTrang);
    }
}