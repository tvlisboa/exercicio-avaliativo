package org.serratec.backend.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.serratec.backend.dto.LancamentoVendasResponseDTO;
import org.serratec.backend.entities.LancamentoVendas;
import org.serratec.backend.exception.LancamentoException;
import org.serratec.backend.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	public LancamentoVendasResponseDTO listarPorId(Long id) {
		Optional<LancamentoVendas> lancamento = lancamentoRepository.findById(id);

		if (lancamento.isPresent()) {
			LancamentoVendas venda = lancamento.get();
			
			return new LancamentoVendasResponseDTO(venda.getDataVenda(), venda.getValorVenda(),
					venda.getVendedor().getNome());
		}
		throw new LancamentoException("venda com id " + id + "não encontrada ! ");
		// eu inseri a exception da Juliana aqui acima
	}

	public List<LancamentoVendasResponseDTO> listar() {
		List<LancamentoVendas> lancamentos = lancamentoRepository.findAll();
		List<LancamentoVendasResponseDTO> lancamentosDTO = new ArrayList<>();
		for(LancamentoVendas lancamento : lancamentos){
			lancamentosDTO.add(new LancamentoVendasResponseDTO(lancamento.getDataVenda(), lancamento.getValorVenda(),
					lancamento.getVendedor().getNome()));
		}
		return lancamentosDTO;
	}

	public LancamentoVendasResponseDTO inserirLancamento(LancamentoVendas novoLancamento) {
		LancamentoVendas vendaSalva = lancamentoRepository.save(novoLancamento);
		
		return new LancamentoVendasResponseDTO(vendaSalva.getDataVenda(), vendaSalva.getValorVenda(),
				vendaSalva.getVendedor().getNome());
	}
}
