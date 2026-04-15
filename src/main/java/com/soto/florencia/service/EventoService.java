package com.soto.florencia.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soto.florencia.model.Evento;
import com.soto.florencia.repository.EventoRepository;

import jakarta.validation.Valid;

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

    public Evento create(Evento evento) {
        return eventoRepository.agregar(evento);
    }

    public Evento updateEvento(int id, Evento evento) {
        return eventoRepository.modificarEvento(id, evento);
    }

    public String Delete(int id) {
        return eventoRepository.borrar(id);
    }

    public void seed() {
        eventoRepository.seed();
    }

    public List<Evento> readByTipo(String tipo_evento) {
        return eventoRepository.buscarPortTipo(tipo_evento);
    }
}
