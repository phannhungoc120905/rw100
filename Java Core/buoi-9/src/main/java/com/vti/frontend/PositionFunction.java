package com.vti.frontend;

import com.vti.backend.controller.PositionController;
import com.vti.entity.Position;
import com.vti.enums.PositionName;

import java.util.List;
import java.util.Scanner;

public class PositionFunction {
    private static Scanner scanner = new Scanner(System.in);

    private static PositionController positionController = new PositionController();
    public void run() throws ClassNotFoundException {
        while (true) {
            System.out.println("=== MENU POSITION ===");
            System.out.println("1. Xem danh sách chức vụ");
            System.out.println("2. Thêm chức vụ");
            System.out.println("3. Xóa chức vụ");
            System.out.println("4. Sửa chức vụ");
            System.out.println("5. Thoát");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    List<Position> positions = positionController.findAll();
                    this.showPosition(positions);
                    break;
                case "2":
                    this.insertPosition();
                    break;
                case "3":
                    this.deletePosition();
                    break;
                case "4":
                    updatePosition();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Chọn sai!");
            }
        }
    }
    public void showPosition(List<Position> positions) {
        System.out.println("+-----+--------------------+");
        System.out.printf("|%5s|%20s|\n", "ID", "Tên chức vụ");
        System.out.println("+-----+--------------------+");
        for (Position position : positions) {
            System.out.printf("|%5s|%20s|\n", position.getId(), position.getName());
        }
        if (positions.size() == 0) {
            System.out.println("Không tìm thấy");
        }
        System.out.println("+-----+--------------------+");
    }
    public void insertPosition()  {
        System.out.println("Nhập tên chức vụ (DEV, TEST, PM...): ");
        String name = scanner.nextLine();

        try {
            PositionName positionName = PositionName.valueOf(name.toUpperCase());

            Position pos = new Position();
            pos.setName(positionName);

            boolean check = positionController.create(pos);

            if (check) {
                System.out.println("Thêm thành công!");
            } else {
                System.out.println("Thêm thất bại!");
            }

        } catch (Exception e) {
            System.out.println("Tên chức vụ không hợp lệ!");
        }
    }
    public void deletePosition()  {
        System.out.print("Nhập ID cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean check = positionController.delete(id);

        if (check) {
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Xóa thất bại!");
        }
    }
    public void updatePosition()  {
        System.out.print("Nhập ID cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập tên mới (DEV, TEST, PM...): ");
        String name = scanner.nextLine();

        try {
            PositionName positionName = PositionName.valueOf(name.toUpperCase());

            Position pos = new Position();
            pos.setId(id);
            pos.setName(positionName);

            boolean check = positionController.update(pos);

            if (check) {
                System.out.println("Update thành công!");
            } else {
                System.out.println("Update thất bại!");
            }

        } catch (Exception e) {
            System.out.println("Tên chức vụ không hợp lệ!");
        }
    }
}
