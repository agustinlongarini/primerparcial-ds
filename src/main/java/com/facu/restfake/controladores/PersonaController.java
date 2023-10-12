package com.facu.restfake.controladores;

import com.facu.restfake.entidades.Persona;
import com.facu.restfake.servicios.PersonaServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{

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

    @GetMapping("/buscarPorDniQueryMethodPaged")
    public ResponseEntity<?> buscarPorDniQueryMethodPaged(@RequestParam int dni, Pageable pageable)  {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorDniQueryMethodPaged(dni, pageable));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/buscarPorDniJPQL")
    public ResponseEntity<?> buscarPorDniJPQL(@RequestParam int dni)  {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorDniJPQL(dni));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/buscarPorDniNative")
    public ResponseEntity<?> buscarPorDniNative(@RequestParam int dni)  {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorDniNative(dni));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/buscarPorNombreAscendente")
    public ResponseEntity<?> buscarPorNombreAscendente()  {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorNombreAscendente());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}
