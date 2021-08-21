package br.com.alura.mudi_springmvc.mudi.repository;

import br.com.alura.mudi_springmvc.mudi.model.Pedido;
import br.com.alura.mudi_springmvc.mudi.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    //@Query("SELECT * FROM PEDIDO p WHERE p.statusPedido = :statusPedido")
    List<Pedido> findByStatus(StatusPedido statusPedido);
}
