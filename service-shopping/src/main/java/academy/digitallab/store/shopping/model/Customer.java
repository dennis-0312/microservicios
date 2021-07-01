package academy.digitallab.store.shopping.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String numberID;
    private String firstName;
    private String lastName;
    private String email;
    private String photoUrl;
    private String state;
    private Region region;
}
