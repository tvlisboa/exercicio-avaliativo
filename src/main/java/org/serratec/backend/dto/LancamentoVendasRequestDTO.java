package org.serratec.backend.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.CreationTimestamp;
import org.serratec.backend.entities.LancamentoVendas;
import org.serratec.backend.entities.Vendedor;


import java.time.LocalDate;
public class LancamentoVendasRequestDTO {

    @NotBlank(message = "O campo data da venda é obrigatória")
    @CreationTimestamp
    private LocalDate dataVenda;

    @Positive
    @NotNull(message = "O campo valor da venda é obrigatório")
    private Double valorVenda;

    @NotNull(message = "O campo ID vendedor é obrigatório")
    private Vendedor vendedor;

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

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public LancamentoVendasRequestDTO() {
    }

    public LancamentoVendasRequestDTO(LancamentoVendas lancamentoVendas) {
        this.dataVenda = lancamentoVendas.getDataVenda();
        this.valorVenda = lancamentoVendas.getValorVenda();
        this.vendedor = lancamentoVendas.getVendedor();
    }
}
