package com.webflux.webflux.controller;


import com.webflux.webflux.dto.UsuarioDTO;
import com.webflux.webflux.exception.BusinessException;
import com.webflux.webflux.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Log Data Controller", description = "Crud para Cadastro do usuario - H2SQL")
public class UsuarioController {

    private final UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.buscarUsuarioPorId(id));
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(path = "/publico/salvar",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> salvarUsuario(@RequestBody UsuarioDTO dto) {
        try {
            return ResponseEntity.ok(service.salvarUsuario(dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id) {
        try {
            service.deletarUsuario(id);
            return ResponseEntity.noContent().build();
        } catch (BusinessException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
