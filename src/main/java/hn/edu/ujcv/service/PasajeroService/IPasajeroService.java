package hn.edu.ujcv.service.PasajeroService;

import hn.edu.ujcv.entity.Pasajero.Pasajero;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;

import java.util.List;

public interface IPasajeroService {
    Pasajero savePasajero(Pasajero pasajero)throws BusinessException;
    List<Pasajero> savePasajeros(List<Pasajero> pasajeros)throws BusinessException;
    List<Pasajero> getPasajeros()throws BusinessException;
    Pasajero       getPasajeroByID(long id) throws BusinessException, NotFoundException;
    Pasajero       getPasajeroByNombre(String nombre)throws BusinessException,NotFoundException;
    void         deletePasajero(long id)throws BusinessException,NotFoundException;
    Pasajero       updatePasajero(Pasajero pasajero) throws BusinessException,NotFoundException;
}
