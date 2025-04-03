package com.example.POA.controller;

import com.example.POA.service.PedidoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public String criarPedido(@RequestParam String produto, @RequestParam int quantidade){
        return  pedidoService.criarPedido(produto,quantidade);
    }

    @DeleteMapping("/{id}")
    public String cancelarPedido(@PathVariable Long id){
        return  pedidoService.cancelarPedido(id);
    }
}
