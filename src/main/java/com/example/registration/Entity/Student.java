package com.example.registration.Entity;

import com.example.registration.Config.CustomElement;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Student")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long syskey;
    @CustomElement(key="name")
    private String t1;
    @CustomElement(key = "className")
    private String t2;
    private int recordstatus;
    private String createddate;
    private String modifieddate;

    public long getSyskey() {
        return syskey;
    }

    public void setSyskey(long syskey) {
        this.syskey = syskey;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public int getRecordstatus() {
        return recordstatus;
    }

    public void setRecordstatus(int recordstatus) {
        this.recordstatus = recordstatus;
    }

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public String getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(String modifieddate) {
        this.modifieddate = modifieddate;
    }
}
