package hn.edu.ujcv.service.PersonaService;

import hn.edu.ujcv.entity.Persona.Persona;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;

import java.util.List;

public interface IPersonaService {
    Persona savePersona(Persona persona)throws BusinessException;
    List<Persona> savePersonas(List<Persona> personas)throws BusinessException;
    List<Persona> getPersonas()throws BusinessException;
    Persona       getPersonaByID(long id) throws BusinessException, NotFoundException;
    Persona       getPersonaByNombre(String nombre)throws BusinessException,NotFoundException;
    void         deletePersona(long id)throws BusinessException,NotFoundException;
    Persona       updatePersona(Persona persona) throws BusinessException,NotFoundException;

}
