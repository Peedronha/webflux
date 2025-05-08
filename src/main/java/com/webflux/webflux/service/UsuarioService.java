package com.webflux.webflux.service;

import com.webflux.webflux.dto.UsuarioDTO;
import com.webflux.webflux.entity.UsuarioEntity;
import com.webflux.webflux.exception.BusinessException;
import com.webflux.webflux.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDTO buscarUsuarioPorId(Long id) throws BusinessException {
        var optEntity = usuarioRepository.findById(id);
        if (optEntity.isPresent())
            return new UsuarioDTO(optEntity.get());

        throw new BusinessException(" Usuario nao encontrado");
    }

    public UsuarioDTO salvarUsuario(UsuarioDTO dto) {
        var entity = new UsuarioEntity(dto);
        entity = usuarioRepository.save(entity);
        dto.setId(entity.getId());

        return dto;
    }

    public void deletarUsuario(Long id) throws BusinessException{
        var entity = buscarUsuarioPorId(id);
        usuarioRepository.deleteById(entity.getId());
    }


}
