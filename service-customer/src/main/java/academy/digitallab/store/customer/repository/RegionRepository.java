package academy.digitallab.store.customer.repository;


import academy.digitallab.store.customer.repository.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
