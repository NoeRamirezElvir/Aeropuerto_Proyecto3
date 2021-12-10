package hn.edu.ujcv.controller.LocalComercialController;

import hn.edu.ujcv.entity.LocalComercial.LocalComercial;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;
import hn.edu.ujcv.service.LocalComercialService.LocalComercialService;
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
@RequestMapping("/api/v1/locales")
public class LocalComercialController {
    @Autowired
    private LocalComercialService service;

    @PostMapping("/addLocal") //Post es Guardar
    public ResponseEntity<Object> agregarLocal(@RequestBody LocalComercial local){
        try{
            service.saveLocalComercial(local);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_LOCALESCOMERCIALES + local.getId());
            return new ResponseEntity(local,responseHeader, HttpStatus.CREATED);
        }catch(Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "La información enviada no es válida.",e.getMessage());
            return new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/addLocales")
    public ResponseEntity<Any> agregarLocales(@RequestBody List<LocalComercial> locales){
        try{
            return new ResponseEntity(service.saveLocalesComerciales(locales),HttpStatus.CREATED);
        }catch(Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "La información enviada no es válida.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("")//obtener
    public ResponseEntity<List<LocalComercial>> buscarLocales(){
        try{
            return new ResponseEntity(service.getLocalesComerciales(),HttpStatus.OK);
        }catch(Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "La lista no es válida.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<LocalComercial> buscarLocalPorId(@PathVariable long id){
        try{
            return new ResponseEntity(service.getLocalComercialById(id),HttpStatus.OK);
        }catch(BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "El Local no es válido",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(NotFoundException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se encontró el Local Comercical.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<LocalComercial> buscarLocalPorNombre(@PathVariable String nombre){
        try{
            return new ResponseEntity(service.getLocalComerciaByName(nombre),HttpStatus.OK);
        }catch(BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "El Local no es válido",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(NotFoundException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se encontró el Local Comercial.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("")
    public ResponseEntity<Any> actualizarLocal(@RequestBody LocalComercial local){
        try{
            service.updateLocalComercial(local);
            return new ResponseEntity(local,HttpStatus.OK);
        }catch(BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "El Local no es válido",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(NotFoundException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se encontró el Local Comercial.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Any> eliminarLocal(@PathVariable long id){
        try{
            service.deleteLocalComercial(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch(BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "El Local no es válido",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(NotFoundException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se encontró el Local Comercial.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.NOT_FOUND);
        }
    }
}
