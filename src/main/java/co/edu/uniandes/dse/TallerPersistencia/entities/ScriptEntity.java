package co.edu.uniandes.dse.TallerPersistencia.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class ScriptEntity extends BaseEntity{
    private String name;
    private String originalName;
}
