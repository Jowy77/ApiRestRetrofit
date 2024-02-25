package com.api.hotel.huesped.model;

import com.api.hotel.reserva.model.Reserva;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Huesped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHuesped;

    private String nombre;
    private String telefono;
    private String fotoPerfil;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;
}
