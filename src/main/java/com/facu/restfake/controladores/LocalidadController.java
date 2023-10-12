package com.facu.restfake.controladores;

import com.facu.restfake.entidades.Localidad;
import com.facu.restfake.servicios.LocalidadServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/localidades")
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImpl>{

    @GetMapping("/buscarPorDenominacionMethodPaged")
    public ResponseEntity<?> buscarPorDenominacionQueryMethodPaged(@RequestParam String denominacion, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorDenominacionQueryMethodPaged(denominacion, pageable));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/buscarPorDenominacionJPQL")
    public ResponseEntity<?> buscarPorDenominacionJPQL(@RequestParam String denominacion)  {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorDenominacionJPQL(denominacion));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/buscarPorDenominacionNative")
    public ResponseEntity<?> buscarPorDenominacionNative(@RequestParam String denominacion)  {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorDenominacionNative(denominacion));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}
