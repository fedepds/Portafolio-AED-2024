import java.util.Collection;



public class TGrafoRedElectrica extends TGrafoNoDirigido implements IGrafoRedElectrica{
    
    public TGrafoRedElectrica(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
    }

    @Override
    public TAristas mejorRedElectrica() {
        return super.mejorRedElectrica();
    }
    public TAristas mejorRedElectrica2() {
        return super.mejorRedElectrica2();
    }

}