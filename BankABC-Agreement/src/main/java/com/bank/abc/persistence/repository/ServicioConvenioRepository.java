package com.bank.abc.persistence.repository;

import com.bank.abc.persistence.entity.Convenio;
import com.bank.abc.persistence.entity.ServicioConvenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioConvenioRepository extends JpaRepository<ServicioConvenio,Integer> {
    public ServicioConvenio findByConvenioAndOperationName(Convenio convenio,String operationName);

}
