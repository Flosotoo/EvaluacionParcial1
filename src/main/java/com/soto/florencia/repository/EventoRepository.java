package com.soto.florencia.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.soto.florencia.model.Evento;

@Repository
public class EventoRepository {

    private List<Evento> listaEventos = new ArrayList<>();

    public List<Evento> obtenerEvento() {
        return listaEventos;
    }

    public Evento eventoPorId(int id) {
        for (Evento evento : listaEventos) {
            if (id == evento.getId()) {
                return evento;
            }
        }
        return null;
    }

    public Evento agregar(Evento evento) {
        listaEventos.add(evento);
        return evento;
    }

    public Evento modificarEvento(int id, Evento evento) {
        Evento buscado = eventoPorId(id);
        if (buscado != null) {
            buscado.setNombre(evento.getNombre());
            buscado.setDia(evento.getDia());
            buscado.setUbicacion(evento.getUbicacion());
            buscado.setCant_part(evento.getCant_part());
            return buscado;
        }
        return null;
    }

    public String borrar(int id) {
        if (listaEventos.remove(eventoPorId(id))) {
            return "Evento eliminado";
        }
        return "Error al eliminar";
    }

    public void seed() {
        agregar(new Evento(1, "Lollapalooza", "Concierto", 3, "Parque Vicentenario", 1500));

    }

    public List<Evento> buscarPortTipo(String tipo_evento) {
        List<Evento> filtrados = new ArrayList<>();
        for(Evento evento : listaEventos){
            if(evento.getTipo_evento().equalsIgnoreCase(tipo_evento)){
                filtrados.add(evento);
            }
        }
        return filtrados;
    }
}
