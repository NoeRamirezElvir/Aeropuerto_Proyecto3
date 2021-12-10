package hn.edu.ujcv.service.LocalComercialService;

import hn.edu.ujcv.entity.LocalComercial.LocalComercial;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;
import hn.edu.ujcv.repository.LocalComercialRepository.LocalComercialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LocalComercialService implements ILocalComercialService{
    @Autowired
    private LocalComercialRepository repository;

    @Override
    public LocalComercial saveLocalComercial(LocalComercial localComercial) throws BusinessException {
        try{
            //nombre
            if(localComercial.getNombre().isEmpty()){
                throw new BusinessException("El nombre está vacío.");
            }
            if(localComercial.getNombre().length() < 3){
                throw new BusinessException("Ingrese más de 2 caracteres en el nombre.");
            }
            if(localComercial.getNombre().length() > 50){
                throw new BusinessException("El nombre no puede tener más de 50 caracteres.");
            }
            //descripcion
            if (localComercial.getDescripcion().isEmpty()) {
                throw new BusinessException("La descripción está vacía.");
            }
            if (localComercial.getDescripcion().length() < 3) {
                throw new BusinessException("Ingrese más de 3 caracteres en la descripción.");
            }
            if (localComercial.getDescripcion().length() > 50) {
                throw new BusinessException("La descripción no puede tener más de 50 caracteres.");
            }
            //correoElectronico
            if(localComercial.getCorreoElectronico().isEmpty()){
                throw new BusinessException("El correo electrónnico está vacío.");
            }
            if(localComercial.getCorreoElectronico().length() < 10){
                throw new BusinessException("El correo electrónnico es muy corto.");
            }
            if(localComercial.getCorreoElectronico().length() > 50){
                throw new BusinessException("El correo electrónnico es muy extenso.");
            }
            //tipoServicio
            if(localComercial.getTipoServicio().isEmpty()){
                throw new BusinessException("El tipo de servicio está vacío.");
            }
            if(localComercial.getTipoServicio().length() < 3){
                throw new BusinessException("Ingrese más de 5 caracteres en el tipo.");
            }
            if(localComercial.getTipoServicio().length() > 30){
                throw new BusinessException("El tipo no puede tener más de 30 caracteres.");
            }
            //telefono
            if(String.valueOf(localComercial.getTelefono()).isEmpty()){
                throw new Exception("El número de teléfono esta vacío.");
            }
            if(localComercial.getTelefono() <= 0){
                throw new Exception("El número de teléfono no puede ser menor o igual a 0.");
            }
            Pattern patron=Pattern.compile("[2389]");
            Matcher validarNumero = patron.matcher(String.valueOf(localComercial.getTelefono()).substring(0,1));
            if(!validarNumero.matches()){
                throw new Exception("El número de teléfono debe iniciar con 2,3,8 o 9");
            }
            if(String.valueOf(localComercial.getTelefono()).length() < 8){
                throw new Exception("El número de teléfono es muy corto.");
            }
            if(String.valueOf(localComercial.getTelefono()).length() > 8){
                throw new Exception("El número de teléfono es muy largo.");
            }
            //PaginaWeb
            if (localComercial.getPaginaWeb().isEmpty()){
                throw new BusinessException("Pagina Web de la Aerolinea viene vacio");
            }
            if (localComercial.getPaginaWeb().length() < 11){
                throw new BusinessException("Pagina Web de la Aerolinea muy corta");
            }
            if (localComercial.getPaginaWeb().length() >100){
                throw new BusinessException("Pagina Web de la Aerolinea muy extensa ");
            }
            //fechaIngreso
            if(String.valueOf(localComercial.getFechaIngreso()).isEmpty()){
                throw new BusinessException("La fecha está vacía.");
            }
            return repository.save(localComercial);
        }catch (Exception e){
           throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<LocalComercial> saveLocalesComerciales(List<LocalComercial> comercialList) throws BusinessException {
        try{
            for (LocalComercial localComercial:comercialList) {
                //nombre
                if(localComercial.getNombre().isEmpty()){
                    throw new BusinessException("El nombre está vacío.");
                }
                if(localComercial.getNombre().length() < 3){
                    throw new BusinessException("Ingrese más de 2 caracteres en el nombre.");
                }
                if(localComercial.getNombre().length() > 50){
                    throw new BusinessException("El nombre no puede tener más de 50 caracteres.");
                }
                //descripcion
                if (localComercial.getDescripcion().isEmpty()) {
                    throw new BusinessException("La descripción está vacía.");
                }
                if (localComercial.getDescripcion().length() < 3) {
                    throw new BusinessException("Ingrese más de 3 caracteres en la descripción.");
                }
                if (localComercial.getDescripcion().length() > 50) {
                    throw new BusinessException("La descripción no puede tener más de 50 caracteres.");
                }
                //correoElectronico
                if(localComercial.getCorreoElectronico().isEmpty()){
                    throw new BusinessException("El correo electrónnico está vacío.");
                }
                if(localComercial.getCorreoElectronico().length() < 10){
                    throw new BusinessException("El correo electrónnico es muy corto.");
                }
                if(localComercial.getCorreoElectronico().length() > 50){
                    throw new BusinessException("El correo electrónnico es muy extenso.");
                }
                //tipoServicio
                if(localComercial.getTipoServicio().isEmpty()){
                    throw new BusinessException("El tipo de servicio está vacío.");
                }
                if(localComercial.getTipoServicio().length() < 3){
                    throw new BusinessException("Ingrese más de 5 caracteres en el tipo.");
                }
                if(localComercial.getTipoServicio().length() > 30){
                    throw new BusinessException("El tipo no puede tener más de 30 caracteres.");
                }
                //telefono
                if(String.valueOf(localComercial.getTelefono()).isEmpty()){
                    throw new Exception("El número de teléfono esta vacío.");
                }
                if(localComercial.getTelefono() <= 0){
                    throw new Exception("El número de teléfono no puede ser menor o igual a 0.");
                }
                Pattern patron=Pattern.compile("[2389]");
                Matcher validarNumero = patron.matcher(String.valueOf(localComercial.getTelefono()).substring(0,1));
                if(!validarNumero.matches()){
                    throw new Exception("El número de teléfono debe iniciar con 2,3,8 o 9");
                }
                if(String.valueOf(localComercial.getTelefono()).length() < 8){
                    throw new Exception("El número de teléfono es muy corto.");
                }
                if(String.valueOf(localComercial.getTelefono()).length() > 8){
                    throw new Exception("El número de teléfono es muy largo.");
                }
                //PaginaWeb
                if (localComercial.getPaginaWeb().isEmpty()){
                    throw new BusinessException("Pagina Web de la Aerolinea viene vacio");
                }
                if (localComercial.getPaginaWeb().length() < 11){
                    throw new BusinessException("Pagina Web de la Aerolinea muy corta");
                }
                if (localComercial.getPaginaWeb().length() >100){
                    throw new BusinessException("Pagina Web de la Aerolinea muy extensa ");
                }
                //fechaIngreso
                if(String.valueOf(localComercial.getFechaIngreso()).isEmpty()){
                    throw new BusinessException("La fecha está vacía.");
                }
            }
            return repository.saveAll(comercialList);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<LocalComercial> getLocalesComerciales() throws BusinessException {
        try{
            return repository.findAll();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public LocalComercial getLocalComercialById(long id) throws BusinessException, NotFoundException {
        Optional<LocalComercial> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if(!opt.isPresent()){
            throw new NotFoundException("No se encontro el Local Comercial: " + id);
        }
        return opt.get();
    }

    @Override
    public LocalComercial getLocalComerciaByName(String name) throws BusinessException, NotFoundException {
        Optional<LocalComercial> opt = null;
        try{
            opt = repository.findByName(name);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if(!opt.isPresent()){
            throw new NotFoundException("No se encontro el Local Comercial: " + name);
        }
        return opt.get();
    }

    @Override
    public void deleteLocalComercial(long id) throws BusinessException, NotFoundException {
        Optional<LocalComercial> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if(!opt.isPresent()){
            throw new NotFoundException("No se encontro el Local Comercial: " + id);
        } else {
            try{
                repository.deleteById(id);
            }catch (Exception e1){
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    @Override
    public LocalComercial updateLocalComercial(LocalComercial localComercial) throws BusinessException, NotFoundException {
        Optional<LocalComercial> opt = null;
        try{
            if (String.valueOf(localComercial.getId()).isEmpty()) {
                throw new BusinessException("ID del Local Comercial viene vacio");
            }
            opt= repository.findById(localComercial.getId());
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()){
            throw new NotFoundException("No se Encontro el Local Comercial: "+ localComercial.getId());
        }else{
            try{
                //nombre
                if(localComercial.getNombre().isEmpty()){
                    throw new BusinessException("El nombre está vacío.");
                }
                if(localComercial.getNombre().length() < 3){
                    throw new BusinessException("Ingrese más de 2 caracteres en el nombre.");
                }
                if(localComercial.getNombre().length() > 50){
                    throw new BusinessException("El nombre no puede tener más de 50 caracteres.");
                }
                //descripcion
                if (localComercial.getDescripcion().isEmpty()) {
                    throw new BusinessException("La descripción está vacía.");
                }
                if (localComercial.getDescripcion().length() < 3) {
                    throw new BusinessException("Ingrese más de 3 caracteres en la descripción.");
                }
                if (localComercial.getDescripcion().length() > 50) {
                    throw new BusinessException("La descripción no puede tener más de 50 caracteres.");
                }
                //correoElectronico
                if(localComercial.getCorreoElectronico().isEmpty()){
                    throw new BusinessException("El correo electrónnico está vacío.");
                }
                if(localComercial.getCorreoElectronico().length() < 10){
                    throw new BusinessException("El correo electrónnico es muy corto.");
                }
                if(localComercial.getCorreoElectronico().length() > 50){
                    throw new BusinessException("El correo electrónnico es muy extenso.");
                }
                //tipoServicio
                if(localComercial.getTipoServicio().isEmpty()){
                    throw new BusinessException("El tipo de servicio está vacío.");
                }
                if(localComercial.getTipoServicio().length() < 3){
                    throw new BusinessException("Ingrese más de 5 caracteres en el tipo de Servicio.");
                }
                if(localComercial.getTipoServicio().length() > 30){
                    throw new BusinessException("El tipo de Servicio no puede tener más de 30 caracteres.");
                }
                //telefono
                if(String.valueOf(localComercial.getTelefono()).isEmpty()){
                    throw new Exception("El número de teléfono esta vacío.");
                }
                if(localComercial.getTelefono() <= 0){
                    throw new Exception("El número de teléfono no puede ser menor o igual a 0.");
                }
                Pattern patron=Pattern.compile("[2389]");
                Matcher validarNumero = patron.matcher(String.valueOf(localComercial.getTelefono()).substring(0,1));
                if(!validarNumero.matches()){
                    throw new Exception("El número de teléfono debe iniciar con 2,3,8 o 9");
                }
                if(String.valueOf(localComercial.getTelefono()).length() < 8){
                    throw new Exception("El número de teléfono es muy corto.");
                }
                if(String.valueOf(localComercial.getTelefono()).length() > 8){
                    throw new Exception("El número de teléfono es muy largo.");
                }
                //PaginaWeb
                if (localComercial.getPaginaWeb().isEmpty()){
                    throw new BusinessException("Pagina Web del Local Comercial viene vacio");
                }
                if (localComercial.getPaginaWeb().length() < 11){
                    throw new BusinessException("Pagina Web del Local Comercial muy corta");
                }
                if (localComercial.getPaginaWeb().length() >100){
                    throw new BusinessException("Pagina Web del Local Comercial muy extensa ");
                }
                //fechaIngreso
                if(String.valueOf(localComercial.getFechaIngreso()).isEmpty()){
                    throw new BusinessException("La fecha está vacía.");
                }
                LocalComercial localComercialEx = new LocalComercial();
                localComercialEx.setId(localComercial.getId());
                localComercialEx.setNombre(localComercial.getNombre());
                localComercialEx.setDescripcion(localComercial.getDescripcion());
                localComercialEx.setCorreoElectronico(localComercial.getCorreoElectronico());
                localComercialEx.setTipoServicio(localComercial.getTipoServicio());
                localComercialEx.setTelefono(localComercial.getTelefono());
                localComercialEx.setPaginaWeb(localComercial.getPaginaWeb());
                localComercialEx.setFechaIngreso(localComercial.getFechaIngreso());
                return repository.save(localComercialEx);
            }catch (Exception e1){
                throw new BusinessException(e1.getMessage());
            }
        }
    }
}
