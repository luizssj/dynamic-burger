package dynamic.controller;

import dynamic.domain.Lanche;
import dynamic.service.LancheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@RequestMapping(value="/lanches")
public class LancheController {

  @Autowired
  private LancheService lancheService;

  @RequestMapping(value="")
  @ResponseBody
  public ResponseEntity<Collection<Lanche>> getAll() {
    try {
      Collection<Lanche> lanches =  this.lancheService.getAll();
      return new ResponseEntity<>(lanches, HttpStatus.OK);
    }
    catch(Exception ex) {
      System.out.println(ex);
    }

    return null;
  }

  @RequestMapping(value="", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<Lanche> getValor(@RequestBody Lanche lanche) {

    try {
      Lanche lancheCriado =  this.lancheService.create(lanche);
      return new ResponseEntity<>(lancheCriado, HttpStatus.OK);
    }
    catch(Exception ex) {
      System.out.println(ex);
    }

    return null;
  }
}
