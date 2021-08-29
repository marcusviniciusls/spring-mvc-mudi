package br.com.alura.mudi_springmvc.mudi.repository;

import br.com.alura.mudi_springmvc.mudi.model.Pedido;
import br.com.alura.mudi_springmvc.mudi.model.StatusPedido;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Cacheable("pedidos")
    List<Pedido> findByStatus(StatusPedido statusPedido, Pageable sort);

    @Query("SELECT p FROM Pedido p JOIN p.user u WHERE u.username = :username")
    List<Pedido> findAllByUsuario(@Param("username") String username);

    @Query("SELECT p FROM Pedido p JOIN p.user u WHERE u.username = :username and p.status = :status")
    List<Pedido> findByStatusUser(@Param("status") StatusPedido statusPedido, @Param("username") String username);
}
