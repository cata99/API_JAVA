package tesis.Paschini.Benedictus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tesis.Paschini.Benedictus.model.Donation;

public interface DonationRepository extends JpaRepository<Donation,Long> {
}
