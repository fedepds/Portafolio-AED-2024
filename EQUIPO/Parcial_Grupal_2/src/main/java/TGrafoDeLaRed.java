import java.util.Collection;

@SuppressWarnings({"unchecked", "rawtypes"})
public class TGrafoDeLaRed extends TGrafoNoDirigido<TNodoDeLaRed> implements IGrafoDeLaRed {

    public TGrafoDeLaRed(Collection<TVerticeDeLaRed> vertices, Collection<IArista> aristas) {
        super((Collection<IVertice<TNodoDeLaRed>>) (Collection<?>) vertices, aristas);
    }

    @Override
    public TCaminos<TNodoDeLaRed> caminosDesdeHasta(Comparable nodoOrigen, Comparable nodoDestino) {

        TVerticeDeLaRed v = (TVerticeDeLaRed) buscarVertice(nodoOrigen);
        TVerticeDeLaRed u = (TVerticeDeLaRed)buscarVertice(nodoDestino);
            if ((v != null)&&(u != null)) {
                TCaminos<TNodoDeLaRed> todosLosCaminos = new TCaminos<TNodoDeLaRed>();
                TCamino<TNodoDeLaRed> caminoPrevio = new TCamino<TNodoDeLaRed>(v);
                v.caminoDesdeHasta(nodoDestino, caminoPrevio, todosLosCaminos);
                return todosLosCaminos;
            }
            return null;
        }
    }
