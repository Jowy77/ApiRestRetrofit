package com.api.hotel.reserva.service.impl;

import com.api.hotel.huesped.service.HuespedService;
import com.api.hotel.reserva.model.Reserva;
import com.api.hotel.reserva.repository.ReservaRepository;
import com.api.hotel.reserva.service.ReservaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements ReservaService {


    private final ReservaRepository reservaRepository;

    private final HuespedService huespedService;

    public List<Reserva> getAllReservas() {
        log.info("get reservas");
        return reservaRepository.findAll();
    }

    @Override
    public List<Reserva> getReservasByFechaEntradaOrFechaSalida(String fechaEntrada, String fechaSalida) {
        log.info("get ReservasByFechaEntradaOrFechaSalida");
        return reservaRepository.findByfechaEntradaOrFechaSalida(fechaEntrada,fechaSalida);
    }


    public Optional<Reserva> getReservaById(Long id) {
        log.info("get reserva by id: {}", id);
        return reservaRepository.findById(id);
    }


    public Reserva createReserva(Reserva reserva) {
        log.info("create reserva");
        return reservaRepository.save(reserva);
    }


    public Reserva updateReserva(Reserva reserva) {
        log.info("update reserva");
        return reservaRepository.save(reserva);
    }


    public void deleteReservaById(Long id) {
        log.info("delete reserva by id: {}", id);
        huespedService.desvincularReserva(id);
    }
}
