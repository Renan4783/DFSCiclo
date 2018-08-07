package depthfirstsearch;

import java.util.Vector;

/**
 *
 * @author Renan
 */
public class DepthFirstSearch {
    private int timeDfs = 0;

    public DepthFirstSearch(Graph g) {
        Vertex aux = new Vertex(null);
        Vector vertices = g.getVertices();
        g.setCiclo("Não tem ciclo");
        for (Object i : vertices) {
            aux = (Vertex) i;
            aux.setColor("Branco");
        }

        for (Object u : vertices) {
            aux = (Vertex) u;
            if (aux.getColor().equals("Branco")) {
                dfsVisit(aux, g);
            }
        }
    }

    private void dfsVisit(Vertex u, Graph g) {
        Vertex aux = new Vertex(null);
        Vector vector = u.getAdjacents();
        u.setColor("Cinza");
        timeDfs++;
        u.setVi(timeDfs);

        for (Object v : vector) {
            aux = (Vertex) v;
            if (aux.getColor().equals("Branco") && aux.getParent() == null) {
                aux.setParent(u.getName());
                dfsVisit(aux, g);
            } else {
                g.setCiclo("Tem ciclo");
            }
        }
        u.setColor("Preto");
        timeDfs++;
        u.setVf(timeDfs);
    }

    /**
     * @return the ciclo
     */
}
