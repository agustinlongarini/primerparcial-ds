package com.facu.restfake.servicios;

import com.facu.restfake.entidades.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LibroService extends BaseService<Libro, Long>{

    Page<Libro> buscarPorTituloQueryMethodPaged(String titulo, Pageable pageable) throws Exception;

    List<Libro> buscarPorTituloJPQL(String titulo) throws Exception;

    List<Libro> buscarPorTituloNative(String titulo) throws Exception;

    List<Libro> buscarPorGenero(String genero) throws Exception;

}
