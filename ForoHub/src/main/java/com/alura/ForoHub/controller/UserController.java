package com.alura.ForoHub.controller;

import com.alura.ForoHub.topicos.DatosListaTopicos;
import com.alura.ForoHub.topicos.DatosTopico;
import com.alura.ForoHub.topicos.ITopcioRepository;
import com.alura.ForoHub.topicos.Topico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/topico")
public class UserController {

    @Autowired
    private ITopcioRepository repository;

    @Transactional
    @PostMapping
    public void register(@RequestBody @Valid DatosTopico datos) {
        repository.save(new Topico(datos));
        System.out.println(datos);
    }

    @GetMapping
    public Page<DatosListaTopicos> obtenerTopicos(@PageableDefault(size = 10, page = 0, sort = {"nombreCurso"})Pageable paginacion) {
        return repository.findAllByActivoTrue(paginacion)
                .map(DatosListaTopicos::new);
    }

    @Transactional
    @PutMapping("/{id}")
    public void actualizar(@PathVariable Long id, @RequestBody @Valid DatosTopico datos){

        var topico = repository.getReferenceById(id);
        topico.actualizarInfo(datos);

    }

    @Transactional
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
       // repository.deleteById(id);
        var topico = repository.getReferenceById(id);
        topico.eliminarInfo();
    }

}
