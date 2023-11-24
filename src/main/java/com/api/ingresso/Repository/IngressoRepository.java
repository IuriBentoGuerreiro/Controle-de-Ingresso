package com.api.ingresso.Repository;

import com.api.ingresso.Model.IngressoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IngressoRepository extends JpaRepository <IngressoModel, Long> {
}
