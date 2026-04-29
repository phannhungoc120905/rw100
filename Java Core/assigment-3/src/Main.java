//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Department department1 = new Department();
        department1.departmentId = 1;
        department1.departmentName = "Sale";

        Department department2 = new Department();
        department2.departmentId = 2;
        department2.departmentName = "Marketing";

        Department department3 = new Department();
        department3.departmentId = 3;
        department3.departmentName = "Phòng A";

        Department[] departments = {
                department1,
                department2,
                department3
        };

        Account account1 = new Account();
        account1.accountId = 1;
        account1.email = "email1@gmail.com";
        account1.userName = "user1";
        account1.fullName = "Nguyễn Văn A";

        Account account2 = new Account();
        account2.accountId = 2;
        account2.email = "email2@gmail.com";
        account2.userName = "user2";
        account2.fullName = "Nguyễn Văn B";

        Account account3 = new Account();
        account3.accountId = 3;
        account3.email = "email3@gmail.com";
        account3.userName = "user3";
        account3.fullName = "Nguyễn Văn C";

        Account[] accounts = {
                account1,
                account2,
                account3
        };

        Group group1 = new Group();
        group1.groupId = 1;
        group1.groupName = "Java Fresher";

        Group group2 = new Group();
        group2.groupId = 2;
        group2.groupName = "C# Fresher";

        Group group3 = new Group();
        group3.groupId = 3;
        group3.groupName = "Java";

        Group[] groups = {
                group1,
                group2,
                group3
        };

        Exercise1.question1();
        Exercise1.question2();
        Exercise1.question3();
        Exercise1.question4();

        Exercise5.question1(department1);
        Exercise5.question2(departments);
        Exercise5.question3(department1);
        Exercise5.question4(department3);
        Exercise5.question5(department1, department2);
        Exercise5.question6();
        Exercise5.question7();

        Exercise4.question1();
        Exercise4.question2();
        Exercise4.question3();
        Exercise4.question4();
        Exercise4.question5();
        Exercise4.question6();
        Exercise4.question7();
        Exercise4.question8(groups);
        Exercise4.question9(groups);
        Exercise4.question10();
        Exercise4.question11();
        Exercise4.question12();
        Exercise4.question13();
        Exercise4.question14();
        Exercise4.question15();
        Exercise4.question16();

    }
    }