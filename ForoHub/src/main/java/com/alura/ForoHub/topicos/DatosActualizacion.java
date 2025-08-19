package com.alura.ForoHub.topicos;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record DatosActualizacion(
        @NotNull Long id,
        String autor,
        LocalDateTime fechaCreacion
) {
}
