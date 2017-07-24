package dynamic.controller;

import dynamic.domain.Ingrediente;
import dynamic.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@RequestMapping(value="/ingredientes")
public class IngredienteController {
  @Autowired
  private IngredienteService ingredienteService;

  @RequestMapping(value="")
  @ResponseBody
  public ResponseEntity<Collection<Ingrediente>> getAll() {
    try {
      Collection<Ingrediente> ingredientes =  this.ingredienteService.getAll();
      return new ResponseEntity<>(ingredientes, HttpStatus.OK);
    }
    catch(Exception ex) {
      System.out.print(ex.getMessage());
    }

    return null;
  }
}
