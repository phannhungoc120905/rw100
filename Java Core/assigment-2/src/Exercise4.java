import java.time.LocalDate;
import java.util.Random;

public class Exercise4 {
    // Question 1:
    //In ngẫu nhiên ra 1 số nguyên
    public static void question1(){
        Random random = new Random();
        int number = random.nextInt(100);
        System.out.println("Số nguyên ngẫu nhiên " + number);
    }

    //Question 2:
    //In ngẫu nhiên ra 1 số thực
    public static void question2(){
        Random random = new Random();
        float number = random.nextFloat(100);
        System.out.println("Số thực ngẫu nhiên " + number);
    }

    // Question 3:  Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1 bạn
    public static void question3(){
        String[] names = {"Uyên", "An", "Băng", "Như", "Quỳnh"};
        Random random = new Random();
        int index = random.nextInt(names.length);
        System.out.println("Tên ngẫu nhiên " + names[index]);
    }

    // Question 4:
    //Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-121995
    public static void question4(){
        Random random = new Random();
        LocalDate start = LocalDate.of(1995,7,24);
        LocalDate end = LocalDate.of(1995,12,20);

        int randomDays = random.nextInt((int)(end.toEpochDay()-start.toEpochDay()));
        LocalDate randomDate = start.plusDays(randomDays);
        System.out.println("Ngày ngẫu nhiên " + randomDate);
    }

    // Question 5:
    //Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây
    public static void question5() {
        Random random = new Random();

        LocalDate end = LocalDate.now();
        LocalDate start = end.minusYears(1);

        int randomDays = random.nextInt((int)
                (end.toEpochDay() - start.toEpochDay()));

        LocalDate randomDate = start.plusDays(randomDays);

        System.out.println("Ngày ngẫu nhiên trong 1 năm gần đây: " + randomDate);
    }

    // Question 6:
    //Lấy ngẫu nhiên 1 ngày trong quá khứ
    public static void question6() {
        Random random = new Random();

        LocalDate start = LocalDate.of(2005, 1, 1);
        LocalDate end = LocalDate.now();

        int randomDays = random.nextInt((int)
                (end.toEpochDay() - start.toEpochDay()));

        LocalDate randomDate = start.plusDays(randomDays);

        System.out.println("Ngày ngẫu nhiên trong quá khứ: " + randomDate);
    }

    // Question 7:
    //Lấy ngẫu nhiên 1 số có 3 chữ số
    public static void question7() {
        Random random = new Random();

        int number = 100 + random.nextInt(900);

        System.out.println("Số ngẫu nhiên có 3 chữ số: " + number);
    }
}
