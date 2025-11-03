package edu.com.community.inventory.management.infrastructure.input.rest.controllers;

import edu.com.community.inventory.management.application.input.IGenericServicePort;
import edu.com.community.inventory.management.infrastructure.input.rest.mappers.IGenericRestMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class IGenericController<DTO, ID, REQUEST, RESPONSE> {
    protected final IGenericServicePort<DTO, ID> servicePort;
    protected final IGenericRestMapper<REQUEST, RESPONSE, DTO> mapper;

    public IGenericController(IGenericServicePort<DTO, ID> servicePort, IGenericRestMapper<REQUEST, RESPONSE, DTO> mapper) {
        this.servicePort = servicePort;
        this.mapper = mapper;
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RESPONSE> findById(@RequestParam("id")
                                             @NotNull(message = "campo id es requerido") ID id) {
        RESPONSE response = this.servicePort.findById(id)
                .map(this.mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Objeto con id %s no encontrado".formatted(id)));
        return ResponseEntity.ok(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RESPONSE> create(@RequestBody @Valid REQUEST request) {
        RESPONSE dtoCreated = this.mapper.toResponse(
                this.servicePort.create(this.mapper.toDto(request)));
        return ResponseEntity.ok(dtoCreated);
    }

    @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RESPONSE> update(@RequestParam("id")
                                           @NotNull(message = "campo id es requerido")
                                           @Valid ID id,
                                           @RequestBody @Valid REQUEST request) {
        RESPONSE ingredientUpdated = this.mapper.toResponse(
                this.servicePort.update(id, this.mapper.toDto(request)));
        return ResponseEntity.ok(ingredientUpdated);
    }

}
