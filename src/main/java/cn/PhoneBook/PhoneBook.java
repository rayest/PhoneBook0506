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
        DBUtils.AddAPerson(person);
    }


    public List<Person> loadPersons() throws SQLException,ClassNotFoundException{
        List<Person> persons=DBUtils.loadAllPersons();
        return persons;
    }

    public List<Person> findPersonByName(String name)throws ClassNotFoundException, SQLException {
       List<Person> persons=DBUtils.findAPersonByName(name);
       return persons;}


     public Person editPersonByName(String name,Person person)throws ClassNotFoundException,SQLException{
        Person newPerson= DBUtils.editAPersonByName(name,person);
         return newPerson;
    }
    public void deletePerson(String name)throws ClassNotFoundException, SQLException {
                DBUtils.deleteAPerson(name);
            }
        }







