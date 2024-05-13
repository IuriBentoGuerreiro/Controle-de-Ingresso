package com.api.ingresso.Controller;

import com.api.ingresso.Model.Ingresso;
import com.api.ingresso.Service.IngressoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Ingresso")
@RequestMapping ("/ingresso")
@RestController
public class IngressoController {

    @Autowired
    private IngressoService ingressoService;

    @Operation(summary = "salvar ingresso")
    @PostMapping
    public Ingresso salvar(@RequestBody Ingresso ingresso){
        return ingressoService.salvar(ingresso);
    }

    @Operation(summary = "listar ingressos")
    @GetMapping
    public List<Ingresso> listar() {
        return ingressoService.listar();
    }

    @Operation(summary = "pegar por id")
    @GetMapping("/{id}")
    public Ingresso pegarPorId(@PathVariable Long id) {
        return ingressoService.pegarPorId(id);
    }

    @Operation(summary = "atualizar Ingresso")
    @PutMapping("/{id}")
    public Ingresso atualizar(@PathVariable Long id, @RequestBody Ingresso ingresso){
        return ingressoService.atualizar(id, ingresso);
    }

    @Operation(summary = "deletar ingresso")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        ingressoService.deletar(id);
    }
}