package com.api.hotel.service;

import com.api.hotel.model.Huesped;
import com.api.hotel.model.Reserva;
import com.api.hotel.repository.HuespedRepository;
import com.api.hotel.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HuespedService {

    @Autowired
    private HuespedRepository huespedRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    //MOSTRAR HUESPED
    public List<Huesped> getAllHuespedes(){
        return huespedRepository.findAll();
    }

    //MOSTRAR HUESPED POR ID
    public Optional<Huesped> getHuespedById(Long id){
        return huespedRepository.findById(id);
    }

    //CREAR HUESPED
    public Huesped createHuesped(Huesped huesped){
        return huespedRepository.save(huesped);
    }

    //EDITAR HUESPED
    public Huesped updateHuesped(Huesped huesped){
        return huespedRepository.save(huesped);
    }

    //ELIMINAR HUESPED
    public void deleteHuespedById(Long id){
        huespedRepository.deleteById(id);
    }

    //POR IMPLEMENTAR CORRECTAMENTE

    /*public boolean agregarReservaHuesped(Long huespedId, Long reservaId) {
        // Implementa la lógica para añadir la reserva al huésped
        // Puedes utilizar el repositorio o cualquier otra forma de acceso a datos aquí
        Huesped huesped = huespedRepository.findById(huespedId).orElse(null);
        Reserva reserva = reservaRepository.findById(reservaId).orElse(null);

        if (huesped != null && reserva != null) {
            huesped.agregarReserva(reserva);
            huespedRepository.save(huesped);
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarReservaHuesped(Long huespedId, Long reservaId) {
        // Implementa la lógica para eliminar la reserva del huésped
        // Puedes utilizar el repositorio o cualquier otra forma de acceso a datos aquí
        Huesped huesped = huespedRepository.findById(huespedId).orElse(null);
        Reserva reserva = reservaRepository.findById(reservaId).orElse(null);

        if (huesped != null && reserva != null) {
            huesped.eliminarReserva(reserva);
            huespedRepository.save(huesped);
            return true;
        } else {
            return false;
        }
    }*/

}
