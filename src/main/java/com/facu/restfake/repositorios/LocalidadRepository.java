package com.facu.restfake.repositorios;

import com.facu.restfake.entidades.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadRepository extends BaseRepository<Localidad, Long>{

    // Query method con paginacion
    Page<Localidad> findAllByDenominacionContaining(String denominacion, Pageable pageable);

    // Consulta utilizando JPQL
    @Query("SELECT l FROM Localidad l WHERE l.denominacion LIKE %:filtro%")
    List<Localidad> findAllByDenominacionJPQL(@Param("filtro") String denominacion);

    // Consulta nativa
    @Query(
            value = "SELECT * FROM localidad WHERE denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    List<Localidad> findAllByDenominacionNative(@Param("filtro") String denominacion);

}
