package hn.edu.ujcv.service.AeronaveService;

import hn.edu.ujcv.entity.Aeronave.Aeronave;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;

import java.util.List;

public interface IAeronaveService {
    Aeronave       saveAeronave(Aeronave aeronave) throws BusinessException;
    List<Aeronave> saveAeronaves(List<Aeronave> aeronaves) throws BusinessException;
    List<Aeronave> getAeronaves() throws BusinessException;
    Aeronave       getAeronaveByID(long id)throws BusinessException,NotFoundException;
    Aeronave       getAeronaveByModelo(String modelo)throws BusinessException,NotFoundException;
    void           deleteAeronave(long id) throws BusinessException,NotFoundException;
    Aeronave       updateAeronave(Aeronave aeronave)throws BusinessException,NotFoundException;
}
