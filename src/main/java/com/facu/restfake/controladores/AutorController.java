package com.facu.restfake.controladores;

import com.facu.restfake.entidades.Autor;
import com.facu.restfake.servicios.AutorServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/autores")
public class AutorController extends BaseControllerImpl<Autor, AutorServiceImpl>{

    @GetMapping("/buscarPorNombreMethodPaged")
    public ResponseEntity<?> buscarPorNombreQueryMethodPaged(@RequestParam String nombre, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorNombreQueryMethodPaged(nombre, pageable));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/buscarPorNombreJPQL")
    public ResponseEntity<?> buscarPorNombreJPQL(@RequestParam String nombre)  {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorNombreJPQL(nombre));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/buscarPorNombreNative")
    public ResponseEntity<?> buscarPorNombreNative(@RequestParam String nombre)  {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorNombreNative(nombre));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}
