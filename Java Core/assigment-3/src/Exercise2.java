import java.time.LocalDate;

public class Exercise2 {
        public static void question1() {

            Account account1 = new Account();
            account1.email = "Email 1";
            account1.userName = "User name 1";
            account1.fullName = "Full name 1";
            account1.createDate = LocalDate.now();

            Account account2 = new Account();
            account2.email = "Email 2";
            account2.userName = "User name 2";
            account2.fullName = "Full name 2";
            account2.createDate = LocalDate.now();

            Account account3 = new Account();
            account3.email = "Email 3";
            account3.userName = "User name 3";
            account3.fullName = "Full name 3";
            account3.createDate = LocalDate.now();

            Account account4 = new Account();
            account4.email = "Email 4";
            account4.userName = "User name 4";
            account4.fullName = "Full name 4";
            account4.createDate = LocalDate.now();

            Account account5 = new Account();
            account5.email = "Email 5";
            account5.userName = "User name 5";
            account5.fullName = "Full name 5";
            account5.createDate = LocalDate.now();

            Account[] accounts = {
                    account1,
                    account2,
                    account3,
                    account4,
                    account5
            };

            for (Account acc : accounts) {
                System.out.println("Email: " + acc.email);
                System.out.println("Username: " + acc.userName);
                System.out.println("Full Name: " + acc.fullName);
                System.out.println("Create Date: " + acc.createDate);
                System.out.println("----------------------");
            }
        }

    }
