package com.api.ingresso.Controller;

import com.api.ingresso.Model.IngressoModel;
import com.api.ingresso.Service.IngressoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequestMapping ("/ingresso")
@RestController
@Data
public class IngressoController {

        private IngressoService ingressoService;
        @Autowired
        public IngressoController(IngressoService ingressoService){
            this.ingressoService = ingressoService;
        }

    @PostMapping
    public IngressoModel criarIngresso(@RequestBody IngressoModel criarIngresso){
        criarIngresso.setData(LocalDateTime.now());
        IngressoModel ingressoModel = ingressoService.criarIngresso(criarIngresso);
        return new ResponseEntity<>(ingressoModel, HttpStatus.CREATED).getBody();
    }

    @GetMapping
    public ResponseEntity<List<IngressoModel>> listarIngressos() {
        List<IngressoModel> ingressos = ingressoService.listarIngressos();
        return new ResponseEntity<>(ingressos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngressoModel> encontrarIngresso(@PathVariable Long id) {
        Optional<IngressoModel> ingresso = ingressoService.encontrarIngresso(id);
        return ingresso.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
