package hn.edu.ujcv.service.EmpleadoService;

import hn.edu.ujcv.entity.Empleado.Empleado;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;

import java.util.List;

public interface IEmpleadoService {
    Empleado       saveEmpleado(Empleado empleado)throws BusinessException;
    List<Empleado> saveEmpleados(List<Empleado> empleados)throws BusinessException;
    List<Empleado> getEmpleados()throws BusinessException;
    Empleado       getEmpleadoByID(long id)throws BusinessException, NotFoundException;
    Empleado       getEmpleadoByNombre(String nombre)throws BusinessException,NotFoundException;
    void           deleteEmpleado(long id)throws BusinessException,NotFoundException;
    Empleado       updateEmpleado(Empleado empleado)throws BusinessException,NotFoundException;
}
