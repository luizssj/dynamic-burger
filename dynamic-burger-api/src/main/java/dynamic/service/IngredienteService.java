package dynamic.service;

import dynamic.dao.IngredienteDao;
import dynamic.domain.Ingrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class IngredienteService {

    @Autowired
    private IngredienteDao ingredienteDao;

    public Collection<Ingrediente> getAll() {
        return ingredienteDao.getAll();
    }

    public Ingrediente getById(Long id) {
        return ingredienteDao.getById(id);
    }
}
