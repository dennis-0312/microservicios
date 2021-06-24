package academy.digitallab.store.customer.repository.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "tbl_regions")
@Data
public class Region implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
