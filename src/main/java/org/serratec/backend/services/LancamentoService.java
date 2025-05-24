package org.serratec.backend.services;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.serratec.backend.dto.LancamentoVendasRequestDTO;
import org.serratec.backend.dto.LancamentoVendasResponseDTO;
import org.serratec.backend.entities.LancamentoVendas;
import org.serratec.backend.entities.Vendedor;
import org.serratec.backend.exception.LancamentoException;
import org.serratec.backend.exception.VendedorException;
import org.serratec.backend.repository.LancamentoRepository;
import org.serratec.backend.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	@Autowired
	private VendedorRepository vendedorRepository;

	public LancamentoVendasResponseDTO listarPorId(Long id) {
		Optional<LancamentoVendas> lancamento = lancamentoRepository.findById(id);

		if (lancamento.isPresent()) {
			LancamentoVendas venda = lancamento.get();

			return new LancamentoVendasResponseDTO(venda.getDataVenda(), venda.getValorVenda(),
					venda.getVendedor().getNome());
		}
		throw new LancamentoException("venda com id " + id + "não encontrada ! ");
	}

	public List<LancamentoVendasResponseDTO> listar() {
		List<LancamentoVendas> lancamentos = lancamentoRepository.findAll();
		List<LancamentoVendasResponseDTO> lancamentosDTO = new ArrayList<>();
		for (LancamentoVendas lancamento : lancamentos) {
			lancamentosDTO.add(new LancamentoVendasResponseDTO(lancamento.getDataVenda(), lancamento.getValorVenda(),
					lancamento.getVendedor().getNome()));
		}
		return lancamentosDTO;
	}

	public LancamentoVendasResponseDTO inserirLancamento(LancamentoVendasRequestDTO novoLancamento) {
		Optional<Vendedor> vendedorCadastrado  = vendedorRepository.findById(novoLancamento.getVendedor().getCodigoVendedor());
		if (vendedorCadastrado.isEmpty()){
			throw new VendedorException("Vendedor não cadastrado!");
		}
		LancamentoVendas vendaSalva = new LancamentoVendas();
		vendaSalva.setDataVenda(LocalDate.now());
		vendaSalva.setValorVenda(novoLancamento.getValorVenda());
		novoLancamento.getVendedor().getCodigoVendedor();
		vendaSalva.setVendedor(vendedorCadastrado.get());
		lancamentoRepository.save(vendaSalva);

		return new LancamentoVendasResponseDTO(
				vendaSalva.getDataVenda(),
				vendaSalva.getValorVenda(),
				vendaSalva.getVendedor().getNome());
	}
}
