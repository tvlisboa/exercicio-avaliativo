package org.serratec.backend.dto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.serratec.backend.entities.Vendedor;

public class VendedorRequestDTO {

    @NotBlank(message = "O nome do vendedor é obrigatório")
    private String nome;

    @NotNull(message = "O email do vendedor é obrigatório.")
    @Email(message = "Email inválido.")
    private String email;

    @DecimalMin(value = "1518.00", message = "O salário do vendedor deve ser maior que R$ 1.518,00 (Salário mínimo)")
    private Double salario;

    public VendedorRequestDTO() {
    }

    public VendedorRequestDTO(Vendedor vendedor) {
        this.nome = vendedor.getNome();
        this.email = vendedor.getEmail();
        this.salario = vendedor.getSalario();
    }
}
