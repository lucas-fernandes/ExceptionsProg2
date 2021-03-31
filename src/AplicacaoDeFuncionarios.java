import java.util.ArrayList;
import java.util.Scanner;

public class AplicacaoDeFuncionarios {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int codigo, codigoFuncao, opcao = 0;
		String nome;
		double sal;
		
		Funcionario func;
		Funcao f;
		CadastroFuncionarios repositorio = new CadastroFuncionarios();
		
		do {
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Buscar");
			System.out.println("3 - Imprimir Folha");
			System.out.println("4 - Remover");
			System.out.println("5 - Alterar Funcionario");
			System.out.println("9 - Sair");
			opcao = sc.nextInt();
			sc.nextLine();
			
			switch(opcao) {
				case 1:
					System.out.println("1 - Gerente");
					System.out.println("2 - Operador");
					System.out.println("3 - Vendedor");
					opcao = sc.nextInt();
					sc.nextLine();
					
					System.out.println("Nome...:");
					nome = sc.nextLine();
					
					System.out.println("Salário...:");
					sal = sc.nextDouble();
					sc.nextLine();
					
					System.out.println("Código do Funcionário:");
					codigo = sc.nextInt();
					sc.nextLine();
					
					if(opcao == 1) {
						codigoFuncao = 100;
						f = new Gerente(codigoFuncao);
					}else if(opcao == 2) {
						codigoFuncao = 200;
						f = new Operador(codigoFuncao);
					}else {
						codigoFuncao = 300;
						f = new Vendedor(codigoFuncao);
					}
					
					func = new Funcionario(codigo, nome, sal, f);
					
					try {
						repositorio.inserir(func);
						System.out.println("Cadastrado com sucesso!!");
					}catch(CadastroCheioException | FuncionarioJaCadastradoException c){
						System.out.println(c.getMessage());
					}
				break;
				
				case 2:
					System.out.println("Digite o código do funcionário:");
					codigo = sc.nextInt();
					sc.nextLine();
					
					try {
						func = repositorio.buscar(codigo);
						System.out.println(func);
					}catch(FuncionarioNaoCadastradoException e) {
						System.out.println(e.getMessage());
					}
				break;	
				
				case 3:
					imprimeFolha(repositorio.getFuncionarios());
					break;
					
				case 4:
					System.out.println("Digite o código do funcionário a remover:");
					codigo = sc.nextInt();
					sc.nextLine();
					
					try {
						repositorio.remover(codigo);
						System.out.println("Removido com sucesso!");
					}catch(FuncionarioNaoCadastradoException e) {
						System.out.println(e.getMessage());
					}finally {
						System.out.println("Quantidade atual: " + repositorio.getQuantFunc());
					}
				break;
				
				case 5:
					System.out.println("Insira o código do funcionário para alterar:");
					codigo = sc.nextInt();
					sc.nextLine();
					
					try{
						Funcionario fun = repositorio.buscar(codigo);
						
						System.out.println("Funcionário selecionado: \n" + fun);
						System.out.println("----------------------------------------------");
						System.out.println("Insira os novos dados do funcionário");
						System.out.println("Função:");
						System.out.println("1 - Gerente");
						System.out.println("2 - Operador");
						System.out.println("3 - Vendedor");
						opcao = sc.nextInt();
						sc.nextLine();
						
						System.out.println("Nome...:");
						nome = sc.nextLine();
						
						System.out.println("Salário...:");
						sal = sc.nextDouble();
						sc.nextLine();
						
						if(opcao == 1) {
							codigoFuncao = 100;
							f = new Gerente(codigoFuncao);
						}else if(opcao == 2) {
							codigoFuncao = 200;
							f = new Operador(codigoFuncao);
						}else {
							codigoFuncao = 300;
							f = new Vendedor(codigoFuncao);
						}
						
						func = new Funcionario(fun.getCodigo(), nome, sal, f);
						
						repositorio.alterar(func);
						System.out.println("Funcionário alterado com sucesso!");
						
						Funcionario exibFunc = repositorio.buscar(func.getCodigo());
						System.out.println(exibFunc);
						
					}catch(FuncionarioNaoCadastradoException | FuncionarioJaCadastradoException | CadastroCheioException e) {
						System.out.println(e.getMessage());
					}
				break;
			}
			
		}while(opcao !=9);
		
	}

	public static void imprimeFolha(ArrayList<Funcionario> array) {
		
		double total = 0;
		
		for(Funcionario temp: array) {
			System.out.println(temp.getNome() + "\t");
			System.out.println("R$:" + temp.getSalario() + "\t");
			
			total += temp.getSalario();
			
			if(temp.getFuncao() instanceof Gerente) {
				System.out.print("Gerente \n");
			}else if(temp.getFuncao() instanceof Operador) {
				System.out.print("Operador \n");
			}else {
				System.out.print("Vendedor \n");
			}
			
		}
		
		System.out.println("Total de pagamento: " + total);
		
	}
}
