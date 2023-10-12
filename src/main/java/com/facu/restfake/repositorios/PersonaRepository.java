package com.facu.restfake.repositorios;

import com.facu.restfake.entidades.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    // Query method con paginacion
    Page<Persona> findAllByNombreContaining(String nombre, Pageable pageable);

    // Consulta utilizando JPQL
    @Query("SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro%")
    List<Persona> findAllByNombreJPQL(@Param("filtro") String nombre);

    // Consulta nativa
    @Query(
            value = "SELECT * FROM persona WHERE nombre LIKE %:filtro%",
            nativeQuery = true
    )
    List<Persona> findAllByNombreNative(@Param("filtro") String nombre);

    // Query method con paginacion
    Page<Persona> findAllByDni(int dni, Pageable pageable);

    // Consulta utilizando JPQL
    @Query("SELECT p FROM Persona p WHERE p.dni = :filtro")
    List<Persona> findAllByDniJPQL(@Param("filtro") int dni);

    // Consulta nativa
    @Query(
            value = "SELECT * FROM persona WHERE dni = :filtro",
            nativeQuery = true
    )
    List<Persona> findAllByDniNative(@Param("filtro") int dni);

    // Consulta avanzada

    @Query("SELECT p FROM Persona p ORDER BY p.nombre")
    List<Persona> findAllByOrderByNombreAsc();

}
