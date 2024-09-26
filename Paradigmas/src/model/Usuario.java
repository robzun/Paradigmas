package model;

public abstract class Usuario {
    private String nombre;
    private String correo;
    private String telefono;

    Usuario(){}

    Usuario(String nombre){
        this.nombre = nombre;
    }

    Usuario(String nombre, String correo){
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Correo: " + correo ;
    }

    public abstract void saludar();

    public void despedirse(){
        System.out.println("Adiós");
    }
}