package org.serratec.backend.controller;
import org.serratec.backend.dto.LancamentoVendasResponseDTO;
import org.serratec.backend.entities.LancamentoVendas;
import org.serratec.backend.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

	@Autowired
	private LancamentoService lancamentoService;

	@GetMapping("/{id}")
	public ResponseEntity<LancamentoVendasResponseDTO> listaPorId(@PathVariable Long id) {
		return ResponseEntity.ok(lancamentoService.listarPorId(id));
	}

	@PostMapping
	public ResponseEntity<LancamentoVendasResponseDTO> inserirLancamento(@RequestBody LancamentoVendas lancamento) {
		return ResponseEntity.ok(lancamentoService.inserirLancamento(lancamento));
	}
}
