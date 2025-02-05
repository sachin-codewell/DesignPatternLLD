package com.codewell.strategypattern;

public class LoginUsingGmail implements Login {

    String email;
    String password;

    public LoginUsingGmail(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void login() {
       System.out.println("Sign in using gmail User "+this.email+ "Password "+this.password);
    }
}
