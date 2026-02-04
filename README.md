# Taller Persistencia
• Justificación Técnica: En el README.md, explica por qué elegiste cada tipo de relación y qué sucede en la base de datos al usar mappedBy.
R: En este caso, se tienen varios tipos de relaciones. Por ejemplo, la que hay entre directores y películas la manejé como @OneToMany para director y @ManyToOne para movies porque un director puede tener varias pelícuas y varias películas un director. Entre género y películas manejé @ManytoMany en ambos sentidos, ya que un género puede tener varias películas asociadas y una película puede ser de varios géneros. Por último, use la relación @OneToOne de películas hacia script (de forma unidireccional como indicaba el diagrama), ya que una película tiene solo un script. Al usar mappedBy en relaciones bidrireccionales (ejemplo de la clase director con el atributo de movies con la relación @OneToMany), lo que sucede en la base de datos es que al consultar la tabla de películas se asocia la llave primaria de director a la tabla, de tal forma que cada película queda asociada a un director_id que aparece como una columna más en el query de la BD.

• Remove on cascade: 
R: Al consultar en internet, la IA de google describió que: "Para eliminar en cascada en Java, especialmente utilizando JPA/Hibernate, se debe configurar el atributo cascade en las anotaciones de relación (@OneToMany, @OneToOne) a CascadeType.REMOVE o CascadeType.ALL. Esto asegura que al eliminar una entidad padre, sus entidades hijas asociadas también se borren automáticamente." Así, en la clase MovieEntity modifiqué la relación que tiene con ScriptEntity (@OneToMany) de tal forma que, al eliminar la instancia de una palícula, también se elimine el script asociado. Al intentar eliminar un director con peliculas asignadas, me aparece el siguiente error: 

"Violación de una restricción de Integridad Referencial: "FKBVS9LEGR1VASNEKR8Q39PHWNI: PUBLIC.MOVIE_ENTITY FOREIGN KEY(DIRECTOR_ID) REFERENCES PUBLIC.DIRECTOR_ENTITY(ID) (CAST(1 AS BIGINT))"
Referential integrity constraint violation: "FKBVS9LEGR1VASNEKR8Q39PHWNI: PUBLIC.MOVIE_ENTITY FOREIGN KEY(DIRECTOR_ID) REFERENCES PUBLIC.DIRECTOR_ENTITY(ID) (CAST(1 AS BIGINT))"; SQL statement:
DELETE FROM DIRECTOR_ENTITY WHERE ID = 1 [23503-224]".

Este comportamiento es deseable para mantener la integridad referencial porque, al eliminar un director que mantiene películas asignadas a través de una llave foránea con el id del director, se generan referencias huérfanas y datos inexistentes. Es decir, al mantener las películas una referencia a una instancia inexistente, el proyecto puede causar inconsistencias en las relaciones entre entidades.


## Enlaces de interés

- [BookstoreBack](https://github.com/Uniandes-isis2603/bookstore-back) -> Repositorio de referencia para el Back
