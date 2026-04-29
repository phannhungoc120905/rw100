import java.util.Random;
import java.util.Scanner;

public class Exercise1 {
    // Question 1:
    //Khai báo 2 số lương có kiểu dữ liệu là float.
    //Khởi tạo Lương của Account 1 là 5240.5 $
    //Khởi tạo Lương của Account 2 là 10970.055$
    //
    //Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
    //Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra
    public static void question1() {
        float salaryAccount1 = 5240.5f;
        float salaryAccount2 = 10970.055f;

        int roundSalary1 = (int) salaryAccount1;
        int roundSalary2 = (int) salaryAccount2;

        System.out.println("Lương Account 1: " + roundSalary1);
        System.out.println("Lương Account 2: " + roundSalary2);
    }

    //Question 2:
    //Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm có số 0 ở đầu cho đủ 5 chữ số)
    public static void question2() {
        Random random = new Random();

        int number = random.nextInt(100000);

        System.out.printf("Số ngẫu nhiên 5 chữ số: %05d\n", number);
    }

    // Question 3:
    //Lấy 2 số cuối của số ở Question 2 và in ra.
    //Gợi ý:
    //Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối
    //Cách 2: chia lấy dư số đó cho 100
    public static void question3() {
        Random random = new Random();

        int number = random.nextInt(100000);

        System.out.printf("Số 5 chữ số: %05d\n", number);

        int lastTwoDigits = number % 100;

        System.out.printf("2 số cuối là: %02d\n", lastTwoDigits);
    }

    // Question 4:
    //Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng
    public static void question4() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số nguyên a: ");
        int a = scanner.nextInt();

        System.out.print("Nhập số nguyên b: ");
        int b = scanner.nextInt();

        if (b == 0) {
            System.out.println("Không thể chia cho 0");
            return;
        }

        float result = (float) a / b;

        System.out.println("Thương của a / b là: " + result);
    }
}
