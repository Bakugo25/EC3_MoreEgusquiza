package com.venta.EC3_MoreEgusquiza.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.venta.EC3_MoreEgusquiza.dto.DtoEntity;
import com.venta.EC3_MoreEgusquiza.dto.GenericResponseDto;
import com.venta.EC3_MoreEgusquiza.exception.ResourceNotFoundException;
import com.venta.EC3_MoreEgusquiza.model.Client;
import com.venta.EC3_MoreEgusquiza.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<GenericResponseDto<List<DtoEntity>>> listarClientes(){
        List<DtoEntity> clientList = clientService
                .listarClientes();
        if(clientList.isEmpty()){
            return new ResponseEntity<>(
                    HttpStatus.NO_CONTENT);
        }
        GenericResponseDto<List<DtoEntity>> responseDto = new GenericResponseDto<>();
        responseDto.setRespuesta(clientList);
        responseDto.setStatusCode(200);
        return new ResponseEntity<>(responseDto,
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> registrarCliente
            (@RequestBody Client client){
        return new ResponseEntity<>(
                clientService.guardarClientes(client),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id_cliente}")
    public ResponseEntity<Client> obtenerCategoriaXid(@PathVariable Integer id_cliente){
        Client client = clientService.obtenerClientesXid(id_cliente).orElseThrow(()->new ResourceNotFoundException("El cliente buscado no existe"));
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PutMapping("/{id_cliente}")
    public ResponseEntity<Client> actualizarCliente(@PathVariable Integer id_cliente, @RequestBody Client client){
        Client currentClient = clientService.obtenerClientesXid(id_cliente).orElseThrow(()->new ResourceNotFoundException("El cliente buscado no existe"));
        currentClient.setNombre_cliente(client.getNombre_cliente());
        currentClient.setApellido_cliente(client.getApellido_cliente());
        return new ResponseEntity<>(clientService.guardarClientes(currentClient),HttpStatus.OK);
    }
}
