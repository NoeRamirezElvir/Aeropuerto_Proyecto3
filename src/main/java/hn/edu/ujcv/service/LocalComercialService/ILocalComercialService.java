package hn.edu.ujcv.service.LocalComercialService;

import hn.edu.ujcv.entity.LocalComercial.LocalComercial;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;

import java.util.List;

public interface ILocalComercialService {
    LocalComercial       saveLocalComercial(LocalComercial localComercial)throws BusinessException;
    List<LocalComercial> saveLocalesComerciales(List<LocalComercial> comercialList)throws BusinessException;
    List<LocalComercial> getLocalesComerciales()throws BusinessException;
    LocalComercial       getLocalComercialById(long id)throws BusinessException, NotFoundException;
    LocalComercial       getLocalComerciaByName(String nombre)throws BusinessException,NotFoundException;
    void                 deleteLocalComercial(long id)throws BusinessException, NotFoundException;
    LocalComercial       updateLocalComercial(LocalComercial localComercial)throws BusinessException,NotFoundException;
}
