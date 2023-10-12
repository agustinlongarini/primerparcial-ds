package com.facu.restfake.servicios;

import com.facu.restfake.entidades.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DomicilioService extends BaseService<Domicilio, Long> {

    Page<Domicilio> buscarPorCalleQueryMethodPaged(String calle, Pageable pageable) throws Exception;

    List<Domicilio> buscarPorCalleJPQL(String calle) throws Exception;

    List<Domicilio> buscarPorCalleNative(String calle) throws Exception;

}
