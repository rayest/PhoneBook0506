package cn.PhoneBook;

import com.util.db.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xubt on 4/23/16.
 */
public class PhoneBook {

    private List<Person> persons = new ArrayList<Person>();

    public void addPerson(Person person) throws Exception {
        if (person == null) {
            throw new Exception("联系人信息不能为空!");
        }
        Connection conn = DBUtils.getConnection();
        String sql;
        Statement statement=conn.createStatement();
        sql = "insert into persons(ID,name,phonenumber)values('"+person.getID()+"','"+person.getName()+"','"+person.getPhoneNumber()+"')";
        statement.executeUpdate(sql);
    }


    public List<Person> loadPersons() throws SQLException,ClassNotFoundException{
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

    public List<Person> findPersonByName(String name)throws ClassNotFoundException, SQLException {
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
            persons.add(person);


    }
        System.out.println("查找联系人成功");
        return persons;}

     public Person editPersonByName(String name,Person person)throws ClassNotFoundException,SQLException{
         Connection conn=DBUtils.getConnection();
         Statement statement=conn.createStatement();
         String sql;
         sql="update persons set name='"+person.getName()+"',phonenumber='"+person.getPhoneNumber()+"'where name='"+name+"'";
         statement.executeUpdate(sql);
         return person;
    }
    public void deletePerson(String name)throws ClassNotFoundException, SQLException {
                Connection conn=DBUtils.getConnection();
                Statement statement=conn.createStatement();
                String sql;
                sql="delete from persons where name='"+name+"'";
                statement.executeUpdate(sql);
                System.out.println("删除成功");
            }
        }







