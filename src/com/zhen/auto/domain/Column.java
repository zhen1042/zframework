package com.zhen.auto.domain;

import com.zhen.core.domain.SerializeCloneable;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * To change this template use File | Settings | File Templates.
 */
public class Column extends SerializeCloneable {

    private String name;//字段英文名称
    private String annotation;//字段注释（中文名）
    private String jdbcType;//jdbc数据类型
    private String nullAble;//允许为空
    private String pk;//主键字段
    private Integer length;//字段长度
    private Integer scale;//字段精度


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public String getJavaType() {
        String ibatisType = getIbatisType();
        if (ibatisType == null) return "String";
        else if ("VARCHAR".equals(ibatisType)) return "String";
        else if ("TEXT".equals(ibatisType)) return "String";
        else if ("CLOB".equals(ibatisType)) return "String";
        else if ("NUMERIC".equals(ibatisType)) return scale == 0 ? (length < 10 ? "Integer" : "Long") : "Double";
        else if ("TIMESTAMP".equals(ibatisType)) return "Date";
        else if ("BLOB".equals(ibatisType)) return "byte[]";
        else return "String";
    }

    public String getIbatisType(){
        if (jdbcType == null) return null;
        else if ("CHAR".equalsIgnoreCase(jdbcType)) return "VARCHAR";
        else if ("NCHAR".equalsIgnoreCase(jdbcType)) return "VARCHAR";
        else if ("VARCHAR".equalsIgnoreCase(jdbcType)) return "VARCHAR";
        else if ("VARCHAR2".equalsIgnoreCase(jdbcType)) return "VARCHAR";
        else if ("NVARCHAR2".equalsIgnoreCase(jdbcType)) return "VARCHAR";

        else if ("NUMBER".equalsIgnoreCase(jdbcType)) return "NUMERIC";
        else if ("NUMERIC".equalsIgnoreCase(jdbcType)) return "NUMERIC";
        else if ("DECIMAL".equalsIgnoreCase(jdbcType)) return "NUMERIC";
        else if ("DEC".equalsIgnoreCase(jdbcType)) return "NUMERIC";
        else if ("MONEY".equalsIgnoreCase(jdbcType)) return "NUMERIC";
        else if ("FLOAT".equalsIgnoreCase(jdbcType)) return "NUMERIC";
        else if ("DOUBLE".equalsIgnoreCase(jdbcType)) return "NUMERIC";
        else if ("REAL".equalsIgnoreCase(jdbcType)) return "NUMERIC";
        else if ("INT".equalsIgnoreCase(jdbcType)) return "NUMERIC";
        else if ("INTEGER".equalsIgnoreCase(jdbcType)) return "NUMERIC";
        else if ("BIGINT".equalsIgnoreCase(jdbcType)) return "NUMERIC";
        else if ("TINYINT".equalsIgnoreCase(jdbcType)) return "NUMERIC";
        else if ("SMALLINT".equalsIgnoreCase(jdbcType)) return "NUMERIC";

        else if ("DATE".equalsIgnoreCase(jdbcType)) return "TIMESTAMP";
        else if ("DATETIME".equalsIgnoreCase(jdbcType)) return "TIMESTAMP";
        else if ("TIME".equalsIgnoreCase(jdbcType)) return "TIMESTAMP";
        else if ("TIMESTAMP".equalsIgnoreCase(jdbcType)) return "TIMESTAMP";
        else if ("TIMESTAMP(6)".equalsIgnoreCase(jdbcType)) return "TIMESTAMP";

        else if ("TEXT".equalsIgnoreCase(jdbcType)) return "TEXT";
        else if ("LONGVARCHAR".equalsIgnoreCase(jdbcType)) return "TEXT";
        else if ("CLOB".equalsIgnoreCase(jdbcType)) return "CLOB";

        else if ("LONGVARBINARY".equalsIgnoreCase(jdbcType)) return "BLOB";
        else if ("BLOB".equalsIgnoreCase(jdbcType)) return "BLOB";
        else if ("IMAGE".equalsIgnoreCase(jdbcType)) return "BLOB";

        else return "VARCHAR";
    }

    public String getNullAble() {
        return nullAble;
    }

    public void setNullAble(String nullAble) {
        this.nullAble = nullAble;
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public String getMax(){
        String n = "";
        if ("Integer".equals(getJavaType()) || "Long".equals(getJavaType())) {
            for (int i = 0; i < length; i++) n += "9";
        }
        else if ("Double".equals(getJavaType())) {
            for (int i = 0; i < length - scale; i++) n += "9";
            n += ".";
            for (int i = 0; i < scale; i++) n += "9";
        }
        return n;
    }
    
}
