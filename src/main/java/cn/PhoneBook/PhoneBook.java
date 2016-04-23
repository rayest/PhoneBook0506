package cn.PhoneBook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xubt on 4/23/16.
 */
public class PhoneBook {

    private List<Person> persons = new ArrayList<Person>();

    public void addPerson(Person person) throws Exception {
        if (person == null) {
            throw new Exception("联系人信息不能为空!");
        }
        persons.add(person);
        System.out.println("添加成功!");
    }

    public List<Person> loadPersons() {
        return persons;
    }

    public Person findPersonByName(String name) {
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }
}

