package com.alura.ForoHub.topicos;

import java.time.LocalDateTime;

public record DatosListaTopicos(

        Long id,
        String tituloTopico,
        String mensaje,
        LocalDateTime fechaDeCreacion,
        String statusNumber,
        String autor,
        TipoDeCurso nombreCurso
) {
    public DatosListaTopicos(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getNombreCurso());
    }
}
