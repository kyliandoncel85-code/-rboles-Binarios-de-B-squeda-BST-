public class ArbolBST {
    private NodoBST raiz;
    public ArbolBST() {
        raiz = null;
    }
    public void insertar(int codigo, String nombre, String municipio) {
        raiz = insertarRec(raiz, codigo, nombre, municipio);
    }
    private NodoBST insertarRec(NodoBST actual, int codigo,String nombre, String municipio) {
        if (actual == null) {
            return new NodoBST(codigo, nombre, municipio);
        }
        if (codigo < actual.codigo) {
            actual.izquierdo = insertarRec(actual.izquierdo,codigo, nombre, municipio);
        } else if (codigo > actual.codigo) {
            actual.derecho = insertarRec(actual.derecho,codigo, nombre, municipio);
        }
        return actual;
    }
    public NodoBST buscar(int codigo) {
        return buscarRec(raiz, codigo);
    }
    private NodoBST buscarRec(NodoBST actual, int codigo) {
        if (actual == null || actual.codigo == codigo) {
            return actual;
        }
        if (codigo < actual.codigo) {
            return buscarRec(actual.izquierdo, codigo);
        }
        return buscarRec(actual.derecho, codigo);
    }
    public void preOrden() {
        preOrdenRec(raiz);
        System.out.println();
    }
    private void preOrdenRec(NodoBST nodo) {
        if (nodo != null) {
            System.out.print(nodo.codigo + " ");
            preOrdenRec(nodo.izquierdo);
            preOrdenRec(nodo.derecho);
        }
    }
    public void inOrden() {
        inOrdenRec(raiz);
        System.out.println();
    }
    private void inOrdenRec(NodoBST nodo) {
        if (nodo != null) {
            inOrdenRec(nodo.izquierdo);
            System.out.print(nodo.codigo + " ");
            inOrdenRec(nodo.derecho);
        }
    }
    public void postOrden() {
        postOrdenRec(raiz);
        System.out.println();
    }
    private void postOrdenRec(NodoBST nodo) {
        if (nodo != null) {
            postOrdenRec(nodo.izquierdo);
            postOrdenRec(nodo.derecho);
            System.out.print(nodo.codigo + " ");
        }
    }
}