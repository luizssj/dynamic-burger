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

    public Double somaValorIngredientes(Collection<Ingrediente> ingredientes) {
        Double valor = 0.0;
        if (ingredientes != null) {
            for (Ingrediente ingrediente : ingredientes) {
                valor += ingrediente.getValor();
            }
        }

        return valor;
    }

    /**
     * Conta o número de {@param ingredientes} com o id em {@param idToCount}
     * @param ingredientes
     * @param idToCount
     * @return número de {@param ingredientes}
     */
    public Integer countIngredienteByName(final Collection<Ingrediente> ingredientes, final Long idToCount) {
        Integer numIngredientes = 0;
        for (Ingrediente ingrediente : ingredientes) {
            if (ingrediente.getId().equals(idToCount)) {
                numIngredientes++;
            }
        }

        return numIngredientes;
    }
}
