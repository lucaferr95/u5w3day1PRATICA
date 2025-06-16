package it.epicode.u5w3day1PRATICA.Repository;

import it.epicode.u5w2dayGESTIONEVIAGGI.Model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DipendenteRepository extends JpaRepository <Dipendente, Integer> , PagingAndSortingRepository <Dipendente, Integer> {
}
