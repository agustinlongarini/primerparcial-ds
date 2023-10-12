package com.facu.restfake.servicios;

import com.facu.restfake.entidades.Autor;
import com.facu.restfake.entidades.Persona;
import com.facu.restfake.repositorios.AutorRepository;
import com.facu.restfake.repositorios.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor, Long> implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository, AutorRepository autorRepository) {
        super(baseRepository);
        this.autorRepository = autorRepository;
    }

    public Page<Autor> buscarPorNombreQueryMethodPaged(String nombre, Pageable pageable) throws Exception {
        try {
            return autorRepository.findAllByNombreContaining(nombre, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Autor> buscarPorNombreJPQL(String nombre) throws Exception {
        try {
            return autorRepository.findAllByNombreJPQL(nombre);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Autor> buscarPorNombreNative(String nombre) throws Exception {
        try {
            return autorRepository.findAllByNombreNative(nombre);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
