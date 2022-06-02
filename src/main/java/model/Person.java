package model;

import java.net.PortUnreachableException;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String type;
   private String username;
   private String password;

    public Person(int id, String firstName, String lastName, String email, int age, String type,String username,String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.type = type;
        this.username=username;
        this.password=password;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        String text = "";
        text += id + "," + firstName + "," + lastName + "," + email + "," + age + "," + type+","+username+","+password;
        return text;
    }

    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
                return  person.age==this.age;
    }

}
