package com.gussoft.pedidoscr.service;

import com.gussoft.pedidoscr.models.Mesa;
import com.gussoft.pedidoscr.models.dto.PedirPlato;

public interface MesaService extends Crud<Mesa>{

    Mesa hacerPedido(PedirPlato pedido);

}
