package com.api.ingresso.Repository;

import com.api.ingresso.Model.Ingresso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngressoRepository extends JpaRepository <Ingresso, Long> {
}
