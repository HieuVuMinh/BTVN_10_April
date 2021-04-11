import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static NhanVien[] nhanVien1 = new NhanVien[6];

    public static void main(String[] args) {

        nhanVien1[0] = new NhanVienFulltime("1", "Jonny", 24, "0982349729",
                "Jonny@gmail.com", 10000, 1000, 500);
        nhanVien1[1] = new NhanVienParttime("2", "Drac", 20, "0123665479",
                "Drac@gmail.com", 5);
        nhanVien1[2] = new NhanVienParttime("3", "Hose", 21, "0123623279",
                "Hose@gmail.com", 2);
        nhanVien1[3] = new NhanVienParttime("4", "Trade", 25, "0123666679",
                "Trade@gmail.com", 8);
        nhanVien1[4] = new NhanVienFulltime("5", "Pack", 30, "0982377729",
                "Pack@gmail.com", 9000, 5000, 1200);
        nhanVien1[5] = new NhanVienFulltime("6", "Kangaroo", 22, "0987749729",
                "Kangaroo@gmail.com", 10000, 500, 300);

//Hiển thị danh sách nhân viên
        displayNhanVien();

        System.out.println("1. Thêm Nhân Viên");
        System.out.println("2. Lương nhân viên toàn thời gian < trung bình");
        System.out.println("3. Tổng lương phải trả cho toàn bộ nhân viên Partime");
        int selection = sc.nextInt();
        switch (selection) {
            case 1: {
                //Thêm mới nhân viên
                System.out.println("Nhập số lượng nhân viên muốn thêm");
                int size = sc.nextInt();
                NhanVien[] nhanVien2 = new NhanVien[size];
                for (int i = 0; i < nhanVien2.length; i++) {
                    System.out.println("Chọn nhân viên: 1.Fulltime   2.Partime");
                    int chose = sc.nextInt();
                    switch (chose) {
                        case 1: {
                            sc.nextLine();
                            System.out.println("Nhập ID: ");
                            String id = sc.nextLine();
                            System.out.println("Nhập Name: ");
                            String name = sc.nextLine();
                            System.out.println("Nhập age: ");
                            int age = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Nhập số điện thoại: ");
                            String phone = sc.nextLine();
                            System.out.println("Nhập email: ");
                            String email = sc.nextLine();
                            System.out.println("Nhập salary: ");
                            double salary = sc.nextDouble();
                            System.out.println("Nhập reward: ");
                            double reward = sc.nextDouble();
                            System.out.println("Nhập penalty: ");
                            double penalty = sc.nextDouble();
                            nhanVien2[i] = new NhanVienFulltime(id, name, age, phone, email, salary, reward, penalty);
                            break;
                        }
                        case 2: {
                            System.out.println("Nhập ID: ");
                            String id = sc.nextLine();
                            System.out.println("Nhập Name: ");
                            String name = sc.nextLine();
                            System.out.println("Nhập age: ");
                            int age = sc.nextInt();
                            System.out.println("Nhập số điện thoại: ");
                            String phone = sc.nextLine();
                            System.out.println("Nhập email: ");
                            String email = sc.nextLine();
                            System.out.println("Nhập time working: ");
                            double timeWorking = sc.nextDouble();
                            nhanVien2[i] = new NhanVienParttime(id, name, age, phone, email, timeWorking);
                            break;
                        }
                    }
                }
                //Cộng 2 mảng
                NhanVien[] newNhanVien = new NhanVien[nhanVien1.length + nhanVien2.length];
                for (int i = 0; i < nhanVien1.length; i++) {
                    newNhanVien[i] = nhanVien1[i];
                }
                for (int j = nhanVien1.length + 1; j <= newNhanVien.length; j++) {
                    newNhanVien[j - 1] = nhanVien2[j - 7];
                }
                System.out.println("Trước khi thêm nhân viên:");
                displayNhanVien();
                System.out.println("Sau khi thêm nhân viên:");
                for (NhanVien nhanVien : newNhanVien) {
                    System.out.println(nhanVien);
                }
                break;
            }
            case 2: {
                //Danh sách lương nhân viên Fulltime thấp hơn lương trung bình
                double luongTungBinh = luongTrungBinh();
                for (int i = 0; i < nhanVien1.length; i++) {
                    if (nhanVien1[i] instanceof NhanVienFulltime) {
                        if (((NhanVienFulltime) nhanVien1[i]).getSalary() < luongTungBinh) {
                            System.out.println("Nhân viên có mức lương nhỏ hơn trung bình: " + nhanVien1[i].getName() +
                                    " với id = " + nhanVien1[i].getId());
                        }
                    }
                }
                break;
            }
            case 3:{
                //Tổng lương phải trả cho toàn bộ nhân viên Partime
                tongLuongNhanVienPartime();
                break;
            }
            default:{
                System.out.println("Selection: không chính xác");
                break;
            }
        }

    }

    public static void displayNhanVien() {
        for (NhanVien nhanVien : nhanVien1) {
            System.out.println(nhanVien);
        }
    }

    public static double luongTrungBinh() {
        double totalSaary = 0;
        int count = 0;
        for (int i = 0; i < nhanVien1.length; i++) {
            if (nhanVien1[i] instanceof NhanVienFulltime) {
                count++;
                totalSaary += ((NhanVienFulltime) nhanVien1[i]).getSalary();
            }
        }
        System.out.println("Công ty có " + count + " nhân viên Fulltime và tổng lương = " + totalSaary);
        double average = totalSaary / count;
        System.out.println("Trung bình lương của " + count + " nhân viên Fulltime = " + average);
        return average;
    }

    public static void tongLuongNhanVienPartime(){
        double totalSalary = 0;
        int count = 0;
        for (int i = 0; i < nhanVien1.length; i++){
            if (nhanVien1[i] instanceof NhanVienParttime){
                System.out.println("Nhân viên Partime id: " + nhanVien1[i].getId() + " có tổng lương: " +
                        ((NhanVienParttime) nhanVien1[i]).totalSalaryParttime());
                count++;
                totalSalary += ((NhanVienParttime) nhanVien1[i]).totalSalaryParttime();
            }
        }
        System.out.println("Tổng lương phải trả cho " + count + " nhân viên Partime = " + totalSalary);
    }

//    public static void enterElement(){
//        System.out.println("Nhập ID: ");
//        int id = sc.nextInt();
//        System.out.println("Nhập Name: ");
//        String name = sc.nextLine();
//        System.out.println("Nhập age: ");
//        int age = sc.nextInt();
//        System.out.println("Nhập số điện thoại: ");
//        String phone = sc.nextLine();
//        System.out.println("Nhập email: ");
//        String email = sc.nextLine();
//    }
}
