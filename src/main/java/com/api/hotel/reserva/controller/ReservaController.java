package com.api.hotel.reserva.controller;

import com.api.hotel.huesped.model.Huesped;
import com.api.hotel.reserva.model.Reserva;
import com.api.hotel.reserva.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaService.getAllReservas();
    }

    @GetMapping("/filter")
    public List<Reserva> getAllReservasByFechaEntradaOrFechaSalida(@RequestParam(value = "fecha_entrada", required = false) String fechaEntrada, @RequestParam(value = "fecha_salida", required = false) String fechaSalida) {
        return reservaService.getReservasByFechaEntradaOrFechaSalida(fechaEntrada,fechaSalida);
    }

    @GetMapping("{id}")
    public Optional<Reserva> getReservaByID(@PathVariable Long id) {
        return reservaService.getReservaById(id);
    }


    @PostMapping
    public Reserva create(@RequestBody Reserva reserva) {
        return reservaService.createReserva(reserva);
    }


    @PutMapping("put/{id}")
    public Reserva update(@RequestBody Reserva reserva, @PathVariable Long id) {
        reserva.setIdReserva(id);
        return reservaService.updateReserva(reserva);
    }

    @DeleteMapping("delete/{id}")
    public void eliminar(@PathVariable Long id) {
        reservaService.deleteReservaById(id);
    }
}
