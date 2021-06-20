/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fu.didemo.dao;

import com.fu.didemo.dto.Student;
import com.fu.didemo.util.Filter;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author phamv
 */
//class này sẽ chứa tập họp các dữ liệu - list of students
//khi đó có các hàm xử lí trên đám data này, ta sẽ filter danh sách này theo các đk khác nhau 
public class StudentManager {

    private ArrayList<Student> list = new ArrayList();

//cần load data từ DB len, sau đó phần còn lại ta chỉ làm rên list
    {
        list.add(new Student("SE999999", "Chín Nguyễn", 2000, 9.0, "SE"));
        list.add(new Student("SE666666", "Sáu Nguyễn", 2000, 9.0, "SE"));
        list.add(new Student("Se684686", "sd Nguyễn", 2000, 9.0, "SE"));

        list.add(new Student("SE666688", "Tuaans Nguyễn", 2000, 4.0, "IA"));
        list.add(new Student("IA777777", "Chín Nguyễn", 2000, 9.0, "IA"));
        list.add(new Student("IA444444", "Sa Nguyễn", 1999, 7.0, "IA"));

        list.add(new Student("SE222222", "Nam Nguyễn", 2001, 10.0, "GD"));
        list.add(new Student("SE333333", "Thanh Nguyễn", 2000, 8.0, "GD"));
        list.add(new Student("SE111119", "Tuaans Nguyễn", 2000, 4.0, "GD"));

    }

    public List<Student> getAllStudents() {
        System.out.println("The list of student");
        return list;
    }

//Solution trả liiwf cho những câu query này là: 2 cách
//Cách 1: dễ làm nhất, dễ hiểu nhất, thiếu tính linh hoạt mở rộng
//mỗi câu query là 1 hàm
//1.In ra danh sách sv ngành SE
    public List<Student> getSEStudents() {
        List<Student> result = new ArrayList();
        for (Student x : list) {
            if (x.getMajor().equalsIgnoreCase("SE") == true) {
                result.add(x);
            }
        }

        return result;

    }
//Cách 2

//1.In ra danh sách sv ngành SE
//2.In ra danh sách sv ngành IA
    public List<Student> getIAStudents() {
        List<Student> result = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMajor().equalsIgnoreCase("IA") == true) {
                result.add(list.get(i));
            }
        }

        return result;
    }
//3.In ra danh sách sv ngành SE có GPA >=8

    public List<Student> getSEStudentsGT8() {
        List<Student> result = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Student x = list.get(i);
            if (x.getMajor().equalsIgnoreCase("SE") && x.getGpa() >= 8) {
                result.add(x);
            }

        }
        return result;
    }

    //gom hamf , chichs vaof cais loaij querry
    //qui uowcs xaif hamf: swrt(thực) -> thực, hok in ra kq, chỉ return 
    //for(int i=2;i <= Math.sqrt(n); i++)
    //0: Lấy tất cả sinh viên
    //1: lấy tất cả SE; 2.Lấy tất cả SE và điểm GPA >= 8. 3.Lấy tất cả SE <= 5
    //4.Lấy tất cả SE, in d sách sắp xếp theo giảm dần về điểm
    //5. trả về những SE cao điểm nhất
    //6. IA .....
    //ENUM, dùng các hằng số đại diện
    //FilterType.ALL_SE
    public List<Student> getStudents(int filterType) {
        List<Student> result = new ArrayList();
        switch (filterType) {
            case 0:
                result = list;
                break;
            case 1:
                for (Student x : list) //tao đang xết dùm m tiêu chuẩn sv m muốn
                {
                    if (x.getMajor().equalsIgnoreCase("SE")) {
                        result.add(x);
                    }
                }
                break;
            case 2:
                for (Student x : list) {
                    if (x.getMajor().equalsIgnoreCase("SE") && x.getGpa() >= 8) {
                        result.add(x);
                    }
                }
                break;
            case 3:
                break;
            default:
                return null;
        }
        return result;
    }

    public static void testGetStudentByUsingDIAndAnolymousClass() {
        //hàm getStudents() chỉ cần object chứa hàm check() có code
        // true/ flase để nó add vào wish-list và return sau cùng
        //ta focus vào viêkj làm hàm check() thay vù chú ý vào tên class rời chưa hàm 
        //đây là ý tưởng của class vô danh - Anonymus Class - hok thèm ddawjt tên
        //như truyền thống
        //Filter<Student> filterBySEGt8 = new class Rời có sẵn hàm check đã viết rồi
        Filter<Student> filterBySEGt8 = new Filter<Student>() {
            @Override
            public boolean check(Student x) {
                return x.getMajor().equalsIgnoreCase("SE") && x.getGpa() >= 8;
            }
        };
        //VIP giống như Filter x -= new FilterBYX();
        StudentManager sm = new StudentManager();
        List<Student> result = sm.getStudents(filterBySEGt8);
        System.out.println("The list Student");
        for(Student x: result){
            x.showProfile();
        }
    }

    public static void testGetStudentByUsingDIAndConcreateClass() {
        //filter ntn nếu là object của interface éo có code
        //viết code ở đâu đó, hàm check() á
        //if phải viết trong check() nhưng ở đâu đó
        //có 3 cách
        //1. tạo class rời
        //2.Anonymous
        //3. Lamda expression  nếu Inteface là Functional Inteface , duy nhất 1 hàm abstract

        //FilterBySE filterSE = new FilterBySE();
        Filter<Student> filterBySE = new FilterBySE();
        StudentManager sm = new StudentManager();
        List<Student> result = sm.getStudents(filterBySE); // tao chichs cho m caau if--DI
        //cảnh giới cao, k tạo class rời mà if ngay tại lúc sài hàm getStudent()
        // ON THE GO, LÚC XÀI HÀM THÌ MỚI VIẾT IF
        System.out.println("The List of SE STUDENTs");
        for (Student x : result) {
            x.showProfile();  //3 SE
        }

    }

    //khai cha new con
    //Khai con new con
    //cha abstract thif khai cha new cha -> anonymous class
    public List<Student> getStudents(Filter<Student> filter) {
        List<Student> result = new ArrayList();
        for (Student x : list) {
            if (filter.check(x)) {
                result.add(x);
            }
        }

        return result;
    }

//4.In ra danh sách sv ngành IA có GPA >=8
//5.In ra danh sách sv có GPA >=8
//6.In ra danh sách sv có GPA <5
//7. In ra danh sách sv SE và Í có GPA <5
//8.vô chừng, theo nhu cầu thống kê của bên PĐT
    //BÌNH LUẬN
    //khi có tập data và ta muốn filter, có giải pháp
    //1. 1 hàm filter, 1 câu WHERE. Code kiểu này k sai, k hay
    //quá nhiều hàm lẻ, k biết còn bao nhiêu câu kiểu này nữa
    //                  sửa code/ bổ sung hàm liên tục nếu có nhu cầu
    //                  thay đổi tiêu chí thống kê
    //11.1 Giải quyết chuyện nhiều hảm lẻ
    // đưa/chích/inject loại QUERY
    // một hàm (nhận vào type - loại query - xài enum cũng được)
    //1 hàm , gọn
    // bên trong hàm vẫn where như cũ 
    // mình vẫn phải dự đoán hết accs cases ngay lúc thiết kế
    // và mình code tieps phần case -> k sai , nhưng vô chừng case
    //ĐẢO NGƯỢC TU DUY
    //IoC: Inversion of Cojntrol - StringBoot
    //tao ngồi dự đoán mày muốn gì , k thể , dự đoán, cơ bản đc
    //bi giờ mày muons lọc theo ds của mày, if() của mày mày rõ hơn tao
    //vậy m đưa t cái if() của mày thay vì tao phải tự if()
    //tao có ds sv, tao lấy từng bạn ra, 
}

//ChỐT HẠ < MÀY ĐƯA VÀO IF CỦA MÀY ĐI < MÀY TRẢ VỀ TAO BIẾT SV NÀY ĐC K
//ĐƯỢC TAO CẤT LÁT HỒI ĐƯA HẾT CHO MÀY
//TAO K TỰ LÀM IF NỮA, TỰ DUỰ ĐOÁN BAO NHIÊU IF, VIỆC IF LÀ CỦA MÀY
//TYAO LẤY TỪNG SV, TYAO HỎI MÀY ĐC K? ĐƯỢC HẢ THÌ T SẼ ĐƯA SAU
//HÀM CỦA TA CHỜ NGƯỜI NGOÀI, MÀY ĐƯA IF VÀO???
//CHÍCH VÀO CÁI RB 
