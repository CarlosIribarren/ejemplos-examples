package oiasso.system.examples.security.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import oiasso.system.examples.security.entitys.Nota;

public interface NotaDao extends JpaRepository<Nota, Integer> {

}
