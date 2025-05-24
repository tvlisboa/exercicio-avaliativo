package org.serratec.backend.controller;
import org.serratec.backend.dto.LancamentoVendasRequestDTO;
import org.serratec.backend.dto.LancamentoVendasResponseDTO;
import org.serratec.backend.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

	@Autowired
	private LancamentoService lancamentoService;

	@GetMapping
	public ResponseEntity<List<LancamentoVendasResponseDTO>> listar() {
		return ResponseEntity.ok(lancamentoService.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<LancamentoVendasResponseDTO> listaPorId(@PathVariable Long id) {
		return ResponseEntity.ok(lancamentoService.listarPorId(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LancamentoVendasResponseDTO inserirLancamento(@RequestBody LancamentoVendasRequestDTO lancamento) {
		return lancamentoService.inserirLancamento(lancamento);
	}
}
