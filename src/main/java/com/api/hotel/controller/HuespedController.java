package com.api.hotel.controller;

import com.api.hotel.model.Huesped;
import com.api.hotel.service.HuespedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/huespedes")
public class HuespedController {

    @Autowired
    private HuespedService huespedService;

    //GET
    @GetMapping
    public List<Huesped> getAllHuesped(){
        return huespedService.getAllHuespedes();
    }

    //GET BY ID
    @GetMapping("{id}")
    public Optional<Huesped> getAllHuespedById(@PathVariable Long id){
        return huespedService.getHuespedById(id);
    }

    //POST
    @PostMapping
    public Huesped create(@RequestBody Huesped huesped){
        return huespedService.createHuesped(huesped);
    }

    //PUT

    @PostMapping("put/{id}")
    public Huesped update(@RequestBody Huesped huesped, @PathVariable Long id){
        huesped.setIdHuesped(id);
        return huespedService.updateHuesped(huesped);
    }

    @DeleteMapping("delete/{id}")
    public void eliminar(@PathVariable Long id){
        huespedService.deleteHuespedById(id);
    }

    /*@PostMapping("/{huespedId}/reservas/{reservaId}")
    public ResponseEntity<String> addReservaToHuesped(@PathVariable Long huespedId, @PathVariable Long reservaId) {
        boolean result = huespedService.agregarReservaHuesped(huespedId, reservaId);
        if (result) {
            return ResponseEntity.ok("Reserva añadida al huésped correctamente");
        } else {
            return ResponseEntity.badRequest().body("No se pudo añadir la reserva al huésped");
        }
    }

    // Eliminar reserva de un huésped
    @DeleteMapping("/{huespedId}/reservas/{reservaId}")
    public ResponseEntity<String> removeReservaFromHuesped(@PathVariable Long huespedId, @PathVariable Long reservaId) {
        boolean result = huespedService.eliminarReservaHuesped(huespedId, reservaId);
        if (result) {
            return ResponseEntity.ok("Reserva eliminada del huésped correctamente");
        } else {
            return ResponseEntity.badRequest().body("No se pudo eliminar la reserva del huésped");
        }
    }*/
}
