package frontend;
import backend.QLAccount;
import backend.QLDepartment;
import backend.QLTK;
import entity.Account;
import entity.Department;
import entity.Position;

import java.util.Scanner;

public class AccountFunction {
    private static Scanner scanner = new Scanner(System.in);

    public static void run() throws ClassNotFoundException {
        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Thêm mới Account");
            System.out.println("2. Xóa Account");
            System.out.println("3. Sửa Account");
            System.out.println("4. Lấy các Account");
            System.out.println("5. Thoát");


            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    insertAccount();
                    break;
                case "2":
                    deleteAccount();
                    break;
                case "3":
                    updateAccount();
                    break;
                case "4":
                    QLAccount.showAccount();
                case "5":
                    break;
                default:
                    System.out.println("Chọn sai, chọn lại!");

            }
        }
    }


    public static void updateAccount() throws ClassNotFoundException {
        System.out.print("Nhập ID cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Username mới: ");
        String username = scanner.nextLine();

        System.out.print("Fullname mới: ");
        String fullname = scanner.nextLine();

        System.out.print("Email mới: ");
        String email = scanner.nextLine();

        System.out.print("Department ID mới: ");
        int depId = Integer.parseInt(scanner.nextLine());

        System.out.print("Position ID mới: ");
        int posId = Integer.parseInt(scanner.nextLine());

        Account acc = new Account();
        acc.setId(id);
        acc.setUsername(username);
        acc.setFullName(fullname);
        acc.setEmail(email);

        Department dep = new Department();
        dep.setId(depId);
        acc.setDepartment(dep);

        Position pos = new Position();
        pos.setId(posId);
        acc.setPosition(pos);

        acc.setCreateDate(java.time.LocalDate.now());

        boolean check = QLAccount.updateAccount(acc);

        if (check) {
            System.out.println("Update thành công!");
        } else {
            System.out.println("Update thất bại!");
        }
    }

    public static void deleteAccount() throws ClassNotFoundException {
        System.out.print("Nhập ID cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean check = QLAccount.deleteAccount(id);

        if (check) {
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Xóa thất bại!");
        }
    }

    public static void insertAccount() throws ClassNotFoundException {
        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Fullname: ");
        String fullname = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Department ID: ");
        int depId = Integer.parseInt(scanner.nextLine());

        System.out.print("Position ID: ");
        int posId = Integer.parseInt(scanner.nextLine());

        Account acc = new Account();
        acc.setUsername(username);
        acc.setFullName(fullname);
        acc.setEmail(email);

        Department dep = new Department();
        dep.setId(depId);
        acc.setDepartment(dep);

        Position pos = new Position();
        pos.setId(posId);
        acc.setPosition(pos);

        acc.setCreateDate(java.time.LocalDate.now());

        boolean check = QLAccount.createAccount(acc);

        if (check) {
            System.out.println("Thêm thành công!");
        } else {
            System.out.println("Thêm thất bại!");
        }
    }
}
