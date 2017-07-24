package dynamic.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dynamic.domain.Ingrediente;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LancheResource {
    
    private Long id;
    private String nome;
    private Set<Ingrediente> ingredientes;
}
