package com.codewell.strategypattern;

public class UsingLogin {

    public static void main(String args []) {

        ClickOnLogin user1 = new ClickOnLogin();
        user1.login(new LoginUsingGmail("sny@gmail.com","123456"));
        ClickOnLogin user2 = new ClickOnLogin();
        user2.login(new LoginUsingFacebook("codewelluser","Vilen@006"));

    }
}
