package entities.partner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Partner {

    @Id
    @GeneratedValue
    private Integer pId;

}
