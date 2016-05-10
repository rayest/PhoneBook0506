package com.util.db;

import cn.PhoneBook.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bogehu on 16/5/10.
 */
public class DBUtils {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn=null;
        try{String url="jdbc:mysql://localhost:3306/phonebook?user=root&password=123456&useUnicode=true" +
                "&characterEncoding=UTF8";
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("成功加载MySQL驱动程序");
        conn= DriverManager.getConnection(url);}
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("获取连接失败");
        }
        return conn;

    }
    //增加一个联系人
    public static void AddAPerson(Person person) throws Exception {
        if (person == null) {
            throw new Exception("联系人信息不能为空!");
        }
        Connection conn = DBUtils.getConnection();
        String sql;
        Statement statement=conn.createStatement();
        sql = "insert into persons(ID,name,phonenumber)values('"+person.getID()+"','"+person.getName()+"','"+person.getPhoneNumber()+"')";
        statement.executeUpdate(sql);
    }
    //删除一个联系人
    public static void deleteAPerson(String name)throws ClassNotFoundException, SQLException {
        Connection conn=DBUtils.getConnection();
        Statement statement=conn.createStatement();
        String sql;
        sql="delete from persons where name='"+name+"'";
        statement.executeUpdate(sql);
        System.out.println("删除成功");
    }
    //查找一个联系人
    public static List<Person> findAPersonByName(String name)throws ClassNotFoundException, SQLException {
        Connection conn=DBUtils.getConnection();
        Statement statement=conn.createStatement();
        String sql;
        sql="select * from persons where name='"+name+"'";
        ResultSet rs=statement.executeQuery(sql);
        List<Person> persons=new ArrayList<Person>();
        while (rs.next()){
            Person person=new Person();
            person.setID(rs.getInt(1));
            person.setName(rs.getString(2));
            person.setPhoneNumber(rs.getString(3));
            persons.add(person);}
        System.out.println("查找联系人成功");
        return persons;
    }
    //修改一个联系人
    public static Person editAPersonByName(String name,Person person)throws ClassNotFoundException,SQLException{
        Connection conn=DBUtils.getConnection();
        Statement statement=conn.createStatement();
        String sql;
        sql="update persons set name='"+person.getName()+"',phonenumber='"+person.getPhoneNumber()+"'where name='"+name+"'";
        statement.executeUpdate(sql);
        return person;
    }
    //显示所有联系人

    public static List<Person> loadAllPersons() throws SQLException,ClassNotFoundException{
        Connection conn = DBUtils.getConnection();
        String sql;
        Statement statement=conn.createStatement();
        sql ="select * from persons";
        ResultSet rs = statement.executeQuery(sql);
        List<Person> persons=new ArrayList<Person>();
        while (rs.next()){
            Person person=new Person();
            person.setID(rs.getInt(1));
            person.setName(rs.getString(2));
            person.setPhoneNumber(rs.getString(3));
            persons.add(person);
        }
        return persons;

    }
}

