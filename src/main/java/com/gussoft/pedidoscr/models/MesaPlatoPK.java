package com.gussoft.pedidoscr.models;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MesaPlatoPK implements Serializable {
    //importante la implementacion de Serializable!!
    @ManyToOne
    @JoinColumn(name = "id_mesa", nullable = false)
    private Mesa mesa;

    @ManyToOne
    @JoinColumn(name = "id_plato", nullable = false)
    private Plato plato;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MesaPlatoPK that = (MesaPlatoPK) o;
        return Objects.equals(mesa, that.mesa) && Objects.equals(plato, that.plato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mesa, plato);
    }
}
