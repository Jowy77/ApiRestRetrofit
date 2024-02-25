package com.api.hotel.service;

import com.api.hotel.model.Huesped;
import com.api.hotel.model.Reserva;
import com.api.hotel.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    //MOSTRAR RESERVA
    public List<Reserva> getAllReservas(){
        return reservaRepository.findAll();
    }

    //RESERVA POR ID
    public Optional<Reserva> getReservaById(Long id){
        return reservaRepository.findById(id);
    }

    //CREAR RESERVA
    public Reserva createReserva(Reserva reserva){
        return reservaRepository.save(reserva);
    }

    //EDITAR RESERVA
    public Reserva updateReserva(Reserva reserva){
        return reservaRepository.save(reserva);
    }

    //ELIMINAR RESERVA
    public void deleteReservaById(Long id){
        reservaRepository.deleteById(id);
    }
}
