package academy.digitallab.store.customer.service;


import academy.digitallab.store.customer.repository.entity.Region;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegionService {
    public List<Region> findByAll();
    public Region createRegion(Region region);
}
