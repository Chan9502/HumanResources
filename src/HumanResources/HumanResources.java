package HumanResources;

import java.util.*;

public class HumanResources {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Department> listDepartment = new ArrayList<>();
    static ArrayList<Staff> staffList = new ArrayList<>();
    public static void main(String[] args) {
//      gọi hàm hiển thị dữ liệu của nhân viên
        listStaff();
//      gọi hàm hiển thị dữ liệu bộ phận
        listDeparment();
        int chose;
        do {
//          hiển thị menu cho người dùng
            runMainMenu();

//           yêu cầu người dùng nhập sự lưa chọn
            System.out.print("Lua Lua Chon Cua Ban (0 >=7): ");
            chose = sc.nextInt();

//          <Chi tiết các TH từ 0~7>
            switch (chose){
                case 1: //hiển thị toàn bộ nhân viên có trong công ty
                    System.out.println("Danh Sach Nhan Vien Toan Cong Ty");
                    showHeaderList();
                    showlistStaff();
                    break;
                case 2: //Hiển thị ds Bộ phận công ty
                    showAllDepart();
                    break;
                case 3://hiển thị các nhân viên theo từng bộ phận
                    showByDepart();
                    break;
                case 4: //Thêm nhân viên mới
                    add();
                    break;
                case 5://tìm kiếm thông tin nhân viên theo Tên hoặc ID
                    searchStaffByKey();
                    break;
                case 6://Hiển thị bảng lương của nhân viên theo thứ tự tăng dần
                    sortAscedanceBySalary();
                    break;
                case 7://hiển thị bảng lương theo thứ tự giảm dần
                    sortDescendanceBySalary();
                    break;
                    }
            }while (chose!= 0 && chose < 8);
        //nếu user chọn 0 -- kết thúc chương trình
        if(chose == 0 || chose > 7){
            System.out.println("Chuong Trinh Da Ket Thuc.");
            System.out.println("Cam On Ban!!!!");
            return;
        }
    }
//  Phần viết hàm

//  hàm hiển thị menu dùng cho người dùng nhập các lựa chọn
    public static void runMainMenu(){
        System.out.println(
                 "*================================================================*\n"
                + "    1. Hien Thi Danh Sach Nhan Vien Hien Co Trong Cong Ty\n"
                + "    2. Hien Thi Cac Bo Phan Trong Cong Ty\n"
                + "    3. Hien Thi Cac Nhan Vien Theo Tung Bo Phan\n"
                + "    4. Them Nhan Vien Moi Vao Cong Ty\n"
                + "    5. Tim Kiem Thong Tin Nhan Vien Theo Ten Hoac Ma Nhan Vien\n"
                + "    6. Hien Thi Bang Luong Cua Toan Nhan Vien\n"
                + "    7. Hien Thi Luong cua nhan vien theo thu tu\n"
                + "    0. Thoat Chuong Trinh\n"
                + "*================================================================*"
        );
    }
//  hàm hiển thị header cho danh sách nhân viên
    public static void showHeaderList(){
        System.out.println("------------------------------------------------------------------" +
                "----------------------------------------------------------------");
        System.out.printf("%-10s|%-16s|%-5s|%-10s|%-14s|%-15s|%-20s|%-20s|%-20s%n",
                "Ma NV","Ten NV",
                "Tuoi","HS Luong", "Ngay Vao Lam",
                "Ngay Nghi Phep", "Bo Phan","Gio Tang Ca/Chuc Vu", "Luong");
        System.out.println("------------------------------------------------------------------" +
                "----------------------------------------------------------------");
    }
//  danh sách bộ phận làm việc của công ty
    public static void listDeparment(){
//      thêm bộ phận làm việc
        Department d1 = new Department("HC", "Hanh Chinh Nhan Su",2);
        Department d2 = new Department("IT", "Cong Nghe Thong Tin",2);
        Department d3 = new Department("MKT", "Marketing",0);
        listDepartment.add(d1);
        listDepartment.add(d2);
        listDepartment.add(d3);
    }
//  danh sách nhân viên
    public static void listStaff(){
//      Thêm nhân viên thông thường
        Employee st1 = new Employee("EB001", "Phong Tuyet Hoa", 28, 3.2f, "10/10/2010", "Hanh Chinh Nhan Su", 10, 4.0f, 10400000f);
        Employee st2 = new Employee("EB002", "Tran Thi B", 24, 2.2f, "10/01/2010", "Hanh Chinh Nhan Su", 7, 3f, 7200000f);

//      Thêm nhân viên là Manager
        Manager m1 = new Manager("MA001", "Nguyen Van An", 25, 2.5f, "11/11/2010", "Cong Nghe Thong Tin", 5, "Business Leader", 20500000f);
        Manager m2 = new Manager("MA002", "Ta Van Luc", 32, 4.5f, "01/11/2010", "Cong Nghe Thong Tin", 1, "Technical Leader", 28500000f);

//      Thêm danh sách nhân viên vào danh sách chung
        staffList.add(st1);
        staffList.add(st2);
        staffList.add(m1);
        staffList.add(m2);
    }
//  hàm hiển thị danh sách toàn có trong công ty nhân viên --> done
    public static void showlistStaff() {
//      gọi hàm hiển thị danh sách nhân viên
        for (Staff x: staffList) {
            x.displayInformation();
        }
    }
//  hàm hiển thị danh sánh bộ phận --> done
    public static void showAllDepart(){
//       Hiển thị ds Bộ phận công ty
//       Header hiển thị thông tin
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-15s|%-20s|%-10s%n",
                "Ma Bo Phan","Ten Bo Phan",
                "So Luong Nhan Vien Hien Tai");
        System.out.println("----------------------------------------------------------------");
//       in danh sách bộ phận
//       dùng mảng duyệt mảng để in
        for (Department d: listDepartment) {
            System.out.print(d.toString());
        }
        System.out.println();
    }
//  hàm phụ giúp kiểm tra id nhập từ người dùng có tồn tại hay không?
    public static boolean containsId(ArrayList<Department> listDepartment, String id){
        for (Department d:listDepartment) {
            if(d.getDepartId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        System.out.println("Ma Bo Phan Khong Ton Tai");
        return false;
    }
//  hàm phụ kiểm tra xem ID Nhân viên được thêm mới có trùng với ID nhân viên đã có hay chưa?
//  ID Nhân viên không được trùng nhau
    public static boolean checkStaffID(ArrayList<Staff> staffList , String id){
        for (Staff s: staffList) {
            if (s.getId() != null && s.getId().equalsIgnoreCase(id)) {
                System.out.println("Ma Nhan Vien Da Ton Tai, Vui Long Nhap Lai!!!");
                return false;
            }
        }
        return true;
    }

//  hàm thêm nhân viên mới  --> done
    public static void add() {
        System.out.println("1. Them Nhan Vien Thong Thuong");
        System.out.println("2. Them Nhan Vien la Cap Quan Ly - Co Them Chuc Vu");
        System.out.print("Ban Chon: ");
        int a = sc.nextInt();
        sc.nextLine();
//      1. Them Nhan Vien Thong Thuong
        if (a == 1) {
//          hiển thị thông tin cơ bản
            Employee newE = new Employee();
            String id;
            do{
                System.out.println("Nhap Ma Nhan Vien: ");
                id = sc.nextLine();
            }while (!checkStaffID(staffList, id));
            System.out.println("Nhap Ten Nhan Vien: ");
            String name = sc.nextLine();
            System.out.println("Nhap Tuoi Nhan Vien: ");
            int age = sc.nextInt();
            System.out.println("Nhap He So Luong: ");
            float coeStaffSalary = sc.nextFloat(); sc.nextLine();
            System.out.println("Nhap Ngay Vao Lam Cua Nhan Vien: ");
            String inDate = sc.nextLine();
            System.out.println("Nhap So Ngay Nghi Phep Cua Nhan Vien: ");
            int vacationDates = sc.nextInt();

//          set thông tin vào mảng
//          đã fix phần này trong n == 2
            newE.setId(id.toUpperCase());
            newE.setName(name);
            newE.setAge(age);
            newE.setCoeffSalary(coeStaffSalary);
            newE.setInDate(inDate);
            newE.setVacationDates(vacationDates);

//          Nhập thông tin về bộ phận làm việc
            System.out.println("HC - Hanh Chinh Nhan Su");
            System.out.println("IT - Cong Nghe Thong Tin");
            System.out.println("MKT - Marketing");
            String department;
//          kiểm tra user có nhập đúng mã bộ phận hay không - không phân biệt hoa thường
//          nếu nhập sai sẽ nhập lại
            do {
                System.out.println("Ban Nhap Ma Bo Phan: ");
                department = sc.next();
            }while (!containsId(listDepartment, department));
//          cài đặt bộ phận làm việc theo mã bộ phận mà user đã nhập
            if(department.equalsIgnoreCase("HC")){
                newE.setDepartment("Hanh Chinh Nhan Su");
            }else if(department.equalsIgnoreCase("IT")){
                newE.setDepartment("Cong Nghe Thong Tin");
            } else if (department.equalsIgnoreCase("MKT")) {
                newE.setDepartment("Marketing");
            }
//          tính số lượng nhân viên hiên có theo bộ phận
            for(Department d : listDepartment){
                if(department.equalsIgnoreCase(d.getDepartId())){
                    d.departOfStaff++;
                }
            }
//          Đối với Emb có thêm giờ làm thêm
            System.out.print("Nhap So Gio Lam Them: ");
            newE.setOverTime(sc.nextInt());

//          Tính lương cho nhân viên thông thường
            newE.calculateSalary();

//          thêm nhân viên mói vào danh sánh chung
            staffList.add(newE);

            System.out.println("Them Moi Thanh Cong!!");
        }
//      2. Them Nhan Vien la Cap Quan Ly - Co Them Chuc Vu
        if(a == 2){
//          hiển thị thông tin cơ bản của 1 Staff
            Manager newMa = new Manager();
            String id;
            do {
                System.out.println("Nhap Ma Nhan Vien: ");
                id = sc.nextLine();
            }while (!checkStaffID(staffList,id));
            newMa.setId(id.toUpperCase());
            System.out.println("Nhap Ten Nhan Vien: ");
            newMa.setName(sc.nextLine());
            System.out.println("Nhap Tuoi Nhan Vien: ");
            newMa.setAge(sc.nextInt());
            System.out.println("Nhap He So Luong: ");
            newMa.setCoeffSalary(sc.nextFloat());
            System.out.println("Nhap Ngay Vao Lam Cua Nhan Vien: ");
            newMa.setInDate(sc.next());
            System.out.println("Nhap So Ngay Nghi Phep Cua Nhan Vien: ");
            newMa.setVacationDates(sc.nextInt());

//          Nhập thông tin về bộ phận làm việc
            System.out.println("HC - Hanh Chinh Nhan Su");
            System.out.println("IT - Cong Nghe Thong Tin");
            System.out.println("MKT - Marketing");
            String department;
//          kiểm tra xem người dùng nhập bộ phận có trùng với list đã cho hay không- không phân biệt hoa thường
//          nếu không thì phải nhập lại
            do {
                System.out.println("Ban Chon: ");
                department = sc.next();
            }while (!containsId(listDepartment, department));
//          Cài thông tin bộ phận làm việc theo key mà người dùng đã nhập
            if(department.equalsIgnoreCase("HC")){
                newMa.setDepartment("Hanh Chinh Nhan Su");
            }else if(department.equalsIgnoreCase("IT")){
                newMa.setDepartment("Cong Nghe Thong Tin");
            } else if (department.equalsIgnoreCase("MKT")) {
                newMa.setDepartment("Marketing");
            }
//          tính số lượng nhân viên hiện tại theo từng bộ phận
//            for(Department d: listDepartment){
//                if(d.getDepartId().equalsIgnoreCase(department)){
//                    d.departOfStaff++;
//                }
//            }
//          Nhập thêm chức danh - đối với nhân viên là Manager, người dùng chỉ nhập số là tự động lưu chức danh theo số người cùng nhập
            System.out.println("Chuc Danh: ");
            System.out.println("1. Business Leader");
            System.out.println("2. Project Leader");
            System.out.println("3. Technical Leader");
            System.out.print("Nhap Chuc Danh: ");
            int n = sc.nextInt();
            if(n == 1){ // Business Leader, gán trực tiếp chức vụ cho Manger là "Business Leader"
                newMa.setPositiontName("Business Leader");
            } else if (n == 2){ //Project Leader, gán trực tiếp chức vụ cho Manager là "Project Leader"
                newMa.setPositiontName("Project Leader");
            } else if (n == 3){ //Technical Leader, gán trực tiếp chức vụ cho Manager là "Technical Leader"
                newMa.setPositiontName("Technical Leader");
            }
//          tính lương cho Manager
            newMa.calculateSalary();
//          thêm Manager mới vào danh sách nhân viên, hiển thị thông báo đã hoàn thành việc thêm nhân viên.
            staffList.add(newMa);
            System.out.println("Them moi Thanh Cong!");
//            tính số lượng nhân viên hiện có theo bộ phận công ty
            for (Department d: listDepartment){
                if(d.getDepartId().equalsIgnoreCase(department)){
                    d.departOfStaff++;
                }
            }
        }
    }
//  hiển thị nhân viên theo từng bộ phận -- >done
    public static void showByDepart() {
        for (Department x : listDepartment) {
            System.out.println();
            System.out.println(x.getDepartName());
            showHeaderList();
            for (Staff y : staffList) {
                if (y.getDepartment().equals(x.getDepartName())){
                    y.displayInformation();
                }if(y.getDepartment().isEmpty()){
                    break;
                }
            }
        }
    }
//  hàm tìm kiếm nhân viên theo tên hoặc ID --> done
    public static void searchStaffByKey() {
        System.out.println("1. Tim kiem nhan vien bang Ten ");
        System.out.println("2. Tim kiem nhan vien bang ID ");
        System.out.print("Ban Chon: ");
        int n = sc.nextInt();
        sc.nextLine(); //chống dư lệnh bở enter
//      TH người dùng chọn tìm kiếm bằng tên
//      Trong TH này sẽ hiển thị tất cả tên NV có chứa key cần tìm, không phân biêt họ và tên hay chức vụ....
        if (n == 1) {
            System.out.println("Nhap Ten Nhan Vien Ban Can Tim: ");
            String findByName = sc.nextLine();
            showHeaderList();
            for (Staff s : staffList) {
//              hiển thị tất cả trường hợp mà tên NV có chưa Key cần tìm
                if (s.getName() != null && s.getName().contains(findByName)) {
//                  System.out.println("Da Tim Thay " + findByName + " Co Trong Danh Sach");
                    s.displayInformation();
                }
//              điều kiện dừng là đến khi trong list không còn tên chứ key cần tìm - break vòng lặp, hiện thông báo cho user
                if (s.getName() == null) {
                    System.out.println("Khong tim thay " + findByName + " Trong Danh Sach");
                    break;
                }
            }
        }
//      trường hợp người dùng chọn tìm kiếm bằng ID nhân viên
//      Thông thường chỉ ra 1 nhân viên, vì số ID là không trùng nhau, yêu cầu người dùng nhập đầy đủ, nếu k sẽ k tìm thấy
        if (n == 2) {
            System.out.println("Nhap ID Nhan Vien Ban Can Tim: ");
            String findByID = sc.nextLine();
            showHeaderList();
            for (Staff s : staffList) {
//                nếu list không null && list có ID NV trùng với Key cần tìm - không biệt hoa thường
                if (s.getId() != null && s.getId().equalsIgnoreCase(findByID)) {
//                  System.out.print("Da Tim Thay " + findByID);
                    s.displayInformation();
//                  break;
                }
//                điều kiện dừng vòng lặp là đến khi list không còn ID trùng với key cần tìm - break.
                if (s.getId() == null) {
                    System.out.println("Cannot find " + findByID + " in list!!!");
                }
            }
        }
    }
//  Hiển thị bảng lương của nhân viên theo thứ tự tăng dần -> done
    public static void sortAscedanceBySalary(){
        Collections.sort(staffList, new Comparator<Staff>() {
            @Override
            public int compare(Staff s1, Staff s2) {
//              ép kiểu hàm tính lương vì class Staff không được implements class ICalculator
                return (((ICalculator)s1).calculateSalary() > ((ICalculator)s2).calculateSalary()) ? 1 : -1;
            }
        });
//      gọi hàm hiển thị danh sách nhân viên vừa loc
        System.out.println("Bang Luong Theo Thu Tu Tang Dan");
        showHeaderList();
        for (Staff x: staffList) {
            x.displayInformation();
        }
        System.out.println();
    }

//   hiển thị bảng lương của nhân viên theo thứ tự giảm dần -> done
    public static void sortDescendanceBySalary(){
            Collections.sort(staffList, new Comparator<Staff>(){
            @Override
            public int compare(Staff s1, Staff s2) {
//              ép kiểu hàm tính lương vì class Staff không được implements class ICalculator
                return (((ICalculator)s1).calculateSalary() < ((ICalculator)s2).calculateSalary()) ? 1: -1;
            }
        });
//      gọi hàm hiển thị
        System.out.println("Bang Luong Theo Thu Tu Giam Dan");
        showHeaderList();
        for (Staff x : staffList) {
            x.displayInformation();
        }
        System.out.println();
    }
}
