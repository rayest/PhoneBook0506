package cn.PhoneBook;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by xubt on 4/23/16.
 */
public class Application {
    private static PhoneBook phoneBook = new PhoneBook();
    public static void main(String[] args) throws Exception {
        backToHome();
    }
    public static void backToHome() throws Exception {


        System.out.println("Welcome!");
        System.out.println("选择要进行的操作:");
        System.out.println("1,添加联系人");
        System.out.println("2,查找联系人");
        System.out.println("3,删除联系人");
        System.out.println("4,修改联系人");
        System.out.println("5,查看所有联系人");
        Scanner input = new Scanner(System.in);
        int selectedOption = input.nextInt();
        switch (selectedOption) {
            case 1:
                Person newPerson = new Person();
                System.out.println("请输入联系人的姓名:");
                Scanner scan = new Scanner(System.in);
                newPerson.setName(scan.nextLine());
                 String string=newPerson.getName();
                // 正则表达式规则
                String regex="^[a-z]+$";
                // 编译正则表达式
                Pattern pattern1 = Pattern.compile(regex);
                // 查找字符串中是否有匹配正则表达式的字符/字符串
                Matcher matcher1 = pattern1.matcher(string);
                boolean rs1=matcher1.find();
                if (rs1)
                    System.out.println(newPerson.getName() + "添加成功");
                else
                    System.out.println("输入联系人有误");
                System.out.println("请输入联系人的号码:");
                Scanner scan1 = new Scanner(System.in);
                newPerson.setPhoneNumber(scan1.nextLine());
                String str = newPerson.getPhoneNumber();
                // ^[1][358][0-9]{9}$现在只有13、15和18开头的11位手机号码。以1开头，第2位数字为3或5或8，后面接9位数字。
                String regEx ="^[1][358][0-9]{9}$";
                Pattern pattern = Pattern.compile(regEx);
                Matcher matcher = pattern.matcher(str);
                boolean rs = matcher.find();
                if (rs) {
                    phoneBook.addPerson(newPerson);
                System.out.println(newPerson.getName() + "已经添加到电话本!");}
                else
                    System.out.println("输入号码有误");
                break;
            case 2:
                System.out.println("请输入查找的联系人");
                input = new Scanner(System.in);
                List<Person> persons= phoneBook.findPersonByName(input.nextLine());
                for (Person person : persons){
                    System.out.println(person.getID()+":"+person.getName() + ":" + person.getPhoneNumber());
                }
                break;
            case 3:
                System.out.println("请输入要删除的联系人");
                input = new Scanner(System.in);
                phoneBook.deletePerson(input.nextLine());
                System.out.println("删除联系人成功");
                break;
            case 4:
                System.out.println("请输入要修改的联系人");
                input = new Scanner(System.in);
                Person newperson = new Person();
                String name = input.nextLine();
                Person personToModify = phoneBook.editPersonByName(name,newperson);
                    Person newperson1 = new Person();
                    System.out.println("请输入联系人的姓名:");
                    newperson1.setName(input.nextLine());
                    System.out.println("请输入联系人的号码:");
                    newperson1.setPhoneNumber(input.nextLine());
                    phoneBook.editPersonByName(name,newperson1);
                    System.out.println("联系人"+newperson1.getName()+"修改成功！");
                break;


            case 5:
                persons = phoneBook.loadPersons();
                for (Person person : persons) {
                    System.out.println("ID:"+person.getID());
                    System.out.println("姓名:" + person.getName());
                    System.out.println("号码:" + person.getPhoneNumber());
                    System.out.println("----------------------------------");
                }
        }
        backToHome();

    }
}
