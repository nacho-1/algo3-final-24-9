package ar.uba.fi.algo3;

public abstract class Producto {

    private String nombre;
    private float precio;

    public Producto(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }
    
    public boolean nombreExacto(String nombre) {
    	boolean exacto = this.nombre.equals(nombre);
    	return exacto;
    }
    
    public boolean nombreAproximado(String nombre) {
    	boolean aproximado = this.nombre.startsWith(nombre);
    	return aproximado;
    }
    
    public boolean enRango(double desde, double hasta) {
    	boolean enRango;
    	enRango = (this.precio >= desde) && (this.precio <= hasta);
    	return enRango;
    }

}
