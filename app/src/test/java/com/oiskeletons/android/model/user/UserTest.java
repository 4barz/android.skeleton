package com.oiskeletons.android.model.user;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by rubin.apore on 10/29/17.
 */
class UserTest {
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getName() {
        String name = "name";
        User user = new User(name);
        assertEquals(user.getName(), name);
    }

    @org.junit.jupiter.api.Test
    void setName() {
        String oldName = "old.name";
        String newName = "new.name";
        User user = new User(oldName);
        user.setName(newName);
        assertEquals(user.getName(), newName);
    }

}