package com.ysoyso.annotation.orm.compile;

public class TableBean {
    private String name;
    private String engine;
    private String comment;

    public TableBean(String name, String engine, String comment) {
        this.name = name;
        this.engine = engine;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        if (null != engine && !"".equals(engine)) {
            this.engine = "ENGINE=" + engine;
        } else {
            this.engine = "";
        }
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        if (null != comment && !"".equals(comment)) {
            this.comment = "COMMENT=" + comment;
        } else {
            this.comment = "";
        }
    }
}
