package org.serratec.backend.repository;
import org.serratec.backend.entities.LancamentoVendas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<LancamentoVendas, Long> {

}
