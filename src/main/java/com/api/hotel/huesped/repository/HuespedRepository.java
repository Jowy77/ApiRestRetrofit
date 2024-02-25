package com.api.hotel.huesped.repository;

import com.api.hotel.huesped.model.Huesped;
import com.api.hotel.reserva.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HuespedRepository extends JpaRepository<Huesped, Long> {

    List<Huesped> findByNombreIgnoreCaseOrTelefono(String nombre, String telefono);

    Huesped findHuespedByReservas(Reserva reserva);
}
