package com.api.hotel.huesped.service.impl;

import com.api.hotel.huesped.model.Huesped;
import com.api.hotel.huesped.repository.HuespedRepository;
import com.api.hotel.huesped.service.HuespedService;
import com.api.hotel.reserva.model.Reserva;
import com.api.hotel.reserva.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class HuespedServiceImpl implements HuespedService {


    private final HuespedRepository huespedRepository;

    private final ReservaRepository reservaRepository;

    public List<Huesped> getAllHuespedes() {
        log.info("get huespedes");
        return huespedRepository.findAll();
    }

    @Override
    public List<Huesped> getHuespedesByNameOrTelefono(String nombre, String telefono) {
        log.info("get huespedesByNameOrTelefono");
        return huespedRepository.findByNombreIgnoreCaseOrTelefono(nombre,telefono);
    }

    public Optional<Huesped> getHuespedById(Long id) {
        log.info("get huesped by id: {}",id);
        return huespedRepository.findById(id);
    }

    @Transactional
    @Override
    public void desvincularReserva(Long id) {
        Optional<Reserva> reserva = reservaRepository.findById(id);

        if(reserva.isPresent()){
            Huesped huesped = huespedRepository.findHuespedByReservas(reserva.get());
            if(huesped != null && !CollectionUtils.isEmpty(huesped.getReservas())){
                huesped.getReservas().remove(reserva.get());
                huespedRepository.save(huesped);
            }
        }
    }

    public Huesped createHuesped(Huesped huesped) {
        log.info("create huesped");
        return huespedRepository.save(huesped);
    }

    public Huesped updateHuesped(Huesped huesped) {
        log.info("update huesped");
        return huespedRepository.save(huesped);
    }

    public void deleteHuespedById(Long id) {
        log.info("delete huesped by id: {}",id);
        huespedRepository.deleteById(id);
    }

}
