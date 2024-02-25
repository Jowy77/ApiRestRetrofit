package com.api.hotel.huesped.controller;

import com.api.hotel.huesped.model.Huesped;
import com.api.hotel.huesped.service.HuespedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/huespedes")
@RequiredArgsConstructor
public class HuespedController {


    private final HuespedService huespedService;


    @GetMapping
    public List<Huesped> getAllHuesped() {
        return huespedService.getAllHuespedes();
    }

    @GetMapping("/filter")
    public List<Huesped> getAllHuespedesByNameOrTelefono(@RequestParam(value = "nombre", required = false) String nombre, @RequestParam(value = "telefono", required = false) String telefono) {
        return huespedService.getHuespedesByNameOrTelefono(nombre,telefono);
    }

    @GetMapping("{id}")
    public Optional<Huesped> getAllHuespedById(@PathVariable Long id) {
        return huespedService.getHuespedById(id);
    }


    @PostMapping
    public Huesped create(@RequestBody Huesped huesped) {
        return huespedService.createHuesped(huesped);
    }


    @PutMapping("put/{id}")
    public Huesped update(@RequestBody Huesped huesped, @PathVariable Long id) {
        huesped.setIdHuesped(id);
        return huespedService.updateHuesped(huesped);
    }

    @DeleteMapping("delete/{id}")
    public void eliminar(@PathVariable Long id) {
        huespedService.deleteHuespedById(id);
    }

}
