public class Exercise1 {

    // Question 1: Kiểm tra account thứ 2
    // Nếu không có phòng ban (tức là department == null) thì sẽ in ra text
    // "Nhân viên này chưa có phòng ban"
    // Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là …"
    public void question1(Account account2){
        if(account2.department == null){
            System.out.println("Nhân viên này chưa có phòng ban");
        } else {
            System.out.println("Phòng ban của nhân viên này là "+ account2.department.departmentName);
        }
    }

    // Question 2: Kiểm tra account thứ 2
    // Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
    // Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên này là Java Fresher, C# Fresher"
    // Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều group"
    // Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là người hóng chuyện, tham gia tất cả các group"
    public void question2(Account account2, GroupAccount[] groupAccounts){
        int count = 0;
        for (GroupAccount ga : groupAccounts){
            if(ga.account == account2){
                count++;
            }
        }
        if(count == 0){
            System.out.println("Nhân viên này chưa có group");
        }else if(count <= 2){
            System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
        }else if(count == 3){
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        } else {
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }
    }

    // Question3: Sử dụng toán tử ternary để làm Question 1
    public void question3(Account account2){
        String result = (account2.department == null) ? "Nhân viên này chưa có phòng ban" : "Phòng ban của nhân viên này là "+ account2.department.departmentName;
        System.out.println(result);
    }

    // Question 4: Sử dụng toán tử ternary để làm yêu cầu sau:
    // Kiểm tra Position của account thứ 1
    // Nếu Position = Dev thì in ra text "Đây là Developer"
    // Nếu không phải thì in ra text "Người này không phải là Developer"
    public void question4(Account account1){
        String result = (account1.position.postion.name().equals("DEV")) ? "Đây là Developer" : "Người này không phải là Developer";
        System.out.println(result);
    }

    // Question5: Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau: Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
    // Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
    // Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
    // Còn lại in ra "Nhóm có nhiều thành viên"
    public void question5(GroupAccount[] groupAccounts, Group group1){
        int count = 0;
        for(GroupAccount ga : groupAccounts){
            if(ga.group == group1){
                count++;
            }
        }
        switch (count){
            case 1:
                System.out.println("Nhóm có một thành viên");
                break;
            case 2:
                System.out.println("Nhóm có hai thành viên");
                break;
            case 3:
                System.out.println("Nhóm có ba thành viên");
                break;
            default:
                System.out.println("Nhóm có nhiều thành viên");
        }
    }
    // Question 6: Sử dụng switch case để làm lại Question 2
    public void question6(Account account2, GroupAccount[] groupAccounts){
        int count = 0;
        String groupNames = "";
        for(GroupAccount ga : groupAccounts){
            if(ga.account == account2){
                count++;
                groupNames += ga.group.groupName + ", ";
            }
        }
        switch (count){
            case 0:
                System.out.println("Nhân viên này chưa có group");
                break;
            case 1:
            case 2:
                if(groupNames.length() > 2){
                    groupNames = groupNames.substring(0, groupNames.length() - 2);
                }
                System.out.println("Group của nhân viên này là " + groupNames);
                break;
            case 3:
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                break;
            default:
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");

        }
    }
    //Question7: Sử dụng switch case để làm lại Question 4
    public void question7(Account account1){
        String positionName = account1.position.postion.name();
        switch (positionName){
            case "DEV":
                System.out.println("Đây là Developer");
                break;
            default:
                System.out.println("Người này không phải là Developer");
        }
    }
    // Question8: In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ
    public void question8(Account[] accounts){
        for(Account acc : accounts){
            System.out.println(acc.email + " - " + acc.fullName + " - " + acc.department.departmentName);
        }
    }
    // Question9: In ra thông tin các phòng ban bao gồm: id và name
    public void question9(Department[] departments){
        for(Department de : departments){
            System.out.println("ID: " + de.departmentId);
            System.out.println("Name: " + de.departmentName);
        }
    }
    // Question10: In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau:
    //Thông tin account thứ 1 là:
    //Email: NguyenVanA@gmail.com
    //Full name: Nguyễn Văn A
    //Phòng ban: Sale
    //
    //Thông tin account thứ 2 là:
    //Email: NguyenVanB@gmail.com
    //Full name: Nguyễn Văn B
    //Phòng ban: Marketting
    public void question10(Account[] accounts){
        for(int i = 0; i < accounts.length; i++){
            System.out.println("Thông tin account thứ " + (i + 1));
            System.out.println("\tEmail: " + accounts[i].email);
            System.out.println("\tFull name: " + accounts[i].fullName);
            System.out.println("\tPhòng ban: " +accounts[i].department.departmentName);
        }
    }
    // Question11: In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
    //Thông tin department thứ 1 là:
    //	 	 	Id: 1
    //	 	 	Name: Sale
    //Thông tin department thứ 2 là:
    //	 	 	Id: 2
    //	 	 	Name: Marketing
    public void question11(Department[] departments){
        for(int i = 0; i < departments.length; i++) {
            System.out.println("Thông tin department thứ " + (i + 1));
            System.out.println("\tId: " + departments[i].departmentId);
            System.out.println("\tName: " + departments[i].departmentName);
        }
    }
    // Question12:Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
    public void question12(Department[] departments){
        for(int i = 0; i < departments.length; i++) {
            if (i == 2) break;
            System.out.println("Thông tin department thứ " + (i + 1));
            System.out.println("\tId: " + departments[i].departmentId);
            System.out.println("\tName: " + departments[i].departmentName);
        }
    }

    // Question13: In ra thông tin tất cả các account ngoại trừ account thứ 2
    public void question13(Account[] accounts){
        for(int i = 0; i < accounts.length; i++){
            if (i == 1) continue;
            System.out.println("\tEmail: " + accounts[i].email);
            System.out.println("\tFull name: " + accounts[i].fullName);
        }
    }

    // Question14: In ra thông tin tất cả các account có id < 4
    public void question14(Account[] accounts) {
        for (Account acc : accounts) {
            if (acc.accountId < 4) {
                System.out.println("Email: " + acc.email);
                System.out.println("Full Name: " + acc.fullName);
            }
        }
    }

    //Question15: In ra các số chẵn nhỏ hơn hoặc bằng 20
    public void question15() {
        for (int i = 0; i <= 20; i = i + 2) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }

    // Question16: Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với lệnh break, continue
    // Bài 10
    public void while_question10(Account[] accounts){
        int i = 0;
        while (i < accounts.length) {
            System.out.println("Thông tin account thứ " + (i + 1));
            System.out.println("\tEmail: " + accounts[i].email);
            System.out.println("\tFull name: " + accounts[i].fullName);
            System.out.println("\tPhòng ban: " + accounts[i].department.departmentName);
            i++;
        }
    }
    // Bài 11
    public void while_question11(Department[] departments){
        int i = 0;
        while (i < departments.length) {
            System.out.println("Thông tin department thứ " + (i + 1));
            System.out.println("\tId: " + departments[i].departmentId);
            System.out.println("\tName: " + departments[i].departmentName);
            i++;
        }
    }
    //Bài 12
    public void while_question12(Department[] departments){
        int i = 0;
        while(i < departments.length) {
            if (i == 2) break;
            System.out.println("Thông tin department thứ " + (i + 1));
            System.out.println("\tId: " + departments[i].departmentId);
            System.out.println("\tName: " + departments[i].departmentName);
            i++;
        }
    }
    //Bài 13
    public void while_question13(Account[] accounts){
        int i = 0;
        while ( i < accounts.length){
            if (i == 1) continue;
            System.out.println("\tEmail: " + accounts[i].email);
            System.out.println("\tFull name: " + accounts[i].fullName);
            i++;
        }
    }

    // Question 17: Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với lệnh break, continue
    // Bài 10
    public void do_question10(Account[] accounts){
        int i = 0;
        if(accounts.length == 0) return;
        do {
            System.out.println("Thông tin account thứ " + (i + 1));
            System.out.println("\tEmail: " + accounts[i].email);
            System.out.println("\tFull name: " + accounts[i].fullName);
            System.out.println("\tPhòng ban: " + accounts[i].department.departmentName);
            i++;
        } while (i < accounts.length);
    }
    // Bài 11
    public void do_question11(Department[] departments){
        int i = 0;
        if(departments.length == 0) return;
        do {
            System.out.println("Thông tin department thứ " + (i + 1));
            System.out.println("\tId: " + departments[i].departmentId);
            System.out.println("\tName: " + departments[i].departmentName);
            i++;
        } while (i < departments.length);
    }
    // Bài 12
    public void do_question12(Department[] departments){
        int i = 0;
        if (departments.length == 0) return;
        do {
            if (i == 2) break;
            System.out.println("Thông tin department thứ " + (i + 1));
            System.out.println("\tId: " + departments[i].departmentId);
            System.out.println("\tName: " + departments[i].departmentName);
            i++;
        } while(i < departments.length);
    }
    // Bài 13
    public void do_question13(Account[] accounts){
        int i = 0;
        if(accounts.length == 0) return;
        do{
            if (i == 1) continue;
            System.out.println("\tEmail: " + accounts[i].email);
            System.out.println("\tFull name: " + accounts[i].fullName);
            i++;
        } while ( i < accounts.length);
    }


}
