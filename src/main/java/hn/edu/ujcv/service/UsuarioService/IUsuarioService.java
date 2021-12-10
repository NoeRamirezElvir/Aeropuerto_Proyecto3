package hn.edu.ujcv.service.UsuarioService;

import hn.edu.ujcv.entity.Usuario.Usuario;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;

import java.util.List;

public interface IUsuarioService {
    Usuario       saveUsuario(Usuario usuario)throws BusinessException;
    List<Usuario> saveUsuarios(List<Usuario> usuarioList)throws BusinessException;
    List<Usuario> getUsuarios()throws BusinessException;
    Usuario       getUsuarioById(long id)throws BusinessException, NotFoundException;
    Usuario       getUsuarioByNombre(String name)throws BusinessException,NotFoundException;
    void          deleteUsuario(long id)throws BusinessException, NotFoundException;
    Usuario       updateUsuario(Usuario usuario)throws BusinessException,NotFoundException;
}
