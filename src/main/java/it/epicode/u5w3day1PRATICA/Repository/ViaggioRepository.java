package it.epicode.u5w3day1PRATICA.Repository;

import it.epicode.u5w3day1PRATICA.Model.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViaggioRepository extends JpaRepository<Viaggio, Integer> {
}
