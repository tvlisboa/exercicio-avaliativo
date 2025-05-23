package org.serratec.backend.entities;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoVendedor;
    private String nome;
    private String email;
    private Double salario;

    @OneToMany(mappedBy = "vendedor")
    private Set<LancamentoVendas> lancamentoVendas = new HashSet<>();

    public Long getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(Long codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}

 /**
 * @author <THIAGO>
 * @Date 2025-23-05
 * Um vendedor - lancamento vendas:
 * Possui um relacionamento, onetomany.
 */
