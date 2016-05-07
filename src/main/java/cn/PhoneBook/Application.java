package cn.PhoneBook;

import java.util.List;
import java.util.Scanner;

/**
 * Created by xubt on 4/23/16.
 */
public class Application {
    private static PhoneBook phoneBook = new PhoneBook();
    public static void main(String[] args) throws Exception {
        backToHome();
    }

    public static void backToHome() throws Exception {


        System.out.println("欢迎!");
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
                System.out.println("请添加下一位联系人:");
                Person newPerson = new Person();
                Scanner scanner = new Scanner(System.in);
                newPerson.setID(scanner.nextInt());
                System.out.println("请输入联系人的姓名:");
                Scanner scan = new Scanner(System.in);
                newPerson.setName(scan.nextLine());
                System.out.println("请输入联系人的号码:");
                Scanner scan1 = new Scanner(System.in);
                newPerson.setPhoneNumber(scan1.nextLine());
                phoneBook.addPerson(newPerson);
                System.out.println(newPerson.getName() + "已经添加到电话本!");
                break;
            case 2:
                System.out.println("请输入查找的联系人");
                input = new Scanner(System.in);
                Person foundPerson = phoneBook.findPersonByName(input.nextLine());
                if (foundPerson == null) {
                    System.out.println("未找到联系人");
                } else {
                    System.out.printf("%-5d%-10s%-10s\n",foundPerson.getID(),foundPerson.getName(),foundPerson.getPhoneNumber());
                }
                break;
            case 3:
                System.out.println("请输入要删除的联系人");
                input = new Scanner(System.in);
                phoneBook.deletePerson(input.nextLine());
                System.out.println("删除联系人成功");
                break;
            case 4:
                System.out.println("请输入要修改的联系人姓名:");
                input = new Scanner(System.in);
                String inputName=input.nextLine();
                Person personToEdit=new Person();
                Person editPerson=phoneBook.editPersonByName(inputName,personToEdit);
                if (editPerson == null) {
                    System.out.println("未找到要修改的联系人");
                } else {
                    Person newperson=new Person();
                    scanner = new Scanner(System.in);
                    System.out.println("输入修改后的姓名");
                    newperson.setName(scanner.nextLine());
                    System.out.println("请输入修改后的号码:");
                    newperson.setPhoneNumber(scanner.nextLine());
                    phoneBook.editPersonByName(inputName,newperson);
                    System.out.println("联系人" + newperson.getName() +":"+newperson.getPhoneNumber()+ "修改成功!");
                }
                break;
            case 5:

                List<Person> persons = phoneBook.loadPersons();
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
