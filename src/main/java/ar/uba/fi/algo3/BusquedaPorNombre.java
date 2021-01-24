package ar.uba.fi.algo3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BusquedaPorNombre {

	private List<Producto> productos;
	
	public BusquedaPorNombre(List<Producto> productos) {
		this.productos = productos;
	}
	
	public List<Producto> buscarExacto(String nombre, int cantidadResultados){
		List<Producto> resultado = new LinkedList<Producto>();
		Iterator<Producto> iterador = this.productos.iterator();
		while(iterador.hasNext()) {
			Producto producto = iterador.next();
			if(producto.nombreExacto(nombre)) {
				resultado.add(producto);
			}
		}
		return resultado;
	}
	
	public List<Producto> buscarAproximado(String nombre, int cantidadResultados){
		List<Producto> resultado = new LinkedList<Producto>();
		Iterator<Producto> iterador = this.productos.iterator();
		int i = 0;
		while(iterador.hasNext() && i <= cantidadResultados) {
			Producto producto = iterador.next();
			if(producto.nombreAproximado(nombre)) {
				resultado.add(producto);
			}
		}
		return resultado;
	}
	
}
