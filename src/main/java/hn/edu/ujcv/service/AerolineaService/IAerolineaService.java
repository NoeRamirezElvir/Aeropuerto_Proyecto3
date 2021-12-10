package hn.edu.ujcv.service.AerolineaService;

import hn.edu.ujcv.entity.Aerolinea.Aerolinea;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;

import java.util.List;

public interface IAerolineaService {
    Aerolinea       saveAerolinea(Aerolinea aerolinea)throws BusinessException;
    List<Aerolinea> saveAerolineas(List<Aerolinea> aerolineas)throws BusinessException;
    List<Aerolinea> getAerolineas()throws BusinessException;
    Aerolinea       getAerolineaById(long id)throws BusinessException, NotFoundException;
    Aerolinea       getAerolineaByNombre(String nombre)throws BusinessException,NotFoundException;
    void            deleteAerolinea(long id)throws BusinessException, NotFoundException;
    Aerolinea       updateAerolinea(Aerolinea aerolinea)throws BusinessException,NotFoundException;
}
