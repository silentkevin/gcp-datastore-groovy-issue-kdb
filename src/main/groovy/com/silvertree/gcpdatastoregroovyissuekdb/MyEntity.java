package com.silvertree.gcpdatastoregroovyissuekdb;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

import static com.silvertree.gcpdatastoregroovyissuekdb.Constants.DATASTORE_KIND_MY_ENTITY;

@Entity(name = DATASTORE_KIND_MY_ENTITY)
public class MyEntity {
    @Id
    Long id;

    String stringField1;
    String stringField2;
    String stringField3;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getStringField1() {
        return stringField1;
    }
    public void setStringField1(String stringField1) {
        this.stringField1 = stringField1;
    }

    public String getStringField2() {
        return stringField2;
    }
    public void setStringField2(String stringField2) {
        this.stringField2 = stringField2;
    }

    public String getStringField3() {
        return stringField3;
    }
    public void setStringField3(String stringField3) {
        this.stringField3 = stringField3;
    }
}
