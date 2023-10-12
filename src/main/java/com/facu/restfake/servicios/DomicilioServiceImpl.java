package com.facu.restfake.servicios;

import com.facu.restfake.entidades.Domicilio;
import com.facu.restfake.entidades.Localidad;
import com.facu.restfake.repositorios.BaseRepository;
import com.facu.restfake.repositorios.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService {

    @Autowired
    private DomicilioRepository domicilioRepository;

    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository, DomicilioRepository domicilioRepository) {
        super(baseRepository);
        this.domicilioRepository = domicilioRepository;
    }

    public Page<Domicilio> buscarPorCalleQueryMethodPaged(String calle, Pageable pageable) throws Exception {
        try {
            return domicilioRepository.findAllByCalleContaining(calle, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Domicilio> buscarPorCalleJPQL(String calle) throws Exception {
        try {
            return domicilioRepository.findAllByCalleJPQL(calle);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Domicilio> buscarPorCalleNative(String calle) throws Exception {
        try {
            return domicilioRepository.findAllByCalleNative(calle);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
