package com.api.hotel.huesped.service;

import com.api.hotel.huesped.model.Huesped;

import java.util.List;
import java.util.Optional;

public interface HuespedService {

    List<Huesped> getAllHuespedes();

    List<Huesped> getHuespedesByNameOrTelefono(String nombre, String telefono);

    Optional<Huesped> getHuespedById(Long id);

    void desvincularReserva(Long id);

    Huesped createHuesped(Huesped huesped);

    Huesped updateHuesped(Huesped huesped);

    void deleteHuespedById(Long id);
}
