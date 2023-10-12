package com.facu.restfake.servicios;

import com.facu.restfake.entidades.Autor;
import com.facu.restfake.entidades.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AutorService extends BaseService<Autor, Long>{

    Page<Autor> buscarPorNombreQueryMethodPaged(String nombre, Pageable pageable) throws Exception;

    List<Autor> buscarPorNombreJPQL(String nombre) throws Exception;

    List<Autor> buscarPorNombreNative(String nombre) throws Exception;

}
