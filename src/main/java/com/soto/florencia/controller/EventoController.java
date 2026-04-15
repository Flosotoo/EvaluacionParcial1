package com.soto.florencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soto.florencia.model.Evento;
import com.soto.florencia.service.EventoService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/eventos")
public class EventoController {
    @Autowired
    private EventoService eventoService;
    
    @GetMapping
    public ResponseEntity<?> getEventos(){
        List<Evento> lista = eventoService.readAll();
        if(lista.isEmpty()){
            return ResponseEntity.status(404).body("No hay eventos disponibles");
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getEventosPorId(@PathVariable int id){
        Evento evento = eventoService.readById(id);
        if(evento == null){
            return ResponseEntity.status(404).body("No se encontraron eventos");
        }
        return ResponseEntity.ok(evento);
    }

    @PostMapping
    public ResponseEntity<String>postEvento(@Valid @RequestBody Evento evento){
        Evento creado = eventoService.create(evento);
        if(creado == null){
            return ResponseEntity.status(400).body("El ID del evento ya existe");
        }
        return ResponseEntity.ok("Evento guardado exitosamente");
    } 

    @PutMapping("{id}")
    public ResponseEntity<?> putEvento(@PathVariable int id, @Valid @RequestBody Evento evento){
        Evento actualizado = eventoService.updateEvento(id, evento);
        if(actualizado == null){
            return ResponseEntity.status(404).body("Evento no encontrado");
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEvento(@PathVariable int id){
        return ResponseEntity.ok(eventoService.Delete(id));
    }

    @GetMapping("inicializar")
    public ResponseEntity<String> inicializar(){
        eventoService.seed();
        return ResponseEntity.ok("Eventos creados correctamente, yuju");
    }
    
    @GetMapping("tipo/{tipo_evento}")
    public ResponseEntity<?> getEventosPorTipo(@PathVariable String tipo_evento){
        List<Evento> filtrados = eventoService.readByTipo(tipo_evento);
        if(filtrados.isEmpty()){
            return ResponseEntity.status(404).body("No se encontraron eventos de ese tipo");
        }
        return ResponseEntity.ok(filtrados);
    }
    
    
    
}
