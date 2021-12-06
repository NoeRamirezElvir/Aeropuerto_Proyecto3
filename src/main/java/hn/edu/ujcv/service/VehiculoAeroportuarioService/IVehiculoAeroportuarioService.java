package hn.edu.ujcv.service.VehiculoAeroportuarioService;

import hn.edu.ujcv.entity.VehiculoAeroportuario.VehiculoAeroportuario;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;

import java.util.List;

public interface IVehiculoAeroportuarioService {
    VehiculoAeroportuario       saveVehiculo(VehiculoAeroportuario vehiculoAeroportuario)throws BusinessException;
    List<VehiculoAeroportuario> saveVehiculos(List<VehiculoAeroportuario> vehiculoAeroportuarios)throws BusinessException;
    List<VehiculoAeroportuario> getVehiculos()throws BusinessException;
    VehiculoAeroportuario       getVehiculoByID(long id) throws BusinessException, NotFoundException;
    VehiculoAeroportuario       getVehiculoByCodigo(String codigo)throws BusinessException,NotFoundException;
    void                        deleteVehiculo(long id)throws BusinessException,NotFoundException;
    VehiculoAeroportuario       updateVehiculo(VehiculoAeroportuario vehiculoAeroportuario) throws BusinessException,NotFoundException;
}
