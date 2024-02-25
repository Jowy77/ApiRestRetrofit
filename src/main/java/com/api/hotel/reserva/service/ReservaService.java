package com.api.hotel.reserva.service;

import com.api.hotel.huesped.model.Huesped;
import com.api.hotel.reserva.model.Reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaService {

    List<Reserva> getAllReservas();

    List<Reserva> getReservasByFechaEntradaOrFechaSalida(String fechaEntrada, String fechaSalida);

    Optional<Reserva> getReservaById(Long id);


    Reserva createReserva(Reserva reserva);


    Reserva updateReserva(Reserva reserva);


    void deleteReservaById(Long id);
}
