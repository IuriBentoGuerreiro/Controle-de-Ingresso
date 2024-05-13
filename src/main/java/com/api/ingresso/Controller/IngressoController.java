package com.api.ingresso.Controller;

import com.api.ingresso.Model.Ingresso;
import com.api.ingresso.Service.IngressoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping ("/ingresso")
@RestController
public class IngressoController {

    @Autowired
    private IngressoService ingressoService;


    @PostMapping
    public ResponseEntity<Ingresso> salvar(@RequestBody Ingresso ingresso){
        Ingresso ingressoSalvo = ingressoService.salvar(ingresso);
        return ResponseEntity.status(HttpStatus.CREATED).body(ingressoSalvo);
    }

    @GetMapping
    public List<Ingresso> listar() {
        return ingressoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingresso> encontrarIngresso(@PathVariable Long id) {
        Ingresso ingresso = ingressoService.pegarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(ingresso);
    }
}
