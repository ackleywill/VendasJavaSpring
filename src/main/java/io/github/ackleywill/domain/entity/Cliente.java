package io.github.ackleywill.domain.entity;

import javax.persistence.*;
import java.util.Set;

@Entity // Deve ser escaneado como uma tabela do banco de dados
@Table(name = "cliente") // Não necessário se o nome da tabela for igual ao da classe
public class Cliente {

    @Id // indica que é primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // indica o auto incremento
    @Column(name="id") // Relacionar o nome do atributo com o campo no banco de dados
    private Integer id;
    @Column(name="nome", length = 100)
    private String nome;

    // Se utilizar FetchType.EAGER, toda vez que trouxer o cliente vira a listas de pedidos dele
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Pedido> pedidos;

    public Cliente(){
    }

    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Cliente(String nome){
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}

