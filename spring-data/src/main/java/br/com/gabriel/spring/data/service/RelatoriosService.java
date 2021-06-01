package br.com.gabriel.spring.data.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.gabriel.spring.data.orm.Funcionario;
import br.com.gabriel.spring.data.repository.FuncionarioRepository;

@Service
public class RelatoriosService {

	private Boolean system = true;
	
	private final FuncionarioRepository funcionarioRepository;
	
	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner) {
		
		while (system) {
			System.out.println("Qual ação referente a cargos deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca funcionário por nome");
		
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				buscaFuncionarioPorNome(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
	}
	
	private void buscaFuncionarioPorNome(Scanner scanner) {
		System.out.println("Digite o nome a ser pesquisado: ");
		String nome = scanner.next();
		List<Funcionario> lista = funcionarioRepository.findByNome(nome);
		lista.forEach(System.out::println);
	}
}
