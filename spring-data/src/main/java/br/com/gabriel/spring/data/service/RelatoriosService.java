package br.com.gabriel.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.gabriel.spring.data.orm.Funcionario;
import br.com.gabriel.spring.data.repository.FuncionarioRepository;

@Service
public class RelatoriosService {

	private Boolean system = true;
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private final FuncionarioRepository funcionarioRepository;
	
	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner) {
		
		while (system) {
			System.out.println("Qual relatório deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca funcionário por nome");
			System.out.println("2 - Busca funcionário por nome, salario maior que... e data de contratação");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				buscaFuncionarioPorNome(scanner);
				break;
			case 2:
				buscaNomeSalarioMaiorQueEDataContratacao(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
	}
	
	private void buscaFuncionarioPorNome(Scanner scanner) {
		System.out.println("Digite o nome a ser pesquisado:");
		String nome = scanner.next();
		List<Funcionario> lista = funcionarioRepository.findByNome(nome);
		lista.forEach(System.out::println);
	}
	
	private void buscaNomeSalarioMaiorQueEDataContratacao(Scanner scanner) {
		System.out.println("Digite o nome a ser pesquisado:");
		String nome = scanner.next();
		
		System.out.println("Digite a data de contratação a ser pesquisada:");
		String data = scanner.next();
		
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		System.out.println("Digite o salário a ser pesquisado:");
		Double salario = scanner.nextDouble();
		
		List<Funcionario> list = funcionarioRepository
				.buscaNomeSalarioMaiorQueEDataContratacao(nome, salario, localDate);
		list.forEach(System.out::println);
		
	}
}
