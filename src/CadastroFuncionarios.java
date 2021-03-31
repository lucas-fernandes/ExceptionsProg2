import java.util.ArrayList;

public class CadastroFuncionarios {

	private ArrayList<Funcionario> funcionarios;
	private int quantFunc;
	
	public CadastroFuncionarios() {
		funcionarios = new ArrayList<Funcionario>(50);
		quantFunc = 0;
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public int getQuantFunc() {
		return quantFunc;
	}
	
	public void inserir(Funcionario func) throws FuncionarioJaCadastradoException,
												 CadastroCheioException{
		if(quantFunc == 5) {
			throw new CadastroCheioException();
		}
		
		if(funcionarios.contains(func)) {
			throw new FuncionarioJaCadastradoException();
		}

		funcionarios.add(func);
		quantFunc++;
	}
	
	public Funcionario buscar(int codigo) throws FuncionarioNaoCadastradoException{
		Funcionario f = new Funcionario(codigo,"",0.0,null);
		
		if(!funcionarios.contains(f)) {
			throw new FuncionarioNaoCadastradoException();
		}else {
			for(Funcionario temp: funcionarios) {
				if(temp.getCodigo() == f.getCodigo());{
					f = temp;
					break;
				}
			}
		}
		return f;
	}
	
	public void remover(int codigo) throws FuncionarioNaoCadastradoException{
		Funcionario temp = new Funcionario(codigo, "", 0.0, null);
		
		boolean resultado = funcionarios.remove(temp);
		
		if(!resultado) {
			throw new FuncionarioNaoCadastradoException();
		}
		
		quantFunc--;
	}
	
	public void alterar(Funcionario func) throws FuncionarioNaoCadastradoException, FuncionarioJaCadastradoException, CadastroCheioException {
		
		remover(func.getCodigo());
		inserir(func);
	}

}
