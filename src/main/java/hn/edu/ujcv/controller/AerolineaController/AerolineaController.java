package hn.edu.ujcv.controller.AerolineaController;

import hn.edu.ujcv.entity.Aerolinea.Aerolinea;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;
import hn.edu.ujcv.service.AerolineaService.AerolineaService;
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
@RequestMapping("/api/v1/aerolineas")
public class AerolineaController {
    @Autowired
    private AerolineaService service;

    @PostMapping("/addAerolinea") //Post es Guardar
    public ResponseEntity<Object> agregarAerolinea(@RequestBody Aerolinea aerolinea){
        try{
            service.saveAerolinea(aerolinea);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_AEROLINEAS + aerolinea.getId());
            return new ResponseEntity(aerolinea,responseHeader, HttpStatus.CREATED);
        }catch(Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "La información enviada no es válida.",e.getMessage());
            return new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/addAerolineas")
    public ResponseEntity<Any> agregarAerolineas(@RequestBody List<Aerolinea> aerolineas){
        try{
            return new ResponseEntity(service.saveAerolineas(aerolineas),HttpStatus.CREATED);
        }catch(Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "La información enviada no es válida.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("")//obtener
    public ResponseEntity<List<Aerolinea>> buscarAerolineas(){
        try{
            return new ResponseEntity(service.getAerolineas(),HttpStatus.OK);
        }catch(Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "La lista no es válida.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Aerolinea> buscarAerolineaPorId(@PathVariable long id){
        try{
            return new ResponseEntity(service.getAerolineaById(id),HttpStatus.OK);
        }catch(BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "la Aerolínea no es válida",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(NotFoundException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se encontró la Aerolínea.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Aerolinea> buscarAerolineaPorNombre(@PathVariable String nombre){
        try{
            return new ResponseEntity(service.getAerolineaByNombre(nombre),HttpStatus.OK);
        }catch(BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "la Aerolínea no es válida",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(NotFoundException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se encontró la Aerolínea.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("")
    public ResponseEntity<Any> actualizarAerolinea(@RequestBody Aerolinea aerolinea){
        try{
            service.updateAerolinea(aerolinea);
            return new ResponseEntity(aerolinea,HttpStatus.OK);
        }catch(BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "la Aerolínea no es válida",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(NotFoundException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se encontró la Aerolínea.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Any> eliminarAerolinea(@PathVariable long id){
        try{
            service.deleteAerolinea(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch(BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "la Aerolínea no es válida",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(NotFoundException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se encontró la Aerolínea.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.NOT_FOUND);
        }
    }
}
