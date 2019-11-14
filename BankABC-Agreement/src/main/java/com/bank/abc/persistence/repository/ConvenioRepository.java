package com.bank.abc.persistence.repository;

import com.bank.abc.persistence.entity.Convenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvenioRepository extends JpaRepository<Convenio,Integer> {

    public Convenio findByConvenio(String convenio);
}
