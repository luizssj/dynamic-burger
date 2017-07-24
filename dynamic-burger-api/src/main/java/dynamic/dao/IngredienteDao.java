package dynamic.dao;

import dynamic.domain.Ingrediente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class IngredienteDao {
  
  @Autowired
  private SessionFactory sessionFactory;
  
  private Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  public Ingrediente getById(Long id) {
    return (Ingrediente) getSession().createQuery("from Ingrediente i where i.id = :id").setParameter("id", id).list().get(0);
  }

  public List<Ingrediente> getAll() {
    return getSession().createQuery("from Ingrediente").list();
  }

  public void save(Ingrediente ingrediente) {
    getSession().save(ingrediente);
    return;
  }
  
  public void delete(Ingrediente ingrediente) {
    getSession().delete(ingrediente);
    return;
  }

  public void update(Ingrediente ingrediente) {
    getSession().update(ingrediente);
    return;
  }

}
