package dynamic.service;

import dynamic.dao.LancheDao;
import dynamic.domain.Lanche;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

import static dynamic.domain.Ingrediente.IngredienteEnum.*;

@Service
public class LancheService {

    @Autowired
    private LancheDao lancheDao;

    @Autowired
    private IngredienteService ingredienteService;


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
        lanchePromocao.setValor(ingredienteService.somaValorIngredientes(lanchePromocao.getIngredientes()));

        lanchePromocao.setValor(this.aplicaPromocaoMuitoIngrediente(HAMBURGER_CARNE.getId(), lanchePromocao));
        lanchePromocao.setValor(this.aplicaPromocaoMuitoIngrediente(QUEIJO.getId(), lanchePromocao));
        lanchePromocao.setValor(this.aplicaLight(lanchePromocao));

        return lanchePromocao;
    }

    public Collection<Lanche> aplicaPromocoes(Collection<Lanche> lanches) {
        Collection<Lanche> lancheComPromocao = new ArrayList<>();
        for (Lanche lanche : lanches) {
            lancheComPromocao.add(this.aplicaPromocoes(lanche));
        }

        return lancheComPromocao;
    }

    /**
     * Light - Se o lanche tem alface e não tem bacon, ganha 10% de desconto.
     */
    private Double aplicaLight(final Lanche lanche) {
        Double valorLanche = lanche.getValor();

        Integer numAlface = ingredienteService.countIngredienteByName(lanche.getIngredientes(), ALFACE.getId());
        Integer numBacon = ingredienteService.countIngredienteByName(lanche.getIngredientes(), BACON.getId());

        if (numAlface > 0 && numBacon == 0) {
            valorLanche = lanche.getValor()  * 0.9;
        }

        return valorLanche;
    }

    /**
     * Aplica promoçao de Muito Ingrediente
     * A cada 3 porções de carne o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4. Assim por diante...
     *
     * @param idIngrediente
     * @param lanche
     * @return
     */
    private Double aplicaPromocaoMuitoIngrediente(Long idIngrediente, Lanche lanche) {
        Double valorLanche = lanche.getValor();

        Integer numIngrediente = ingredienteService.countIngredienteByName(lanche.getIngredientes(), idIngrediente);
        Integer numIngredienteRemover = numIngrediente / 3;

        if (numIngredienteRemover >= 1) {
            Double valorCarne = ingredienteService.getById(idIngrediente).getValor();
            valorLanche = lanche.getValor() - valorCarne * numIngredienteRemover;
        }

        return valorLanche;
    }
}
