package dynamic.service;

import dynamic.dao.IngredienteDao;
import dynamic.dao.LancheDao;
import dynamic.domain.Ingrediente;
import dynamic.domain.Lanche;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class LancheService {

    @Autowired
    private LancheDao lancheDao;

    @Autowired
    private IngredienteService ingredienteService;

    @Autowired
    private IngredienteDao ingredienteDao;

    public Collection<Lanche> getAll() {
        return this.aplicaPromocoes(lancheDao.getAll());
    }

    public Lanche getById(Long id) {
        return this.aplicaPromocoes(lancheDao.getById(id));
    }

    public Lanche create(Lanche lanche) {
        Long idCriado = this.lancheDao.save(this.aplicaPromocoes(lanche));

        return this.getById(idCriado);
    }

    public Lanche aplicaPromocoes(Lanche lanche) {
        Lanche lanchePromocao = new Lanche();
        BeanUtils.copyProperties(lanche, lanchePromocao);
        lanchePromocao.setValor(this.somaValorIngredientes(lanchePromocao.getIngredientes()));

        lanchePromocao = this.aplicaMuitaCarne(lanchePromocao);
        lanchePromocao = this.aplicaMuitoQueijo(lanchePromocao);
        lanchePromocao = this.aplicaLight(lanchePromocao);

        return lanchePromocao;
    }

    public Collection<Lanche> aplicaPromocoes(Collection<Lanche> lanches) {
        Collection<Lanche> lancheComPromocao = new ArrayList<>();
        for (Lanche lanche : lanches) {
            lancheComPromocao.add(this.aplicaPromocoes(lanche));
        }

        return lancheComPromocao;
    }

    private Double somaValorIngredientes(Collection<Ingrediente> ingredientes) {
        Double valor = 0.0;
        if (ingredientes != null) {
            for (Ingrediente ingrediente : ingredientes) {
                valor += ingrediente.getValor();
            }
        }

        return valor;
    }

    /**
     * Light - Se o lanche tem alface e não tem bacon, ganha 10% de desconto.
     */
    private Lanche aplicaLight(Lanche lanche) {
        Boolean temBacon = false;
        Boolean temAlface = false;

        for (Ingrediente ingrediente : lanche.getIngredientes()) {
            if (ingrediente.getNome().equals("Alface")) {
                temAlface = true;
            } else if (ingrediente.getNome().equals("Bacon")) {
                temBacon = true;
            }
        }

        if (temAlface && !temBacon) {
            Lanche lancheLight = new Lanche();
            BeanUtils.copyProperties(lanche, lancheLight);
            lancheLight.setValor(lancheLight.getValor()  * 0.9);

            return lancheLight;
        }

        return lanche;
    }

    /**
     *      Muita carne - A cada 3 porções de carne o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4. Assim por diante...
     */
    private Lanche aplicaMuitaCarne(Lanche lanche) {
        Lanche lancheMuitaCarne = new Lanche();
        BeanUtils.copyProperties(lanche, lancheMuitaCarne);

        Integer numCarne = 0;
        for (Ingrediente ingrediente : lanche.getIngredientes()) {
            // id: Hanburger de Carne
            if (ingrediente.getId().equals(3L)) {
                numCarne++;
            }
        }

        Integer numCarneRemover = 0;
        if (numCarne / 3 > 0) {
            numCarneRemover = (numCarne / 3);
        }

        if (numCarneRemover > 0) {
            Ingrediente ingrediente = ingredienteService.getById(3L);
            Double valorCarne = ingrediente.getValor();
            lancheMuitaCarne.setValor(lancheMuitaCarne.getValor() - valorCarne * numCarneRemover);

            return lancheMuitaCarne;
        }

        return lancheMuitaCarne;
    }

    /**
     *      Muito queijo - A cada 3 porções de queijo o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4. Assim por diante...
     */
    private Lanche aplicaMuitoQueijo(Lanche lanche) {
        Lanche lancheMuitoQueijo = new Lanche();
        BeanUtils.copyProperties(lanche, lancheMuitoQueijo);

        Integer numQueijo = 0;
        for (Ingrediente ingrediente : lanche.getIngredientes()) {
            // id: Queijo
            if (ingrediente.getId().equals(5L)) {
                numQueijo++;
            }
        }

        Integer numQueijoRemover = 0;
        if (numQueijo / 3 > 0) {
            numQueijoRemover = (numQueijo / 3);
        }

        if (numQueijoRemover > 0) {
            Ingrediente ingrediente = ingredienteService.getById(5L);
            Double valorQueijo = ingrediente.getValor();
            lancheMuitoQueijo.setValor(lancheMuitoQueijo.getValor() - valorQueijo * numQueijoRemover);

            return lancheMuitoQueijo;
        }

        return lancheMuitoQueijo;
    }
}
