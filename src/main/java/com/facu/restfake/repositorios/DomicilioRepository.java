package com.facu.restfake.repositorios;

import com.facu.restfake.entidades.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio, Long>{

    // Query method con paginacion
    Page<Domicilio> findAllByCalleContaining(String calle, Pageable pageable);

    // Consulta utilizando JPQL
    @Query("SELECT d FROM Domicilio d WHERE d.calle LIKE %:filtro%")
    List<Domicilio> findAllByCalleJPQL(@Param("filtro") String calle);

    // Consulta nativa
    @Query(
            value = "SELECT * FROM domicilio WHERE calle LIKE %:filtro%",
            nativeQuery = true
    )
    List<Domicilio> findAllByCalleNative(@Param("filtro") String calle);

}
