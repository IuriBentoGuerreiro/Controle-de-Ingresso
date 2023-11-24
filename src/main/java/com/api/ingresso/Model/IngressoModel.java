package com.api.ingresso.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Data
@RequestMapping
@Table(name = "ingresso")
@Entity
@Component
public class IngressoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private  long id;
    @Column(name = "data")
    private LocalDateTime data;
    @Column (name = "cpf")
    private String cpf;
    @Column (name = "nome")
    private String nome;

}
