package testeIniflex;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Principal {

	public static void main(String[] args) {

		List<Funcionario> funcionarios = new ArrayList<>();

		// 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
		funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
		funcionarios.add(new Funcionario("Joao", LocalDate.of(1990, 05, 12), new BigDecimal("2284.38"), "Operador"));
		funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 05, 02), new BigDecimal("9836.14"), "Coordenador"));
		funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
		funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 01, 05), new BigDecimal("2234.68"), "Recepcionista"));
		funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
		funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 03, 31), new BigDecimal("4071.84"), "Contador"));
		funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 07, 8), new BigDecimal("3017.45"), "Gerente"));
		funcionarios.add(new Funcionario("Heloisa", LocalDate.of(2003, 05, 24), new BigDecimal("1606.85"), "Eletricista"));
		funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 02), new BigDecimal("2799.93"), "Gerente"));

		
		System.out.println("Todos os funcionarios inseridos:");
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Nome: " + funcionario.getNome() + " - " + 
							   "Data de nascimento: " 	+ funcionario.getDataNascimento() + " - " + 
							   "Salario: R$" + funcionario.getSalario() + " - " + 
							   "Funcao: " + funcionario.getFuncao());
		}
		System.out.println("\n");

		// 3.2 – Remover o funcionário “João” da lista.
		for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario funcionario = funcionarios.get(i);
            if (funcionario.getNome().equals("Joao")) {
                funcionarios.remove(i);
                i--;
            }
        }		
		System.out.println("Removendo Joao da lista:");
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Nome: " + funcionario.getNome() + " - " + 
					   		   "Data de nascimento: " 	+ funcionario.getDataNascimento() + " - " + 
					           "Salario: R$" + funcionario.getSalario() + " - " + 
					           "Funcao: " + funcionario.getFuncao());
		}
		
		System.out.println("\n");
		
		DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormatSymbols separador = new DecimalFormatSymbols(Locale.getDefault());
		separador.setDecimalSeparator(',');
		separador.setGroupingSeparator('.');
		DecimalFormat salarioFormatado = new DecimalFormat("###,###.00", separador);
		
		
		//3.3 – Imprimir todos os funcionários com todas suas informações		
		System.out.println("Todos os funcionarios inseridos com data e salario formatados: ");
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Nome: " + funcionario.getNome() + " - " + 
					   		   "Data de nascimento: " 	+ funcionario.getDataNascimento().format(dataFormatada) + " - " + 
					           "Salario: R$" + salarioFormatado.format(funcionario.getSalario()) + " - " + 
					           "Funcao: " + funcionario.getFuncao());
		}
		
		System.out.println("\n");

		//3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
		System.out.println("Todos os funcionarios com aumento de 10% de salario:");
		for (Funcionario funcionario : funcionarios) {
			BigDecimal novoSalario = funcionario.getSalario().multiply(new BigDecimal("1.10"));
			funcionario.setSalario(novoSalario);
			
			System.out.println("Nome: " + funcionario.getNome() + " - " + 
							   "Data de nascimento: " 	+ funcionario.getDataNascimento().format(dataFormatada) + " - " + 
			                   "Salario: R$" + salarioFormatado.format(funcionario.getSalario()) + " - " + 
			                   "Funcao: " + funcionario.getFuncao());
		}
		
		System.out.println("\n");
		
		//3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
		//não consegui fazer assim e fiz dessa forma de baixo
		
		//3.6 – Imprimir os funcionários, agrupados por função.
		System.out.println("Funcionarios agrupados por funcao:");

		for (Funcionario funcionario : funcionarios) {
			if(funcionario.getFuncao().equals("Operador")) {
				System.out.println("Nome: " + funcionario.getNome() + " - " + 
						   		   "Data de nascimento: " 	+ funcionario.getDataNascimento().format(dataFormatada) + " - " + 
		                           "Salario: R$" + salarioFormatado.format(funcionario.getSalario()) + " - " + 
		                           "Funcao: " + funcionario.getFuncao());
			}
		}
			System.out.println("\n");
			
		for (Funcionario funcionario : funcionarios) {	
			if(funcionario.getFuncao().equals("Coordenador")) {
				System.out.println("Nome: " + funcionario.getNome() + " - " + 
						   		   "Data de nascimento: " 	+ funcionario.getDataNascimento().format(dataFormatada) + " - " + 
		                           "Salario: R$" + salarioFormatado.format(funcionario.getSalario()) + " - " + 
		                           "Funcao: " + funcionario.getFuncao());
			}
		}
		System.out.println("\n");
		
		for (Funcionario funcionario : funcionarios) {
			if(funcionario.getFuncao().equals("Diretor")) {
				System.out.println("Nome: " + funcionario.getNome() + " - " + 
						   		   "Data de nascimento: " 	+ funcionario.getDataNascimento().format(dataFormatada) + " - " + 
		                           "Salario: R$" + salarioFormatado.format(funcionario.getSalario()) + " - " + 
		                           "Funcao: " + funcionario.getFuncao());
			}
		}
		
		System.out.println("\n");
		
		for (Funcionario funcionario : funcionarios) {
			if(funcionario.getFuncao().equals("Recepcionista")) {
				System.out.println("Nome: " + funcionario.getNome() + " - " + 
						   		   "Data de nascimento: " 	+ funcionario.getDataNascimento().format(dataFormatada) + " - " + 
		                           "Salario: R$" + salarioFormatado.format(funcionario.getSalario()) + " - " + 
		                           "Funcao: " + funcionario.getFuncao());
			}
		}
		
		System.out.println("\n");
		
		for (Funcionario funcionario : funcionarios) {
			if(funcionario.getFuncao().equals("Contador")) {
				System.out.println("Nome: " + funcionario.getNome() + " - " + 
						   		   "Data de nascimento: " 	+ funcionario.getDataNascimento().format(dataFormatada) + " - " + 
		                           "Salario: R$" + salarioFormatado.format(funcionario.getSalario()) + " - " + 
		                           "Funcao: " + funcionario.getFuncao());
			}
		}
		
		System.out.println("\n");
		
		for (Funcionario funcionario : funcionarios) {
			if(funcionario.getFuncao().equals("Gerente")) {
				System.out.println("Nome: " + funcionario.getNome() + " - " + 
						   		   "Data de nascimento: " 	+ funcionario.getDataNascimento().format(dataFormatada) + " - " + 
		                           "Salario: R$" + salarioFormatado.format(funcionario.getSalario()) + " - " + 
		                           "Funcao: " + funcionario.getFuncao());
			}
		}
		
		System.out.println("\n");
		
		for (Funcionario funcionario : funcionarios) {
			if(funcionario.getFuncao().equals("Eletricista")) {
				System.out.println("Nome: " + funcionario.getNome() + " - " + 
						   		   "Data de nascimento: " 	+ funcionario.getDataNascimento().format(dataFormatada) + " - " + 
		                           "Salario: R$" + salarioFormatado.format(funcionario.getSalario()) + " - " + 
		                           "Funcao: " + funcionario.getFuncao());
			}
		}
		System.out.println("\n");

		//3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
		System.out.println("Funcionarios que fazem aniversario no mes 10 e 12:");
		for (Funcionario funcionario : funcionarios) {
			int mesNascimento = funcionario.getDataNascimento().getMonthValue();
			if(mesNascimento == 10 || mesNascimento == 12) {
				System.out.println("Nome: " + funcionario.getNome() + " - " + 
						   		   "Data de nascimento: " 	+ funcionario.getDataNascimento().format(dataFormatada) + " - " + 
		                           "Salario: R$" + salarioFormatado.format(funcionario.getSalario()) + " - " + 
		                           "Funcao: " + funcionario.getFuncao());
			}
		}
		
		System.out.println("\n");
		
		//3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
		Funcionario funcionarioMaisVelho = null;
		int maiorIdade = 0;
		
		
		for (Funcionario funcionario : funcionarios) {
			LocalDate dataNascimento = funcionario.getDataNascimento();
			LocalDate dataAtual = LocalDate.now();
			
			int anoNascimento = dataNascimento.getYear();
			int anoAtual = dataAtual.getYear();

			int idade = anoAtual - anoNascimento;
			
			if (dataNascimento.getDayOfYear() > dataAtual.getDayOfYear()) {
			    idade--;
			}	
			
			if (idade > maiorIdade) {
		        maiorIdade = idade;
		        funcionarioMaisVelho = funcionario;
		    }
			
		}
		System.out.println("Funcionario com maior idade:");
		System.out.println("Nome: " + funcionarioMaisVelho.getNome() + " - " + 
				   		   "Idade: " + maiorIdade); 
		
		System.out.println("\n");

		//3.10 – Imprimir a lista de funcionários por ordem alfabética.
		funcionarios.sort(Comparator.comparing(Funcionario::getNome));
		
		System.out.println("Funcionarios em ordem alfabetica:");
		for (Funcionario funcionario : funcionarios) {
		    System.out.println(funcionario.getNome());
		}
		
		System.out.println("\n");

		//3.11 – Imprimir o total dos salários dos funcionários.		
		BigDecimal totalSalarioFuncionario = BigDecimal.ZERO;
		
		for (Funcionario funcionario : funcionarios) {	
		    totalSalarioFuncionario = totalSalarioFuncionario.add(funcionario.getSalario());
		}
		
		System.out.println("Total dos salarios dos funcionarios: R$ " + salarioFormatado.format(totalSalarioFuncionario));
		
		//3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
		BigDecimal salarioMinimo = new BigDecimal("1212.00");
		for (Funcionario funcionario : funcionarios) {
		    double qtdSalariosMinimos = funcionario.getSalario().doubleValue() / salarioMinimo.doubleValue();
		    System.out.println(funcionario.getNome() + ": " + String.format("%.2f", qtdSalariosMinimos) + " salarios minimos");
		}
	}	
}
