package io.github.ackleywill.domain.repository;

import io.github.ackleywill.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    //queries methods
    List<Cliente> findByNomeLike(String nome);

    List<Cliente> findByNomeOrIdOrderById(String nome, Integer id);

    //Cliente findOneByNome(String );
    //void deleteByNome(String nome);
    Boolean existsByNome(String nome);

    ////////// Utilizando @Query - Pode utilizar HQL ou SQL

    @Query(value = " select c from Cliente c where c.nome like :nome ")
    //@Query(value = " select * from cliente c where c.nome like '%nome%' ", nativeQuery = true)
    List<Cliente> encontrarPorNome(@Param("nome") String nome);

    @Query(value = "delete from Cliente c where c.nome = :nome")
    @Modifying
    void deletarPorNome(String nome);

    @Query(" select c from Cliente c left join fetch c.pedidos p where c.id = :id ")
    Cliente findClienteFetchPedidos(@Param("id") Integer Id);



}
