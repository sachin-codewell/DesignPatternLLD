package com.codewell.user;

public class Main {

    public static void main(String [] args) {
        UserService user = new UserService();
        user.registerUser("Sachin Yadav",24,Gender.Male,"sny@gmail.com","Vilen@123");
        user.loginUser("sny@gmail.com","Vilen@123");
    }
}
