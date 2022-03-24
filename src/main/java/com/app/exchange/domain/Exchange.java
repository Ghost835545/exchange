package com.app.exchange.domain;

import javax.persistence.*;

@Entity (name="exchange")
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String valuteID;

    private Integer numcode;
    private String charcode;
    private Integer nominal;
    private String name;
    private float value;

    public Exchange(String valuteID, Integer numcode, String charcode, Integer nominal, String name, float value) {
        this.valuteID = valuteID;
        this.numcode = numcode;
        this.charcode = charcode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
    }

    public Exchange() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setvaluteID (String valuteID){
        this.valuteID = valuteID;
    }
    public String getvaluteID(){
        return valuteID;
    }

    public void setnumcode(Integer numcode){
        this.numcode = numcode;
    }
    public Integer getnumcode(){
        return numcode;
    }
    public String getCharcode() {
        return charcode;
    }

    public void setCharcode(String charcode) {
        this.charcode = charcode;
    }

    public Integer getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
