package vc.com.cartorio.repository.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import vc.com.cartorio.domain.Endereco;
import vc.com.cartorio.repository.EnderecoRepository;

@Repository
public class EnderecoHibernate implements EnderecoRepository {
	
	//Hibernate
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
 
	@Override
	public void adicionarEndereco(Endereco e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(e);
	}

	@Override
	public void atualizarEndereco(Endereco e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Endereco> listarEnderecos() {
		Session session = this.sessionFactory.getCurrentSession();
		return (List<Endereco>) session.createCriteria(Endereco.class).list();
	}

	@Override
	public Endereco getEnderecoPorId(int id) {
		Session session = this.sessionFactory.getCurrentSession();	
		return (Endereco) session.createCriteria(Endereco.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public void removerEndereco(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Endereco c = (Endereco) session.load(Endereco.class, new Integer(id));
		if(null != c){
			session.delete(c);
		}
	}


}
