package entidad;


import javax.persistence.*;

@Entity
@Table(name = "libro")
public class Libro{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long isbn;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "anio")
    private Integer anio;
    @Column(name = "ejemplares")
    private Integer ejemplares;
    @Column(name = "ejemplaresPrestados")
    private Integer ejemplaresPrestados;
    @Column(name = "ejemplaresRestantes")
    private Integer ejemplaresRestantes;
    @Column(name = "alta")
    private Boolean alta = true;
    @OneToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
    @OneToOne
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;

    public Libro() {
    }


    public long getIsbn() {
        return isbn;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Integer getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public void setEjemplaresPrestados(Integer ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    public Integer getEjemplaresRestantes() {
        return ejemplaresRestantes;
    }

    public void setEjemplaresRestantes(Integer ejemplaresRestantes) {
        this.ejemplaresRestantes = ejemplaresRestantes;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", anio=" + anio +
                ", ejemplares=" + ejemplares +
                ", ejemplaresPrestados=" + ejemplaresPrestados +
                ", ejemplaresRestantes=" + ejemplaresRestantes +
                ", alta=" + alta +
                ", autor=" + autor.getNombre() +
                ", editorial=" + editorial.getNombre() +
                '}';
    }


}
