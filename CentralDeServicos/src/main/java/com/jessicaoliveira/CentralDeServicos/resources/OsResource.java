package com.jessicaoliveira.CentralDeServicos.resources;

import com.jessicaoliveira.CentralDeServicos.domain.OS;
import com.jessicaoliveira.CentralDeServicos.dtos.OSDTO;
import com.jessicaoliveira.CentralDeServicos.services.OsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/os")
public class OsResource {

    @Autowired
    private OsService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<OSDTO> findById(@PathVariable Integer id){
        OSDTO obj = new OSDTO(service.findById(id));
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<OSDTO>> findAll(){
        List<OSDTO> list = service.findAll().stream().map
                (obj -> new OSDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<OSDTO> create(@Valid @RequestBody OSDTO obj){
        OS newObj = service.create(obj);
        OSDTO newObjDTO = new OSDTO(newObj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObjDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(newObjDTO);
    }

    @PutMapping
    public ResponseEntity<OSDTO> update(@Valid @RequestBody OSDTO obj){
        obj = new OSDTO(service.update(obj));
        return ResponseEntity.ok().body(obj);
    }
}
