package controllers;

import services.PedidoService;

public class PedidoController {

    private PedidoService pedidoService;

    
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    
    
}
