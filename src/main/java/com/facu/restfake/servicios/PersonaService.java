package com.facu.restfake.servicios;

import com.facu.restfake.entidades.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonaService extends BaseService<Persona, Long>{

    Page<Persona> buscarPorNombreQueryMethodPaged(String nombre, Pageable pageable) throws Exception;

    List<Persona> buscarPorNombreJPQL(String nombre) throws Exception;

    List<Persona> buscarPorNombreNative(String nombre) throws Exception;

    Page<Persona> buscarPorDniQueryMethodPaged(int dni, Pageable pageable) throws Exception;

    List<Persona> buscarPorDniJPQL(int dni) throws Exception;

    List<Persona> buscarPorDniNative(int dni) throws Exception;

    List<Persona> buscarPorNombreAscendente () throws Exception;

}
