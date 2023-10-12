package com.facu.restfake.servicios;

import com.facu.restfake.entidades.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LocalidadService extends BaseService<Localidad, Long>{

    Page<Localidad> buscarPorDenominacionQueryMethodPaged(String denominacion, Pageable pageable) throws Exception;

    List<Localidad> buscarPorDenominacionJPQL(String denominacion) throws Exception;

    List<Localidad> buscarPorDenominacionNative(String denominacion) throws Exception;

}
