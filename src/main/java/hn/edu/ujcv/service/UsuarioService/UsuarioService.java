package hn.edu.ujcv.service.UsuarioService;

import hn.edu.ujcv.entity.Usuario.Usuario;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;
import hn.edu.ujcv.repository.UsuarioRepository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService{
    @Autowired
    private UsuarioRepository repository;
    @Override
    public Usuario saveUsuario(Usuario usuario) throws BusinessException {
        try{
            if (usuario.getEmpleado().isEmpty()){
                throw new BusinessException("Empleado esta vacio");
            }
            //usuario
            if (usuario.getUsuario().isEmpty()) {
                throw new BusinessException("Nombre de Usuario esta vacio");
            }
            if (usuario.getUsuario().length() < 3) {
                throw new BusinessException("El Nombre de Usuario tiene que tener mas de 3 caracteres");
            }
            if (usuario.getUsuario().length() > 25) {
                throw new BusinessException("Ingrese un Nombre de Usuario con menos de 25 caracteres");
            }
            if (validarUser(usuario)){
                throw new BusinessException("Nombre de Usuario ya Registrado!");
            }
            //contraseña
            if (usuario.getContraseña().isEmpty()){
                throw new BusinessException("Contraseña esta vacia");
            }
            if (usuario.getContraseña().length() < 8){
                throw new BusinessException("Ingrese una contraseña con mas de 7 caracteres");
            }
            if (usuario.getContraseña().length() > 15){
                throw new BusinessException("Contraseña muy extensa Ingrese menos de 15 caracteres");
            }
            return repository.save(usuario);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Usuario> saveUsuarios(List<Usuario> usuarioList) throws BusinessException {
        try{
            for (Usuario usuario:usuarioList) {
                if (usuario.getEmpleado().isEmpty()){
                    throw new BusinessException("Empleado esta vacio");
                }
                //usuario
                if (usuario.getUsuario().isEmpty()) {
                    throw new BusinessException("Nombre de Usuario esta vacio");
                }
                if (usuario.getUsuario().length() < 15) {
                    throw new BusinessException("Ingrese un Nombre de Usuario con mas de 14 caracteres");
                }
                if (usuario.getUsuario().length() > 25) {
                    throw new BusinessException("Ingrese un Nombre de Usuario con menos de 25 caracteres");
                }
                //contraseña
                if (usuario.getContraseña().isEmpty()) {
                    throw new BusinessException("Contraseña esta vacia");
                }
                if (usuario.getContraseña().length() < 8) {
                    throw new BusinessException("Ingrese una contraseña con mas de 7 caracteres");
                }
                if (usuario.getContraseña().length() > 15) {
                    throw new BusinessException("Contraseña muy extensa Ingrese menos de 15 caracteres");
                }
            }
            return repository.saveAll(usuarioList);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Usuario> getUsuarios() throws BusinessException {
        try{
            return repository.findAll();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Usuario getUsuarioById(long id) throws BusinessException, NotFoundException {
        Optional<Usuario> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if(!opt.isPresent()){
            throw new NotFoundException("No se encontro el Usuario: " + id);
        }
        return opt.get();
    }

    @Override
    public Usuario getUsuarioByUsuario(String usuario) throws BusinessException, NotFoundException {
        Optional<Usuario> opt = null;
        try{
            opt = repository.findByUsuario(usuario);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if(!opt.isPresent()){
            throw new NotFoundException("No se encontro el Usuario: " + usuario);
        }
        return opt.get();
    }

    @Override
    public void deleteUsuario(long id) throws BusinessException, NotFoundException {
        Optional<Usuario> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if(!opt.isPresent()){
            throw new NotFoundException("No se encontro el Usuario: " + id);
        } else {
            try{
                repository.deleteById(id);
            }catch (Exception e1){
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) throws BusinessException, NotFoundException {
        Optional<Usuario> opt = null;
        try{
            if (String.valueOf(usuario.getId()).isEmpty()) {
                throw new BusinessException("ID del Usuario viene vacio");
            }
            opt = repository.findById(usuario.getId());
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if(!opt.isPresent()){
            throw new NotFoundException("No se encontro el Usuario: " + usuario.getId());
        } else {
            try{
                if (usuario.getEmpleado().isEmpty()){
                    throw new BusinessException("Empleado esta vacio");
                }
                //usuario
                if (usuario.getUsuario().isEmpty()) {
                    throw new BusinessException("Nombre de Usuario esta vacio");
                }
                if (usuario.getUsuario().length() < 3) {
                    throw new BusinessException("El Nombre de Usuario tiene que tener mas de 3 caracteres");
                }
                if (usuario.getUsuario().length() > 25) {
                    throw new BusinessException("Ingrese un Nombre de Usuario con menos de 25 caracteres");
                }
                //contraseña
                if (usuario.getContraseña().isEmpty()){
                    throw new BusinessException("Contraseña esta vacia");
                }
                if (usuario.getContraseña().length() < 8){
                    throw new BusinessException("Ingrese una contraseña con mas de 7 caracteres");
                }
                if (usuario.getContraseña().length() > 15){
                    throw new BusinessException("Contraseña muy extensa Ingrese menos de 15 caracteres");
                }
                Usuario usuarioEx = new Usuario();
                usuarioEx.setId(usuario.getId());
                usuarioEx.setEmpleado(usuario.getEmpleado());
                usuarioEx.setUsuario(usuario.getUsuario());
                usuarioEx.setContraseña(usuario.getContraseña());
                return repository.save(usuarioEx);
            }catch (Exception e1){
                throw new BusinessException(e1.getMessage());
            }
        }
    }
    public boolean validarUser(Usuario usuario) throws BusinessException{
        boolean condicion = false;
        try{
            for (Usuario usuario1:getUsuarios()) {
                if (usuario.getUsuario().equals(usuario1.getUsuario())){
                    condicion = true;
                }
            }
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        return condicion;
    }
}