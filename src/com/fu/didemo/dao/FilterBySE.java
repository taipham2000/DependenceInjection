/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fu.didemo.dao;

import com.fu.didemo.dto.Student;
import com.fu.didemo.util.Filter;

/**
 *
 * @author phamv
 */
//tham gia CLB, tiêu chuẩn , thì phải làm gì cụ thể, implement, viết code
//cho hàm abstract, cụ thể rồi, k chung chung trừu tượng nữa
//class rời, phải có create class -> CONCRETE CLASS
public class FilterBySE implements Filter<Student>{

    @Override
    public boolean check(Student x){
        return x.getMajor().equalsIgnoreCase("SE");
     //   if(x.getMajor().equals("SE"))
     //       return true;
     //   return false;
        
    }
  
}
