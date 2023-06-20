package com.ysoyso.annotation.orm.compile;

import java.lang.reflect.Field;

public class Property {
    private String name;
    // PRIMARY KEY
    private String identity;
    // NOT NULL
    private String nullable;
    // UNIQUE
    private String unique;
    // AUTO_INCREMENT
    private String autoincrement;
    // COMMENT 'COMMENT'
    private String comment;
    // index
    private boolean index;

    public Property(String name, String identity, String nullable, String unique, String autoincrement, String comment) {
        this.name = name;
        this.identity = identity;
        this.nullable = nullable;
        this.unique = unique;
        this.autoincrement = autoincrement;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getNullable() {
        return nullable;
    }

    public void setNullable(String nullable) {
        this.nullable = nullable;
    }

    public String getUnique() {
        return unique;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }

    public String getAutoincrement() {
        return autoincrement;
    }

    public void setAutoincrement(String autoincrement) {
        this.autoincrement = autoincrement;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        if (null != comment && !"".equals(comment)) {
            this.comment = "COMMENT " + comment;
        } else {
            this.comment = "";
        }
    }

    public void setIndex(boolean index) {
        this.index = index;
    }

    public boolean isIndex() {
        return index;
    }

    public String getCreateTableColumn() {
        return name + " " + identity + " " + unique + " " + nullable + " " + autoincrement + " " + comment + ",";
    }

    public String getColumns() {
        return name + ",";
    }

    public Object getValue(Object obj) {
        if (null != obj) {
            try {
                Field field = obj.getClass().getField(name);
                field.setAccessible(true);
                return field.get(obj);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
