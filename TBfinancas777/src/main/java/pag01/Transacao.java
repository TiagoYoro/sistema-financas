package pag01;
//importes 
import java.time.LocalDate;
import pag01.Modelotrasacao.tipoTransacao;

public class Transacao{
	//atrputos 
	private String descricao;
	private double valor;
	private String categoria;// Exemplo: "Salário", "Alimentação"
	private LocalDate data;
	private tipoTransacao tipo;//RECEITA , DESPESA;
	
	//metodo construtor 
	public Transacao(String descricao,double valor,String categoria,LocalDate data,tipoTransacao tipo) {
		this.descricao=descricao;
		this.valor=valor;
		this.categoria=categoria;
		this.data=data;
		this.tipo=tipo;
		}
	
//gettes and setters 
	public String getDescricao(){
		return descricao;
	}

	public void setDescricao(String descricao){
		this.descricao = descricao;
	}

	public double getValor(){
		return valor;
	}

	public void setValor(double valor){
		this.valor = valor;
	}

	public String getCategoria(){
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public LocalDate getData(){
		return data;
	}

	public void setData(LocalDate data){
		this.data = data;
	}

	public tipoTransacao getTipo(){
		return tipo;
	}

	public void setTipo(tipoTransacao tipo){
		this.tipo = tipo;
	}
	//toString 
	
	public String ResumoObjetos() {
	    return String.format(
	        "Descrição: %s | Valor: %.2f | Categoria: %s | Data: %s | Tipo: %s",
	        descricao, valor, categoria, data, tipo
	    );
	}



}
