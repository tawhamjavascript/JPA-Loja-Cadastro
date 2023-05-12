package aplicacao;

/**
 * IFPB - TSI - PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import modelo.Produto;

public class Listar {
	private EntityManager manager;

	public Listar() {
		try {
			manager = Util.conectarBanco();
			System.out.println("Listagem de pessoas");

			TypedQuery<Produto> query = manager.createQuery("select p from Produto p order by p.id", Produto.class); // order by p.nome
			List<Produto> resultados = query.getResultList();
			for (Produto p : resultados)
				System.out.println(p);

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			Util.fecharBanco();
		}
	}

	// =================================================
	public static void main(String[] args) {
		new Listar();
	}

}
