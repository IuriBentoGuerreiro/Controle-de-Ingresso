package com.api.ingresso.Service;

import com.api.ingresso.Model.IngressoModel;
import com.api.ingresso.Repository.IngressoRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;
@Data
@Service
public class IngressoService {

     private IngressoRepository igressoRepository;

     @Autowired
    public IngressoService(IngressoRepository ingressoRepository){
        this.igressoRepository = ingressoRepository;
    }

    @PostMapping
    public IngressoModel criarIngresso(@RequestBody IngressoModel criarIngresso){
        return igressoRepository.save((criarIngresso));
    }

    @GetMapping("/ingressos")
    public List<IngressoModel> listarIngressos(){
        return igressoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<IngressoModel> encontrarIngresso(@PathVariable Long id){
        return igressoRepository.findById(id);
    }

}
