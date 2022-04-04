package com.gussoft.pedidoscr.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(MesaPlatoPK.class)
public class MesaPlato {

    @Id
    private Mesa mesa;

    @Id
    private Plato plato;

    public MesaPlato() {
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }
}
