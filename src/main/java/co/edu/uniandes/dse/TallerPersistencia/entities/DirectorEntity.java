package co.edu.uniandes.dse.TallerPersistencia.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class DirectorEntity extends BaseEntity{
    private long id;
    private String name;
    private String nationality;
}
