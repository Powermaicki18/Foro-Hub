package com.alura.ForoHub.topicos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

public record DatosTopico(
        @NotBlank String mensaje,
        @NotBlank String autor, //creador del topico
        @NotBlank @Email String email,
        @NotNull TipoDeCurso nombreCurso,
        @NotNull @NotBlank String tituloTopico


) {
}
