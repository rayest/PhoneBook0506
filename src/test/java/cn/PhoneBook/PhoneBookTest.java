package cn.PhoneBook;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by xubt on 4/23/16.
 */
public class PhoneBookTest {

    @Test
    public void 添加一个联系人() throws Exception {
        PhoneBook phoneBook = new PhoneBook();
        Person person = new Person();
        person.setName("hucz");
        person.setPhoneNumber("1580000000");
        person.setID(66);

        phoneBook.addPerson(person);

        assertEquals(18, phoneBook.loadPersons().size());
    }

    @Test(expected = Exception.class)
    public void 添加联系人时联系人信息为空时抛出异常() throws Exception {
        PhoneBook phoneBook = new PhoneBook();
        Person person = null;

        phoneBook.addPerson(person);
    }

    @Test
    public void 根据姓名查找联系人_查到() throws Exception {
        PhoneBook phoneBook = new PhoneBook();
        Person person = new Person("hucz","1223",77);
        phoneBook.addPerson(person);
        Person actualPerson = phoneBook.findPersonByName("hucz");
        assertNotNull(actualPerson);
        assertEquals("hucz",actualPerson.getName());
    }

}