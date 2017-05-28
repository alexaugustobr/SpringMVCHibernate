package vc.com.cartorio.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import vc.com.cartorio.model.Cartorio;

@Repository
public class CartorioDAOImpl implements CartorioDAO {
	
	//Hibernate
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
 
	@Override
	public void adicionarCartorio(Cartorio c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
	}

	@Override
	public void atualizarCartorio(Cartorio c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
	}

	@Override
	public List<Cartorio> listarCartorios() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Cartorio> CartoriosList = session.createQuery("from Cartorio").list();
		return CartoriosList;
	}

	@Override
	public Cartorio getCartorioPorId(int id) {
		Session session = this.sessionFactory.getCurrentSession();	
		Cartorio c = (Cartorio) session.get(Cartorio.class, new Integer(id));
		return c;
	}

	@Override
	public void removerCartorio(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cartorio c = (Cartorio) session.load(Cartorio.class, new Integer(id));
		if(null != c){
			session.delete(c);
		}
	}


}
