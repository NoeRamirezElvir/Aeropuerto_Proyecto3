package hn.edu.ujcv.service.VehiculoAeroportuarioService;


import hn.edu.ujcv.entity.VehiculoAeroportuario.VehiculoAeroportuario;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;
import hn.edu.ujcv.repository.VehiculoAeroportuarioRepository.VehiculoAeroportuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoAeroportuarioService implements IVehiculoAeroportuarioService{
    @Autowired
    private VehiculoAeroportuarioRepository repository;

    @Override
    public VehiculoAeroportuario saveVehiculo(VehiculoAeroportuario vehiculoAeroportuario) throws BusinessException {
        try{
            //codigo
            if(vehiculoAeroportuario.getCodigo().isEmpty()){
               throw new BusinessException("El código está vacío.");
           }
           if(vehiculoAeroportuario.getCodigo().length() < 3){
               throw new BusinessException("Ingrese más de 3 caracteres en el código.");
           }
           if(validarCodigo(vehiculoAeroportuario)){
               throw new BusinessException("El código ya está en uso.");
           }
           if(vehiculoAeroportuario.getCodigo().length() > 10){
               throw new BusinessException("El código no puede tener más de 10 caracteres.");
           }
            //numeroPlaca
            if(vehiculoAeroportuario.getNumeroPlaca().isEmpty()){
                throw new BusinessException("El número de placa está vacío.");
            }
            if(validarNumPlaca(vehiculoAeroportuario)){
                throw new BusinessException("El número de placa ya está registrado.");
            }
            if(vehiculoAeroportuario.getNumeroPlaca().length() < 3){
                throw new BusinessException("Ingrese más de 3 caracteres en el número de placa.");
            }
            if(vehiculoAeroportuario.getNumeroPlaca().length() > 10){
                throw new BusinessException("El número de placa no puede tener más de 10 caracteres.");
            }
            //tipo
            if (vehiculoAeroportuario.getTipo().isEmpty()) {
                throw new BusinessException("El tipo está vacío.");
            }
            if (vehiculoAeroportuario.getTipo().length() < 3) {
                throw new BusinessException("Ingrese más de 1 caracteres en el tipo.");
            }
            if (vehiculoAeroportuario.getTipo().length() > 50) {
                throw new BusinessException("El tipo no puede tener más de 50 caracteres.");
            }
            //descripcion
            if (vehiculoAeroportuario.getDescripcion().isEmpty()) {
                throw new BusinessException("La descripción está vacía.");
            }
            if (vehiculoAeroportuario.getDescripcion().length() < 3) {
                throw new BusinessException("Ingrese más de 3 caracteres en la descripción.");
            }
            if (vehiculoAeroportuario.getDescripcion().length() > 50) {
                throw new BusinessException("La descripción no puede tener más de 50 caracteres.");
            }
            //estado
            if (vehiculoAeroportuario.getEstado().isEmpty()) {
                throw new BusinessException("El estado está vacío.");
            }
            if (vehiculoAeroportuario.getEstado().length() < 3) {
                throw new BusinessException("Ingrese más de 3 caracteres en el estado.");
            }
            if (vehiculoAeroportuario.getEstado().length() > 50) {
                throw new BusinessException("El estado no puede tener más de 50 caracteres.");
            }
            //tipoCombustible
            if (vehiculoAeroportuario.getTipoCombustible().isEmpty()) {
                throw new BusinessException("El tipo de combustible está vacío.");
            }
            if (vehiculoAeroportuario.getTipoCombustible().length() < 3) {
                throw new BusinessException("Ingrese más de 3 caracteres en el tipo de combustible.");
            }
            if (vehiculoAeroportuario.getTipoCombustible().length() > 50) {
                throw new BusinessException("El tipo de combustible no puede tener más de 50 caracteres.");
            }
            //capacidad
            if(String.valueOf(vehiculoAeroportuario.getCapacidad()).isEmpty()){
                throw new BusinessException("La capacidad está vacía.");
            }
            if(vehiculoAeroportuario.getCapacidad() <= 0){
                throw new BusinessException("La capacidad no puede ser menor o igual a 0.");
            }
            if(vehiculoAeroportuario.getCapacidad() > 150){
                throw new BusinessException("La capacidad no puede ser mayor a 150.");
            }
            if((String.valueOf(vehiculoAeroportuario.getCapacidad()).length())>4){
                throw new BusinessException("La capacidad excede el límite.");
            }
            return repository.save(vehiculoAeroportuario);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<VehiculoAeroportuario> saveVehiculos(List<VehiculoAeroportuario> vehiculoAeroportuarios) throws BusinessException {
        try{
            for (VehiculoAeroportuario vehiculoAeroportuario: vehiculoAeroportuarios) {
                //codigo
                if(vehiculoAeroportuario.getCodigo().isEmpty()){
                    throw new BusinessException("El código está vacío.");
                }
                if(vehiculoAeroportuario.getCodigo().length() < 3){
                    throw new BusinessException("Ingrese más de 3 caracteres en el código.");
                }
                if(validarCodigo(vehiculoAeroportuario)){
                    throw new BusinessException("El código ya está en uso.");
                }
                if(vehiculoAeroportuario.getCodigo().length() > 10){
                    throw new BusinessException("El código no puede tener más de 10 caracteres.");
                }
                //numeroPlaca
                if(vehiculoAeroportuario.getNumeroPlaca().isEmpty()){
                    throw new BusinessException("El número de placa está vacío.");
                }
                if(validarNumPlaca(vehiculoAeroportuario)){
                    throw new BusinessException("El número de placa ya está registrado.");
                }
                if(vehiculoAeroportuario.getNumeroPlaca().length() < 3){
                    throw new BusinessException("Ingrese más de 3 caracteres en el número de placa.");
                }
                if(vehiculoAeroportuario.getNumeroPlaca().length() > 10){
                    throw new BusinessException("El número de placa no puede tener más de 10 caracteres.");
                }
                //tipo
                if (vehiculoAeroportuario.getTipo().isEmpty()) {
                    throw new BusinessException("El tipo está vacío.");
                }
                if (vehiculoAeroportuario.getTipo().length() < 3) {
                    throw new BusinessException("Ingrese más de 1 caracteres en el tipo.");
                }
                if (vehiculoAeroportuario.getTipo().length() > 50) {
                    throw new BusinessException("El tipo no puede tener más de 50 caracteres.");
                }
                //descripcion
                if (vehiculoAeroportuario.getDescripcion().isEmpty()) {
                    throw new BusinessException("La descripción está vacía.");
                }
                if (vehiculoAeroportuario.getDescripcion().length() < 3) {
                    throw new BusinessException("Ingrese más de 3 caracteres en la descripción.");
                }
                if (vehiculoAeroportuario.getDescripcion().length() > 50) {
                    throw new BusinessException("La descripción no puede tener más de 50 caracteres.");
                }
                //estado
                if (vehiculoAeroportuario.getEstado().isEmpty()) {
                    throw new BusinessException("El estado está vacío.");
                }
                if (vehiculoAeroportuario.getEstado().length() < 3) {
                    throw new BusinessException("Ingrese más de 3 caracteres en el estado.");
                }
                if (vehiculoAeroportuario.getEstado().length() > 50) {
                    throw new BusinessException("El estado no puede tener más de 50 caracteres.");
                }
                //tipoCombustible
                if (vehiculoAeroportuario.getTipoCombustible().isEmpty()) {
                    throw new BusinessException("El tipo de combustible está vacío.");
                }
                if (vehiculoAeroportuario.getTipoCombustible().length() < 3) {
                    throw new BusinessException("Ingrese más de 3 caracteres en el tipo de combustible.");
                }
                if (vehiculoAeroportuario.getTipoCombustible().length() > 50) {
                    throw new BusinessException("El tipo de combustible no puede tener más de 50 caracteres.");
                }
                //capacidad
                if(String.valueOf(vehiculoAeroportuario.getCapacidad()).isEmpty()){
                    throw new BusinessException("La capacidad está vacía.");
                }
                if(vehiculoAeroportuario.getCapacidad() <= 0){
                    throw new BusinessException("La capacidad no puede ser menor o igual a 0.");
                }
                if(vehiculoAeroportuario.getCapacidad() > 150){
                    throw new BusinessException("La capacidad no puede ser mayor a 150.");
                }
                if((String.valueOf(vehiculoAeroportuario.getCapacidad()).length())>4){
                    throw new BusinessException("La capacidad excede el límite.");
                }
            }
            return repository.saveAll(vehiculoAeroportuarios);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<VehiculoAeroportuario> getVehiculos() throws BusinessException {
        try{
            return repository.findAll();
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public VehiculoAeroportuario getVehiculoByID(long id) throws BusinessException, NotFoundException {
        Optional<VehiculoAeroportuario> opt = null;
        try{
            opt = repository.findById(id);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el vehículo: " + id);
        }
        return opt.get();
    }

    @Override
    public VehiculoAeroportuario getVehiculoByCodigo(String codigo) throws BusinessException, NotFoundException {
        Optional<VehiculoAeroportuario> opt = null;
        try{
            opt = repository.findByCodigo(codigo);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el vehículo: " + codigo);
        }
        return opt.get();
    }

    @Override
    public void deleteVehiculo(long id) throws BusinessException, NotFoundException {
        Optional<VehiculoAeroportuario> opt = null;
        try{
            opt = repository.findById(id);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el vehículo: " + id);
        }else{
            try {
                repository.deleteById(id);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }

    }

    @Override
    public VehiculoAeroportuario updateVehiculo(VehiculoAeroportuario vehiculoAeroportuario) throws BusinessException, NotFoundException {
        Optional<VehiculoAeroportuario> opt = null;
        try{
            opt = repository.findById(vehiculoAeroportuario.getId());
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el vehículo: " + vehiculoAeroportuario.getId());
        }else{
            try {
                //codigo
                if(vehiculoAeroportuario.getCodigo().isEmpty()){
                    throw new BusinessException("El código está vacío.");
                }
                if(vehiculoAeroportuario.getCodigo().length() < 3){
                    throw new BusinessException("Ingrese más de 3 caracteres en el código.");
                }
                if(vehiculoAeroportuario.getCodigo().length() > 10){
                    throw new BusinessException("El código no puede tener más de 10 caracteres.");
                }
                //numeroPlaca
                if(vehiculoAeroportuario.getNumeroPlaca().isEmpty()){
                    throw new BusinessException("El número de placa está vacío.");
                }
                if(vehiculoAeroportuario.getNumeroPlaca().length() < 3){
                    throw new BusinessException("Ingrese más de 3 caracteres en el número de placa.");
                }
                if(vehiculoAeroportuario.getNumeroPlaca().length() > 10){
                    throw new BusinessException("El número de placa no puede tener más de 10 caracteres.");
                }
                //tipo
                if (vehiculoAeroportuario.getTipo().isEmpty()) {
                    throw new BusinessException("El tipo está vacío.");
                }
                if (vehiculoAeroportuario.getTipo().length() < 3) {
                    throw new BusinessException("Ingrese más de 1 caracteres en el tipo.");
                }
                if (vehiculoAeroportuario.getTipo().length() > 50) {
                    throw new BusinessException("El tipo no puede tener más de 50 caracteres.");
                }
                //descripcion
                if (vehiculoAeroportuario.getDescripcion().isEmpty()) {
                    throw new BusinessException("La descripción está vacía.");
                }
                if (vehiculoAeroportuario.getDescripcion().length() < 3) {
                    throw new BusinessException("Ingrese más de 3 caracteres en la descripción.");
                }
                if (vehiculoAeroportuario.getDescripcion().length() > 50) {
                    throw new BusinessException("La descripción no puede tener más de 50 caracteres.");
                }
                //estado
                if (vehiculoAeroportuario.getEstado().isEmpty()) {
                    throw new BusinessException("El estado está vacío.");
                }
                if (vehiculoAeroportuario.getEstado().length() < 3) {
                    throw new BusinessException("Ingrese más de 3 caracteres en el estado.");
                }
                if (vehiculoAeroportuario.getEstado().length() > 50) {
                    throw new BusinessException("El estado no puede tener más de 50 caracteres.");
                }
                //tipoCombustible
                if (vehiculoAeroportuario.getTipoCombustible().isEmpty()) {
                    throw new BusinessException("El tipo de combustible está vacío.");
                }
                if (vehiculoAeroportuario.getTipoCombustible().length() < 3) {
                    throw new BusinessException("Ingrese más de 3 caracteres en el tipo de combustible.");
                }
                if (vehiculoAeroportuario.getTipoCombustible().length() > 50) {
                    throw new BusinessException("El tipo de combustible no puede tener más de 50 caracteres.");
                }
                //capacidad
                if(String.valueOf(vehiculoAeroportuario.getCapacidad()).isEmpty()){
                    throw new BusinessException("La capacidad está vacía.");
                }
                if(vehiculoAeroportuario.getCapacidad() <= 0){
                    throw new BusinessException("La capacidad no puede ser menor o igual a 0.");
                }
                if(vehiculoAeroportuario.getCapacidad() > 150){
                    throw new BusinessException("La capacidad no puede ser mayor a 150.");
                }
                if((String.valueOf(vehiculoAeroportuario.getCapacidad()).length())>4){
                    throw new BusinessException("La capacidad excede el límite.");
                }

                VehiculoAeroportuario existingVehiculo = new VehiculoAeroportuario();
                existingVehiculo.setId(vehiculoAeroportuario.getId());
                existingVehiculo.setCodigo(vehiculoAeroportuario.getCodigo());
                existingVehiculo.setNumeroPlaca(vehiculoAeroportuario.getNumeroPlaca());
                existingVehiculo.setTipo(vehiculoAeroportuario.getTipo());
                existingVehiculo.setDescripcion(vehiculoAeroportuario.getDescripcion());
                existingVehiculo.setEstado(vehiculoAeroportuario.getEstado());
                existingVehiculo.setTipoCombustible(vehiculoAeroportuario.getTipoCombustible());
                existingVehiculo.setCapacidad(vehiculoAeroportuario.getCapacidad());

                return repository.save(existingVehiculo);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    private boolean validarCodigo(VehiculoAeroportuario vehiculo) throws BusinessException{
        boolean condicion = false;
        try{
            List<VehiculoAeroportuario> listaVehiculos = repository.findAll();
            for (VehiculoAeroportuario vehiculos: listaVehiculos) {
                if (vehiculo.getCodigo().equals(vehiculos.getCodigo())) {
                    condicion = true;
                    break;
                }
            }
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }
        return condicion;
    }
    private boolean validarNumPlaca(VehiculoAeroportuario vehiculo) throws BusinessException{
        boolean condicion = false;
        try{
            List<VehiculoAeroportuario> listaVehiculos = repository.findAll();
            for (VehiculoAeroportuario vehiculos: listaVehiculos) {
                if (vehiculo.getNumeroPlaca().equals(vehiculos.getNumeroPlaca())) {
                    condicion = true;
                    break;
                }
            }
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }
        return condicion;
    }
}
