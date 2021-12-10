package hn.edu.ujcv.service.AerolineaService;

import hn.edu.ujcv.entity.Aerolinea.Aerolinea;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;
import hn.edu.ujcv.repository.AerolineaRepository.AerolineaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AerolineaService implements IAerolineaService{
    @Autowired
    private AerolineaRepository repository;

    @Override
    public Aerolinea saveAerolinea(Aerolinea aerolinea) throws BusinessException {
        try{
            //nombre
            if (aerolinea.getNombre().isEmpty()){
                throw new BusinessException("Nombre de la Aerolinea viene vacio");
            }
            if (aerolinea.getNombre().length() < 4){
                throw new BusinessException("Ingrese mas de 3 caracteres en el Nombre de la Aerolinea");
            }
            if (aerolinea.getNombre().length() >30){
                throw new BusinessException("Nombre de la Aerolinea no puede tener mas 30 caracteres");
            }
            //codigo
            if (aerolinea.getCodigo().isEmpty()){
                throw new BusinessException("Código de la Aerolinea viene vacio");
            }
            if (aerolinea.getCodigo().length() < 2){
                throw new BusinessException("Ingrese mas de 1 caracter en el Codigo de la Aerolinea ");
            }
            if (aerolinea.getCodigo().length() > 3){
                throw new BusinessException("Código de la Aerolinea no puede tener mas de 3 caracateres");
            }
            //telefonoAtencion
            if(String.valueOf(aerolinea.getTelefonoAtencion()).isEmpty()){
                throw new Exception("El número de teléfono de atención esta vacío.");
            }
            if(aerolinea.getTelefonoAtencion() <= 0){
                throw new Exception("El número de teléfono de atención no puede ser menor o igual a 0.");
            }
            Pattern patron=Pattern.compile("[2389]");
            Matcher validarNumero = patron.matcher(String.valueOf(aerolinea.getTelefonoAtencion()).substring(0,1));
            if(!validarNumero.matches()){
                throw new Exception("El número de teléfono de atención debe iniciar con 2,3,8 o 9");
            }
            if(String.valueOf(aerolinea.getTelefonoAtencion()).length() < 8){
                throw new Exception("El número de teléfono de atención es muy corto.");
            }
            if(String.valueOf(aerolinea.getTelefonoAtencion()).length() > 8){
                throw new Exception("El número de teléfono de atención es muy largo.");
            }
            //telefonoCarga
            if(String.valueOf(aerolinea.getTelefonoAtencion()).isEmpty()){
                throw new Exception("El número de teléfono de carga esta vacío.");
            }
            if(aerolinea.getTelefonoAtencion() <= 0){
                throw new Exception("El número de teléfono de carga no puede ser menor o igual a 0.");
            }
            Pattern patron1=Pattern.compile("[2389]");
            Matcher validarNumero1 = patron1.matcher(String.valueOf(aerolinea.getTelefonoAtencion()).substring(0,1));
            if(!validarNumero1.matches()){
                throw new Exception("El número de teléfono  de carga debe iniciar con 2,3,8 o 9");
            }
            if(String.valueOf(aerolinea.getTelefonoAtencion()).length() < 8){
                throw new Exception("El número de teléfono de carga es muy corto.");
            }
            if(String.valueOf(aerolinea.getTelefonoAtencion()).length() > 8){
                throw new Exception("El número de teléfono de carga es muy largo.");
            }
            //direccion
            if(aerolinea.getDireccion().isEmpty()){
                throw new BusinessException("La dirección está vacío.");
            }
            if(aerolinea.getDireccion().length() < 3){
                throw new BusinessException("Ingrese más de 2 caracteres en la dirección.");
            }
            if(aerolinea.getDireccion().length() > 50){
                throw new BusinessException("La dirección no puede tener más de 50 caracteres.");
            }
            //paginaWeb
            if (aerolinea.getPaginaWeb().isEmpty()){
                throw new BusinessException("Pagina Web de la Aerolinea viene vacio");
            }
            if (aerolinea.getPaginaWeb().length() < 11){
                throw new BusinessException("Pagina Web de la Aerolinea muy corta");
            }
            if (aerolinea.getPaginaWeb().length() >100){
                throw new BusinessException("Pagina Web de la Aerolinea muy extensa ");
            }
            //ubicacionAeropuerto
            if (aerolinea.getUbicacionAeropuerto().isEmpty()){
                throw new BusinessException("Ubicación de la Aerolinea viene vacio");
            }
            if (aerolinea.getUbicacionAeropuerto().length() < 7){
                throw new BusinessException("Ubicación de la Aerolinea muy corta");
            }
            if (aerolinea.getUbicacionAeropuerto().length() > 50){
                throw new BusinessException("Ubicación de la Aerolinea muy extenso");
            }
            return repository.save(aerolinea);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Aerolinea> saveAerolineas(List<Aerolinea> aerolineas) throws BusinessException {
        try{
            for (Aerolinea aerolinea:aerolineas) {
                //nombre
                if (aerolinea.getNombre().isEmpty()){
                    throw new BusinessException("Nombre de la Aerolinea viene vacio");
                }
                if (aerolinea.getNombre().length() < 4){
                    throw new BusinessException("Ingrese mas de 3 caracteres en el Nombre de la Aerolinea");
                }
                if (aerolinea.getNombre().length() >30){
                    throw new BusinessException("Nombre de la Aerolinea no puede tener mas 30 caracteres");
                }
                //codigo
                if (aerolinea.getCodigo().isEmpty()){
                    throw new BusinessException("Código de la Aerolinea viene vacio");
                }
                if (aerolinea.getCodigo().length() < 2){
                    throw new BusinessException("Ingrese mas de 1 caracter en el Codigo de la Aerolinea ");
                }
                if (aerolinea.getCodigo().length() > 3){
                    throw new BusinessException("Código de la Aerolinea no puede tener mas de 3 caracateres");
                }
                //telefonoAtencion
                if(String.valueOf(aerolinea.getTelefonoAtencion()).isEmpty()){
                    throw new Exception("El número de teléfono de atención esta vacío.");
                }
                if(aerolinea.getTelefonoAtencion() <= 0){
                    throw new Exception("El número de teléfono de atención no puede ser menor o igual a 0.");
                }
                Pattern patron=Pattern.compile("[2389]");
                Matcher validarNumero = patron.matcher(String.valueOf(aerolinea.getTelefonoAtencion()).substring(0,1));
                if(!validarNumero.matches()){
                    throw new Exception("El número de teléfono de atención debe iniciar con 2,3,8 o 9");
                }
                if(String.valueOf(aerolinea.getTelefonoAtencion()).length() < 8){
                    throw new Exception("El número de teléfono de atención es muy corto.");
                }
                if(String.valueOf(aerolinea.getTelefonoAtencion()).length() > 8){
                    throw new Exception("El número de teléfono de atención es muy largo.");
                }
                //telefonoCarga
                if(String.valueOf(aerolinea.getTelefonoAtencion()).isEmpty()){
                    throw new Exception("El número de teléfono de carga esta vacío.");
                }
                if(aerolinea.getTelefonoAtencion() <= 0){
                    throw new Exception("El número de teléfono de carga no puede ser menor o igual a 0.");
                }
                Pattern patron1=Pattern.compile("[2389]");
                Matcher validarNumero1 = patron1.matcher(String.valueOf(aerolinea.getTelefonoAtencion()).substring(0,1));
                if(!validarNumero1.matches()){
                    throw new Exception("El número de teléfono  de carga debe iniciar con 2,3,8 o 9");
                }
                if(String.valueOf(aerolinea.getTelefonoAtencion()).length() < 8){
                    throw new Exception("El número de teléfono de carga es muy corto.");
                }
                if(String.valueOf(aerolinea.getTelefonoAtencion()).length() > 8){
                    throw new Exception("El número de teléfono de carga es muy largo.");
                }
                //direccion
                if(aerolinea.getDireccion().isEmpty()){
                    throw new BusinessException("La dirección está vacío.");
                }
                if(aerolinea.getDireccion().length() < 3){
                    throw new BusinessException("Ingrese más de 2 caracteres en la dirección.");
                }
                if(aerolinea.getDireccion().length() > 50){
                    throw new BusinessException("La dirección no puede tener más de 50 caracteres.");
                }
                //paginaWeb
                if (aerolinea.getPaginaWeb().isEmpty()){
                    throw new BusinessException("Pagina Web de la Aerolinea viene vacio");
                }
                if (aerolinea.getPaginaWeb().length() < 11){
                    throw new BusinessException("Pagina Web de la Aerolinea muy corta");
                }
                if (aerolinea.getPaginaWeb().length() >100){
                    throw new BusinessException("Pagina Web de la Aerolinea muy extensa ");
                }
                //ubicacionAeropuerto
                if (aerolinea.getUbicacionAeropuerto().isEmpty()){
                    throw new BusinessException("Ubicación de la Aerolinea viene vacio");
                }
                if (aerolinea.getUbicacionAeropuerto().length() < 7){
                    throw new BusinessException("Ubicación de la Aerolinea muy corta");
                }
                if (aerolinea.getUbicacionAeropuerto().length() > 50){
                    throw new BusinessException("Ubicación de la Aerolinea muy extenso");
                }
            }
            return repository.saveAll(aerolineas);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Aerolinea> getAerolineas() throws BusinessException {
        try{
            return repository.findAll();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Aerolinea getAerolineaById(long id) throws BusinessException, NotFoundException {
        Optional<Aerolinea> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()){
            throw new NotFoundException("No se Encontro la Aerolinea: "+ id);
        }
        return opt.get();
    }

    @Override
    public Aerolinea getAerolineaByName(String name) throws BusinessException, NotFoundException {
        Optional<Aerolinea> opt = null;
        try{
            opt=repository.findByNombre(name);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()){
            throw new NotFoundException("No se Encontro la Aerolinea: "+name);
        }
        return opt.get();
    }

    @Override
    public void deleteAerolinea(long id) throws BusinessException, NotFoundException {
        Optional<Aerolinea> opt = null;
        try{
            opt= repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()){
            throw new NotFoundException("No se Encontro la Aerolinea: "+ id);
        }else{
            try{
                repository.deleteById(id);
            }catch (Exception e1){
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    @Override
    public Aerolinea updateAerolinea(Aerolinea aerolinea) throws BusinessException, NotFoundException {
        Optional<Aerolinea> opt = null;
        try{
            if (String.valueOf(aerolinea.getId()).isEmpty()) {
                throw new BusinessException("ID de la aerolinea viene vacio");
            }
            opt= repository.findById(aerolinea.getId());
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()){
            throw new NotFoundException("No se Encontro la Aerolinea: "+ aerolinea.getId());
        }else{
            try{
                if (String.valueOf(aerolinea.getId()).isEmpty()) {
                    throw new BusinessException("ID de la Aerolinea viene vacio");
                }
                //nombre
                if (aerolinea.getNombre().isEmpty()){
                    throw new BusinessException("Nombre de la Aerolinea viene vacio");
                }
                if (aerolinea.getNombre().length() < 4){
                    throw new BusinessException("Ingrese mas de 3 caracteres en el Nombre de la Aerolinea");
                }
                if (aerolinea.getNombre().length() >30){
                    throw new BusinessException("Nombre de la Aerolinea no puede tener mas 30 caracteres");
                }
                //codigo
                if (aerolinea.getCodigo().isEmpty()){
                    throw new BusinessException("Código de la Aerolinea viene vacio");
                }
                if (aerolinea.getCodigo().length() < 2){
                    throw new BusinessException("Ingrese mas de 1 caracter en el Codigo de la Aerolinea ");
                }
                if (aerolinea.getCodigo().length() > 3){
                    throw new BusinessException("Código de la Aerolinea no puede tener mas de 3 caracateres");
                }
                //telefonoAtencion
                if(String.valueOf(aerolinea.getTelefonoAtencion()).isEmpty()){
                    throw new Exception("El número de teléfono de atención esta vacío.");
                }
                if(aerolinea.getTelefonoAtencion() <= 0){
                    throw new Exception("El número de teléfono de atención no puede ser menor o igual a 0.");
                }
                Pattern patron=Pattern.compile("[2389]");
                Matcher validarNumero = patron.matcher(String.valueOf(aerolinea.getTelefonoAtencion()).substring(0,1));
                if(!validarNumero.matches()){
                    throw new Exception("El número de teléfono de atención debe iniciar con 2,3,8 o 9");
                }
                if(String.valueOf(aerolinea.getTelefonoAtencion()).length() < 8){
                    throw new Exception("El número de teléfono de atención es muy corto.");
                }
                if(String.valueOf(aerolinea.getTelefonoAtencion()).length() > 8){
                    throw new Exception("El número de teléfono de atención es muy largo.");
                }
                //telefonoCarga
                if(String.valueOf(aerolinea.getTelefonoAtencion()).isEmpty()){
                    throw new Exception("El número de teléfono de carga esta vacío.");
                }
                if(aerolinea.getTelefonoAtencion() <= 0){
                    throw new Exception("El número de teléfono de carga no puede ser menor o igual a 0.");
                }
                Pattern patron1=Pattern.compile("[2389]");
                Matcher validarNumero1 = patron1.matcher(String.valueOf(aerolinea.getTelefonoAtencion()).substring(0,1));
                if(!validarNumero1.matches()){
                    throw new Exception("El número de teléfono  de carga debe iniciar con 2,3,8 o 9");
                }
                if(String.valueOf(aerolinea.getTelefonoAtencion()).length() < 8){
                    throw new Exception("El número de teléfono de carga es muy corto.");
                }
                if(String.valueOf(aerolinea.getTelefonoAtencion()).length() > 8){
                    throw new Exception("El número de teléfono de carga es muy largo.");
                }
                //direccion
                if(aerolinea.getDireccion().isEmpty()){
                    throw new BusinessException("La dirección está vacío.");
                }
                if(aerolinea.getDireccion().length() < 3){
                    throw new BusinessException("Ingrese más de 2 caracteres en la dirección.");
                }
                if(aerolinea.getDireccion().length() > 50){
                    throw new BusinessException("La dirección no puede tener más de 50 caracteres.");
                }
                //paginaWeb
                if (aerolinea.getPaginaWeb().isEmpty()){
                    throw new BusinessException("Pagina Web de la Aerolinea viene vacio");
                }
                if (aerolinea.getPaginaWeb().length() < 11){
                    throw new BusinessException("Pagina Web de la Aerolinea muy corta");
                }
                if (aerolinea.getPaginaWeb().length() >100){
                    throw new BusinessException("Pagina Web de la Aerolinea muy extensa ");
                }
                //ubicacionAeropuerto
                if (aerolinea.getUbicacionAeropuerto().isEmpty()){
                    throw new BusinessException("Ubicación de la Aerolinea viene vacio");
                }
                if (aerolinea.getUbicacionAeropuerto().length() < 7){
                    throw new BusinessException("Ubicación de la Aerolinea muy corta");
                }
                if (aerolinea.getUbicacionAeropuerto().length() > 50){
                    throw new BusinessException("Ubicación de la Aerolinea muy extenso");
                }
                Aerolinea aerolineaEx = new Aerolinea();
                aerolineaEx.setId(aerolinea.getId());
                aerolineaEx.setCodigo(aerolinea.getCodigo());
                aerolineaEx.setNombre(aerolinea.getNombre());
                aerolineaEx.setDireccion(aerolinea.getDireccion());
                aerolineaEx.setPaginaWeb(aerolinea.getPaginaWeb());
                aerolineaEx.setTelefonoAtencion(aerolinea.getTelefonoAtencion());
                aerolineaEx.setTelefonoCarga(aerolinea.getTelefonoCarga());
                aerolineaEx.setUbicacionAeropuerto(aerolinea.getUbicacionAeropuerto());
                return repository.save(aerolineaEx);
            }catch (Exception e1){
                throw new BusinessException(e1.getMessage());
            }
        }
    }
}
