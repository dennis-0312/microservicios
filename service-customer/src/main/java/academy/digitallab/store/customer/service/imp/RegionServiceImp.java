package academy.digitallab.store.customer.service.imp;

import academy.digitallab.store.customer.repository.RegionRepository;
import academy.digitallab.store.customer.repository.entity.Region;
import academy.digitallab.store.customer.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegionServiceImp implements RegionService {

    @Autowired
    private RegionRepository regionRepository;

    @Override
    public List<Region> findByAll() {
        return regionRepository.findAll();
    }

    @Override
    public Region createRegion(Region region) {
        return regionRepository.save(region);
    }
}
