package co.edu.uniandes.dse.TallerPersistencia.entities;

import java.lang.reflect.Array;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import java.util.*;

@Data
@Entity
public class MovieEntity extends BaseEntity{
    private String title;

    @ManyToOne
    private DirectorEntity director;

    @OneToOne
    private ScriptEntity script;

    @ManyToMany
    private List<GenreEntity> genres;
}
