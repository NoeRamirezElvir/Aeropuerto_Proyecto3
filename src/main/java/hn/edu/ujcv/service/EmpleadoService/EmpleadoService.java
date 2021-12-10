package hn.edu.ujcv.service.EmpleadoService;

import hn.edu.ujcv.entity.Empleado.Empleado;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;
import hn.edu.ujcv.repository.EmpleadoRepository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements IEmpleadoService{
    @Autowired
    private EmpleadoRepository repository;
    @Override
    public Empleado saveEmpleado(Empleado empleado) throws BusinessException {
        try{
            //Codigo
            if(empleado.getCodigo().isEmpty()){
                throw new BusinessException("El código está vacío.");
            }
            if(empleado.getCodigo().length() < 3){
                throw new BusinessException("El código es muy corto.");
            }
            if(validarCodigo(empleado)){
                throw new BusinessException("El código ya esta en uso.");
            }
            if(empleado.getCodigo().length() > 4){
                throw new BusinessException("El código es muy extenso.");
            }
           //Correo electronico
            if(empleado.getCorreoElectronico().isEmpty()){
                throw new BusinessException("El correo electrónnico está vacío.");
            }
            if(empleado.getCorreoElectronico().length() < 10){
                throw new BusinessException("El correo electrónnico es muy corto.");
            }
            if(empleado.getCorreoElectronico().length() > 50){
                throw new BusinessException("El correo electrónnico es muy extenso.");
            }
            //departamento
            if(empleado.getDepartamento().isEmpty()){
                throw new BusinessException("El departamento está vacío.");
            }
            if(empleado.getDepartamento().length() < 3){
                throw new BusinessException("El departamento es muy corto.");
            }
            if(empleado.getDepartamento().length() > 50){
                throw new BusinessException("El departamentoes muy extenso.");
            }
            //sueldo
            if(String.valueOf(empleado.getSueldo()).isEmpty()){
                throw new BusinessException("El sueldo está vacío.");
            }
            if(empleado.getSueldo() <= 0){
                throw new BusinessException("El sueldo no puede ser menor o igual a 0.");
            }
            if(String.valueOf(empleado.getSueldo()).length() < 3){
                throw new BusinessException("El sueldo es muy corto.");
            }
            if(String.valueOf(empleado.getSueldo()).length() > 12){
                throw new BusinessException("El sueldo es muy extenso.");
            }
            //fecha de ingreso
            if(String.valueOf(empleado.getFechaIngreso()).isEmpty()){
                throw new BusinessException("La fecha está vacía.");
            }
            //Cargo
            if(empleado.getCargo().isEmpty()){
                throw new BusinessException("El cargo está vacío.");
            }
            if(empleado.getCargo().length() < 10){
                throw new BusinessException("El cargo es muy corto.");
            }
            if(empleado.getCargo().length() > 50){
                throw new BusinessException("El cargo es muy extenso.");
            }
            //Horario
            if(empleado.getHorario().isEmpty()){
                throw new BusinessException("El horario está vacío.");
            }
            if(empleado.getHorario().length() < 10){
                throw new BusinessException("El horario es muy corto.");
            }
            if(empleado.getHorario().length() > 15){
                throw new BusinessException("El horario muy extenso.");
            }
            //nombre
            if(empleado.getNombre().isEmpty()){
                throw new BusinessException("El nombre está vacío.");
            }
            if(empleado.getNombre().length() < 3){
                throw new BusinessException("El nombre es muy corto.");
            }
            if(empleado.getNombre().length() > 50){
                throw new BusinessException("El nombre muy extenso.");
            }
            return repository.save(empleado);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Empleado> saveEmpleados(List<Empleado> empleados) throws BusinessException {
        try{
            for (Empleado empleado: empleados) {
                //Codigo
                if(empleado.getCodigo().isEmpty()){
                    throw new BusinessException("El código está vacío.");
                }
                if(empleado.getCodigo().length() < 3){
                    throw new BusinessException("El código es muy corto.");
                }
                if(validarCodigo(empleado)){
                    throw new BusinessException("El código ya esta en uso.");
                }
                if(empleado.getCodigo().length() > 4){
                    throw new BusinessException("El código es muy extenso.");
                }
                //Correo electronico
                if(empleado.getCorreoElectronico().isEmpty()){
                    throw new BusinessException("El correo electrónnico está vacío.");
                }
                if(empleado.getCorreoElectronico().length() < 10){
                    throw new BusinessException("El correo electrónnico es muy corto.");
                }
                if(empleado.getCorreoElectronico().length() > 50){
                    throw new BusinessException("El correo electrónnico es muy extenso.");
                }
                //departamento
                if(empleado.getDepartamento().isEmpty()){
                    throw new BusinessException("El departamento está vacío.");
                }
                if(empleado.getDepartamento().length() < 3){
                    throw new BusinessException("El departamento es muy corto.");
                }
                if(empleado.getDepartamento().length() > 50){
                    throw new BusinessException("El departamentoes muy extenso.");
                }
                //sueldo
                if(String.valueOf(empleado.getSueldo()).isEmpty()){
                    throw new BusinessException("El sueldo está vacío.");
                }
                if(empleado.getSueldo() <= 0){
                    throw new BusinessException("El sueldo es muy corto.");
                }
                if(String.valueOf(empleado.getSueldo()).length() < 3){
                    throw new BusinessException("El sueldo es muy corto.");
                }
                if(String.valueOf(empleado.getSueldo()).length() > 12){
                    throw new BusinessException("El sueldo es muy extenso.");
                }
                //fecha de ingreso
                if(String.valueOf(empleado.getFechaIngreso()).isEmpty()){
                    throw new BusinessException("La fecha está vacía.");
                }
                //Cargo
                if(empleado.getCargo().isEmpty()){
                    throw new BusinessException("El cargo está vacío.");
                }
                if(empleado.getCargo().length() < 10){
                    throw new BusinessException("El cargo es muy corto.");
                }
                if(empleado.getCargo().length() > 50){
                    throw new BusinessException("El cargo es muy extenso.");
                }
                //Horario
                if(empleado.getHorario().isEmpty()){
                    throw new BusinessException("El horario está vacío.");
                }
                if(empleado.getHorario().length() < 10){
                    throw new BusinessException("El horario es muy corto.");
                }
                if(empleado.getHorario().length() > 15){
                    throw new BusinessException("El horario muy extenso.");
                }
                //nombre
                if(empleado.getNombre().isEmpty()){
                    throw new BusinessException("El nombre está vacío.");
                }
                if(empleado.getNombre().length() < 3){
                    throw new BusinessException("El nombre es muy corto.");
                }
                if(empleado.getNombre().length() > 50){
                    throw new BusinessException("El nombre muy extenso.");
                }
            }
            return repository.saveAll(empleados);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Empleado> getEmpleados() throws BusinessException {
        try{
            return repository.findAll();
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Empleado getEmpleadoByID(long id) throws BusinessException, NotFoundException {
        Optional<Empleado> opt = null;
        try{
            opt = repository.findById(id);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el empleado: " + id);
        }
        return opt.get();
    }

    @Override
    public Empleado getEmpleadoByNombre(String nombre) throws BusinessException, NotFoundException {
        Optional<Empleado> opt = null;
        try{
            opt = repository.findByNombre(nombre);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el empleado: " + nombre);
        }
        return opt.get();
    }

    @Override
    public void deleteEmpleado(long id) throws BusinessException, NotFoundException {
        Optional<Empleado> opt = null;
        try{
            opt = repository.findById(id);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el empleado: " + id);
        }else{
            try{
                repository.deleteById(id);
            }catch(Exception e1){
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    @Override
    public Empleado updateEmpleado(Empleado empleado) throws BusinessException, NotFoundException {
        Optional<Empleado> opt = null;
        try{
            opt = repository.findById(empleado.getId());
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el empleado: " + empleado.getId());
        }else{
            try{
                //Codigo
                if(empleado.getCodigo().isEmpty()){
                    throw new BusinessException("El código está vacío.");
                }
                if(empleado.getCodigo().length() < 3){
                    throw new BusinessException("El código es muy corto.");
                }
                if(empleado.getCodigo().length() > 4){
                    throw new BusinessException("El código es muy extenso.");
                }
                //Correo electronico
                if(empleado.getCorreoElectronico().isEmpty()){
                    throw new BusinessException("El correo electrónnico está vacío.");
                }
                if(empleado.getCorreoElectronico().length() < 10){
                    throw new BusinessException("El correo electrónnico es muy corto.");
                }
                if(empleado.getCorreoElectronico().length() > 50){
                    throw new BusinessException("El correo electrónnico es muy extenso.");
                }
                //departamento
                if(empleado.getDepartamento().isEmpty()){
                    throw new BusinessException("El departamento está vacío.");
                }
                if(empleado.getDepartamento().length() < 3){
                    throw new BusinessException("El departamento es muy corto.");
                }
                if(empleado.getDepartamento().length() > 50){
                    throw new BusinessException("El departamentoes muy extenso.");
                }
                //sueldo
                if(String.valueOf(empleado.getSueldo()).isEmpty()){
                    throw new BusinessException("El sueldo está vacío.");
                }
                if(empleado.getSueldo() <= 0){
                    throw new BusinessException("El sueldo es muy corto.");
                }
                if(String.valueOf(empleado.getSueldo()).length() < 3){
                    throw new BusinessException("El sueldo es muy corto.");
                }
                if(String.valueOf(empleado.getSueldo()).length() > 12){
                    throw new BusinessException("El sueldo es muy extenso.");
                }
                //fecha de ingreso
                if(String.valueOf(empleado.getFechaIngreso()).isEmpty()){
                    throw new BusinessException("La fecha está vacía.");
                }
                //Cargo
                if(empleado.getCargo().isEmpty()){
                    throw new BusinessException("El cargo está vacío.");
                }
                if(empleado.getCargo().length() < 10){
                    throw new BusinessException("El cargo es muy corto.");
                }
                if(empleado.getCargo().length() > 50){
                    throw new BusinessException("El cargo es muy extenso.");
                }
                //Horario
                if(empleado.getHorario().isEmpty()){
                    throw new BusinessException("El horario está vacío.");
                }
                if(empleado.getHorario().length() < 10){
                    throw new BusinessException("El horario es muy corto.");
                }
                if(empleado.getHorario().length() > 15){
                    throw new BusinessException("El horario muy extenso.");
                }
                //nombre
                if(empleado.getNombre().isEmpty()){
                    throw new BusinessException("El nombre está vacío.");
                }
                if(empleado.getNombre().length() < 3){
                    throw new BusinessException("El nombre es muy corto.");
                }
                if(empleado.getNombre().length() > 50){
                    throw new BusinessException("El nombre muy extenso.");
                }
                Empleado existingEmpleado = new Empleado();
                existingEmpleado.setId(empleado.getId());
                existingEmpleado.setCodigo(empleado.getCodigo());
                existingEmpleado.setCorreoElectronico(empleado.getCorreoElectronico());
                existingEmpleado.setDepartamento(empleado.getDepartamento());
                existingEmpleado.setSueldo(empleado.getSueldo());
                existingEmpleado.setFechaIngreso(empleado.getFechaIngreso());
                existingEmpleado.setCargo(empleado.getCargo());
                existingEmpleado.setHorario(empleado.getHorario());
                existingEmpleado.setNombre(empleado.getNombre());
                return repository.save(existingEmpleado);
            }catch(Exception e1){
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    private boolean validarCodigo(Empleado empleado) throws BusinessException{
        boolean condicion = false;
        try{
            List<Empleado> listaEmpleados = getEmpleados();
            for (Empleado empleados: listaEmpleados) {
                if(empleados.getCodigo() == empleado.getCodigo()){
                    condicion = true;
                }
            }
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }
        return condicion;
    }

}
