package dynamic.dao;

import dynamic.domain.Lanche;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LancheDao {
  
  @Autowired
  private SessionFactory sessionFactory;
  
  private Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  public Lanche getById(Long id) {
    return (Lanche) getSession().createQuery("from Lanche l where l.id = :id").setParameter("id", id).list().get(0);
  }

  public List<Lanche> getAll() {
    return getSession().createQuery("from Lanche").list();
  }

  public Long save(Lanche lanche) {
    return (Long) getSession().save(lanche);

  }
}
