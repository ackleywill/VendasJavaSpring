package io.github.ackleywill;

import io.github.ackleywill.domain.entity.Cliente;
import io.github.ackleywill.domain.entity.Pedido;
import io.github.ackleywill.domain.repository.Clientes;
import io.github.ackleywill.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes,
                                  @Autowired Pedidos pedidos){
        return args -> {
            System.out.println("Salvando clientes");
            clientes.save(new Cliente("Ackley"));
            clientes.save(new Cliente("Outro"));

            Cliente fulano = new Cliente("Fulano");
            clientes.save(fulano);

            List<Cliente> todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            Pedido p = new Pedido();
            p.setCliente(fulano);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));

            pedidos.save(p);

            pedidos.findByCliente(fulano).forEach(System.out::println);


            /*Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
            System.out.println(cliente);
            System.out.println(cliente.getPedidos());*/



/*            System.out.println("Buscando cliente");
            clientes.findByNomeLike("Ack").forEach(System.out::println);

            System.out.println("Procurando a existencia");
            boolean existe = clientes.existsByNome("Ackley");
            System.out.println("Existe um nome? " + existe);

            System.out.println("Buscando por nome com @Query");
            List<Cliente> result = clientes.encontrarPorNome("Ackley");
            result.forEach(System.out::println);*/
        };
    }

    public static void main(String[] args){
        SpringApplication.run(VendasApplication.class, args);
    }

}
