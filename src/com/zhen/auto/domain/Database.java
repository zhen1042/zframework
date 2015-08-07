package com.zhen.auto.domain;

import java.util.List;

import com.zhen.core.domain.SerializeCloneable;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * To change this template use File | Settings | File Templates.
 */
public class Database extends SerializeCloneable {

    private String type;//数据库类型
    private List<Table> tableList;//数据库表集合

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Table> getTableList() {
        return tableList;
    }

    public void setTableList(List<Table> tableList) {
        this.tableList = tableList;
    }

}
