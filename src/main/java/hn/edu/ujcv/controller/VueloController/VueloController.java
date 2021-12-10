package hn.edu.ujcv.controller.VueloController;

import hn.edu.ujcv.entity.Vuelo.Vuelo;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;
import hn.edu.ujcv.service.VueloService.VueloService;
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
@RequestMapping("/api/v1/vuelos")
public class VueloController {
    @Autowired
    private VueloService service;

    @PostMapping("/addVuelo") //Post es Guardar
    public ResponseEntity<Object> agregarVuelo(@RequestBody Vuelo vuelo){
        try{
            service.saveVuelo(vuelo);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_VUELOS + vuelo.getId());
            return new ResponseEntity(vuelo,responseHeader, HttpStatus.CREATED);
        }catch(Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "La información enviada no es válida.",e.getMessage());
            return new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/addVuelos")
    public ResponseEntity<Any> agregarVuelos(@RequestBody List<Vuelo> vuelos){
        try{
            return new ResponseEntity(service.saveVuelos(vuelos),HttpStatus.CREATED);
        }catch(Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "La información enviada no es válida.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("")//obtener
    public ResponseEntity<List<Vuelo>> buscarVuelos(){
        try{
            return new ResponseEntity(service.getVuelos(),HttpStatus.OK);
        }catch(Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "La lista no es válida.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Vuelo> buscarVueloPorId(@PathVariable long id){
        try{
            return new ResponseEntity(service.getVueloById(id),HttpStatus.OK);
        }catch(BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "El Vuelo no es válido",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(NotFoundException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se encontró el Vuelo.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/destino/{destino}")
    public ResponseEntity<Vuelo> buscarVueloPorDestino(@PathVariable String destino){
        try{
            return new ResponseEntity(service.getVueloByDestino(destino),HttpStatus.OK);
        }catch(BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "El Vuelo no es válido",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(NotFoundException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se encontró el  Vuelo.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("")
    public ResponseEntity<Any> actualizarVuelo(@RequestBody Vuelo vuelo){
        try{
            service.updateVuelo(vuelo);
            return new ResponseEntity(vuelo,HttpStatus.OK);
        }catch(BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "El Vuelo no es válido",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(NotFoundException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se encontró el Vuelo.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Any> eliminarLocal(@PathVariable long id){
        try{
            service.deleteVuelo(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch(BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "El Vuelo no es válido",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(NotFoundException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se encontró el Vuelo.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.NOT_FOUND);
        }
    }
}
