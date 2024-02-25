package com.api.hotel.reserva.repository;

import com.api.hotel.huesped.model.Huesped;
import com.api.hotel.reserva.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByfechaEntradaOrFechaSalida(String fecha, String telefono);
}
