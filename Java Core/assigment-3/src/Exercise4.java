import java.util.Scanner;

public class Exercise4 {
    //Question 1:
    //Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có thể cách nhau bằng nhiều khoảng trắng );
    public static void question1() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập một xâu ký tự: ");
        String str = scanner.nextLine();

        str = str.trim();
        String[] words = str.split("\\s+");

        System.out.println("Số lượng từ là: " + words.length);
    }

    //Question 2:
    //Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
    public static void question2() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi s1: ");
        String s1 = scanner.nextLine();

        System.out.print("Nhập chuỗi s2: ");
        String s2 = scanner.nextLine();

        String result = s1 + " " + s2;

        System.out.println("Chuỗi sau khi nối là: " + result);
    }

    //Question 3:
    //Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chư viết hoa chữ cái đầu thì viết hoa lên
    public static void question3() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên của bạn: ");
        String name = scanner.nextLine();

        String firstChar = name.substring(0, 1).toUpperCase();
        String remaining = name.substring(1).toLowerCase();

        name = firstChar + remaining;

        System.out.println("Tên sau khi chuẩn hóa: " + name);
    }

    // Question 4:
    //Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên của người dùng ra VD:  Người dùng nhập vào "Nam", hệ thống sẽ in ra
    //"Ký tự thứ 1 là: N"
    //"Ký tự thứ 1 là: A"
    //"Ký tự thứ 1 là: M"
    public static void question4() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên của bạn: ");
        String name = scanner.nextLine();

        for (int i = 0; i < name.length(); i++) {
            System.out.println("Ký tự thứ " + (i + 1) + " là: " + name.charAt(i));
        }
    }

    //
    //Question 5:
    //Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ
    public static void question5() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập họ: ");
        String lastName = scanner.nextLine();

        System.out.print("Nhập tên: ");
        String firstName = scanner.nextLine();

        String fullName = lastName + " " + firstName;

        System.out.println("Họ và tên đầy đủ là: " + fullName);
    }

    // Question 6:
    //Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và sau đó hệ thống sẽ tách ra họ, tên , tên đệm VD:
    //	 	Người dùng nhập vào "Nguyễn Văn Nam"
    //	 	Hệ thống sẽ in ra
    //	 	 	"Họ là: Nguyễn"
    //"Tên đệm là: Văn"
    //"Tên là: Nam"

    public static void question6() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập họ và tên đầy đủ: ");
        String fullName = scanner.nextLine();

        fullName = fullName.trim();
        String[] words = fullName.split("\\s+");

        String ho = words[0];
        String ten = words[words.length - 1];

        String tenDem = "";
        for (int i = 1; i < words.length - 1; i++) {
            tenDem += words[i] + " ";
        }

        System.out.println("Họ là: " + ho);
        System.out.println("Tên đệm là: " + tenDem.trim());
        System.out.println("Tên là: " + ten);
    }

    //Question 7:
    //Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và  chuẩn hóa họ và tên của họ như sau:
    //Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập vào
    //VD: Nếu người dùng nhập vào "   nguyễn văn nam   " thì sẽ chuẩn hóa thành "nguyễn văn nam"
    //
    //Viết hoa chữ cái mỗi từ của người dùng VD: Nếu người dùng nhập vào "   nguyễn văn nam   " thì sẽ chuẩn hóa thành "Nguyễn Văn Nam"
    public static void question7() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập họ và tên đầy đủ: ");
        String fullName = scanner.nextLine();

        fullName = fullName.trim().toLowerCase();
        String[] words = fullName.split("\\s+");

        String result = "";

        for (int i = 0; i < words.length; i++) {
            String firstChar = words[i].substring(0, 1).toUpperCase();
            String remaining = words[i].substring(1);

            result += firstChar + remaining + " ";
        }

        System.out.println("Họ tên sau khi chuẩn hóa: " + result.trim());
    }

    //Question 8:
    //In ra tất cả các group có chứa chữ "Java"
    public static void question8(Group[] groups) {
        System.out.println("Các group có chứa chữ Java:");

        for (Group group : groups) {
            if (group.groupName.contains("Java")) {
                System.out.println(group.groupName);
            }
        }
    }

    //Question 9:
    //In ra tất cả các group "Java"
    public static void question9(Group[] groups) {
        System.out.println("Các group tên đúng là Java:");

        for (Group group : groups) {
            if (group.groupName.equals("Java")) {
                System.out.println(group.groupName);
            }
        }
    }

    // Question 10 (Optional):
    //Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không.
    //Nếu có xuất ra “OK” ngược lại “KO”.
    //Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau.
    public static void question10() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi thứ nhất: ");
        String str1 = scanner.nextLine();

        System.out.print("Nhập chuỗi thứ hai: ");
        String str2 = scanner.nextLine();

        String reverse = "";

        for (int i = str1.length() - 1; i >= 0; i--) {
            reverse += str1.charAt(i);
        }

        if (reverse.equals(str2)) {
            System.out.println("OK");
        } else {
            System.out.println("KO");
        }
    }

    //Question 11 (Optional): Count special Character
    //Tìm số lần xuất hiện ký tự "a" trong chuỗi
    public static void question11() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                count++;
            }
        }

        System.out.println("Số lần xuất hiện của ký tự a là: " + count);
    }

    //Question 12 (Optional): Reverse String
    //Đảo ngược chuỗi sử dụng vòng lặp
    public static void question12() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();

        String reverse = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }

        System.out.println("Chuỗi đảo ngược là: " + reverse);
    }

    // Question 13 (Optional): String not contains digit
    //Kiểm tra một chuỗi có chứa chữ số hay không, nếu có in ra false ngược lại true.
    //
    //Ví dụ:
    //"abc" => true
    //
    //"1abc", "abc1", "123", "a1bc", null => false

    public static void question13() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();

        if (str == null || str.isEmpty()) {
            System.out.println("false");
            return;
        }

        boolean check = true;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                check = false;
                break;
            }
        }

        System.out.println(check);
    }


    //Question 14 (Optional): Replace character
    //Cho một chuỗi str, chuyển các ký tự được chỉ định sang một ký tự khác cho trước.
    //Ví dụ:
    //"VTI Academy" chuyển ký tự 'e' sang '*' kết quả " VTI Acad*my"
    public static void question14() {
        String str = "VTI Academy";

        String result = str.replace('e', '*');

        System.out.println(result);
    }

    // Question 15 (Optional): Revert string by word
    //Đảo ngược các ký tự của chuỗi cách nhau bởi dấu cách mà không dùng thư viện.
    //
    //Ví dụ: "    I am developer      " => "developer am I".  Các ký tự bên trong chỉ cách nhau đúng một dấu khoảng cách.
    //
    //Gợi ý: Các bạn cần loại bỏ dấu cách ở đầu và cuối câu, thao tác cắt chuỗi theo dấu cách
    public static void question15() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();

        str = str.trim();
        String[] words = str.split("\\s+");

        String result = "";

        for (int i = words.length - 1; i >= 0; i--) {
            result += words[i] + " ";
        }

        System.out.println(result.trim());
    }

    // Question 16 (Optional):
    //Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str ra làm các phần bằng nhau với n ký tự. Nếu chuỗi không chia được thì xuất ra màn hình “KO”.
    public static void question16() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();

        System.out.print("Nhập số n: ");
        int n = scanner.nextInt();

        if (str.length() % n != 0) {
            System.out.println("KO");
            return;
        }

        for (int i = 0; i < str.length(); i += n) {
            System.out.println(str.substring(i, i + n));
        }
    }


}
