/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo_edfinalproject;

/**
 *
 * @author UTEC-5695
 */
public class Usuario {

    //atributos
    private String name;
    private long cpf;
    private String user;
    private String password;
    private String tipoFunc;

    //metodos
    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTipoFunc(String tipoFunc) {
        this.tipoFunc = tipoFunc;
    }

    public String getName() {
        return name;
    }

    public long getCpf() {
        return cpf;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getTipoFunc() {
        return tipoFunc;
    }
}
