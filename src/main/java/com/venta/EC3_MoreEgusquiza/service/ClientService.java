package com.venta.EC3_MoreEgusquiza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.venta.EC3_MoreEgusquiza.dto.ClientDto;
import com.venta.EC3_MoreEgusquiza.dto.DtoEntity;
import com.venta.EC3_MoreEgusquiza.model.Client;
import com.venta.EC3_MoreEgusquiza.repository.ClientRepository;
import com.venta.EC3_MoreEgusquiza.util.ConvertDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    private final ConvertDto convertDto;

    public ClientService(ClientRepository clientRepository, ConvertDto convertDto) {
        this.clientRepository = clientRepository;
        this.convertDto = convertDto;
    }

    public List<DtoEntity> listarClientes(){
        List<DtoEntity> clientDtoList = new ArrayList<>();
        clientDtoList = clientRepository.findAll().stream().map(p -> convertDto.convertirADto(p, new ClientDto())).collect(Collectors.toList());
        return clientDtoList;
    }

    public Client guardarClientes(Client client){
        return clientRepository.save(client);
    }

    public Optional<Client> obtenerClientesXid(Integer id_client){
        return clientRepository.findById(id_client);
    }

}
