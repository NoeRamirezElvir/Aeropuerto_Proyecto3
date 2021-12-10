package hn.edu.ujcv.service.VueloService;

import hn.edu.ujcv.entity.LocalComercial.LocalComercial;
import hn.edu.ujcv.entity.Vuelo.Vuelo;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;

import java.util.List;

public interface IVueloService {
    Vuelo       saveVuelo(Vuelo vuelo)throws BusinessException;
    List<Vuelo> saveVuelos(List<Vuelo> vueloList)throws BusinessException;
    List<Vuelo> getVuelos()throws BusinessException;
    Vuelo       getVueloById(long id)throws BusinessException, NotFoundException;
    Vuelo       getVueloByDestino(String name)throws BusinessException,NotFoundException;
    void        deleteVuelo(long id)throws BusinessException, NotFoundException;
    Vuelo       updateVuelo(Vuelo vuelo)throws BusinessException,NotFoundException;
}
