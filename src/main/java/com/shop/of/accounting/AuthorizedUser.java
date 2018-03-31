package com.shop.of.accounting;

import com.shop.of.accounting.model.AbstractBaseEntity;
import com.shop.of.accounting.model.User;

public class AuthorizedUser {

    private static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        AuthorizedUser.user = user;
    }

    private static int id = AbstractBaseEntity.START_SEQ;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        AuthorizedUser.id = id;
    }

}
