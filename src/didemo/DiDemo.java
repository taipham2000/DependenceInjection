/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didemo;

import com.fu.didemo.dao.StudentManager;
import com.fu.didemo.dto.Student;
import com.fu.didemo.util.Filter;
import java.util.*;

/**
 *
 * @author phamv
 */
public class DiDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      //  StudentManager sm = new StudentManager();
      //  sm.getAllStudents();
      //  testgetStudentsBySparateMethods();
      //testGetStudentByUsingDIAndLambdaExpressionV2();
      testInterface();
    }
    //lamda là hàm k có tên
    public static void testInterface(){
        //new Student("A", "B", 0, 0, "C").showProfile();
        
        
        List<Student> list = new StudentManager().getAllStudents();
//        Comparator<Student> can = new Comparator<Student>() {
 //           @Override
//            public int compare(Student o1, Student o2) {
//                if(o1.getGpa() > o2.getGpa())
//                    return 1;
//                else if (o1.getGpa() == o2.getGpa())
//                    return 0;
//                return -1;
//                return Double.compare(o1.getGpa(), o2.getGpa());
 //           }
 //       };
        Comparator<Student> can = (o1, o2) -> Double.compare(o1.getGpa(), o2.getGpa() );
        
        Collections.sort(list, can);
            System.out.println("The Student listr after sorting ascending by gpa"); 
             for(Student x :list)
                 x.showProfile();



                                        //DI đưa vào cái cân 2 sv cho t
                                        //tạo hàm sort() mới biết cách ss 2 sv
                                        //chích cách của m vào, sao t biết
                                        //gọi hàm gì của mày, t thông nhất
                                        //t với m chơi qua inteface có sẵn hàm 
                                        //Inteface chuyến đi 2 sv, Comparator
                                        //Bộ TC Cân , có hàm check (2 sv) lớn bé
                                        //        compare(o1,o2) -> lớn bé bằng
                                        // việc đổi chỗ là việc của , chỉ cvaanf cách đổi
                                        //chích cách đổi bên ngoài đưa vào
                                        // ua hàm compare(sv1, sv2) của FI Comparator
                                        //chỉ có 1 hàm compare() - LAMBDA EXPRESSION< AND 
                                        
                                        
    }
    public void testgetStudentByFilterType(){
        StudentManager sm= new StudentManager();
        System.out.println("The list of SE student(3)");
        for (Student x : sm.getStudents(1)) 
            x.showProfile();
            
    }
    public static void testgetStudentsBySparateMethods(){
        StudentManager sm= new StudentManager();
        System.out.println("The list of SE student(3)");
        for (Student x : sm.getSEStudents()) {
            x.showProfile();
            
        }
        System.out.println("The list of SE GPA > 8");
        for (Student x : sm.getSEStudentsGT8()) {
            x.showProfile();
        }
    }
    //test pointer in Java
    public static void testPointer(){
        Student list[] = {
            new Student("SE999999", "Chín Nguyễn", 2000, 9.0,"SE"),
            new Student("SE666666", "Sáu Nguyễn", 2000, 9.0,"SE"),
     
        };
        Student a[]=new Student[5];
        a[0] = new Student("SE999999", "Chín Nguyễn", 2000, 9.0,"SE");
        a[1] = new Student("SE666666", "Sau Nguyễn", 2000, 9.0,"SE");
        for(Student x: a)
          x.showProfile();
        
        
        for(int i=0 ;i < 6 ; i++)
                a[i].showProfile();
    
    }
       public static void testGetStudentByUsingDIAndLambdaExpressionV2(){
       //Filter<Student> filterByIA = (x) ->  x.getMajor().equals("IA");//OK
        


        //kq sử dụng
       StudentManager sm = new StudentManager();
        List<Student> result = sm.getStudents(x -> x.getMajor().equalsIgnoreCase("IA") && x.getGpa() < 5); //mày đưa đối tượng nhưng t cần hàm
        
        System.out.println("The list Student");
        for(Student x: result){
            x.showProfile();
        }
   } 

   public static void testGetStudentByUsingDIAndLambdaExpression(){
        // chuẩn bị object đưa vào hàm
        //Filter<Student> filterByIA = new Class Rời if IA; viết sẵn
        //Filter<Student> filterByIA = (Student x) -> {return true;};
        Filter<Student> filterByIA = (x) ->  x.getMajor().equals("IA");//OK
        


        //kq sử dụng
       StudentManager sm = new StudentManager();
        List<Student> result = sm.getStudents(filterByIA);
        System.out.println("The list Student");
        for(Student x: result){
            x.showProfile();
        }
   } 
public static void testGetStudentByUsingDIAndAnolymousClass() {
        //hàm getStudents() chỉ cần object chứa hàm check() có code
        // true/ flase để nó add vào wish-list và return sau cùng
        //ta focus vào viêkj làm hàm check() thay vù chú ý vào tên class rời chưa hàm 
        //đây là ý tưởng của class vô danh - Anonymus Class - hok thèm ddawjt tên
        //như truyền thống
        //Filter<Student> filterBySEGt8 = new class Rời có sẵn hàm check đã viết rồi
        Filter<Student> filterBySEGt8 = (Student x) -> x.getMajor().equalsIgnoreCase("SE") && x.getGpa() >= 8;
        //VIP giống như Filter x -= new FilterBYX();
        StudentManager sm = new StudentManager();
        List<Student> result = sm.getStudents(filterBySEGt8);
        System.out.println("The list Student");
        for(Student x: result){
            x.showProfile();
        }
    }
    //xem thử get set đúng hay k
            public static void testStudent(){
               Student s=new Student("Se123456", "AN NGUYEN", 2000, 5.6,"SE");
               s.showProfile();
}
}
