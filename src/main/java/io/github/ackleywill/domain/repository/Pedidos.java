package io.github.ackleywill.domain.repository;

import io.github.ackleywill.domain.entity.Cliente;
import io.github.ackleywill.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
    // buscar pedidos de um cliente
    List<Pedido> findByCliente(Cliente cliente);


}
