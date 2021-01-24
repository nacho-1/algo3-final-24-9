package ar.uba.fi.algo3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BusquedaPorPrecio {
	
	private List<Producto> productos;
	
	public BusquedaPorPrecio(List<Producto> productos) {
		this.productos = productos;
	}
	
	public List<Producto> buscarPorRango(double desde, double hasta, int cantidadResultados) {
		List<Producto> resultado = new LinkedList<Producto>();
		Iterator<Producto> iterador = this.productos.iterator();
		int i = 0;
		while(iterador.hasNext() && i <= cantidadResultados) {
			Producto producto = iterador.next();
			if(producto.enRango(desde, hasta)) {
				resultado.add(producto);
				i++;
			}
		}
		return resultado;
	}

}
