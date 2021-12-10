package hn.edu.ujcv.service.VueloService;

import hn.edu.ujcv.entity.Vuelo.Vuelo;
import hn.edu.ujcv.exceptions.BusinessException;
import hn.edu.ujcv.exceptions.NotFoundException;
import hn.edu.ujcv.repository.VueloRepository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VueloService implements IVueloService{
    @Autowired
    private VueloRepository repository;
    @Override
    public Vuelo saveVuelo(Vuelo vuelo) throws BusinessException {
        try{
            //fecha
            if(String.valueOf(vuelo.getFecha()).isEmpty()){
                throw new BusinessException("La fecha está vacía.");
            }
            if(String.valueOf(vuelo.getFecha()).length() != 10){
                throw new BusinessException("Tamaño de  fecha incorrecta (dd/MM/yyyy)");
            }
            //lugarPartida
            if(vuelo.getLugarPartida().isEmpty()){
                throw new BusinessException("Lugar de partida viene vacio");
            }
            if(vuelo.getLugarPartida().length() < 4){
                throw new BusinessException("Lugar de partida es muy corto Ingrese mas de 3 caracteres.");
            }
            if(vuelo.getLugarPartida().length() > 50){
                throw new BusinessException("Lugar de partida es muy extenso.");
            }
            //horadespegue
            if (vuelo.getHoraP().isEmpty()) {
                throw new BusinessException("Hora de despegue está vacío.");
            }
            if (vuelo.getHoraP() == "00:00") {
                throw new BusinessException("Hora de despegue invalida! Ingrese una hora correcta");
            }
            if (vuelo.getHoraP().length() != 5) {
                throw new BusinessException("Hora de despegue invalida! Ingrese el formato (00:00)");
            }
            //destino
            if(vuelo.getDestino().isEmpty()){
                throw new BusinessException("El Destino viene vacio");
            }
            if(vuelo.getDestino().length() < 4){
                throw new BusinessException("El destino es muy corto Ingrese mas de 3 caracteres.");
            }
            if(vuelo.getDestino().length() > 50){
                throw new BusinessException("El destino es muy extenso.");
            }
            //aerolinea
            if(vuelo.getAerolinea().isEmpty()){
                throw new BusinessException("La aerolínea está vacía.");
            }
            if(vuelo.getAerolinea().length() < 4){
                throw new BusinessException("Ingrese más de 4 caracteres en la aerolínea.");
            }
            if(vuelo.getAerolinea().length()>50){
                throw new BusinessException("La aerolínea no puede tener más de 50 caracteres.");
            }
            //tiempoEstimado
            if (vuelo.getTiempoE().isEmpty()) {
                throw new BusinessException("El tiempo estimado está vacío.");
            }
            if (vuelo.getTiempoE() == "00:00") {
                throw new BusinessException("Tiempo estimado invalida! Ingrese una hora correcta");
            }
            if (vuelo.getTiempoE().length() != 5) {
                throw new BusinessException("Tiempo estimado invalida! Ingrese el formato (00:00)");
            }
            //descripcion
            if (vuelo.getDescripcion().isEmpty()) {
                throw new BusinessException("La descripción está vacía.");
            }
            if (vuelo.getDescripcion().length() < 3) {
                throw new BusinessException("Ingrese más de 3 caracteres en la descripción.");
            }
            if (vuelo.getDescripcion().length() > 50) {
                throw new BusinessException("La descripción no puede tener más de 50 caracteres.");
            }
            return repository.save(vuelo);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Vuelo> saveVuelos(List<Vuelo> vueloList) throws BusinessException {
        try{
            for (Vuelo vuelo:vueloList) {
                //fecha
                if(String.valueOf(vuelo.getFecha()).isEmpty()){
                    throw new BusinessException("La fecha está vacía.");
                }
                if(String.valueOf(vuelo.getFecha()).length() != 10){
                    throw new BusinessException("Tamaño de  fecha incorrecta (dd/MM/yyyy)");
                }
                //lugarPartida
                if(vuelo.getLugarPartida().isEmpty()){
                    throw new BusinessException("Lugar de partida viene vacio");
                }
                if(vuelo.getLugarPartida().length() < 4){
                    throw new BusinessException("Lugar de partida es muy corto Ingrese mas de 3 caracteres.");
                }
                if(vuelo.getLugarPartida().length() > 50){
                    throw new BusinessException("Lugar de partida es muy extenso.");
                }
                //horadespegue
                if (vuelo.getHoraP().isEmpty()) {
                    throw new BusinessException("Hora de despegue está vacío.");
                }
                if (vuelo.getHoraP() == "00:00") {
                    throw new BusinessException("Hora de despegue invalida! Ingrese una hora correcta");
                }
                if (vuelo.getHoraP().length() != 5) {
                    throw new BusinessException("Hora de despegue invalida! Ingrese el formato (00:00)");
                }
                //destino
                if(vuelo.getDestino().isEmpty()){
                    throw new BusinessException("El Destino viene vacio");
                }
                if(vuelo.getDestino().length() < 4){
                    throw new BusinessException("El destino es muy corto Ingrese mas de 3 caracteres.");
                }
                if(vuelo.getDestino().length() > 50){
                    throw new BusinessException("El destino es muy extenso.");
                }
                //aerolinea
                if(vuelo.getAerolinea().isEmpty()){
                    throw new BusinessException("La aerolínea está vacía.");
                }
                if(vuelo.getAerolinea().length() < 4){
                    throw new BusinessException("Ingrese más de 4 caracteres en la aerolínea.");
                }
                if(vuelo.getAerolinea().length()>50){
                    throw new BusinessException("La aerolínea no puede tener más de 50 caracteres.");
                }
                //tiempoEstimado
                if (vuelo.getTiempoE().isEmpty()) {
                    throw new BusinessException("El tiempo estimado está vacío.");
                }
                if (vuelo.getTiempoE() == "00:00") {
                    throw new BusinessException("Tiempo estimado invalida! Ingrese una hora correcta");
                }
                if (vuelo.getTiempoE().length() != 5) {
                    throw new BusinessException("Tiempo estimado invalida! Ingrese el formato (00:00)");
                }
                //descripcion
                if (vuelo.getDescripcion().isEmpty()) {
                    throw new BusinessException("La descripción está vacía.");
                }
                if (vuelo.getDescripcion().length() < 3) {
                    throw new BusinessException("Ingrese más de 3 caracteres en la descripción.");
                }
                if (vuelo.getDescripcion().length() > 50) {
                    throw new BusinessException("La descripción no puede tener más de 50 caracteres.");
                }
            }
            return repository.saveAll(vueloList);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Vuelo> getVuelos() throws BusinessException {
        try{
            return repository.findAll();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Vuelo getVueloById(long id) throws BusinessException, NotFoundException {
        Optional<Vuelo> opt = null;
        if (opt.isPresent()){
            try{
                opt = repository.findById(id);
            }catch (Exception e){
                throw new BusinessException(e.getMessage());
            }
        }
        if (!opt.isPresent()){
            throw new NotFoundException("No se encontro el Vuelo: " + id);
        }
        return opt.get();
    }

    @Override
    public Vuelo getVueloByDestino(String destino) throws BusinessException, NotFoundException {
        Optional<Vuelo> opt = null;
        try{
            opt = repository.findByDestino(destino);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()){
            throw new NotFoundException("No se encontro el Vuelo con destino a: "+ destino);
        }
        return opt.get();
    }

    @Override
    public void deleteVuelo(long id) throws BusinessException, NotFoundException {
        Optional<Vuelo> opt = null;
        try{
            if (String.valueOf(id).isEmpty()) {
                throw new BusinessException("ID del vuelo viene vacio");
            }
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()){
            throw new NotFoundException("No se encontro el Vuelo: " + id);
        }else{
            try{
                repository.deleteById(id);
            }catch (Exception e1){
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    @Override
    public Vuelo updateVuelo(Vuelo vuelo) throws BusinessException, NotFoundException {
        Optional<Vuelo> opt = null;
        try{
            if (String.valueOf(vuelo.getId()).isEmpty()) {
                throw new BusinessException("ID del vuelo viene vacio");
            }
            opt = repository.findById(vuelo.getId());
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()){
            throw new NotFoundException("No se encontro el Vuelo: " + vuelo.getId());
        }else{
            try{
                //fecha
                if(String.valueOf(vuelo.getFecha()).isEmpty()){
                    throw new BusinessException("La fecha está vacía.");
                }
                if(String.valueOf(vuelo.getFecha()).length() != 10){
                    throw new BusinessException("Tamaño de  fecha incorrecta (dd/MM/yyyy)");
                }
                //lugarPartida
                if(vuelo.getLugarPartida().isEmpty()){
                    throw new BusinessException("Lugar de partida viene vacio");
                }
                if(vuelo.getLugarPartida().length() < 4){
                    throw new BusinessException("Lugar de partida es muy corto Ingrese mas de 3 caracteres.");
                }
                if(vuelo.getLugarPartida().length() > 50){
                    throw new BusinessException("Lugar de partida es muy extenso.");
                }
                //horadespegue
                if (vuelo.getHoraP().isEmpty()) {
                    throw new BusinessException("Hora de despegue está vacío.");
                }
                if (vuelo.getHoraP() == "00:00") {
                    throw new BusinessException("Hora de despegue invalida! Ingrese una hora correcta");
                }
                if (vuelo.getHoraP().length() != 5) {
                    throw new BusinessException("Hora de despegue invalida! Ingrese el formato (00:00)");
                }
                //destino
                if(vuelo.getDestino().isEmpty()){
                    throw new BusinessException("El Destino viene vacio");
                }
                if(vuelo.getDestino().length() < 4){
                    throw new BusinessException("El destino es muy corto Ingrese mas de 3 caracteres.");
                }
                if(vuelo.getDestino().length() > 50){
                    throw new BusinessException("El destino es muy extenso.");
                }
                //aerolinea
                if(vuelo.getAerolinea().isEmpty()){
                    throw new BusinessException("La aerolínea está vacía.");
                }
                if(vuelo.getAerolinea().length() < 4){
                    throw new BusinessException("Ingrese más de 4 caracteres en la aerolínea.");
                }
                if(vuelo.getAerolinea().length()>50){
                    throw new BusinessException("La aerolínea no puede tener más de 50 caracteres.");
                }
                //tiempoEstimado
                if (vuelo.getTiempoE().isEmpty()) {
                    throw new BusinessException("El tiempo estimado está vacío.");
                }
                if (vuelo.getTiempoE() == "00:00") {
                    throw new BusinessException("Tiempo estimado invalida! Ingrese una hora correcta");
                }
                if (vuelo.getTiempoE().length() != 5) {
                    throw new BusinessException("Tiempo estimado invalida! Ingrese el formato (00:00)");
                }
                //descripcion
                if (vuelo.getDescripcion().isEmpty()) {
                    throw new BusinessException("La descripción está vacía.");
                }
                if (vuelo.getDescripcion().length() < 3) {
                    throw new BusinessException("Ingrese más de 3 caracteres en la descripción.");
                }
                if (vuelo.getDescripcion().length() > 50) {
                    throw new BusinessException("La descripción no puede tener más de 50 caracteres.");
                }
                Vuelo vueloEx = new Vuelo();
                vueloEx.setId(vuelo.getId());
                vueloEx.setFecha(vuelo.getFecha());
                vueloEx.setLugarPartida(vuelo.getLugarPartida());
                vueloEx.setHoraP(vuelo.getHoraP());
                vueloEx.setDestino(vuelo.getDestino());
                vueloEx.setAerolinea(vuelo.getAerolinea());
                vueloEx.setTiempoE(vuelo.getTiempoE());
                vueloEx.setDescripcion(vuelo.getDescripcion());
                return repository.save(vueloEx);
            }catch (Exception e1){
                throw new BusinessException(e1.getMessage());
            }
        }
    }
}
