package com.api.ingresso.Service;

import com.api.ingresso.Model.Ingresso;
import com.api.ingresso.Repository.IngressoRepository;
import com.api.ingresso.exeption.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngressoService {



    @Autowired
    private IngressoRepository igressoRepository;


    public Ingresso salvar(Ingresso ingresso){
        return igressoRepository.save((ingresso));
    }

    public List<Ingresso> listar(){
        return igressoRepository.findAll();
    }

    public Ingresso pegarPorId(Long id){
        return igressoRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Recurso não encontrado")
        );
    }

    public Ingresso atualizar(Long id, Ingresso ingresso){
        Ingresso ingressoSalvo = pegarPorId(id);
        BeanUtils.copyProperties(ingresso, ingressoSalvo, "id");
        igressoRepository.save(ingressoSalvo);
        return ingressoSalvo;
    }

    public void deletar(Long id){
        igressoRepository.deleteById(id);
    }
}