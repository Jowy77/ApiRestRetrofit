package com.api.hotel.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Huesped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHuesped;


    private String nombre;
    private String telefono;
    private String fotoPerfil;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Reserva> reservas = new ArrayList<>();
}
