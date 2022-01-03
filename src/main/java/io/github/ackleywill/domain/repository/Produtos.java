package io.github.ackleywill.domain.repository;

import io.github.ackleywill.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos  extends JpaRepository <Produto, Integer>{

}
