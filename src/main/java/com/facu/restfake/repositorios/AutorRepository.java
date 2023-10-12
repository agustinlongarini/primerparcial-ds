package com.facu.restfake.repositorios;

import com.facu.restfake.entidades.Autor;
import com.facu.restfake.entidades.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends BaseRepository<Autor, Long>{

    // Query method con paginacion
    Page<Autor> findAllByNombreContaining(String nombre, Pageable pageable);

    // Consulta utilizando JPQL
    @Query("SELECT a FROM Autor a WHERE a.nombre LIKE %:filtro%")
    List<Autor> findAllByNombreJPQL(@Param("filtro") String nombre);

    // Consulta nativa
    @Query(
            value = "SELECT * FROM autor WHERE nombre LIKE %:filtro%",
            nativeQuery = true
    )
    List<Autor> findAllByNombreNative(@Param("filtro") String nombre);

}
