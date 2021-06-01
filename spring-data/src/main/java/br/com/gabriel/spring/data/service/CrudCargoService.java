package br.com.gabriel.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.gabriel.spring.data.orm.Cargo;
import br.com.gabriel.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {
	
	private Boolean system = true;
	private final CargoRepository repository;

	public CrudCargoService(CargoRepository repository) {
		this.repository = repository;
	}
	
	public void inicial(Scanner scanner) {
		
		while (system) {
			System.out.println("Qual ação referente a cargos deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
		
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
	}
	
	private void salvar(Scanner scanner) {
		System.out.println("Descrição do cargo:");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		repository.save(cargo);
		System.out.println("Cargo salvo.");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("Informe o ID a ser alterado:");
		int id = scanner.nextInt();
		System.out.println("Informe a nova descrição:");
		String descricao = scanner.next();
		descricao += scanner.nextLine();
		
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		
		repository.save(cargo);
		System.out.println("Cargo atualizado.");
		
	}

}
