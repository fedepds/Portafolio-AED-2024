package uy.edu.ucu.aed;

public class TArbolDeProductos extends TArbolBB<Producto> {
    public TArbolDeProductos(){
        super();
    }

    public double longIntMed(){
        if (esVacio()){
            return -1;
        }
        double[] res = raiz.longTraInt(0);
        return res[0]/res[1]; 
    }
    public double longIntMedv2(){
        if (esVacio()){
            return -1;
        }
        double[] res = new double[2];
        raiz.longTraIntv2(res, 0);
        return res[0]/res[1]; 
    }

    public int obtenerTamaño(){
        if (esVacio()){
            return 0;
        }
        return raiz.obtenerTamaño();
    }
}
