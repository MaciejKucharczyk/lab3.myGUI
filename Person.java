import java.util.LinkedList;

public class Person {
    protected String login;
    protected char[] password;
    public Person(String login,char[] password){
        this.login = login;
        this.password = password;
    }
    public static Person person1 = new Person("Jakub", new char[]{'h', 'a', 's', 'l', 'o', 'J', 'a', 'k', 'u', 'b', 'a'});
    public static Person person2 = new Person("Tadeusz123", new char[]{'T','a','d','z','i','o'});
    public static Person person3 = new Person("Krol", new char[]{'k','r','o','l'});

    static LinkedList<Person> people = new LinkedList<>();

    public static LinkedList<Person> addPeople(){
        Person.people.add(person1);
        Person.people.add(person2);
        Person.people.add(person3);
        return people;
    }
}
