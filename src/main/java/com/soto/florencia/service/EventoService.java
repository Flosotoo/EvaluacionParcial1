package com.soto.florencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soto.florencia.model.Evento;
import com.soto.florencia.repository.EventoRepository;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> readAll() {
        return eventoRepository.obtenerEvento();
    }

    public Evento readById(int id) {
        return eventoRepository.eventoPorId(id);
    }
}
