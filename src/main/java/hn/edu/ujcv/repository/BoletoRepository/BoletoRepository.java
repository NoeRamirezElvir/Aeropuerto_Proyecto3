package hn.edu.ujcv.repository.BoletoRepository;

import hn.edu.ujcv.entity.Boleto.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoletoRepository extends JpaRepository <Boleto,Long> {
    Optional<Boleto> findByCodigoFactura(String codigoFactura);
}
