package co.edu.uniandes.dse.TallerPersistencia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import java.util.*;

@Data
@Entity
public class GenreEntity extends BaseEntity{
    private String name;

    @ManyToMany
    private List<MovieEntity> movies;
}
