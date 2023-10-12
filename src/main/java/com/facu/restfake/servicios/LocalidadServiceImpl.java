package com.facu.restfake.servicios;

import com.facu.restfake.entidades.Localidad;
import com.facu.restfake.entidades.Persona;
import com.facu.restfake.repositorios.BaseRepository;
import com.facu.restfake.repositorios.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService {

    @Autowired
    private LocalidadRepository localidadRepository;

    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository, LocalidadRepository localidadRepository) {
        super(baseRepository);
        this.localidadRepository = localidadRepository;
    }

    public Page<Localidad> buscarPorDenominacionQueryMethodPaged(String denominacion, Pageable pageable) throws Exception {
        try {
            return localidadRepository.findAllByDenominacionContaining(denominacion, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Localidad> buscarPorDenominacionJPQL(String denominacion) throws Exception {
        try {
            return localidadRepository.findAllByDenominacionJPQL(denominacion);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Localidad> buscarPorDenominacionNative(String denominacion) throws Exception {
        try {
            return localidadRepository.findAllByDenominacionNative(denominacion);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
