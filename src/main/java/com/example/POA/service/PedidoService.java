package com.example.POA.service;

import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    public String criarPedido(String produto, int quantidade){
        return "Pedido criado: "+ quantidade+ "x"+ produto;
    }

    public String cancelarPedido(Long pedidoId){
        return  "Pedido cancelado: "+ pedidoId;
    }
}
