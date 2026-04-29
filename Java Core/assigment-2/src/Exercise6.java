public class Exercise6 {
    // Question 1:
    //Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10
    public static void question1() {
        System.out.println("Các số chẵn nhỏ hơn 10:");

        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
    }

    //Question 2:
    //Tạo method để in thông tin các account
    public static void question2(Account[] accounts) {
        for (Account acc : accounts) {
            System.out.println("Email: " + acc.email);
            System.out.println("Full Name: " + acc.fullName);
        }
    }

    // Question 3:
    //Tạo method để in ra các số nguyên dương nhỏ hơn 10
    public static void question3() {
        System.out.println("Các số nguyên dương nhỏ hơn 10:");

        for (int i = 1; i < 10; i++) {
            System.out.print(i + " ");
        }

        System.out.println();
    }
}
