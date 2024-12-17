package com.santamariachafloc.denunciaservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.santamariachafloc.denunciaservice.entity.Denuncia;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Integer> {
    List<Denuncia> findByDni(String dni);
}
