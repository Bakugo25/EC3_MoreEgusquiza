package com.venta.EC3_MoreEgusquiza.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.venta.EC3_MoreEgusquiza.dto.DtoEntity;

@Component
public class ConvertDto {

    public DtoEntity convertirADto(Object object, DtoEntity dto){
        return new ModelMapper().map(object, dto.getClass());
    }
}
