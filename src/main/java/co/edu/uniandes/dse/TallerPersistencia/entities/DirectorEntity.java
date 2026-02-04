package co.edu.uniandes.dse.TallerPersistencia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.util.*;

@Data
@Entity
public class DirectorEntity extends BaseEntity{
    private String name;
    private String nationality;
    
    @OneToMany(mappedBy = "director")
    private List<MovieEntity> movies;
}
