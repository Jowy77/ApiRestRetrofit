package com.api.hotel.controller;

import com.api.hotel.model.Reserva;
import com.api.hotel.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> getAllReservas(){
        return reservaService.getAllReservas();
    }

    //GET BY ID
    @GetMapping("{id}")
    public Optional<Reserva> getReservaByID(@PathVariable Long id){
        return reservaService.getReservaById(id);
    }

    //POST
    @PostMapping
    public Reserva create(@RequestBody Reserva reserva){
        return reservaService.createReserva(reserva);
    }

    //PUT

    @PostMapping("put/{id}")
    public Reserva update(@RequestBody Reserva reserva, @PathVariable Long id){
        reserva.setIdReserva(id);
        return reservaService.updateReserva(reserva);
    }

    @DeleteMapping("delete/{id}")
    public void eliminar(@PathVariable Long id){
        reservaService.deleteReservaById(id);
    }
}
