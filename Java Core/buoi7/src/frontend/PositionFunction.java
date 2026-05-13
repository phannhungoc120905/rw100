package frontend;

import backend.QLPosition;
import entity.Position;
import enums.PositionName;

import java.util.Scanner;

public class PositionFunction {
    private static Scanner scanner = new Scanner(System.in);

    public static void run() throws ClassNotFoundException {
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
                    QLPosition.showPosition();
                    break;
                case "2":
                    insertPosition();
                    break;
                case "3":
                    deletePosition();
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

    public static void insertPosition() throws ClassNotFoundException {
        System.out.println("Nhập tên chức vụ (DEV, TEST, PM...): ");
        String name = scanner.nextLine();

        try {
            PositionName positionName = PositionName.valueOf(name.toUpperCase());

            Position pos = new Position();
            pos.setName(positionName);

            boolean check = QLPosition.createPosition(pos);

            if (check) {
                System.out.println("Thêm thành công!");
            } else {
                System.out.println("Thêm thất bại!");
            }

        } catch (Exception e) {
            System.out.println("Tên chức vụ không hợp lệ!");
        }
    }

    public static void deletePosition() throws ClassNotFoundException {
        System.out.print("Nhập ID cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean check = QLPosition.deletePosition(id);

        if (check) {
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Xóa thất bại!");
        }
    }

    public static void updatePosition() throws ClassNotFoundException {
        System.out.print("Nhập ID cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập tên mới (DEV, TEST, PM...): ");
        String name = scanner.nextLine();

        try {
            PositionName positionName = PositionName.valueOf(name.toUpperCase());

            Position pos = new Position();
            pos.setId(id);
            pos.setName(positionName);

            boolean check = QLPosition.updatePosition(pos);

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