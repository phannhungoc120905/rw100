import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Exercise5 {
    // Question 1:
    //Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
    public static void question1(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập 3 số nguyên: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println("Bạn đã nhập: " + a + " " + b + " " + c);
    }

    //Question 2:
    //Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình
    public static void question2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số thực a: ");
        float a = scanner.nextInt();
        System.out.println("Nhập số thực b: ");
        float b = scanner.nextInt();
        System.out.println("Ban đã nhập: " + a + " " + b);
    }

    // Question 3:
    //Viết lệnh cho phép người dùng nhập họ và tên
    public static void question3(){
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println("Nhập họ và tên: ");
        String fullName = scanner.nextLine();
        System.out.println("Họ và tên: " + fullName);
    }

    //Question 4:
    //Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ
    public static void question4(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập năm sinh: ");
        int year = scanner.nextInt();
        System.out.println("Nhập tháng sinh: ");
        int month = scanner.nextInt();
        System.out.println("Nhập ngày sinh: ");
        int day = scanner.nextInt();
        LocalDate birthday = LocalDate.of(year, month, day);
        System.out.println("Ngày sinh của bạn là: " + birthday);
    }

    // Question 5:
    //Viết lệnh cho phép người dùng tạo account (viết thành method) Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và vào chương trình sẽ chuyển thành Position.Dev, Position.Test, Position.ScrumMaster, Position.PM
    public static Account question5(){
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        System.out.println("Nhập accountID: ");
        account.accountId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập Email: ");
        account.email = scanner.nextLine();
        System.out.println("Nhập Username: ");
        account.userName = scanner.nextLine();
        System.out.println("Nhập fullName: ");
        account.fullName = scanner.nextLine();

        System.out.println("Chọn Position:");
        System.out.println("1. DEV");
        System.out.println("2. TEST");
        System.out.println("3. SCRUM MASTER");
        System.out.println("4. PM");

        int choose = scanner.nextInt();
        Position position = new Position();
        switch(choose){
            case 1:
                position.postion = PositionName.DEV;
                break;
            case 2:
                position.postion = PositionName.TEST;
                break;

            case 3:
                position.postion = PositionName.SCRUM_MASTER;
                break;

            case 4:
                position.postion = PositionName.PM;
                break;

            default:
                position.postion = PositionName.DEV;
                break;
        }
        account.position = position;

        System.out.println("Tạo account thành công!");
        System.out.println("Position: " + account.position.postion);
        return account;
    }

    //Question 6:
    //Viết lệnh cho phép người dùng tạo department (viết thành method)
    public static Department question6() {
        Scanner scanner = new Scanner(System.in);

        Department department = new Department();

        System.out.print("Nhập Department ID: ");
        department.departmentId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập Department Name: ");
        department.departmentName = scanner.nextLine();

        System.out.println("Tạo Department thành công!");

        return department;
    }

    //Question 7:
    //Nhập số chẵn từ console
    public static void question7() {
        Scanner scanner = new Scanner(System.in);

        int number;

        do {
            System.out.print("Nhập số chẵn: ");
            number = scanner.nextInt();

        } while (number % 2 != 0);

        System.out.println("Số chẵn bạn nhập là: " + number);
    }

    // Question 8:
    //Viết chương trình thực hiện theo flow sau:
    //Bước 1:  Chương trình in ra text "mời bạn nhập vào chức năng muốn sử dụng"
    //Bước 2:  Nếu người dùng nhập vào 1 thì sẽ thực hiện tạo account
    //Nếu người dùng nhập vào 2 thì sẽ thực hiện chức năng tạo department
    //Nếu người dùng nhập vào số khác thì in ra text "Mời bạn nhập lại" và quay trở lại bước 1
    public static void question8() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Mời bạn nhập vào chức năng muốn sử dụng:");
            System.out.println("1. Tạo Account");
            System.out.println("2. Tạo Department");

            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    Account acc = question5();
                    System.out.println("Tạo Account thành công!");
                    System.out.println("Full Name: " + acc.fullName);
                    return;

                case 2:
                    Department dep = question6();
                    System.out.println("Tạo Department thành công!");
                    System.out.println("Department Name: " + dep.departmentName);
                    return;

                default:
                    System.out.println("Mời bạn nhập lại!");
            }
        }
    }

    // Question 9:
    //Viết method cho phép người dùng thêm group vào account theo flow sau:
    //Bước 1: In ra tên các usernames của user cho người dùng xem
    //Bước 2: Yêu cầu người dùng nhập vào username của account
    //Bước 3:  In ra tên các group cho người dùng xem
    //Bước 4: Yêu cầu người dùng nhập vào tên của group
    //Bước 5:  Dựa vào username và tên của group người dùng vừa chọn, hãy thêm account vào group đó .
    public static void question9(Account[] accounts, Group[] groups) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: In username của các account
        System.out.println("Danh sách username:");

        for (Account acc : accounts) {
            System.out.println(acc.userName);
        }

        // Bước 2: Nhập username
        scanner.nextLine();
        System.out.print("Nhập username của account: ");
        String inputUserName = scanner.nextLine();

        Account selectedAccount = null;

        for (Account acc : accounts) {
            if (acc.userName.equals(inputUserName)) {
                selectedAccount = acc;
                break;
            }
        }

        if (selectedAccount == null) {
            System.out.println("Không tìm thấy account!");
            return;
        }

        // Bước 3: In tên group
        System.out.println("Danh sách group:");

        for (Group gr : groups) {
            System.out.println(gr.groupName);
        }

        // Bước 4: Nhập tên group
        System.out.print("Nhập tên group muốn thêm: ");
        String inputGroupName = scanner.nextLine();

        Group selectedGroup = null;

        for (Group gr : groups) {
            if (gr.groupName.equals(inputGroupName)) {
                selectedGroup = gr;
                break;
            }
        }

        if (selectedGroup == null) {
            System.out.println("Không tìm thấy group!");
            return;
        }

        // Bước 5: Thêm account vào group
        selectedAccount.groups = new Group[] { selectedGroup };

        System.out.println("Thêm account vào group thành công!");
        System.out.println("Username: " + selectedAccount.userName);
        System.out.println("Group: " + selectedGroup.groupName);
    }

    // Question 10: Tiếp tục Question 8 và Question 9
    //Bổ sung thêm vào bước 2 của Question 8 như sau:
    //Nếu người dùng nhập vào 3 thì sẽ thực hiện chức năng thêm group vào account
    //Bổ sung thêm Bước 3 của Question 8 như sau:
    //Sau khi người dùng thực hiện xong chức năng ở bước 2 thì in ra dòng text để hỏi người dùng "Bạn có muốn thực hiện chức năng khác không?". Nếu người dùng chọn "Có" thì quay lại bước 1, nếu người dùng chọn "Không" thì kết thúc chương trình (sử dụng lệnh return để kết thúc chương trình)
    public static void question10(Account[] accounts, Group[] groups) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Mời bạn nhập vào chức năng muốn sử dụng:");
            System.out.println("1. Tạo Account");
            System.out.println("2. Tạo Department");
            System.out.println("3. Thêm Group vào Account");

            int choose = scanner.nextInt();

            switch (choose) {

                case 1:
                    Account acc = question5();
                    System.out.println("Tạo Account thành công!");
                    System.out.println("Full Name: " + acc.fullName);
                    break;

                case 2:
                    Department dep = question6();
                    System.out.println("Tạo Department thành công!");
                    System.out.println("Department Name: " + dep.departmentName);
                    break;

                case 3:
                    question9(accounts, groups);
                    break;

                default:
                    System.out.println("Mời bạn nhập lại!");
                    continue;
            }

            scanner.nextLine();
            System.out.print("Bạn có muốn thực hiện chức năng khác không? (Có/Không): ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("Không")) {
                System.out.println("Kết thúc chương trình!");
                return;
            }
        }
    }

    // Question 11: Tiếp tục Question 10 Bổ sung thêm vào bước 2 của Question 8 như sau:
    //Nếu người dùng nhập vào 4 thì sẽ thực hiện chức năng thêm account vào 1 nhóm ngẫu nhiên, chức năng sẽ được cài đặt như sau:
    //Bước 1:  In ra tên các usernames của user cho người dùng xem
    //Bước 2:  Yêu cầu người dùng nhập vào username của account
    //Bước 3: Sau đó chương trình sẽ chọn ngẫu nhiên 1 group
    //Bước 4:  Thêm account vào group chương trình vừa chọn ngẫu nhiên
    public static void question11(Account[] accounts, Group[] groups) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("Mời bạn nhập vào chức năng muốn sử dụng:");
            System.out.println("1. Tạo Account");
            System.out.println("2. Tạo Department");
            System.out.println("3. Thêm Group vào Account");
            System.out.println("4. Thêm Account vào Group ngẫu nhiên");

            int choose = scanner.nextInt();

            switch (choose) {

                case 1:
                    Account acc = question5();
                    System.out.println("Tạo Account thành công!");
                    System.out.println("Full Name: " + acc.fullName);
                    break;

                case 2:
                    Department dep = question6();
                    System.out.println("Tạo Department thành công!");
                    System.out.println("Department Name: " + dep.departmentName);
                    break;

                case 3:
                    question9(accounts, groups);
                    break;

                case 4:
                    // Bước 1: In username
                    System.out.println("Danh sách username:");

                    for (Account a : accounts) {
                        System.out.println(a.userName);
                    }

                    // Bước 2: Nhập username
                    scanner.nextLine();
                    System.out.print("Nhập username của account: ");
                    String inputUserName = scanner.nextLine();

                    Account selectedAccount = null;

                    for (Account a : accounts) {
                        if (a.userName.equals(inputUserName)) {
                            selectedAccount = a;
                            break;
                        }
                    }

                    if (selectedAccount == null) {
                        System.out.println("Không tìm thấy account!");
                        break;
                    }

                    // Bước 3: Random group
                    int randomIndex = random.nextInt(groups.length);
                    Group randomGroup = groups[randomIndex];

                    // Bước 4: Thêm account vào group
                    selectedAccount.groups = new Group[]{randomGroup};

                    System.out.println("Đã thêm account vào group ngẫu nhiên!");
                    System.out.println("Username: " + selectedAccount.userName);
                    System.out.println("Group được chọn: " + randomGroup.groupName);
                    break;

                default:
                    System.out.println("Mời bạn nhập lại!");
                    continue;
            }

            scanner.nextLine();
            System.out.print("Bạn có muốn tiếp tục không? (Có/Không): ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("Không")) {
                System.out.println("Kết thúc chương trình!");
                return;
            }
        }
    }
}
