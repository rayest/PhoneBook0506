package com.util.db;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by bogehu on 16/5/10.
 */
public class ValidationUtil {
    //判断输入的号码是否有效
 public static boolean phoneNumberIsValid(String string){
     //^[1][358][0-9]{9}$现在只有13、15和18开头的11位手机号码。以1开头，第2位数字为3或5或8，后面接9位数字。
     String regEx ="^[1][358][0-9]{9}$";
     Pattern pattern = Pattern.compile(regEx);
     Matcher matcher = pattern.matcher(string);
     boolean rs = matcher.find();
     if (rs){
         System.out.println("输入号码有效");
     }else {
         System.out.println("输入的号码无效,请重新输入");
     }
     return rs;
 }
  //判断输入的姓名是否有效,这里规定姓名只能输入字母
  public static boolean nameIsValid(String string){
      String regEx="^[a-z]+$";
      Pattern pattern = Pattern.compile(regEx);
      Matcher matcher = pattern.matcher(string);
      boolean rs = matcher.find();
      if (rs){
          System.out.println("输入姓名有效");
      }else {
          System.out.println("输入的姓名无效,请重新输入");
      }
      return rs;
  }
}
