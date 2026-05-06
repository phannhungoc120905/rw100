package com.vti.backend;

import com.vti.entity.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise5 {

    // ================= Q1 + Q2 (QLCB) =================
    public void question1_2() {

        ArrayList<CanBo> list = new ArrayList<>();

        // Thêm
        list.add(new CongNhan("A", 25, "Nam", "DN", 5));
        list.add(new KySu("B", 30, "Nam", "HN", "IT"));
        list.add(new NhanVien("C", 28, "Nữ", "HCM", "Kế toán"));

        // Hiển thị
        System.out.println("=== Danh sách ===");
        for (CanBo cb : list) {
            cb.display();
        }

        // Tìm
        System.out.println("=== Tìm A ===");
        for (CanBo cb : list) {
            if (cb.getName().equalsIgnoreCase("A")) {
                cb.display();
            }
        }

        // Xóa
        list.removeIf(cb -> cb.getName().equalsIgnoreCase("A"));

        System.out.println("=== Sau khi xóa ===");
        for (CanBo cb : list) {
            cb.display();
        }
    }

    // ================= Q3 =================
    public void question3() {

        HighSchoolStudent hs =
                new HighSchoolStudent(1, "Nam", "Chuyên Văn", "ĐH Công nghệ");

        hs.display();
    }

    // ================= Q4 (QLTV) =================
    public void question4() {

        Scanner sc = new Scanner(System.in);
        ArrayList<TaiLieu> list = new ArrayList<>();

        while (true) {
            System.out.println("\n===== MENU QLTV =====");
            System.out.println("1. Thêm tài liệu");
            System.out.println("2. Xóa theo mã");
            System.out.println("3. Hiển thị");
            System.out.println("4. Tìm theo loại");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("1.Sách 2.Tạp chí 3.Báo");
                    int type = sc.nextInt();

                    System.out.print("Mã: ");
                    int ma = sc.nextInt();
                    sc.nextLine();

                    System.out.print("NXB: ");
                    String nxb = sc.nextLine();

                    System.out.print("Số bản: ");
                    int soBan = sc.nextInt();
                    sc.nextLine();

                    if (type == 1) {
                        System.out.print("Tác giả: ");
                        String tg = sc.nextLine();
                        System.out.print("Số trang: ");
                        int st = sc.nextInt();
                        list.add(new Sach(ma, nxb, soBan, tg, st));
                    }

                    if (type == 2) {
                        System.out.print("Số PH: ");
                        int sph = sc.nextInt();
                        System.out.print("Tháng: ");
                        int th = sc.nextInt();
                        list.add(new TapChi(ma, nxb, soBan, sph, th));
                    }

                    if (type == 3) {
                        sc.nextLine();
                        System.out.print("Ngày: ");
                        String ngay = sc.nextLine();
                        list.add(new Bao(ma, nxb, soBan, ngay));
                    }
                    break;

                case 2:
                    System.out.print("Nhập mã cần xóa: ");
                    int del = sc.nextInt();
                    list.removeIf(t -> t.getMaTaiLieu() == del);
                    break;

                case 3:
                    for (TaiLieu t : list) {
                        t.display();
                        System.out.println("------");
                    }
                    break;

                case 4:
                    System.out.print("Nhập loại (Sach/TapChi/Bao): ");
                    String loai = sc.next();

                    for (TaiLieu t : list) {
                        if (loai.equalsIgnoreCase("Sach") && t instanceof Sach) {
                            t.display();
                        }
                        if (loai.equalsIgnoreCase("TapChi") && t instanceof TapChi) {
                            t.display();
                        }
                        if (loai.equalsIgnoreCase("Bao") && t instanceof Bao) {
                            t.display();
                        }
                    }
                    break;

                case 0:
                    return;
            }
        }
    }
}