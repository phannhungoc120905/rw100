import java.util.Arrays;

public class Exercise5 {

    // Question 1:
    //In ra thông tin của phòng ban thứ 1 (sử dụng toString())
    public static void question1(Department department1) {
        System.out.println(department1.toString());
    }

    //Question 2:
    //In ra thông tin của tất cả phòng ban (sử dụng toString())
    public static void question2(Department[] departments) {
        for (Department department : departments) {
            System.out.println(department.toString());
        }
    }

    // Question 3:
    //In ra địa chỉ của phòng ban thứ 1
    public static void question3(Department department1) {
        System.out.println("Địa chỉ phòng ban thứ 1 là: " + department1.departmentName);
    }

    // Question 4: Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không?
    public static void question4(Department department1) {
        if (department1.departmentName.equals("Phòng A")) {
            System.out.println("Phòng ban thứ 1 là Phòng A");
        } else {
            System.out.println("Phòng ban thứ 1 không phải là Phòng A");
        }
    }

    // Question 5: So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau không (bằng nhau khi tên của 2 phòng ban đó bằng nhau)
    public static void question5(Department department1, Department department2) {
        if (department1.departmentName.equals(department2.departmentName)) {
            System.out.println("Hai phòng ban bằng nhau");
        } else {
            System.out.println("Hai phòng ban không bằng nhau");
        }
    }

    // Question 6: Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD) VD:
    //	 	Accounting
    //Boss of director
    //Marketing
    //Sale
    //Waiting room
    public static void question6() {
        Department[] departments = new Department[5];

        departments[0] = new Department();
        departments[0].departmentName = "Sale";

        departments[1] = new Department();
        departments[1].departmentName = "Accounting";

        departments[2] = new Department();
        departments[2].departmentName = "Marketing";

        departments[3] = new Department();
        departments[3].departmentName = "Boss of director";

        departments[4] = new Department();
        departments[4].departmentName = "Waiting room";

        for (int i = 0; i < departments.length - 1; i++) {
            for (int j = i + 1; j < departments.length; j++) {
                if (departments[i].departmentName.compareTo(departments[j].departmentName) > 0) {
                    Department temp = departments[i];
                    departments[i] = departments[j];
                    departments[j] = temp;
                }
            }
        }

        System.out.println("Danh sách phòng ban sau khi sắp xếp:");

        for (Department department : departments) {
            System.out.println(department.departmentName);
        }
    }

    // Question 7: Khởi tạo 1 array học sinh gồm 5 Phòng ban, sau đó in ra danh sách phòng ban được sắp xếp theo tên VD:
    //Accounting
    //Boss of director Marketing waiting room Sale
    public static void question7() {
        Department[] departments = new Department[5];

        departments[0] = new Department();
        departments[0].departmentName = "Marketing";

        departments[1] = new Department();
        departments[1].departmentName = "Sale";

        departments[2] = new Department();
        departments[2].departmentName = "Accounting";

        departments[3] = new Department();
        departments[3].departmentName = "Waiting room";

        departments[4] = new Department();
        departments[4].departmentName = "Boss of director";

        Arrays.sort(departments, (d1, d2) ->
                d1.departmentName.compareTo(d2.departmentName));

        System.out.println("Danh sách phòng ban sau khi sắp xếp:");

        for (Department department : departments) {
            System.out.println(department.departmentName);
        }
    }
}