package hn.edu.ujcv.controller.UsuarioController;

import hn.edu.ujcv.entity.Usuario.Usuario;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;
import hn.edu.ujcv.service.UsuarioService.UsuarioService;
import hn.edu.ujcv.utils.Constants;
import hn.edu.ujcv.utils.RestApiError;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @PostMapping("/addUsuario") //Post es Guardar
    public ResponseEntity<Object> agregarUsuario(@RequestBody Usuario usuario){
        try{
            service.saveUsuario(usuario);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_USUARIOS + usuario.getId());
            return new ResponseEntity(usuario,responseHeader, HttpStatus.CREATED);
        }catch(Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "La Información enviada no es válida.",e.getMessage());
            return new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/addUsuarios")
    public ResponseEntity<Any> agregarUsuarios(@RequestBody List<Usuario> usuarios){
        try{
            return new ResponseEntity(service.saveUsuarios(usuarios),HttpStatus.CREATED);
        }catch(Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "La Información enviada no es válida.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("")//obtener
    public ResponseEntity<List<Usuario>> buscarUsuarios(){
        try{
            return new ResponseEntity(service.getUsuarios(),HttpStatus.OK);
        }catch(Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "La lista no es válida.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable long id){
        try{
            return new ResponseEntity(service.getUsuarioById(id),HttpStatus.OK);
        }catch(BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "El Usuario no es válido",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(NotFoundException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se encontró el Usuario.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Usuario> buscarUsuarioPorNombre(@PathVariable String name){
        try{
            return new ResponseEntity(service.getUsuarioByName(name),HttpStatus.OK);
        }catch(BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "El Usuario no es válido",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(NotFoundException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se encontró el  Usuario.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("")
    public ResponseEntity<Any> actualizarUsuario(@RequestBody Usuario usuario){
        try{
            service.updateUsuario(usuario);
            return new ResponseEntity(usuario,HttpStatus.OK);
        }catch(BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "El Usuario no es válido",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(NotFoundException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se encontró el Usuario.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Any> eliminarUsuario(@PathVariable long id){
        try{
            service.deleteUsuario(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch(BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "El Usuario no es válido",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(NotFoundException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se encontró el Usuario.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.NOT_FOUND);
        }
    }
}
