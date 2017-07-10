package vc.com.cartorio.repository.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vc.com.cartorio.domain.Cartorio;
import vc.com.cartorio.repository.CartorioRepository;

@Repository
public class CartorioHibernate implements CartorioRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
 
	@Override
	public Cartorio adicionarCartorio(Cartorio c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		return c;
	}

	@Override
	public void atualizarCartorio(Cartorio c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cartorio> listarCartorios() {
		Session session = this.sessionFactory.getCurrentSession();
		return (List<Cartorio>) session.createCriteria(Cartorio.class).list();
	}

	@Override
	public Cartorio getCartorioPorId(int id) {
		Session session = this.sessionFactory.getCurrentSession();	
		return (Cartorio) session.createCriteria(Cartorio.class).add(Restrictions.eq("id", id)).uniqueResult();
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
