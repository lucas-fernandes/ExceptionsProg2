
public class Funcionario {

	private int codigo;
	private String nome;
	private Double salario;
	private Funcao funcao;
	
	public Funcionario(int codigo, String nome, Double salario, Funcao f) {
		this.codigo = codigo;
		this.nome = nome;
		this.salario = salario;
		this.funcao = f;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Codigo:" + codigo + "\n Nome:" + nome + " \n Salario R$:" + salario + "\n Função:" + funcao;
	}
}
