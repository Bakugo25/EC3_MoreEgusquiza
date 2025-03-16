package com.venta.EC3_MoreEgusquiza.service;

import com.venta.EC3_MoreEgusquiza.dto.DtoEntity;
import com.venta.EC3_MoreEgusquiza.dto.PedidDto;
import com.venta.EC3_MoreEgusquiza.model.Pedid;
import com.venta.EC3_MoreEgusquiza.repository.PedidReposiroty;
import com.venta.EC3_MoreEgusquiza.util.ConvertDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidService {
    private final PedidReposiroty pedidReposiroty;
    private final ConvertDto convertDto;

    public PedidService(PedidReposiroty pedidReposiroty, ConvertDto convertDto) {
        this.pedidReposiroty = pedidReposiroty;
        this.convertDto = convertDto;
    }

    public List<DtoEntity> listarPedidos(){
        List<DtoEntity> pedidoDtoList = new ArrayList<>();
        pedidoDtoList = pedidReposiroty.findAll().stream().map(p -> convertDto.convertirADto(p, new PedidDto())).collect(Collectors.toList());
        return pedidoDtoList;
    }

    public Pedid guardarPedido(Pedid pedid){
        return pedidReposiroty.save(pedid);
    }

    public Optional<Pedid> obtenerPedidoXid(Integer id_producto){
        return pedidReposiroty.findById(id_producto);
    }

}
