import java.time.format.DateTimeFormatter;

public class Exercise3 {
    //Question1: In ra thông tin Exam thứ 1 và property create date sẽ được format theo định dạng vietnamese
    public void question1(Exam exam1){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("ExamID: " + exam1.examId);
        System.out.println("Title: " + exam1.title);
        System.out.println("Code: " + exam1.code);
        System.out.println("Create Date: " + exam1.createDate.format(formatter));
    }

    //Question2: In ra thông tin: Exam đã tạo ngày nào theo định dạng
    //Năm – tháng – ngày – giờ – phút – giây
    public void question2(Exam exam1){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
        System.out.println("Exam được tạo ngày: " + exam1.createDate.format(formatter));
    }

    //Question3: Chỉ in ra năm của create date property trong Question 2
    public void question3(Exam exam1){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        System.out.println("Năm tạo: " + exam1.createDate.format(formatter));
    }

    //Question4: Chỉ in ra tháng và năm của create date property trong Question 2
    public void question4(Exam exam1){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");
        System.out.println("Năm và tháng tạo: " + exam1.createDate.format(formatter));
    }

    //Question5: Chỉ in ra "MM-DD" của create date trong Question 2
    public void question5(Exam exam1){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
        System.out.println("MM-DD: " + exam1.createDate.format(formatter));
    }
}
