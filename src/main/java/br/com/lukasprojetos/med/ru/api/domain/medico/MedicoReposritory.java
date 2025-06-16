package br.com.lukasprojetos.med.ru.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoReposritory extends JpaRepository<Medico, Long> {


    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}
