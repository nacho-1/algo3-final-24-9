package ar.uba.fi.algo3;

import java.util.LinkedList;
import java.util.List;

public class Buscador {

    private List<Producto> productosLibreria;
    private List<Producto> productosDeporte;

    public Buscador() {
        this.productosLibreria = new LinkedList<>();
        this.productosDeporte = new LinkedList<>();
    }

    public void agregarProducto(ProductoLibreria producto) {
        this.productosLibreria.add(producto);
    }
    
    public void agregarProducto(ProductoDeporte producto) {
    	this.productosDeporte.add(producto);
    }
    
    private List<Producto> stock(){
    	/* en caso de agregar una nueva categora hay que agregar otro addAll aca */
    	List<Producto> stock = new LinkedList<Producto>();
        stock.addAll(this.productosDeporte);
        stock.addAll(this.productosLibreria);
        return stock;
    }

    public List<Producto> buscarPorNombre(String nombre, boolean exacto) {
    	List<Producto> stock = this.stock();
        return this.buscarPorNombre(nombre, exacto, stock.size(), stock);
    }
    
    public List<Producto> buscarPorNombre(String nombre, boolean exacto, int cantidadResultados) {
        return this.buscarPorNombre(nombre, exacto, cantidadResultados, this.stock());
    }
    
    private List<Producto> buscarPorNombre(String nombre, boolean exacto, int cantidadResultados, List<Producto> productos) {
    	BusquedaPorNombre busqueda = new BusquedaPorNombre(productos);
        if(exacto) {
        	return busqueda.buscarExacto(nombre, cantidadResultados);
        } else {
        	return busqueda.buscarAproximado(nombre, cantidadResultados);
        }
    }
    
    public List<Producto> buscarPorPrecio(float desde, float hasta) {
    	List<Producto> stock = this.stock();
        return this.buscarPorPrecio(desde, hasta, stock.size(), stock);
    }
    
    public List<Producto> buscarPorPrecio(float desde, float hasta, int cantidadResultados) {
        return this.buscarPorPrecio(desde, hasta, cantidadResultados, this.stock());
    }
    
    private List<Producto> buscarPorPrecio(float desde, float hasta, int cantidadResultados, List<Producto> productos) {
    	BusquedaPorPrecio busqueda = new BusquedaPorPrecio(productos);
        return busqueda.buscarPorRango(desde, hasta, cantidadResultados);
    }

    public List<Producto> buscarDeportesPorNombre(String nombre, boolean exacto) {
        return this.buscarPorNombre(nombre, exacto, this.productosDeporte.size(), this.productosDeporte);
    }
    
    public List<Producto> buscarLibreriaPorNombre(String nombre, boolean exacto) {
    	return this.buscarPorNombre(nombre, exacto, this.productosLibreria.size(), this.productosLibreria);
    }

    public List<Producto> buscarNombreYPrecio(String nombre, boolean exacto, float desde, float hasta) {
    	List<Producto> resultado = this.buscarPorNombre(nombre, exacto);
    	return this.buscarPorPrecio(desde, hasta, resultado.size(), resultado);
    }
    
    public List<Producto> buscarNombreYPrecio(String nombre, boolean exacto, float desde, float hasta, int cantidadResultados) {
    	List<Producto> resultado = this.buscarPorNombre(nombre, exacto, cantidadResultados, this.stock());
    	return this.buscarPorPrecio(desde, hasta, cantidadResultados, resultado);
    }

}
