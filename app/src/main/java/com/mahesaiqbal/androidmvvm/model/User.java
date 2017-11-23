package com.mahesaiqbal.androidmvvm.model;

/**
 * Created by mahesaiqbal on 11/23/2017.
 */

public class User {

    public String firstName;
    public String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
