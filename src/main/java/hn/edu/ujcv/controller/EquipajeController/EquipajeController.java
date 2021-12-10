package hn.edu.ujcv.controller.EquipajeController;

import hn.edu.ujcv.entity.Equipaje.Equipaje;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;
import hn.edu.ujcv.service.EquipajeService.EquipajeService;
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
@RequestMapping("/api/v1/equipajes")
public class EquipajeController {
    @Autowired
    private EquipajeService service;

    @PostMapping("/addEquipaje") //Post es Guardar
    public ResponseEntity<Object> agregarEquipaje(@RequestBody Equipaje equipaje){
        try{
            service.saveEquipaje(equipaje);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_EQUIPAJES + equipaje.getId());
            return new ResponseEntity(equipaje,responseHeader, HttpStatus.CREATED);
        }catch(Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "La información enviada no es válida.",e.getMessage());
            return new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/addEquipajes")
    public ResponseEntity<Any> agregarEquipajes(@RequestBody List<Equipaje> equipajes){
        try{
            return new ResponseEntity(service.saveEquipajes(equipajes),HttpStatus.CREATED);
        }catch(Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "La información enviada no es válida.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("")//obtener
    public ResponseEntity<List<Equipaje>> buscarEquipajes(){
        try{
            return new ResponseEntity(service.getEquipajes(),HttpStatus.OK);
        }catch(Exception e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "La lista no es válida.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Equipaje> buscarEquipajePorId(@PathVariable long id){
        try{
            return new ResponseEntity(service.getEquipajeById(id),HttpStatus.OK);
        }catch(BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "El Equipaje no es válido",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(NotFoundException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se encontró el Equipaje.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/pasajero/{pasajero}")
    public ResponseEntity<Equipaje> buscarEquipajePorPasajero(@PathVariable String nombre){
        try{
            return new ResponseEntity(service.getEquipajeByPasajero(nombre),HttpStatus.OK);
        }catch(BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "El Equipaje no es válido",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(NotFoundException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se encontró el Equipaje.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("")
    public ResponseEntity<Any> actualizarEquipaje(@RequestBody Equipaje equipaje){
        try{
            service.updateEquipaje(equipaje);
            return new ResponseEntity(equipaje,HttpStatus.OK);
        }catch(BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "El Equipaje no es válido",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(NotFoundException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se encontró el Equipaje.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Any> eliminarEquipaje(@PathVariable long id){
        try{
            service.deleteEquipaje(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch(BusinessException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "El Equipaje no es válido",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(NotFoundException e){
            RestApiError apiError = new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se encontró el Equipaje.",e.getMessage());
            return new ResponseEntity(apiError,HttpStatus.NOT_FOUND);
        }
    }
}
