package aplicacao;

/**
 * IFPB - TSI - PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import modelo.Produto;

public class Deletar {
	private EntityManager manager;

	public Deletar() {
		try {
			manager = Util.conectarBanco();

			manager.getTransaction().begin();
			Produto p;
			TypedQuery<Produto> q = manager.createQuery("select p from Produto p where p.nome = 'oleo' ", Produto.class);
			p = q.getSingleResult();

			manager.remove(p);
			manager.getTransaction().commit();
			System.out.println("deletou o oleo");

		}
		catch (NoResultException e) {
			manager.getTransaction().rollback();
			System.out.println("nao encontrou");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			Util.fecharBanco();
		}
		System.out.println("fim do programa");
	}

	// =================================================
	public static void main(String[] args) {
		new Deletar();
	}

}
