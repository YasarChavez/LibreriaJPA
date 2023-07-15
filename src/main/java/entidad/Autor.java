package entidad;


import javax.persistence.*;

@Entity
@Table (name = "autor")
public class Autor{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "alta")
    private Boolean alta = true;

    public Autor() {
    }

    public Integer getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", alta=" + alta +
                '}';
    }
}
