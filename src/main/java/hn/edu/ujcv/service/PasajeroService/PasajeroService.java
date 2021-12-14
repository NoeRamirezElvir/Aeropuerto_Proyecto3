package hn.edu.ujcv.service.PasajeroService;

import hn.edu.ujcv.entity.Pasajero.Pasajero;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;
import hn.edu.ujcv.repository.PasajeroRepository.PasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PasajeroService implements IPasajeroService{
    @Autowired
    private PasajeroRepository repository;
    @Override
    public Pasajero savePasajero(Pasajero pasajero) throws BusinessException {
        try{
            //codigo
            if(pasajero.getCodigo().isEmpty()){
               throw new BusinessException("El código está vacío.");
           }
           if(pasajero.getCodigo().length() < 3){
               throw new BusinessException("Ingrese más de 3 caracteres en el código.");
           }
           if(validarCodigo(pasajero)){
               throw new BusinessException("El código ya está en uso.");
           }
           if(pasajero.getCodigo().length() > 4){
               throw new BusinessException("El código no puede tener más de 4 caracteres.");
           }
            //categoria
            if(pasajero.getCategoria().isEmpty()){
                throw new BusinessException("La categoría está vacía.");
            }
            if(pasajero.getCategoria().length() < 3){
                throw new BusinessException("Ingrese más de 3 caracteres en la categoría.");
            }
            if(pasajero.getCategoria().length() > 10){
                throw new BusinessException("La categoría no puede tener más de 10 caracteres.");
            }
            //telefono
            if(String.valueOf(pasajero.getTelefono()).isEmpty()){
                throw new Exception("El número de teléfono esta vacío.");
            }
            if(pasajero.getTelefono() <= 0){
                throw new Exception("El número de teléfono no puede ser menor o igual a 0.");
            }
            Pattern patron=Pattern.compile("[2389]");
            Matcher validarNumero = patron.matcher(String.valueOf(pasajero.getTelefono()).substring(0,1));
            if(!validarNumero.matches()){
                throw new Exception("El número de teléfono debe iniciar con 2,3,8 o 9");
            }
            if(String.valueOf(pasajero.getTelefono()).length() < 8){
                throw new Exception("El número de teléfono es muy corto.");
            }
            if(String.valueOf(pasajero.getTelefono()).length() > 8){
                throw new Exception("El número de teléfono es muy largo.");
            }
            //tipoDocumento
            if(pasajero.getTipoDocumento().isEmpty()){
                throw new BusinessException("El tipo de documento está vacío.");
            }
            if(pasajero.getTipoDocumento().length() < 3){
                throw new BusinessException("Ingrese más de 3 caracteres en el tipo de documento.");
            }
            if(pasajero.getTipoDocumento().length() > 50){
                throw new BusinessException("El tipo de documento no puede tener más de 10 caracteres.");
            }
            //idDocumento
            if(pasajero.getIdDocumento().isEmpty()){
                throw new BusinessException("El id de documento está vacío.");
            }
            if(pasajero.getIdDocumento().length() < 11){
                throw new BusinessException("Ingrese más de 3 caracteres en el id de documento.");
            }
            if(pasajero.getIdDocumento().length() > 15){
                throw new BusinessException("El id de documento no puede tener más de 15 caracteres.");
            }
            //nacionalidad
            if(pasajero.getNacionalidad().isEmpty()){
                throw new BusinessException("La nacionalidad está vacía.");
            }
            if(pasajero.getNacionalidad().length() < 3){
                throw new BusinessException("Ingrese más de 3 caracteres en la nacionalidad.");
            }
            if(pasajero.getNacionalidad().length() > 50){
                throw new BusinessException("La nacionalidad no puede tener más de 50 caracteres.");
            }
            //nombre
            if(pasajero.getNombre().isEmpty()){
                throw new BusinessException("El nombre está vacío.");
            }
            if(pasajero.getNombre().length() < 3){
                throw new BusinessException("El nombre es muy corto.");
            }
            if(pasajero.getNombre().length() > 50){
                throw new BusinessException("El nombre muy extenso.");
            }
            return repository.save(pasajero);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Pasajero> savePasajeros(List<Pasajero> pasajeros) throws BusinessException {
        try{
            for (Pasajero pasajero: pasajeros) {
                //codigo
                if(pasajero.getCodigo().isEmpty()){
                    throw new BusinessException("El código está vacío.");
                }
                if(pasajero.getCodigo().length() < 3){
                    throw new BusinessException("Ingrese más de 3 caracteres en el código.");
                }
                if(validarCodigo(pasajero)){
                    throw new BusinessException("El código ya está en uso.");
                }
                if(pasajero.getCodigo().length() > 4){
                    throw new BusinessException("El código no puede tener más de 4 caracteres.");
                }
                //categoria
                if(pasajero.getCategoria().isEmpty()){
                    throw new BusinessException("La categoría está vacía.");
                }
                if(pasajero.getCategoria().length() < 3){
                    throw new BusinessException("Ingrese más de 3 caracteres en la categoría.");
                }
                if(pasajero.getCategoria().length() > 10){
                    throw new BusinessException("La categoría no puede tener más de 10 caracteres.");
                }
                //telefono
                if(String.valueOf(pasajero.getTelefono()).isEmpty()){
                    throw new Exception("El número de teléfono esta vacío.");
                }
                if(pasajero.getTelefono() <= 0){
                    throw new Exception("El número de teléfono no puede ser menor o igual a 0.");
                }
                Pattern patron=Pattern.compile("[2389]");
                Matcher validarNumero = patron.matcher(String.valueOf(pasajero.getTelefono()).substring(0,1));
                if(!validarNumero.matches()){
                    throw new Exception("El número de teléfono debe iniciar con 2,3,8 o 9");
                }
                if(String.valueOf(pasajero.getTelefono()).length() < 8){
                    throw new Exception("El número de teléfono es muy corto.");
                }
                if(String.valueOf(pasajero.getTelefono()).length() > 8){
                    throw new Exception("El número de teléfono es muy largo.");
                }
                //tipoDocumento
                if(pasajero.getTipoDocumento().isEmpty()){
                    throw new BusinessException("El tipo de documento está vacío.");
                }
                if(pasajero.getTipoDocumento().length() < 3){
                    throw new BusinessException("Ingrese más de 3 caracteres en el tipo de documento.");
                }
                if(pasajero.getTipoDocumento().length() > 50){
                    throw new BusinessException("El tipo de documento no puede tener más de 10 caracteres.");
                }
                //idDocumento
                if(pasajero.getIdDocumento().isEmpty()){
                    throw new BusinessException("El id de documento está vacío.");
                }
                if(pasajero.getIdDocumento().length() < 3){
                    throw new BusinessException("Ingrese más de 3 caracteres en el id de documento.");
                }
                if(pasajero.getIdDocumento().length() > 50){
                    throw new BusinessException("El id de documento no puede tener más de 50 caracteres.");
                }
                //nacionalidad
                if(pasajero.getNacionalidad().isEmpty()){
                    throw new BusinessException("La nacionalidad está vacía.");
                }
                if(pasajero.getNacionalidad().length() < 3){
                    throw new BusinessException("Ingrese más de 3 caracteres en la nacionalidad.");
                }
                if(pasajero.getNacionalidad().length() > 10){
                    throw new BusinessException("La nacionalidad no puede tener más de 10 caracteres.");
                }
                //nombre
                if(pasajero.getNombre().isEmpty()){
                    throw new BusinessException("El nombre está vacío.");
                }
                if(pasajero.getNombre().length() < 3){
                    throw new BusinessException("El nombre es muy corto.");
                }
                if(pasajero.getNombre().length() > 50){
                    throw new BusinessException("El nombre muy extenso.");
                }
            }
            return repository.saveAll(pasajeros);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Pasajero> getPasajeros() throws BusinessException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());

        }
    }

    @Override
    public Pasajero getPasajeroByID(long id) throws BusinessException, NotFoundException {
        Optional<Pasajero> opt = null;
        try{
            opt = repository.findById(id);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el pasajero: " + id);
        }
        return opt.get();
    }

    @Override
    public Pasajero getPasajeroByNombre(String nombre) throws BusinessException, NotFoundException {
        Optional<Pasajero> opt = null;
        try{
            opt = repository.findFirstByNombre(nombre);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el pasajero: " + nombre);
        }
        return opt.get();
    }

    @Override
    public void deletePasajero(long id) throws BusinessException, NotFoundException {
        Optional<Pasajero> opt = null;
        try{
            opt = repository.findById(id);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el pasajero: " + id);
        }else{
            try {
                repository.deleteById(id);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    @Override
    public Pasajero updatePasajero(Pasajero pasajero) throws BusinessException, NotFoundException {
        Optional<Pasajero> opt = null;
        try{
            opt = repository.findById(pasajero.getId());
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el pasajero: " + pasajero.getId());
        }else{
            try {
                //codigo
                if(pasajero.getCodigo().isEmpty()){
                    throw new BusinessException("El código está vacío.");
                }
                if(pasajero.getCodigo().length() < 3){
                    throw new BusinessException("Ingrese más de 3 caracteres en el código.");
                }
                if(pasajero.getCodigo().length() > 4){
                    throw new BusinessException("El código no puede tener más de 4 caracteres.");
                }
                //categoria
                if(pasajero.getCategoria().isEmpty()){
                    throw new BusinessException("La categoría está vacía.");
                }
                if(pasajero.getCategoria().length() < 3){
                    throw new BusinessException("Ingrese más de 3 caracteres en la categoría.");
                }
                if(pasajero.getCategoria().length() > 10){
                    throw new BusinessException("La categoría no puede tener más de 10 caracteres.");
                }
                //telefono
                if(String.valueOf(pasajero.getTelefono()).isEmpty()){
                    throw new Exception("El número de teléfono esta vacío.");
                }
                if(pasajero.getTelefono() <= 0){
                    throw new Exception("El número de teléfono no puede ser menor o igual a 0.");
                }
                Pattern patron=Pattern.compile("[2389]");
                Matcher validarNumero = patron.matcher(String.valueOf(pasajero.getTelefono()).substring(0,1));
                if(!validarNumero.matches()){
                    throw new Exception("El número de teléfono debe iniciar con 2,3,8 o 9");
                }
                if(String.valueOf(pasajero.getTelefono()).length() < 8){
                    throw new Exception("El número de teléfono es muy corto.");
                }
                if(String.valueOf(pasajero.getTelefono()).length() > 8){
                    throw new Exception("El número de teléfono es muy largo.");
                }
                //tipoDocumento
                if(pasajero.getTipoDocumento().isEmpty()){
                    throw new BusinessException("El tipo de documento está vacío.");
                }
                if(pasajero.getTipoDocumento().length() < 3){
                    throw new BusinessException("Ingrese más de 3 caracteres en el tipo de documento.");
                }
                if(pasajero.getTipoDocumento().length() > 50){
                    throw new BusinessException("El tipo de documento no puede tener más de 10 caracteres.");
                }
                //idDocumento
                if(pasajero.getIdDocumento().isEmpty()){
                    throw new BusinessException("El id de documento está vacío.");
                }
                if(pasajero.getIdDocumento().length() < 3){
                    throw new BusinessException("Ingrese más de 3 caracteres en el id de documento.");
                }
                if(pasajero.getIdDocumento().length() > 50){
                    throw new BusinessException("El id de documento no puede tener más de 50 caracteres.");
                }
                //nacionalidad
                if(pasajero.getNacionalidad().isEmpty()){
                    throw new BusinessException("La nacionalidad está vacía.");
                }
                if(pasajero.getNacionalidad().length() < 3){
                    throw new BusinessException("Ingrese más de 3 caracteres en la nacionalidad.");
                }
                if(pasajero.getNacionalidad().length() > 10){
                    throw new BusinessException("La nacionalidad no puede tener más de 10 caracteres.");
                }
                //nombre
                if(pasajero.getNombre().isEmpty()){
                    throw new BusinessException("El nombre está vacío.");
                }
                if(pasajero.getNombre().length() < 3){
                    throw new BusinessException("El nombre es muy corto.");
                }
                if(pasajero.getNombre().length() > 50){
                    throw new BusinessException("El nombre muy extenso.");
                }
                Pasajero existingPasajero = new Pasajero();
                existingPasajero.setId(pasajero.getId());
                existingPasajero.setCodigo(pasajero.getCodigo());
                existingPasajero.setCategoria(pasajero.getCategoria());
                existingPasajero.setTelefono(pasajero.getTelefono());
                existingPasajero.setTipoDocumento(pasajero.getTipoDocumento());
                existingPasajero.setIdDocumento(pasajero.getIdDocumento());
                existingPasajero.setNacionalidad(pasajero.getNacionalidad());
                existingPasajero.setNombre(pasajero.getNombre());

                return repository.save(existingPasajero);

            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }
    private boolean validarCodigo(Pasajero pasajero) throws BusinessException{
        boolean condicion = false;
        try{
            List<Pasajero> listaPasajero = repository.findAll();
            for (Pasajero pasajeros: listaPasajero) {
                if (pasajero.getCodigo().equals(pasajeros.getCodigo())) {
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
