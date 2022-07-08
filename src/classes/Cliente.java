package classes;

public class Cliente {

    private String dni;
    private String email;
    private String nombre;
    private String apellidos;
    private String contrasenia;
    private boolean activo;

    public Cliente(String dni, String email, String nombre, 
                    String apellidos, String contrasenia, boolean activo){
        this.dni = dni;
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasenia = contrasenia;
        this.activo = activo;
    }


    public Cliente(String dni, String email, String nombre, String apellidos, String contrasenia) {
        this.dni = dni;
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasenia = contrasenia;
        this.activo = true;
    }


    public String getDNI() {
        return this.dni;
    }

    public void setDNI(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isActivo() {
        return this.activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Dni:" + this.dni + " Nombre:" + this.nombre + "Apellidos: " + this.apellidos;
    }



}