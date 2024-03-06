package org.example.exerciciotableview;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Contacto {
    private StringProperty nome;
    private StringProperty apelidos;
    private StringProperty telefono;
    private StringProperty notas;

    public Contacto() {
    }

    public Contacto(String nome, String apelidos, String telefono, String notas) {
        this.nome = new SimpleStringProperty(nome);
        this.apelidos = new SimpleStringProperty(apelidos);
        this.telefono = new SimpleStringProperty(telefono);
        this.notas = new SimpleStringProperty(notas);
    }

    public StringProperty nomeProperty(){
        return nome;
    }

    public StringProperty apelidosProperty(){
        return apelidos;
    }

    public StringProperty telefonoProperty(){
        return telefono;
    }

    public StringProperty notasProperty(){
        return notas;
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getApelidos() {
        return apelidos.get();
    }

    public void setApelidos(String apelidos) {
        this.apelidos.set(apelidos);
    }

    public String getTelefono() {
        return telefono.get();
    }

    public void setTelefono(String telefono) {
        this.telefono.set(telefono);
    }

    public String getNotas() {
        return notas.get();
    }

    public void setNotas(String notas) {
        this.notas.set(notas);
    }
}
