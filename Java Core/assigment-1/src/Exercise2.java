import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Exercise2 {
    // Question 1:  Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó
    public void question1(){
        int number = 5;
        System.out.println("Số nguyên là: " + number);
    }

    // Question 2:
    //Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in ra số nguyên đó thành định dạng như sau: 100,000,000
    public void question2() {
        int number = 100000000;
        System.out.println("Số nguyên là: %,d\n"+ number);
    }

    // Question 3:
    //Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số thực đó chỉ bao gồm 4 số đằng sau
    public void question3() {
        double number = 5.567098;
        System.out.println("Số thực là: %.4f\n"+ number);
    }

    //Question 4:
    //Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định dạng như sau:
    //Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
    //Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
    public void question4(){
        String name = "Nguyễn Văn A";
        System.out.println("Tên tôi là " + name + "và tôi đang độc thân");
    }

    //Question 5:
    //Lấy thời gian bây giờ và in ra theo định dạng sau:
    //24/04/2020 11h:16p:20s
    public void question5(){
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH'h':mm'm':ss's'");
        System.out.printf("Thời gian hiện tại: ", format.format(now));
    }

    //Question 6:
    //In ra thông tin account (như Question 8 phần FOREACH) theo định dạng table (giống trong Database)
    public void question6(Account[] accounts) {

        System.out.printf("%-20s %-20s %-20s\n", "Email", "Full Name", "Department");

        for (Account acc : accounts) {

            String deptName;

            if (acc.department == null) {
                deptName = "Chưa có";
            } else {
                deptName = acc.department.departmentName;
            }

            System.out.printf("%-20s %-20s %-20s\n",
                    acc.email,
                    acc.fullName,
                    deptName);
        }
    }
}
