/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fu.didemo.util;

import com.fu.didemo.dto.Student;

/**
 *
 * @author phamv
 */
// là 1 hàm k chứa code, từ JDK8, 9 thì có chứa code default
// là 1 bộ tiêu chuẩn, nói rằng ai đó làm gì mà k có cụ thể
// để sự linh hoạt cho ng khác làm, miễn thỏa mãn bộ TC
// chứa hàm k code đc gọi là abstract - ý tưởng, trừu tượng - hữu hình và vô hình
//Đây là bộ lọc dùng chung để nói rằng 1 sv có thỏa tiêuc huân nào đó hay k\
//thỏa tiêu chuẩn nào , tùy m đặt ra
//chứa 1 hàm check chất lượng sv, cụ thể sao tùy mỗi bên
//FPT đtawj ra tiêu chuẩn đầu ra
//HUtech, Hoa Sen ... tiêu chuẩn đầu ra
//... theo tiêu chuẩn chung của bộ GDDT
//generic , biến data type thành tham số
//setX(int a) -> tham số, kiểu value, thực sự t cần value là int
//              5  7  10  oki
//
@FunctionalInterface     //kí hiệu interface này chỉ cos 1 hàm và
//rất dễ chuyển thành landa expression khi xài interface
//truyền tham trị, void f(int x) x đại diện 1 giátrij - pass by value
//truyền tham chiếu void f(Studet x) x đại diện 1 object, nằm chỗ khác
                                        //pass by reference

//truyền theo kiểu , data type lại là 1 tham số
                        //void f(??? x) ??? là data type nào đó, x sẽ ứng với data type đó
                        // void f(<T> x), xài f(<Student> x)
                        //                  f(<Lecture> x) GENERIC
                        // truyền nguyên 1 hàm vào trong tham số, pass by function, đưa 1 hàm vào 1 hàm
//  vòi f(??? x), lại là 1 hàm khác, 
                        //LamBDA EXPRESSION, ĐƯA HÀM VÀO TRONG HÀM
//FUNCTIONAL PROGRAMMING
public interface Filter<T> {
    
    public boolean check(T x); //procedual programming
    
}
