package hn.edu.ujcv.service.AeronaveService;

import hn.edu.ujcv.entity.Aeronave.Aeronave;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;
import hn.edu.ujcv.repository.AeronaveRepository.AeronaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AeronaveService implements IAeronaveService {
   @Autowired
    private AeronaveRepository repository;
   @Override
    public Aeronave saveAeronave(Aeronave aeronave)throws BusinessException{
       try{
           //modelo
           if(aeronave.getModelo().isEmpty()){
               throw new BusinessException("El modelo está vacío.");
           }
           if(aeronave.getModelo().length() < 4){
               throw new BusinessException("Ingrese más de 4 caracteres en el modelo.");
           }
           if(aeronave.getModelo().length()>50){
               throw new BusinessException("El modelo no puede tener más de 50 caracteres.");
           }
           //Fabricante
           if(aeronave.getFabricante().isEmpty()){
               throw new BusinessException("El fabricante está vacío.");
           }
           if(aeronave.getFabricante().length() < 4){
               throw new BusinessException("Ingrese más de 4 caracteres en el fabricante.");
           }
           if(aeronave.getFabricante().length()>50){
               throw new BusinessException("El fabricante no puede tener más de 50 caracteres.");
           }
           //aerolinea
           if(aeronave.getAerolinea().isEmpty()){
               throw new BusinessException("La aerolínea está vacía.");
           }
           if(aeronave.getAerolinea().length() < 4){
               throw new BusinessException("Ingrese más de 4 caracteres en la aerolínea.");
           }
           if(aeronave.getAerolinea().length()>50){
               throw new BusinessException("La aerolínea no puede tener más de 50 caracteres.");
           }
           //tamaño
           if(String.valueOf(aeronave.getTamaño()).isEmpty()){
               throw new BusinessException("El tamaño está vacío.");
           }
           if(aeronave.getTamaño() <= 1){
               throw new BusinessException("La aeronave es demasiado pequeña.");
           }
           if(aeronave.getTamaño()>80){
               throw new BusinessException("La aeronave es demasiado grande.");
           }
           //capacidad
           if(String.valueOf(aeronave.getCapacidad()).isEmpty()){
               throw new BusinessException("la capacidad está vacía.");
           }
           if(aeronave.getCapacidad() <= 1){
               throw new BusinessException("La capacidad es demasiado pequeña.");
           }
           if(aeronave.getCapacidad()>900){
               throw new BusinessException("La capacidad súpera el límite establecido");
           }
           //tipo
           if(aeronave.getTipo().isEmpty()){
               throw new BusinessException("El tipo de aeronave está vacío.");
           }
           if(aeronave.getTipo().length() < 4){
               throw new BusinessException("Ingrese más de 4 caracteres en el tipo de aeronave.");
           }
           if(aeronave.getTipo().length()>50){
               throw new BusinessException("El tipo de aeronave no puede tener más de 50 caracteres.");
           }
           return repository.save(aeronave);

       }catch(Exception e){
           throw new BusinessException(e.getMessage());
       }
   }
    @Override
    public List<Aeronave> saveAeronaves(List<Aeronave> aeronaves)throws BusinessException{
       try{
           for (Aeronave aeronave: aeronaves) {
               //modelo
               if(aeronave.getModelo().isEmpty()){
                   throw new BusinessException("El modelo está vacío.");
               }
               if(aeronave.getModelo().length() < 4){
                   throw new BusinessException("Ingrese más de 4 caracteres en el modelo.");
               }
               if(aeronave.getModelo().length()>50){
                   throw new BusinessException("El modelo no puede tener más de 50 caracteres.");
               }
               //Descripcion
               if(aeronave.getFabricante().isEmpty()){
                   throw new BusinessException("El fabricante está vacío.");
               }
               if(aeronave.getFabricante().length() < 4){
                   throw new BusinessException("Ingrese más de 4 caracteres en el fabricante.");
               }
               if(aeronave.getFabricante().length()>50){
                   throw new BusinessException("El fabricante no puede tener más de 50 caracteres.");
               }
               //aerolinea
               if(aeronave.getAerolinea().isEmpty()){
                   throw new BusinessException("La aerolínea está vacía.");
               }
               if(aeronave.getAerolinea().length() < 4){
                   throw new BusinessException("Ingrese más de 4 caracteres en la aerolínea.");
               }
               if(aeronave.getAerolinea().length()>50){
                   throw new BusinessException("La aerolínea no puede tener más de 50 caracteres.");
               }
               //tamaño
               if(String.valueOf(aeronave.getTamaño()).isEmpty()){
                   throw new BusinessException("El tamaño está vacío.");
               }
               if(aeronave.getTamaño() <= 1){
                   throw new BusinessException("La aeronave es demasiado pequeña.");
               }
               if(aeronave.getTamaño()>80){
                   throw new BusinessException("La aeronave es demasiado grande.");
               }
               //capacidad
               if(String.valueOf(aeronave.getCapacidad()).isEmpty()){
                   throw new BusinessException("la capacidad está vacía.");
               }
               if(aeronave.getCapacidad() <= 1){
                   throw new BusinessException("La capacidad es demasiado pequeña.");
               }
               if(aeronave.getCapacidad()>900){
                   throw new BusinessException("La capacidad súpera el límite establecido");
               }
               //tipo
               if(aeronave.getTipo().isEmpty()){
                   throw new BusinessException("El tipo de aeronave está vacío.");
               }
               if(aeronave.getTipo().length() < 4){
                   throw new BusinessException("Ingrese más de 4 caracteres en el tipo de aeronave.");
               }
               if(aeronave.getTipo().length()>50){
                   throw new BusinessException("El tipo de aeronave no puede tener más de 50 caracteres.");
               }
           }
           return repository.saveAll(aeronaves);
       }catch(Exception e){
           throw new BusinessException(e.getMessage());
       }
    }
    @Override
    public List<Aeronave> getAeronaves() throws BusinessException {
       try{
           return repository.findAll();
       }catch(Exception e){
           throw new BusinessException(e.getMessage());
       }
    }
    @Override
    public Aeronave getAeronaveByID(long id) throws BusinessException,NotFoundException{
       Optional<Aeronave> opt = null;
       try{
           opt = repository.findById(id);
       }catch(Exception e){
           throw new BusinessException(e.getMessage());
       }if(!opt.isPresent()){
           throw new NotFoundException("No se encontró la aeronave: " + id);
        }
       return opt.get();
    }
    @Override
    public Aeronave getAeronaveByModelo(String modelo)throws BusinessException,NotFoundException{
        Optional<Aeronave> opt = null;
        try{
            opt = repository.findFirstByModelo(modelo);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }if(!opt.isPresent()){
            throw new NotFoundException("No se encontró la aeronave: " + modelo);
        }
        return opt.get();
    }
    @Override
    public void deleteAeronave(long id) throws BusinessException,NotFoundException {
        Optional<Aeronave> opt = null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la aeronave: " + id);
        } else {
            try {
                repository.deleteById(id);
            } catch (Exception e) {
                throw new BusinessException(e.getMessage());
            }
        }
    }
    @Override
    public Aeronave updateAeronave(Aeronave aeronave)throws BusinessException,NotFoundException{
        Optional<Aeronave> opt = null;
        try{
            opt = repository.findById(aeronave.getId());
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }if(!opt.isPresent()){
            throw new NotFoundException("No se encontró la aeronave: " + aeronave.getId());
        }else{
            try{
                //modelo
                if(aeronave.getModelo().isEmpty()){
                    throw new BusinessException("El modelo está vacío.");
                }
                if(aeronave.getModelo().length() < 4){
                    throw new BusinessException("Ingrese más de 4 caracteres en el modelo.");
                }
                if(aeronave.getModelo().length()>50){
                    throw new BusinessException("El modelo no puede tener más de 50 caracteres.");
                }
                //Descripcion
                if(aeronave.getFabricante().isEmpty()){
                    throw new BusinessException("El fabricante está vacío.");
                }
                if(aeronave.getFabricante().length() < 4){
                    throw new BusinessException("Ingrese más de 4 caracteres en el fabricante.");
                }
                if(aeronave.getFabricante().length()>50){
                    throw new BusinessException("El fabricante no puede tener más de 50 caracteres.");
                }
                //aerolinea
                if(aeronave.getAerolinea().isEmpty()){
                    throw new BusinessException("La aerolínea está vacía.");
                }
                if(aeronave.getAerolinea().length() < 4){
                    throw new BusinessException("Ingrese más de 4 caracteres en la aerolínea.");
                }
                if(aeronave.getAerolinea().length()>50){
                    throw new BusinessException("La aerolínea no puede tener más de 50 caracteres.");
                }
                //tamaño
                if(String.valueOf(aeronave.getTamaño()).isEmpty()){
                    throw new BusinessException("El tamaño está vacío.");
                }
                if(aeronave.getTamaño() <= 1){
                    throw new BusinessException("La aeronave es demasiado pequeña.");
                }
                if(aeronave.getTamaño()>80){
                    throw new BusinessException("La aeronave es demasiado grande.");
                }
                //capacidad
                if(String.valueOf(aeronave.getCapacidad()).isEmpty()){
                    throw new BusinessException("la capacidad está vacía.");
                }
                if(aeronave.getCapacidad() <= 1){
                    throw new BusinessException("La capacidad es demasiado pequeña.");
                }
                if(aeronave.getCapacidad()>900){
                    throw new BusinessException("La capacidad súpera el límite establecido");
                }
                //tipo
                if(aeronave.getTipo().isEmpty()){
                    throw new BusinessException("El tipo de aeronave está vacío.");
                }
                if(aeronave.getTipo().length() < 4){
                    throw new BusinessException("Ingrese más de 4 caracteres en el tipo de aeronave.");
                }
                if(aeronave.getTipo().length()>50){
                    throw new BusinessException("El tipo de aeronave no puede tener más de 50 caracteres.");
                }
                Aeronave existingAeronave = new Aeronave();
                existingAeronave.setId(aeronave.getId());
                existingAeronave.setModelo(aeronave.getModelo());
                existingAeronave.setFabricante(aeronave.getFabricante());
                existingAeronave.setAerolinea(aeronave.getAerolinea());
                existingAeronave.setTamaño(aeronave.getTamaño());
                existingAeronave.setCapacidad(aeronave.getCapacidad());
                existingAeronave.setTipo(aeronave.getTipo());

                return repository.save(existingAeronave);
            }catch(Exception e1){
                throw new BusinessException(e1.getMessage());
            }
        }
    }

}
