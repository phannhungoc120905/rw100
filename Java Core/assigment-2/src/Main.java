import java.time.LocalDate;
import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Tạo 3 đối tượng cho Department
        Department department1 = new Department();
        department1.departmentId = 1;
        department1.departmentName = "Sale";

        Department department2 = new Department();
        department2.departmentId = 2;
        department2.departmentName = "Marketing";

        Department department3 = new Department();
        department3.departmentId = 3;
        department3.departmentName = "Production";

        // Tạo 3 đối tượng cho Position
        Position position1 = new Position();
        position1.positionId = 1;
        position1.postion = PositionName.PM;

        Position position2 = new Position();
        position2.positionId = 2;
        position2.postion = PositionName.DEV;

        Position position3 = new Position();
        position3.positionId = 3;
        position3.postion = PositionName.SCRUM_MASTER;

        // 3 đối tượng cho Account
        Account account1 = new Account();
        account1.accountId = 1;
        account1.userName = "Minh";
        account1.email = "Minh@gmail.com";
        account1.fullName = "Nguyễn Hào Minh";
        account1.department = department1;
        account1.position = position1;
        account1.createDate = LocalDate.of(2023, 10, 27);

        Account account2 = new Account();
        account2.accountId = 2;
        account2.userName = "Chiến";
        account2.email = "Chien@gmail.com";
        account2.fullName = "Nguyễn Hào Chiến";
        account2.department = department2;
        account2.position = position2;
        account2.createDate = LocalDate.of(2023,1,1);

        Account account3 = new Account();
        account3.accountId = 3;
        account3.userName = "Hân";
        account3.email = "Han@gmail.com";
        account3.fullName = "Nguyễn Hào Hân";
        account3.department = department3;
        account3.position = position3;
        account3.createDate = LocalDate.of(2023, 3,3);

        // Tạo 3 đối tượng cho Group
        Group group1 = new Group();
        group1.groupId = 1;
        group1.groupName = "Star";
        group1.creator = account1;
        group1.createDate = LocalDate.of(2023,4,2);

        Group group2 = new Group();
        group2.groupId = 2;
        group2.groupName = "Flower";
        group2.creator = account2;
        group2.createDate = LocalDate.of(2023,5,3);

        Group group3 = new Group();
        group3.groupId = 3;
        group3.groupName = "Cat";
        group3.creator = account3;
        group3.createDate = LocalDate.of(2023,7,3);

        GroupAccount ga1 = new GroupAccount();
        ga1.group = group1;
        ga1.account = account1;

        GroupAccount ga2 = new GroupAccount();
        ga2.group = group1;
        ga2.account = account2;

        GroupAccount ga3 = new GroupAccount();
        ga3.group = group2;
        ga3.account = account2;

        // Tạo 3 đối tượng cho Question
        CategoryQuestion cq1 = new CategoryQuestion();
        cq1.categoryId = 1;
        cq1.categoryName = "Java";

        TypeQuestion tp1 = new TypeQuestion();
        tp1.typeId = 1;
        tp1.type = TypeName.ESSAY;

        Question question1 = new Question();
        question1.questionId = 1;
        question1.content = "Java là gì?";
        question1.category = cq1;
        question1.type = tp1;
        question1.creator = account1;


        CategoryQuestion cq2 = new CategoryQuestion();
        cq2.categoryId = 2;
        cq2.categoryName = "Net";

        TypeQuestion tp2 = new TypeQuestion();
        tp2.typeId = 2;
        tp2.type = TypeName.MULTIPLE_CHOICE;

        Question question2 = new Question();
        question2.questionId = 2;
        question2.content = "NET là gì?";
        question2.category = cq2;
        question2.type = tp2;
        question2.creator = account2;

        CategoryQuestion cq3 = new CategoryQuestion();
        cq3.categoryId = 3;
        cq3.categoryName = "SQL";

        TypeQuestion tp3 = new TypeQuestion();
        tp3.typeId = 3;
        tp3.type = TypeName.ESSAY;

        Question question3 = new Question();
        question3.questionId = 3;
        question3.content = "SQL là gì?";
        question3.category = cq3;
        question3.type= tp3;
        question3.creator= account3;

        // Tạo 3 đối tượng cho Answer
        Answer answer1 = new Answer();
        answer1.answerId = 1;
        answer1.content = "Ngôn ngữ lập trình";
        answer1.question = question1;
        answer1.isCorrect = true;

        Answer answer2 = new Answer();
        answer2.answerId = 2;
        answer2.content = "Ngôn ngữ lập trình";
        answer2.question = question2;
        answer2.isCorrect = true;

        Answer answer3 = new Answer();
        answer3.answerId = 3;
        answer3.content = "Ngôn ngữ lập trình";
        answer3.question = question3;
        answer3.isCorrect = false;

        // Tạo 3 đối tượng cho Exam
        Exam exam1 = new Exam();
        exam1.examId = 1;
        exam1.code = "EOO123";
        exam1.title = "Java Basic";
        exam1.category = cq1;
        exam1.duration = 30;
        exam1.creator = account1;
        exam1.createDate = LocalDateTime.now();

        Exam exam2 = new Exam();
        exam2.examId = 2;
        exam2.code = "EOO143";
        exam2.title = "NET Basic";
        exam2.category = cq2;
        exam2.duration = 30;
        exam2.creator= account2;

        Exam exam3 = new Exam();
        exam3.examId = 3;
        exam3.code = "EOO153";
        exam3.title = "SQL Basic";
        exam3.category = cq3;
        exam3.duration = 30;
        exam3.creator = account3;

        // Test cho exercise 1, 2, 3
        Exercise1 ex1 = new Exercise1();
        Exercise2 ex2 = new Exercise2();
        Exercise3 ex3 = new Exercise3();
        Account[] accounts = {account1, account2, account3};
        GroupAccount[] groupAccounts = {ga1, ga2, ga3};

        System.out.println("===== Exercise1 =====");
        ex1.question1(account2);
        ex1.question2(account2, groupAccounts);
        ex1.question3(account2);
        ex1.question4(account1);
        ex1.question5(groupAccounts, group1);
        ex1.question6(account2, groupAccounts);
        ex1.question7(account1);

        ex1.question8(accounts);

        System.out.println("\n===== EXERCISE 2 =====");

        ex2.question1();
        ex2.question2();
        ex2.question3();
        ex2.question4();
        ex2.question5();
        ex2.question6(accounts);
        System.out.println("\n===== EXERCISE 3 =====");

        ex3.question1(exam1);
        ex3.question2(exam1);
        ex3.question3(exam1);
        ex3.question4(exam1);
        ex3.question5(exam1);
    }
}