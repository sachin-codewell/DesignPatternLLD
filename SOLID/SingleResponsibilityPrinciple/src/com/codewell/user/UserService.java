package com.codewell.user;

public class UserService {

    String name;
    int age;
    Gender gender;
    String email;
    String password;

    public void registerUser(String name, int age, Gender gender, String email, String password) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.password = password;
        System.out.println("User registered successfully");
    }

    public void loginUser(String email, String password) {
        if(this.email.equals(email) && this.password.equals(password)){
           System.out.println("login successful");
        }
        else{
            System.out.println("wrong credential");
        }
    }

    /*
    public void saveUserInDB(user data){
       some code...............
    }
    if we will do this then it will break SRP because this class should perform action related to
    user only for database interaction we can create another class.
     */
}
