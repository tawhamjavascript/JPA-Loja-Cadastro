package aplicacao;

/**
 * IFPB - TSI - PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

import jakarta.persistence.EntityManager;
import modelo.Produto;

public class Cadastrar {
	private EntityManager manager;

	public Cadastrar() {
		try {
			manager = Util.conectarBanco();
			
			System.out.println("Cadastrando");

			Produto p1;
			manager.getTransaction().begin();
			p1 = new Produto("arroz", 4.0);
			manager.persist(p1);
			manager.getTransaction().commit();

			manager.getTransaction().begin();
			p1 = new Produto("macarrao", 3.0);
			manager.persist(p1);
			manager.getTransaction().commit();

			manager.getTransaction().begin();
			p1 = new Produto("cafe", 10.0);
			manager.persist(p1);
			manager.getTransaction().commit();

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
		new Cadastrar();
	}

}
