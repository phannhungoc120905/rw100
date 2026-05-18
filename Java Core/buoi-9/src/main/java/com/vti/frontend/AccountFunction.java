package com.vti.frontend;

import com.vti.backend.controller.AccountController;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;

import java.util.List;
import java.util.Scanner;

public class AccountFunction {
    private static Scanner scanner = new Scanner(System.in);
    private static AccountController accountController = new AccountController();
    public void run() throws ClassNotFoundException {
        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Danh sách account");
            System.out.println("2. Thêm mới account");
            System.out.println("3. Update account");
            System.out.println("4. Xóa Account");
            System.out.println("5. Thoát");


            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    List<Account> accounts = accountController.findAll();
                    this.showAccount(accounts);
                    break;
                case "2":
                    this.insertAccount();
                    break;
                case "3":
                    this.updateAccount();
                    break;
                case "4":
                    this.deleteAccount();
                case "5":
                    break;
                default:
                    System.out.println("Chọn sai, chọn lại!");

            }
        }
    }
    public void showAccount(List<Account> accounts) {
        System.out.println("+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");
        System.out.printf("|%5s|%20s|%20s|%20s|%20s|%20s|\n", "ID", "FullName", "Email", "Username", "Tên phòng ban", "Tên chức vụ");
        System.out.println("+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");
        for (Account account : accounts) {
            System.out.printf("|%5s|%20s|%20s|%20s|%20s|%20s|\n", account.getId(), account.getFullName(), account.getEmail(), account.getUsername(), account.getDepartment().getName(), account.getPosition().getName().name());
        }
        System.out.println("+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");

        if (accounts.size() == 0) {
            System.out.println("Không tìm thấy");
        }
        System.out.println("+-----+--------------------+");
    }
    public void insertAccount()  {
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

        boolean check = accountController.create(acc);

        if (check) {
            System.out.println("Thêm thành công!");
        } else {
            System.out.println("Thêm thất bại!");
        }
    }

    public void updateAccount()  {
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

        boolean check = accountController.update(acc);

        if (check) {
            System.out.println("Update thành công!");
        } else {
            System.out.println("Update thất bại!");
        }
    }

    public static void deleteAccount() {
        System.out.print("Nhập ID cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean check = accountController.delete(id);

        if (check) {
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Xóa thất bại!");
        }
    }
}
