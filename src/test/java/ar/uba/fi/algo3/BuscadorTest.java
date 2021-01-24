package ar.uba.fi.algo3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BuscadorTest {

    @Test
    public void testBusquedaPorNombreExacto() {
        ProductoDeporte pelota = new ProductoDeporte("pelota", 500);
        ProductoLibreria lapiz = new ProductoLibreria("lapiz", 30);
        ProductoDeporte pelopincho = new ProductoDeporte("pelopincho", 7000);
        Buscador buscador = new Buscador();
        buscador.agregarProducto(pelota);
        buscador.agregarProducto(lapiz);
        buscador.agregarProducto(pelopincho);

        List<Producto> resultados = buscador.buscarPorNombre("lapiz", true);

        assertEquals(Arrays.asList(lapiz), resultados);
    }

    @Test
    public void testBusquedaPorNombreAproximado() {
        ProductoDeporte pelota = new ProductoDeporte("pelota", 500);
        ProductoLibreria lapiz = new ProductoLibreria("lapiz", 30);
        ProductoDeporte pelopincho = new ProductoDeporte("pelopincho", 7000);
        Buscador buscador = new Buscador();
        buscador.agregarProducto(pelota);
        buscador.agregarProducto(lapiz);
        buscador.agregarProducto(pelopincho);

        List<Producto> resultados = buscador.buscarPorNombre("pelo", false);

        assertEquals(Arrays.asList(pelota, pelopincho), resultados);
    }

    @Test
    public void testBusquedaPorCategoriaAproximada() {
    	ProductoDeporte pelota = new ProductoDeporte("pelota", 500);
        ProductoLibreria lapiz = new ProductoLibreria("lapiz", 30);
        ProductoDeporte pelopincho = new ProductoDeporte("pelopincho", 7000);
        Buscador buscador = new Buscador();
        buscador.agregarProducto(pelota);
        buscador.agregarProducto(lapiz);
        buscador.agregarProducto(pelopincho);

        List<Producto> resultados = buscador.buscarDeportesPorNombre("pelo", false);

        assertEquals(Arrays.asList(pelota, pelopincho), resultados);
    }

    @Test
    public void testBusquedaPorPrecio() {
    	ProductoDeporte pelota = new ProductoDeporte("pelota", 500);
        ProductoLibreria lapiz = new ProductoLibreria("lapiz", 30);
        ProductoDeporte pelopincho = new ProductoDeporte("pelopincho", 7000);
        Buscador buscador = new Buscador();
        buscador.agregarProducto(pelota);
        buscador.agregarProducto(lapiz);
        buscador.agregarProducto(pelopincho);

        List<Producto> resultados = buscador.buscarPorPrecio(30, 600);

        assertEquals(Arrays.asList(pelota, lapiz), resultados);
    }

}
