package academy.digitallab.store.customer.controller;


import academy.digitallab.store.customer.repository.entity.Region;
import academy.digitallab.store.customer.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/regions")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping("/all")
    public ResponseEntity<List<Region>> listRegion() {
        List<Region> regions = regionService.findByAll();
        if (regions == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(regions);
        }
    }
}
