package co.edu.uniandes.dse.TallerPersistencia.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class MovieEntity extends BaseEntity{
    private long id;
    private String title;
    
}
