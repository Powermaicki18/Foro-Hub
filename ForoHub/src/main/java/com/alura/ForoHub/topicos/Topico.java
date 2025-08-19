package com.alura.ForoHub.topicos;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Table(name = "topicos" )
@Entity(name = "Topico")

@Getter //obtener datos facil
@Setter
@NoArgsConstructor //constructor sin argumentos
@AllArgsConstructor //constructor con argumentos
@EqualsAndHashCode(of = "id") //identificar que 2 objetos son iguales si el id es el mismo

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean activo;
    private String titulo;
    private String mensaje;
    private String email;
    private String autor;

    private String status;
    @CreationTimestamp
    private LocalDateTime fechaCreacion;


    @Enumerated(EnumType.STRING)
    private TipoDeCurso nombreCurso;

    public Topico(DatosTopico datos) {

        this.id = null;
        this.activo = true;
        this.autor = datos.autor();
        this.titulo = datos.tituloTopico();
        this.mensaje = datos.mensaje();
        this.nombreCurso = datos.nombreCurso();
        this.email = datos.email();
        this.fechaCreacion = LocalDateTime.now();
    }


    public void actualizarInfo(@Valid DatosTopico datos) {
        if (datos.autor() != null) {
            this.autor = datos.autor();
        }
    }

    public void eliminarInfo() {
        this.activo = false;
    }
}
