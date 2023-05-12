package aplicacao;

import java.util.List;

/**
 * IFPB - TSI - PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import modelo.Produto;

public class Atualizar {
	private  EntityManager manager;

	public Atualizar() {
		try {
			manager = Util.conectarBanco();
			System.out.println("Reajustar preço de todos os produtos...");

			manager.getTransaction().begin();
			List<Produto> resultados; 
			TypedQuery<Produto> q = manager.createQuery("select p from Produto p ", Produto.class);
			resultados = q.getResultList();

			if (resultados.size()>0) {
				for(Produto p : resultados) {
					//reajuste de preco em 10%
					p.setPreco(p.getPreco()*1.1);
					manager.merge(p);
				}
				manager.getTransaction().commit();
				System.out.println("reajustou todos produtos");
			} 
			else {
				manager.getTransaction().rollback();
				System.out.println("nao tem produtos");
			}
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
		new Atualizar();
	}

}
