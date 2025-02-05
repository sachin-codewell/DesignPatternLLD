package com.codewell.strategypattern;

public class LoginUsingFacebook implements Login{

    private String userid;
    private String password;

    public LoginUsingFacebook(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }

    public void login() {
        System.out.println("Sign in using Facebook User "+this.userid+ "Password "+this.password);
    }
}
