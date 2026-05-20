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
        String username;

            while (true) {

                System.out.print("Username: ");

                username = scanner.nextLine();

                // null hoặc rỗng
                if (username == null
                        || username.trim().isEmpty()) {

                    System.out.println(
                            "Username không được để trống!"
                    );

                    continue;
                }

                // unique
                if (accountController.checkExistUsernameAndIdNot(username, null)) {
                    System.out.println("Username đã tồn tại!");
                    continue;
                }

                break;
            }

            String fullname;

            while (true) {

                System.out.print("Fullname: ");

                fullname = scanner.nextLine();

                if (fullname == null
                        || fullname.trim().isEmpty()) {

                    System.out.println(
                            "Fullname không được để trống!"
                    );

                    continue;
                }

                break;
            }

            String email;

            while (true) {

                System.out.print("Email: ");

                email = scanner.nextLine();

                if (email == null
                        || email.trim().isEmpty()) {

                    System.out.println(
                            "Email không được để trống!"
                    );

                    continue;
                }

                // check @
                if (!email.contains("@")) {

                    System.out.println(
                            "Email phải chứa @"
                    );

                    continue;
                }

                // unique
                if (accountController.checkExistEmailAndIdNot(
                                email,
                                null)) {

                    System.out.println(
                            "Email đã tồn tại!"
                    );

                    continue;
                }

                break;
            }

            int depId;

            while (true) {

                System.out.print("Department ID: ");

                depId = Integer.parseInt(
                        scanner.nextLine());

                if (depId <= 0) {

                    System.out.println(
                            "Department ID phải > 0"
                    );

                    continue;
                }

                if (!accountController.checkExistDepartmentID(depId)) {

                    System.out.println(
                            "Department không tồn tại!"
                    );

                    continue;
                }

                break;
            }

            int posId;

            while (true) {

                System.out.print("Position ID: ");

                posId = Integer.parseInt(
                        scanner.nextLine());

                if (posId <= 0) {

                    System.out.println(
                            "Position ID phải > 0"
                    );

                    continue;
                }

                if (!accountController.checkExistPositionID(posId)) {

                    System.out.println(
                            "Position không tồn tại!"
                    );

                    continue;
                }

                break;
            }

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

            acc.setCreateDate(
                    java.time.LocalDate.now());

            boolean check =
                    accountController.create(acc);

            if (check) {

                System.out.println(
                        "Thêm thành công!"
                );

            } else {

                System.out.println(
                        "Thêm thất bại!"
                );
            }
        }

    public void updateAccount() {

        int id;

        while (true) {

            System.out.print(
                    "Nhập ID cần sửa: ");

            id = Integer.parseInt(
                    scanner.nextLine());

            // > 0
            if (id <= 0) {

                System.out.println(
                        "ID phải > 0"
                );

                continue;
            }

            // tồn tại
            if (!accountController.checkExistID(id)) {

                System.out.println(
                        "ID không tồn tại!"
                );

                continue;
            }

            break;
        }

        String newUsername;

        while (true) {

            System.out.print(
                    "Username mới: ");

            newUsername =
                    scanner.nextLine();

            if (newUsername == null
                    || newUsername.trim().isEmpty()) {

                System.out.println(
                        "Username không được để trống!"
                );

                continue;
            }

            // unique
            if (accountController.checkExistUsernameAndIdNot(
                            newUsername,
                            id)) {

                System.out.println(
                        "Username đã tồn tại!"
                );

                continue;
            }

            break;
        }

        boolean check =
                accountController.updateUsername(id, newUsername);

        if (check) {

            System.out.println(
                    "Update thành công!"
            );

        } else {

            System.out.println(
                    "Update thất bại!"
            );
        }
    }

    public static void deleteAccount() {

        System.out.print("Nhập ID cần xóa: ");

        int id;

        while (true) {

            id = Integer.parseInt(
                    scanner.nextLine());

            // > 0
            if (id <= 0) {

                System.out.println(
                        "ID phải > 0"
                );

                continue;
            }

            // tồn tại
            if (!accountController.checkExistID(id)) {

                System.out.println(
                        "ID không tồn tại!"
                );

                continue;
            }

            break;
        }

        boolean check = accountController.delete(id);

        if (check) {

            System.out.println(
                    "Xóa thành công!"
            );

        } else {

            System.out.println(
                    "Xóa thất bại!"
            );
        }
    }
}
