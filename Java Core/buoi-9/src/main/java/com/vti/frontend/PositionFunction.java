package com.vti.frontend;

import com.vti.backend.controller.PositionController;
import com.vti.entity.Position;
import com.vti.enums.PositionName;

import java.util.List;
import java.util.Objects;
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
        PositionName positionName;
        while(true) {
            System.out.println("Chọn Position:");
            System.out.println("1. DEV");
            System.out.println("2. TEST");
            System.out.println("3. SCRUM_MASTER");
            System.out.println("4. PM");

            int choice = scanner.nextInt();
            scanner.nextLine();

            positionName = this.convertToPositionName(choice);

            //check null
            if(Objects.isNull(positionName)){
                System.out.println("Nhập sai, nhập lại!");
                continue;
            }

            //check có trùng hay không
            if(positionController.checkExistNameAndIdNot(positionName, null)){
                System.out.println("Position đã tồn tại");
                continue;
            }
            break;
        }
        boolean check =
                positionController.createPosition(positionName);

        if (check) {
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Thêm mới thất bại");
        }
    }
    public void deletePosition()  {
        System.out.print("Nhập ID cần xóa: ");
        int id;
        while(true){
            id = scanner.nextInt();
            scanner.nextLine();

            // check id > 0
            if(id <= 0){
                System.out.println("ID phải > 0, nhập lại");
                continue;
            }
            //check tồn tại
            if(!positionController.checkExistID(id)){
                System.out.println("ID không tồn tại, nhập lại:");
                continue;
            }
            break;
        }
        if (positionController.isPositionUsed(id)) {

            System.out.println(
                    "Position đang được sử dụng, không thể xóa!"
            );

            return;
        }
        boolean check = positionController.delete(id);

        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }
    public void updatePosition() {
        System.out.print("Nhập ID cần sửa: ");
        Integer id;
        while(true){
            id = scanner.nextInt();
            scanner.nextLine();

            if(id <= 0){
                System.out.println("ID phải > 0, nhập lại:");
                continue;
            }
            if(!positionController.checkExistID(id)){
                System.out.println("ID không tồn tại, nhập lại:");
                continue;
            }
            break;
        }
        PositionName newName;

        while (true) {

            System.out.println("Chọn Position mới:");
            System.out.println("1. DEV");
            System.out.println("2. TEST");
            System.out.println("3. SCRUM_MASTER");
            System.out.println("4. PM");

            int choice = scanner.nextInt();
            scanner.nextLine();

            newName = this.convertToPositionName(choice);

            // check null
            if (Objects.isNull(newName)) {

                System.out.println("Lựa chọn không hợp lệ!");
                continue;
            }
            break;
        }

        boolean check =
                positionController.update(id, newName);

        if (check) {
            System.out.println("Update thành công");
        } else {
            System.out.println("Update thất bại");
        }
    }
    public PositionName convertToPositionName(int choice) {

        switch (choice) {

            case 1:
                return PositionName.DEV;

            case 2:
                return PositionName.TEST;

            case 3:
                return PositionName.SCRUM_MASTER;

            case 4:
                return PositionName.PM;

            default:
                return null;
        }
    }
}
