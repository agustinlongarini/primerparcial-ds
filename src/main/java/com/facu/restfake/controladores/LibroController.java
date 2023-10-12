package com.facu.restfake.controladores;

import com.facu.restfake.entidades.Libro;
import com.facu.restfake.servicios.LibroServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/libros")
public class LibroController extends BaseControllerImpl<Libro, LibroServiceImpl>{

    @GetMapping("/buscarPorTituloMethodPaged")
    public ResponseEntity<?> buscarPorTituloQueryMethodPaged(@RequestParam String titulo, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorTituloQueryMethodPaged(titulo, pageable));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/buscarPorTituloJPQL")
    public ResponseEntity<?> buscarPorTituloJPQL(@RequestParam String titulo)  {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorTituloJPQL(titulo));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/buscarPorTituloNative")
    public ResponseEntity<?> buscarPorTituloNative(@RequestParam String titulo)  {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorTituloNative(titulo));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/buscarPorGenero")
    public ResponseEntity<?> buscarPorGenero(@RequestParam String genero)  {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorGenero(genero));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}
