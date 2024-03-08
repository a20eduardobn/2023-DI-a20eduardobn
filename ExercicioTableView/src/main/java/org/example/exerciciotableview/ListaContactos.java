package org.example.exerciciotableview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListaContactos {
    public static final ObservableList<Contacto> listaContactos = FXCollections.observableArrayList(
            new Contacto("Juan","Gomez","62456753","Nota de prueba")
    );

}
