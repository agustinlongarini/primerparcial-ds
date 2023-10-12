package com.facu.restfake.repositorios;

import com.facu.restfake.entidades.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends BaseRepository<Libro, Long>{

    // Query method con paginacion
    Page<Libro> findAllByTituloContaining(String titulo, Pageable pageable);

    // Consulta utilizando JPQL
    @Query("SELECT l FROM Libro l WHERE l.titulo LIKE %:filtro%")
    List<Libro> findAllByTituloJPQL(@Param("filtro") String titulo);

    // Consulta nativa
    @Query(
            value = "SELECT * FROM libro WHERE titulo LIKE %:filtro%",
            nativeQuery = true
    )
    List<Libro> findAllByTituloNative(@Param("filtro") String titulo);

    // Consulta utilizando JPQL
    @Query("SELECT l FROM Libro l WHERE l.genero LIKE %:filtro%")
    List<Libro> findAllByGenero(@Param("filtro") String genero);

}
