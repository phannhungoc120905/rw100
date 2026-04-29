public class Exercise3 {

    //Question 1: Khởi tạo lương có datatype là Integer có giá trị bằng 5000. Sau đó convert lương ra float và hiển thị lương lên màn hình (với số float có 2 số sau dấu thập phân)
    public static void question1() {

        Integer salary = 5000;

        float salaryFloat = salary.floatValue();

        System.out.printf("Lương là: %.2f\n", salaryFloat);
    }

    // Question 2:
    //Khai báo 1 String có value = "1234567"
    //Hãy convert String đó ra số int
    public static void question2() {

        String str = "1234567";

        int number = Integer.parseInt(str);

        System.out.println("Số int là: " + number);
    }

    // Question 3:
    //Khởi tạo 1 số Integer có value là chữ "1234567"
    //Sau đó convert số trên thành datatype int
    public static void question3() {

        Integer numberInteger = Integer.valueOf("1234567");

        int numberInt = numberInteger;

        System.out.println("Số int là: " + numberInt);
    }
}