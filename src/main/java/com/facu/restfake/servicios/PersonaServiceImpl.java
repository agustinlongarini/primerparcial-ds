package com.facu.restfake.servicios;

import com.facu.restfake.entidades.Persona;
import com.facu.restfake.repositorios.BaseRepository;
import com.facu.restfake.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository, PersonaRepository personaRepository) {
        super(baseRepository);
        this.personaRepository = personaRepository;
    }

    public Page<Persona> buscarPorNombreQueryMethodPaged(String nombre, Pageable pageable) throws Exception {
        try {
            return personaRepository.findAllByNombreContaining(nombre, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Persona> buscarPorNombreJPQL(String nombre) throws Exception {
        try {
            return personaRepository.findAllByNombreJPQL(nombre);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Persona> buscarPorNombreNative(String nombre) throws Exception {
        try {
            return personaRepository.findAllByNombreNative(nombre);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Page<Persona> buscarPorDniQueryMethodPaged(int dni, Pageable pageable) throws Exception {
        try {
            return personaRepository.findAllByDni(dni, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Persona> buscarPorDniJPQL(int dni) throws Exception {
        try {
            return personaRepository.findAllByDniJPQL(dni);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Persona> buscarPorDniNative(int dni) throws Exception {
        try {
            return personaRepository.findAllByDniNative(dni);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Persona> buscarPorNombreAscendente() throws Exception {
        try {
            return personaRepository.findAllByOrderByNombreAsc();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
