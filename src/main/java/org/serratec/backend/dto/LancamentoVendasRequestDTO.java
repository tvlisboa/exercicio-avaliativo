package org.serratec.backend.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.CreationTimestamp;
import org.serratec.backend.entities.LancamentoVendas;
import java.time.LocalDate;

public class LancamentoVendasRequestDTO {

    @NotBlank(message = "O campo data da venda é obrigatória")
    @CreationTimestamp
    private LocalDate dataVenda;

    @Positive
    @NotNull(message = "O campo valor da venda é obrigatório")
    private Double valorVenda;

    @NotBlank(message = "O campo nome do vendedor é obrigatório")
    private String nomeVendedor;

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public LancamentoVendasRequestDTO() {
    }

    public LancamentoVendasRequestDTO(LancamentoVendas lancamentoVendas) {
        this.dataVenda = lancamentoVendas.getDataVenda();
        this.valorVenda = lancamentoVendas.getValorVenda();
        this.nomeVendedor = lancamentoVendas.getVendedor().getNome();
    }
}
