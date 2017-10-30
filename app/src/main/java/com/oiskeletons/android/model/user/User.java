package com.oiskeletons.android.model.user;

import javax.inject.Inject;

/**
 * Created by rubin.apore on 10/29/17.
 */

public class User {
    public String name;

    public User(String name) {this.name = name;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}
}
