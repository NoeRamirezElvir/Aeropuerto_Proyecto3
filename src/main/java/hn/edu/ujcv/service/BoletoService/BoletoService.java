package hn.edu.ujcv.service.BoletoService;

import hn.edu.ujcv.entity.Boleto.Boleto;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;
import hn.edu.ujcv.repository.BoletoRepository.BoletoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoletoService implements IBoletoService{
    @Autowired
    private BoletoRepository repository;
    @Override
    public Boleto saveBoleto(Boleto boleto) throws BusinessException {
        try{
            //Codigo Factura
            if(boleto.getCodigoFactura().isEmpty()){
               throw new BusinessException("El código de facturación está vacío.");
           }
           if(boleto.getCodigoFactura().length() < 3){
               throw new BusinessException("Ingrese más de 3 caracteres en el código de facturación.");
           }
           if(validarCodigo(boleto)){
               throw new BusinessException("El código  de facturación ya está en uso.");
           }
           if(boleto.getCodigoFactura().length() > 10){
               throw new BusinessException("El código de facturación no puede tener más de 10 caracteres.");
           }
           //Pasajero
            if(boleto.getNombrePasajero().isEmpty()){
                throw new BusinessException("El nombre del pasajero está vacío.");
            }
            if(boleto.getNombrePasajero().length() < 3){
                throw new BusinessException("Ingrese más de 3 caracteres en el nombre del pasajero.");
            }
            if(boleto.getNombrePasajero().length() > 50){
                throw new BusinessException("El nombre del pasajero no puede tener más de 50 caracteres.");
            }
            //Vuelo
            if(boleto.getVuelo().isEmpty()){
                throw new BusinessException("El vuelo está vacío.");
            }
            if(boleto.getVuelo().length() < 3){
                throw new BusinessException("Ingrese más de 4 caracteres en el vuelo.");
            }
            if(boleto.getVuelo().length() > 50){
                throw new BusinessException("El vuelo no puede tener más de 50 caracteres.");
            }
            //Asiento
            if(boleto.getAsiento().isEmpty()){
                throw new BusinessException("El asiento está vacío.");
            }
            if(boleto.getAsiento().length() < 2){
                throw new BusinessException("Ingrese más de 1 caracteres en el asiento.");
            }
            if(validarAsiento(boleto)){
                throw new BusinessException("El asiento ya está ocupado.");
            }
            if(boleto.getAsiento().length() > 5){
                throw new BusinessException("El asiento no puede tener más de 5 caracteres.");
            }
            //numero puerto embarque
            if(String.valueOf(boleto.getNumeroPuertaEmbarque()).isEmpty()){
                throw new BusinessException("La puerta de embarque está vacía.");
            }
            if((String.valueOf(boleto.getNumeroPuertaEmbarque()).length())<2){
                throw new BusinessException("La puerta de embarque no es correcta.");
            }
            if((String.valueOf(boleto.getNumeroPuertaEmbarque()).length())>4){
                throw new BusinessException("La puerta de embarque excede el límite.");
            }
            //clase
            if(boleto.getClase().isEmpty()){
                throw new BusinessException("La clase está vacía.");
            }
            if(boleto.getClase().length() < 3){
                throw new BusinessException("Ingrese más de 1 caracteres en el asiento.");
            }
            if(boleto.getClase().length() > 50){
                throw new BusinessException("La clase no puede tener más de 50 caracteres.");
            }
            //total
            if(String.valueOf(boleto.getTotal()).isEmpty()){
                throw new BusinessException("El total a pagar está vacío.");
            }
            if(boleto.getTotal() <= 0){
                throw new BusinessException("El total a pagar no puede ser menor o igual a 0.");
            }
            if((String.valueOf(boleto.getTotal()).length())>10){
                throw new BusinessException("El total a pagar excede el límite.");
            }
            return repository.save(boleto);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Boleto> saveBoletos(List<Boleto> boletos) throws BusinessException {
        try{
            for (Boleto boleto: boletos) {
                //Codigo Factura
                if(boleto.getCodigoFactura().isEmpty()){
                    throw new BusinessException("El código de facturación está vacío.");
                }
                if(boleto.getCodigoFactura().length() < 3){
                    throw new BusinessException("Ingrese más de 3 caracteres en el código de facturación.");
                }
                if(validarCodigo(boleto)){
                    throw new BusinessException("El código  de facturación ya está en uso.");
                }
                if(boleto.getCodigoFactura().length() > 10){
                    throw new BusinessException("El código de facturación no puede tener más de 10 caracteres.");
                }
                //Pasajero
                if(boleto.getNombrePasajero().isEmpty()){
                    throw new BusinessException("El nombre del pasajero está vacío.");
                }
                if(boleto.getNombrePasajero().length() < 3){
                    throw new BusinessException("Ingrese más de 3 caracteres en el nombre del pasajero.");
                }
                if(boleto.getNombrePasajero().length() > 50){
                    throw new BusinessException("El nombre del pasajero no puede tener más de 50 caracteres.");
                }
                //Vuelo
                if(boleto.getVuelo().isEmpty()){
                    throw new BusinessException("El vuelo está vacío.");
                }
                if(boleto.getVuelo().length() < 3){
                    throw new BusinessException("Ingrese más de 4 caracteres en el vuelo.");
                }
                if(boleto.getVuelo().length() > 50){
                    throw new BusinessException("El vuelo no puede tener más de 50 caracteres.");
                }
                //Asiento
                if(boleto.getAsiento().isEmpty()){
                    throw new BusinessException("El asiento está vacío.");
                }
                if(boleto.getAsiento().length() < 2){
                    throw new BusinessException("Ingrese más de 1 caracteres en el asiento.");
                }
                if(validarAsiento(boleto)){
                    throw new BusinessException("El asiento ya está ocupado.");
                }
                if(boleto.getAsiento().length() > 5){
                    throw new BusinessException("El asiento no puede tener más de 5 caracteres.");
                }
                //numero puerto embarque
                if(String.valueOf(boleto.getNumeroPuertaEmbarque()).isEmpty()){
                    throw new BusinessException("La puerta de embarque está vacía.");
                }
                if((String.valueOf(boleto.getNumeroPuertaEmbarque()).length())<2){
                    throw new BusinessException("La puerta de embarque no es correcta.");
                }
                if((String.valueOf(boleto.getNumeroPuertaEmbarque()).length())>4){
                    throw new BusinessException("La puerta de embarque excede el límite.");
                }
                //clase
                if(boleto.getClase().isEmpty()){
                    throw new BusinessException("La clase está vacía.");
                }
                if(boleto.getClase().length() < 3){
                    throw new BusinessException("Ingrese más de 1 caracteres en el asiento.");
                }
                if(boleto.getClase().length() > 50){
                    throw new BusinessException("La clase no puede tener más de 50 caracteres.");
                }
                //total
                if(String.valueOf(boleto.getTotal()).isEmpty()){
                    throw new BusinessException("El total a pagar está vacío.");
                }
                if(boleto.getTotal() <= 0){
                    throw new BusinessException("El total a pagar no puede ser menor o igual a 0.");
                }
                if((String.valueOf(boleto.getTotal()).length())>10){
                    throw new BusinessException("El total a pagar excede el límite.");
                }
            }
            return repository.saveAll(boletos);

        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Boleto> getBoletos() throws BusinessException {
        try{
            return repository.findAll();
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Boleto getBoletoByID(long id) throws BusinessException, NotFoundException {
        Optional<Boleto> opt = null;
        try{
            opt = repository.findById(id);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el boleto: " + id);
        }
        return opt.get();
    }

    @Override
    public Boleto getBoletoByCodigoFactura(String codigoFactura) throws BusinessException, NotFoundException {
        Optional<Boleto> opt = null;
        try{
            opt = repository.findByCodigoFactura(codigoFactura);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el boleto: " + codigoFactura);
        }
        return opt.get();
    }

    @Override
    public void deleteBoleto(long id) throws BusinessException, NotFoundException {
        Optional<Boleto> opt = null;
        try{
            opt = repository.findById(id);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el boleto: " + id);
        }else{
            try {
                repository.deleteById(id);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }
    @Override
    public Boleto updateBoleto(Boleto boleto) throws BusinessException, NotFoundException {
        Optional<Boleto> opt = null;
        try{
            opt = repository.findById(boleto.getId());
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el boleto: " + boleto.getId());
        }else{
            try {
                //Codigo Factura
                if(boleto.getCodigoFactura().isEmpty()){
                    throw new BusinessException("El código de facturación está vacío.");
                }
                if(boleto.getCodigoFactura().length() < 3){
                    throw new BusinessException("Ingrese más de 3 caracteres en el código de facturación.");
                }
                if(boleto.getCodigoFactura().length() > 10){
                    throw new BusinessException("El código de facturación no puede tener más de 10 caracteres.");
                }
                //Pasajero
                if(boleto.getNombrePasajero().isEmpty()){
                    throw new BusinessException("El nombre del pasajero está vacío.");
                }
                if(boleto.getNombrePasajero().length() < 3){
                    throw new BusinessException("Ingrese más de 3 caracteres en el nombre del pasajero.");
                }
                if(boleto.getNombrePasajero().length() > 50){
                    throw new BusinessException("El nombre del pasajero no puede tener más de 50 caracteres.");
                }
                //Vuelo
                if(boleto.getVuelo().isEmpty()){
                    throw new BusinessException("El vuelo está vacío.");
                }
                if(boleto.getVuelo().length() < 3){
                    throw new BusinessException("Ingrese más de 4 caracteres en el vuelo.");
                }
                if(boleto.getVuelo().length() > 50){
                    throw new BusinessException("El vuelo no puede tener más de 50 caracteres.");
                }
                //Asiento
                if(boleto.getAsiento().isEmpty()){
                    throw new BusinessException("El asiento está vacío.");
                }
                if(boleto.getAsiento().length() < 2){
                    throw new BusinessException("Ingrese más de 1 caracteres en el asiento.");
                }
                if(boleto.getAsiento().length() > 5){
                    throw new BusinessException("El asiento no puede tener más de 5 caracteres.");
                }
                //numero puerto embarque
                if(String.valueOf(boleto.getNumeroPuertaEmbarque()).isEmpty()){
                    throw new BusinessException("La puerta de embarque está vacía.");
                }
                if((String.valueOf(boleto.getNumeroPuertaEmbarque()).length())<2){
                    throw new BusinessException("La puerta de embarque no es correcta.");
                }
                if((String.valueOf(boleto.getNumeroPuertaEmbarque()).length())>4){
                    throw new BusinessException("La puerta de embarque excede el límite.");
                }
                //clase
                if(boleto.getClase().isEmpty()){
                    throw new BusinessException("La clase está vacía.");
                }
                if(boleto.getClase().length() < 3){
                    throw new BusinessException("Ingrese más de 1 caracteres en el asiento.");
                }
                if(boleto.getClase().length() > 50){
                    throw new BusinessException("La clase no puede tener más de 50 caracteres.");
                }
                //total
                if(String.valueOf(boleto.getTotal()).isEmpty()){
                    throw new BusinessException("El total a pagar está vacío.");
                }
                if(boleto.getTotal() <= 0){
                    throw new BusinessException("El total a pagar no puede ser menor o igual a 0.");
                }
                if((String.valueOf(boleto.getTotal()).length())>10){
                    throw new BusinessException("El total a pagar excede el límite.");
                }
                Boleto existingBoleto = new Boleto();
                existingBoleto.setId(boleto.getId());
                existingBoleto.setCodigoFactura(boleto.getCodigoFactura());
                existingBoleto.setNombrePasajero(boleto.getNombrePasajero());
                existingBoleto.setVuelo(boleto.getVuelo());
                existingBoleto.setAsiento(boleto.getAsiento());
                existingBoleto.setNumeroPuertaEmbarque(boleto.getNumeroPuertaEmbarque());
                existingBoleto.setClase(boleto.getClase());
                existingBoleto.setTotal(boleto.getTotal());
                return repository.save(existingBoleto);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }
    private boolean validarCodigo(Boleto boleto) throws BusinessException{
        boolean condicion = false;
        try{
            List<Boleto> listaBoletos = repository.findAll();
            for (Boleto boletos: listaBoletos) {
                if (boleto.getCodigoFactura().equals(boletos.getCodigoFactura())) {
                    condicion = true;
                    break;
                }
            }
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }
        return condicion;
    }
    private boolean validarAsiento(Boleto boleto) throws BusinessException{
        boolean condicion = false;
        try{
            List<Boleto> listaBoletos = repository.findAll();
            for (Boleto boletos: listaBoletos) {
                if ((boleto.getAsiento().equals(boletos.getAsiento())) && (boleto.getVuelo().equals(boletos.getVuelo()))) {
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
