package dynamic.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IngredienteResource {

    private Long id;
    private String nome;
    private Double valor;
}
