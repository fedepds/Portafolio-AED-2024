import java.util.LinkedList;


public class TArbolTrieTelefonos implements IArbolTrieTelefonos {

    private TNodoTrieTelefonos raiz;

    @Override
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        LinkedList<TAbonado> abonados = new LinkedList<>();
        if (raiz != null) {
            String primerosDigitos = pais + area;
            
            raiz.buscarTelefonos(primerosDigitos, abonados);
        }
        return abonados;
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        if (raiz == null) {
            raiz = new TNodoTrieTelefonos();
        }
        raiz.insertar(unAbonado);
    }    
}
