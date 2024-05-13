package com.api.ingresso.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "ingresso")
@Entity
public class Ingresso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private  Long id;
    @Column(name = "data")
    private LocalDateTime data;
    @Column (name = "cpf")
    private String cpf;
    @Column (name = "nome")
    private String nome;

}
