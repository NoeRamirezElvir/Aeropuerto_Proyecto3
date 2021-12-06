package hn.edu.ujcv.service.BoletoService;

import hn.edu.ujcv.entity.Boleto.Boleto;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;

import java.util.List;

public interface IBoletoService {
    Boleto       saveBoleto(Boleto boleto)throws BusinessException;
    List<Boleto> saveBoletos(List<Boleto> boletos)throws BusinessException;
    List<Boleto> getBoletos()throws BusinessException;
    Boleto       getBoletoByID(long id) throws BusinessException, NotFoundException;
    Boleto       getBoletoByCodigoFactura(String codigoFactura)throws BusinessException,NotFoundException;
    void         deleteBoleto(long id)throws BusinessException,NotFoundException;
    Boleto       updateBoleto(Boleto boleto) throws BusinessException,NotFoundException;
}
