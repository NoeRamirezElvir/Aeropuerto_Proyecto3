package hn.edu.ujcv.service.PersonaService;


import hn.edu.ujcv.entity.Persona.Persona;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;
import hn.edu.ujcv.repository.PersonaRepository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaService{
    @Autowired
    private PersonaRepository repository;
    @Override
    public Persona savePersona(Persona persona) throws BusinessException {
        try{
            //dni
            if(String.valueOf(persona.getDni()).isEmpty()){
                throw new BusinessException("El DNI está vacío.");
            }
            if(validarDNI(persona)){
                throw new BusinessException("El DNI ya está en uso.");
            }
            if(String.valueOf(persona.getDni()).length() < 13){
                throw new BusinessException("El DNI es muy corto.");
            }
            if(String.valueOf(persona.getDni()).length() > 13){
                throw new BusinessException("El DNI es muy largo.");
            }
            //nombre
            if(persona.getNombre().isEmpty()){
                throw new BusinessException("El nombre está vacío.");
            }
            if(persona.getNombre().length() < 3){
                throw new BusinessException("Ingrese más de 1 caracteres en el nombre.");
            }
            if(persona.getNombre().length() > 50){
                throw new BusinessException("El nombre no puede tener más de 50 caracteres.");
            }
            //edad
            if(String.valueOf(persona.getEdad()).isEmpty()){
                throw new BusinessException("La edad está vacía.");
            }
            if(persona.getEdad() <= 0){
                throw new BusinessException("La edad no puede ser menor o igual a 0.");
            }
            if(persona.getEdad() > 100){
                throw new BusinessException("La edad no puede ser mayor 100.");
            }
            //direccion
            if(persona.getDireccion().isEmpty()){
                throw new BusinessException("La dirección está vacío.");
            }
            if(persona.getDireccion().length() < 3){
                throw new BusinessException("Ingrese más de 1 caracteres en la dirección.");
            }
            if(persona.getDireccion().length() > 50){
                throw new BusinessException("La dirección no puede tener más de 50 caracteres.");
            }
            //genero
            if(persona.getGenero().isEmpty()){
                throw new BusinessException("El género está vacío.");
            }
            if(persona.getGenero().length() < 3){
                throw new BusinessException("Ingrese más de 1 caracteres en el género.");
            }
            if(persona.getGenero().length() > 50){
                throw new BusinessException("El género no puede tener más de 50 caracteres.");
            }
            //tipo
            if(persona.getTipo().isEmpty()){
                throw new BusinessException("El tipo está vacío.");
            }
            if(persona.getTipo().length() < 3){
                throw new BusinessException("Ingrese más de 1 caracteres en el tipo.");
            }
            if(persona.getTipo().length() > 50){
                throw new BusinessException("El tipo no puede tener más de 50 caracteres.");
            }
            return repository.save(persona);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Persona> savePersonas(List<Persona> personas) throws BusinessException {
        try{
            for (Persona persona:personas) {
                //dni
                if(String.valueOf(persona.getDni()).isEmpty()){
                    throw new BusinessException("El DNI está vacío.");
                }
                if(validarDNI(persona)){
                    throw new BusinessException("El DNI ya está en uso.");
                }
                if(String.valueOf(persona.getDni()).length() < 13){
                    throw new BusinessException("El DNI es muy corto.");
                }
                if(String.valueOf(persona.getDni()).length() > 13){
                    throw new BusinessException("El DNI es muy largo.");
                }
                //nombre
                if(persona.getNombre().isEmpty()){
                    throw new BusinessException("El nombre está vacío.");
                }
                if(persona.getNombre().length() < 3){
                    throw new BusinessException("Ingrese más de 1 caracteres en el nombre.");
                }
                if(persona.getNombre().length() > 50){
                    throw new BusinessException("El nombre no puede tener más de 50 caracteres.");
                }
                //edad
                if(String.valueOf(persona.getEdad()).isEmpty()){
                    throw new BusinessException("La edad está vacía.");
                }
                if(persona.getEdad() <= 0){
                    throw new BusinessException("La edad no puede ser menor o igual a 0.");
                }
                if(persona.getEdad() > 100){
                    throw new BusinessException("La edad no puede ser mayor 100.");
                }
                //direccion
                if(persona.getDireccion().isEmpty()){
                    throw new BusinessException("La dirección está vacío.");
                }
                if(persona.getDireccion().length() < 3){
                    throw new BusinessException("Ingrese más de 1 caracteres en la dirección.");
                }
                if(persona.getDireccion().length() > 50){
                    throw new BusinessException("La dirección no puede tener más de 50 caracteres.");
                }
                //genero
                if(persona.getGenero().isEmpty()){
                    throw new BusinessException("El género está vacío.");
                }
                if(persona.getGenero().length() < 3){
                    throw new BusinessException("Ingrese más de 1 caracteres en el género.");
                }
                if(persona.getGenero().length() > 50){
                    throw new BusinessException("El género no puede tener más de 50 caracteres.");
                }
                //tipo
                if(persona.getTipo().isEmpty()){
                    throw new BusinessException("El tipo está vacío.");
                }
                if(persona.getTipo().length() < 3){
                    throw new BusinessException("Ingrese más de 1 caracteres en el tipo.");
                }
                if(persona.getTipo().length() > 50){
                    throw new BusinessException("El tipo no puede tener más de 50 caracteres.");
                }
            }
            return repository.saveAll(personas);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Persona> getPersonas() throws BusinessException {
        try{
            return repository.findAll();
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Persona getPersonaByID(long id) throws BusinessException, NotFoundException {
        Optional<Persona> opt = null;
        try{
            opt = repository.findById(id);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }if(!opt.isPresent()){
            throw new NotFoundException("No se encontró la persona: " + id);
        }
        return opt.get();
    }

    @Override
    public Persona getPersonaByNombre(String nombre) throws BusinessException, NotFoundException {
        Optional<Persona> opt = null;
        try{
            opt = repository.findByNombre(nombre);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }if(!opt.isPresent()){
            throw new NotFoundException("No se encontró la persona: " + nombre);
        }
        return opt.get();
    }

    @Override
    public void deletePersona(long id) throws BusinessException, NotFoundException {
        Optional<Persona> opt = null;
        try{
            opt = repository.findById(id);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }if(!opt.isPresent()){
            throw new NotFoundException("No se encontró la persona: " + id);
        }else{
            try {
                repository.deleteById(id);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    @Override
    public Persona updatePersona(Persona persona) throws BusinessException, NotFoundException {
        Optional<Persona> opt = null;
        try {
            opt = repository.findById(persona.getId());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la persona: " + persona.getId());
        } else {
            try {
                //dni
                if (String.valueOf(persona.getDni()).isEmpty()) {
                    throw new BusinessException("El DNI está vacío.");
                }
                if (String.valueOf(persona.getDni()).length() < 13) {
                    throw new BusinessException("El DNI es muy corto.");
                }
                if (String.valueOf(persona.getDni()).length() > 13) {
                    throw new BusinessException("El DNI es muy largo.");
                }
                //nombre
                if (persona.getNombre().isEmpty()) {
                    throw new BusinessException("El nombre está vacío.");
                }
                if (persona.getNombre().length() < 3) {
                    throw new BusinessException("Ingrese más de 1 caracteres en el nombre.");
                }
                if (persona.getNombre().length() > 50) {
                    throw new BusinessException("El nombre no puede tener más de 50 caracteres.");
                }
                //edad
                if (String.valueOf(persona.getEdad()).isEmpty()) {
                    throw new BusinessException("La edad está vacía.");
                }
                if (persona.getEdad() <= 0) {
                    throw new BusinessException("La edad no puede ser menor o igual a 0.");
                }
                if (persona.getEdad() > 100) {
                    throw new BusinessException("La edad no puede ser mayor 100.");
                }
                //direccion
                if (persona.getDireccion().isEmpty()) {
                    throw new BusinessException("La dirección está vacío.");
                }
                if (persona.getDireccion().length() < 3) {
                    throw new BusinessException("Ingrese más de 1 caracteres en la dirección.");
                }
                if (persona.getDireccion().length() > 50) {
                    throw new BusinessException("La dirección no puede tener más de 50 caracteres.");
                }
                //genero
                if (persona.getGenero().isEmpty()) {
                    throw new BusinessException("El género está vacío.");
                }
                if (persona.getGenero().length() < 3) {
                    throw new BusinessException("Ingrese más de 1 caracteres en el género.");
                }
                if (persona.getGenero().length() > 50) {
                    throw new BusinessException("El género no puede tener más de 50 caracteres.");
                }
                //tipo
                if (persona.getTipo().isEmpty()) {
                    throw new BusinessException("El tipo está vacío.");
                }
                if (persona.getTipo().length() < 3) {
                    throw new BusinessException("Ingrese más de 1 caracteres en el tipo.");
                }
                if (persona.getTipo().length() > 50) {
                    throw new BusinessException("El tipo no puede tener más de 50 caracteres.");
                }
                Persona existingPersona = new Persona();
                existingPersona.setId(persona.getId());
                existingPersona.setDni(persona.getDni());
                existingPersona.setNombre(persona.getNombre());
                existingPersona.setEdad(persona.getEdad());
                existingPersona.setDireccion(persona.getDireccion());
                existingPersona.setGenero(persona.getGenero());
                existingPersona.setTipo(persona.getTipo());
                return repository.save(existingPersona);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    private boolean validarDNI (Persona persona) throws BusinessException {
        boolean condicion = false;
        try {
            List<Persona> listaPersonas = repository.findAll();
            for (Persona personas : listaPersonas) {
                if (persona.getDni() == personas.getDni()) {
                    condicion = true;
                    break;
                }
            }
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        return condicion;
    }
}
