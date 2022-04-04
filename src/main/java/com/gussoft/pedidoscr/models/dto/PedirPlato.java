package com.gussoft.pedidoscr.models.dto;

import com.gussoft.pedidoscr.models.Mesa;
import com.gussoft.pedidoscr.models.Pagos;
import com.gussoft.pedidoscr.models.Plato;

import java.util.List;

public class PedirPlato {

    private Mesa mesa;
    //private Pagos pago;

    public PedirPlato() {
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    /*public Pagos getPago() {
        return pago;
    }

    public void setPago(Pagos pago) {
        this.pago = pago;
    }*/
}
