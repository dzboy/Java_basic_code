package com.ysoyso.annotation.orm.compile;

import com.ysoyso.annotation.orm.User;

import java.util.Map;

public class UserDao extends AbstractDao<User> {
    {
        Property id = new Property("id", "PRIMARY KEY", "NOT NULL", "", "AUTO_INCREMENT", "");
        properties.add(id);
        bean = new TableBean("USER", "InnoDB", "");
    }

    @Override
    protected String getUpdateFields() {
        return null;
    }

    @Override
    protected String getWhereStatement() {
        return null;
    }
}
