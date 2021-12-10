package hn.edu.ujcv.service.EquipajeService;

import hn.edu.ujcv.entity.Equipaje.Equipaje;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;

import java.util.List;

public interface IEquipajeService {
    Equipaje       saveEquipaje(Equipaje equipaje)throws BusinessException;
    List<Equipaje> saveEquipajes(List<Equipaje> aerolineas)throws BusinessException;
    List<Equipaje> getEquipajes()throws BusinessException;
    Equipaje       getEquipajeById(long id)throws BusinessException, NotFoundException;
    Equipaje       getEquipajeByPasajero(String name)throws BusinessException,NotFoundException;
    void           deleteEquipaje(long id)throws BusinessException, NotFoundException;
    Equipaje       updateEquipaje(Equipaje equipaje)throws BusinessException,NotFoundException;
}
