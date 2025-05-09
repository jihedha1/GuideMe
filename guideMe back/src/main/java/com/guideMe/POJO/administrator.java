package com.guideMe.POJO;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@NamedQuery(name = "User.findByEmailId", query = "SELECT u FROM administrator u WHERE u.email = :email")
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "administrator")
public class administrator implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "cin")
    private Long cin;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phone_number;
    @Column(name = "password")
    private String password;

    @Column(name = "local_type")
    private String local_type;
    @Column(name = "address")
    private String adress;
    @Column(name = "card_number")
    private String card_number;
    @Column(name = "connected")
    private String connected;

    public administrator() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCin() {
        return cin;
    }

    public void setCin(Long cin) {
        this.cin = cin;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getLocal_type() {
        return local_type;
    }

    public void setLocal_type(String local_type) {
        this.local_type = local_type;
    }

    public String getAdress() {
        return adress;
    }

    public administrator(String first_name, String last_name, Long cin, String email, String phone_number, String password, String local_type, String adress, String card_number, String connected, Long id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.cin = cin;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
        this.local_type = local_type;
        this.adress = adress;
        this.card_number = card_number;
        this.connected = connected;
        this.id = id;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getConnected() {
        return connected;
    }

    public void setConnected(String connected) {
        this.connected = connected;
    }


}
