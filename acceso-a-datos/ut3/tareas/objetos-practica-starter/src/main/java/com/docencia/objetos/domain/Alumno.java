package com.docencia.objetos.domain;

public class Alumno {
  private Long id;
  private String nombre;
  private String email;
  private String ciclo;
  
  /**
   * Constructor vacio
   */
  public Alumno() {}
  
  /**
   * Constructor con el id del alumno para busquedas
   * @param id identificador unico del alumno
   */
  public Alumno(Long id) {
    this.id = id;
  }

  /**
   * Constructor con todas las propiedades del alumno
   * @param id identificador del alumno
   * @param nombre nombre del alumno
   * @param email correo electronico del alumno
   * @param ciclo ciclo formativo del alumno
   */
  public Alumno(Long id, String nombre, String email, String ciclo) {
    this.id = id;
    this.nombre = nombre;
    this.email = email;
    this.ciclo = ciclo;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCiclo() {
    return ciclo;
  }

  public void setCiclo(String ciclo) {
    this.ciclo = ciclo;
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Alumno other = (Alumno) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  

}
