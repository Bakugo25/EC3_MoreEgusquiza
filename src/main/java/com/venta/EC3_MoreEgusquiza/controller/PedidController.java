package com.venta.EC3_MoreEgusquiza.controller;

import com.venta.EC3_MoreEgusquiza.dto.DtoEntity;
import com.venta.EC3_MoreEgusquiza.dto.GenericResponseDto;
import com.venta.EC3_MoreEgusquiza.exception.ResourceNotFoundException;
import com.venta.EC3_MoreEgusquiza.model.Pedid;
import com.venta.EC3_MoreEgusquiza.service.PedidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pedid")
public class PedidController {
    private final PedidService pedidService;

    public PedidController(PedidService pedidService) {
        this.pedidService = pedidService;
    }

    @GetMapping
    public ResponseEntity<GenericResponseDto<List<DtoEntity>>> listarPedidos(){
        List<DtoEntity> pedidList = pedidService
                .listarPedidos();
        if(pedidList.isEmpty()){
            return new ResponseEntity<>(
                    HttpStatus.NO_CONTENT);
        }
        GenericResponseDto<List<DtoEntity>> responseDto = new GenericResponseDto<>();
        responseDto.setRespuesta(pedidList);
        responseDto.setStatusCode(200);
        return new ResponseEntity<>(responseDto,
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pedid> registrarPedido
            (@RequestBody Pedid pedid){
        return new ResponseEntity<>(
                pedidService.guardarPedido(pedid),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id_pedido}")
    public ResponseEntity<Pedid> obtenerPedidoXid(@PathVariable Integer id_pedido){
        Pedid pedid = pedidService.obtenerPedidoXid(id_pedido).orElseThrow(()->new ResourceNotFoundException("El Pedido buscado no existe"));
        return new ResponseEntity<>(pedid, HttpStatus.OK);
    }

    @PutMapping("/{id_pedido}")
    public ResponseEntity<Pedid> actualizarPedido(@PathVariable Integer id_pedido, @RequestBody Pedid pedid){
        Pedid currentPedid = pedidService.obtenerPedidoXid(id_pedido).orElseThrow(()->new ResourceNotFoundException("El pedido buscado no existe"));
        currentPedid.setClient(pedid.getClient());
        currentPedid.setProduct(pedid.getProduct());
        return new ResponseEntity<>(pedidService.guardarPedido(currentPedid),HttpStatus.OK);
    }
}
