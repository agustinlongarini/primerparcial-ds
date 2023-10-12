package com.facu.restfake.controladores;

import com.facu.restfake.entidades.Domicilio;
import com.facu.restfake.servicios.DomicilioServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/domicilios")
public class DomicilioController extends BaseControllerImpl<Domicilio, DomicilioServiceImpl>{

    @GetMapping("/buscarPorCalleMethodPaged")
    public ResponseEntity<?> buscarPorCalleQueryMethodPaged(@RequestParam String calle, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorCalleQueryMethodPaged(calle, pageable));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/buscarPorCalleJPQL")
    public ResponseEntity<?> buscarPorCalleJPQL(@RequestParam String calle)  {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorCalleJPQL(calle));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/buscarPorCalleNative")
    public ResponseEntity<?> buscarPorCalleNative(@RequestParam String calle)  {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorCalleNative(calle));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}
