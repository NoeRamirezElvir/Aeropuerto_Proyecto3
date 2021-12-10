package hn.edu.ujcv.service.EquipajeService;


import hn.edu.ujcv.entity.Equipaje.Equipaje;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;
import hn.edu.ujcv.repository.EquipajeRepository.EquipajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipajeService implements IEquipajeService {
    @Autowired
    private EquipajeRepository repository;

    @Override
    public Equipaje saveEquipaje(Equipaje equipaje) throws BusinessException {
        try{
            //boleto
            if(String.valueOf(equipaje.getBoleto()).isEmpty()){
                throw new BusinessException("El boleto del equipaje viene vacio");
            }
            if(String.valueOf(equipaje.getBoleto()).length() > 5){
                throw new BusinessException("El boleto del equipaje es muy extenso ");
            }
            //pasajero
            if(equipaje.getPasajero().isEmpty()){
                throw new BusinessException("El Nombre del Pasajero del equipaje viene vacio");
            }
            if(equipaje.getPasajero().length() < 3){
                throw new BusinessException("El nombre es muy corto.");
            }
            if(equipaje.getPasajero().length() > 50){
                throw new BusinessException("El nombre es muy extenso.");
            }
            //peso
            if(String.valueOf(equipaje.getPeso()).isEmpty()){
                throw new BusinessException("El peso del equipaje viene vacio ");
            }
            if(equipaje.getPeso() <=0 ){
                throw new BusinessException("El Peso del equipaje no tiene que ser menor o igual a 0 ");
            }
            if(equipaje.getPeso() > 23 ){
                throw new BusinessException("El Peso del equipaje excede la cantidad permitida ");
            }
            //fechaRegistro
            if(String.valueOf(equipaje.getFechaRegistro()).isEmpty()){
                throw new BusinessException("La fecha está vacía.");
            }
            //destino
            if(equipaje.getDestino().isEmpty()){
                throw new BusinessException("El Destino del equipaje viene vacio");
            }
            if(equipaje.getDestino().length() < 4){
                throw new BusinessException("El destino es muy corto.");
            }
            if(equipaje.getDestino().length() > 50){
                throw new BusinessException("El destino es muy extenso.");
            }
            //color
            if(equipaje.getColor().isEmpty()){
                throw new BusinessException("El Color del equipaje viene vacio");
            }
            if(equipaje.getColor().length() < 4){
                throw new BusinessException("El Color es muy corto.");
            }
            if(equipaje.getColor().length() > 10){
                throw new BusinessException("El color es muy extenso.");
            }
            //tamaño
            if(equipaje.getTamaño().isEmpty()){
                throw new BusinessException("El Tamaño del equipaje viene vacio");
            }
            if(equipaje.getTamaño().length() < 5){
                throw new BusinessException("El Tamaño es muy corto.");
            }
            if(equipaje.getTamaño().length() > 10){
                throw new BusinessException("El Tamaño es muy extenso.");
            }
            return repository.save(equipaje);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Equipaje> saveEquipajes(List<Equipaje> equipajes) throws BusinessException {
        try{
            for (Equipaje equipaje: equipajes) {
                //boleto
                if(String.valueOf(equipaje.getBoleto()).isEmpty()){
                    throw new BusinessException("El boleto del equipaje viene vacio");
                }
                if(String.valueOf(equipaje.getBoleto()).length() > 5){
                    throw new BusinessException("El boleto del equipaje es muy extenso ");
                }
                //pasajero
                if(equipaje.getPasajero().isEmpty()){
                    throw new BusinessException("El Nombre del Pasajero del equipaje viene vacio");
                }
                if(equipaje.getPasajero().length() < 3){
                    throw new BusinessException("El nombre es muy corto.");
                }
                if(equipaje.getPasajero().length() > 50){
                    throw new BusinessException("El nombre es muy extenso.");
                }
                //peso
                if(String.valueOf(equipaje.getPeso()).isEmpty()){
                    throw new BusinessException("El peso del equipaje viene vacio ");
                }
                if(equipaje.getPeso() <=0 ){
                    throw new BusinessException("El Peso del equipaje no tiene que ser menor o igual a 0 ");
                }
                if(equipaje.getPeso() > 23 ){
                    throw new BusinessException("El Peso del equipaje excede la cantidad permitida ");
                }
                //fechaRegistro
                if(String.valueOf(equipaje.getFechaRegistro()).isEmpty()){
                    throw new BusinessException("La fecha está vacía.");
                }
                //destino
                if(equipaje.getDestino().isEmpty()){
                    throw new BusinessException("El Destino del equipaje viene vacio");
                }
                if(equipaje.getDestino().length() < 4){
                    throw new BusinessException("El destino es muy corto.");
                }
                if(equipaje.getDestino().length() > 50){
                    throw new BusinessException("El destino es muy extenso.");
                }
                //color
                if(equipaje.getColor().isEmpty()){
                    throw new BusinessException("El Color del equipaje viene vacio");
                }
                if(equipaje.getColor().length() < 4){
                    throw new BusinessException("El Color es muy corto.");
                }
                if(equipaje.getColor().length() > 10){
                    throw new BusinessException("El color es muy extenso.");
                }
                //tamaño
                if(equipaje.getTamaño().isEmpty()){
                    throw new BusinessException("El Tamaño del equipaje viene vacio");
                }
                if(equipaje.getTamaño().length() < 5){
                    throw new BusinessException("El Tamaño es muy corto.");
                }
                if(equipaje.getTamaño().length() > 10){
                    throw new BusinessException("El Tamaño es muy extenso.");
                }
            }
            return repository.saveAll(equipajes);
        }catch(Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Equipaje> getEquipajes() throws BusinessException {
        try{
            return repository.findAll();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Equipaje getEquipajeById(long id) throws BusinessException, NotFoundException {
        Optional<Equipaje> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if(!opt.isPresent()){
            throw new NotFoundException("No se encontro el Equipaje: " + id);
        }
        return opt.get();
    }

    @Override
    public Equipaje getEquipajeByPasajero(String name) throws BusinessException, NotFoundException {
        Optional<Equipaje> opt = null;
        try{
            opt = repository.findByPasajero(name);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if(!opt.isPresent()){
            throw new NotFoundException("No se encontro el Equipaje de : " + name);
        }
        return opt.get();
    }

    @Override
    public void deleteEquipaje(long id) throws BusinessException, NotFoundException {
        Optional<Equipaje> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if(!opt.isPresent()){
            throw new NotFoundException("No se encontro el Equipaje: " + id);
        } else {
            try{
                repository.deleteById(id);
            }catch (Exception e1){
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    @Override
    public Equipaje updateEquipaje(Equipaje equipaje) throws BusinessException, NotFoundException {
        Optional<Equipaje> opt = null;
        try{
            //id
            if (String.valueOf(equipaje.getId()).isEmpty()) {
                throw new BusinessException("El ID del equipaje viene vacio");
            }
            opt = repository.findById(equipaje.getId());
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if(!opt.isPresent()){
            throw new BusinessException("No se encontro el Equipaje: " + equipaje.getId());
        } else {
            try {
                //boleto
                if (String.valueOf(equipaje.getBoleto()).isEmpty()) {
                    throw new BusinessException("El boleto del equipaje viene vacio");
                }
                if (String.valueOf(equipaje.getBoleto()).length() > 5) {
                    throw new BusinessException("El boleto del equipaje es muy extenso ");
                }
                //pasajero
                if (equipaje.getPasajero().isEmpty()) {
                    throw new BusinessException("El Nombre del Pasajero del equipaje viene vacio");
                }
                if (equipaje.getPasajero().length() < 3) {
                    throw new BusinessException("El nombre es muy corto.");
                }
                if (equipaje.getPasajero().length() > 50) {
                    throw new BusinessException("El nombre es muy extenso.");
                }
                //peso
                if (String.valueOf(equipaje.getPeso()).isEmpty()) {
                    throw new BusinessException("El peso del equipaje viene vacio ");
                }
                if (equipaje.getPeso() <= 0) {
                    throw new BusinessException("El Peso del equipaje no tiene que ser menor o igual a 0 ");
                }
                if (equipaje.getPeso() > 23) {
                    throw new BusinessException("El Peso del equipaje excede la cantidad permitida ");
                }
                //fechaRegistro
                if (String.valueOf(equipaje.getFechaRegistro()).isEmpty()) {
                    throw new BusinessException("La fecha está vacía.");
                }
                //destino
                if (equipaje.getDestino().isEmpty()) {
                    throw new BusinessException("El Destino del equipaje viene vacio");
                }
                if (equipaje.getDestino().length() < 4) {
                    throw new BusinessException("El destino es muy corto.");
                }
                if (equipaje.getDestino().length() > 50) {
                    throw new BusinessException("El destino es muy extenso.");
                }
                //color
                if (equipaje.getColor().isEmpty()) {
                    throw new BusinessException("El Color del equipaje viene vacio");
                }
                if (equipaje.getColor().length() < 4) {
                    throw new BusinessException("El Color es muy corto.");
                }
                if (equipaje.getColor().length() > 10) {
                    throw new BusinessException("El color es muy extenso.");
                }
                //tamaño
                if (equipaje.getTamaño().isEmpty()) {
                    throw new BusinessException("El Tamaño del equipaje viene vacio");
                }
                if (equipaje.getTamaño().length() < 5) {
                    throw new BusinessException("El Tamaño es muy corto.");
                }
                if (equipaje.getTamaño().length() > 10) {
                    throw new BusinessException("El Tamaño es muy extenso.");
                }
                Equipaje equipajeEx = new Equipaje();
                equipajeEx.setId(equipaje.getId());
                equipajeEx.setBoleto(equipaje.getBoleto());
                equipajeEx.setPasajero(equipaje.getPasajero());
                equipajeEx.setPeso(equipaje.getPeso());
                equipajeEx.setFechaRegistro(equipaje.getFechaRegistro());
                equipajeEx.setDestino(equipaje.getDestino());
                equipajeEx.setColor(equipaje.getColor());
                equipajeEx.setTamaño(equipaje.getTamaño());
                return repository.save(equipajeEx);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }
}
