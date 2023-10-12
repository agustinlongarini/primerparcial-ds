package com.facu.restfake.servicios;

import com.facu.restfake.entidades.Localidad;
import com.facu.restfake.repositorios.BaseRepository;
import com.facu.restfake.entidades.Libro;
import com.facu.restfake.repositorios.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl extends BaseServiceImpl<Libro, Long> implements LibroService{

    @Autowired
    private LibroRepository libroRepository;

    public LibroServiceImpl(BaseRepository<Libro, Long> baseRepository, LibroRepository libroRepository) {
        super(baseRepository);
        this.libroRepository = libroRepository;
    }

    public Page<Libro> buscarPorTituloQueryMethodPaged(String titulo, Pageable pageable) throws Exception {
        try {
            return libroRepository.findAllByTituloContaining(titulo, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Libro> buscarPorTituloJPQL(String titulo) throws Exception {
        try {
            return libroRepository.findAllByTituloJPQL(titulo);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Libro> buscarPorTituloNative(String titulo) throws Exception {
        try {
            return libroRepository.findAllByTituloNative(titulo);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Libro> buscarPorGenero(String genero) throws Exception {
        try {
            return libroRepository.findAllByGenero(genero);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
