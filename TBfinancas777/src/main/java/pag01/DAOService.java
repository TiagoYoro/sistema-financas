package pag01;

import java.time.LocalDate;
import java.util.ArrayList;
import pag01.Modelotrasacao.tipoTransacao;

public class DAOService{
	//.................................................................................................
	//lista privada // todas as outras lista se remetem a esta , porem esta e privada 
	private ArrayList <Transacao > transacao =new ArrayList<>();
	//.................................................................................................
	//metodo adicionar transaçao 
	public  boolean AdicionarTransacao(Transacao transacaoEs){
		if(transacaoEs==null){//caso a transaçao for nulla 
			System.out.println("Erro: Transação nula não pode ser adicionada.");
			 return false;
		}else if(transacaoEs.getValor()<0){//o valor nao podee ser menor que zero 
			 System.out.println("Erro: O valor da transação não pode ser negativo.");
		        return false;
		// Validação da descrição (não pode ser vazia ou nula)        
		}else if(transacaoEs.getDescricao()==null||transacaoEs.getDescricao().trim().isEmpty()){
			System.out.println("Erro: A descrição da transação não pode ser vazia.");
	        return false;
	    // Adiciona a transação à lista se tudo estiver correto
		}
		transacao.add(transacaoEs);
		System.out.println("Transação adicionada com sucesso:"+transacaoEs.getDescricao());
		return true;
		 }
	
	//obter saldo 
	public double  CalcularSaldo(){
		//atributo saldo 
		double saldo=0.0;//valor que começçamos o negocio 
		//laoço de repetiçao earch 
		for(Transacao t:transacao){//percorre a lista privada do topo do codigo 
			if(t.getTipo()==tipoTransacao.RECEITA){
				saldo+=t.getValor();
				System.out.println("saldo adicionado ,pois e uma receita ");
				}else{
				saldo-=t.getValor();
				System.out.println("valor negativo ou subtraido , pois e um gasto ");
			    }
			}
		return saldo;
		}
	
	//filtrar transaçao por periudo 
	public ArrayList <Transacao > FiltrarPouPeriudo(LocalDate inicio , LocalDate fim ) {
		ArrayList<Transacao > filtradas = new ArrayList<>();
		//looping de repeticacao 
		for(Transacao  t: transacao ) {
			//"Se a data da transação não for antes da data de início
			if (!t.getData().isBefore(inicio) && !t.getData().isAfter(fim)) {
				//adicinado a data da transacao  a lista 
				filtradas.add(t);
				System.out.println("transacao adicionada "+ t);
				  }else {
					  System.out.println("data nao foi adxicionada ");
				  }
			}
		return filtradas;
		
		  	}

	//lista a todas as transaçoes /LISTA PRINCIPAL
	public ArrayList<Transacao> ListraTransacao(){
		return new ArrayList<>(transacao);
	}
	
	//metodo de Editar  atravesz da descriçao 
	public boolean EditarTransacao(String descricao, Transacao novadescricao){//dois atributos estataneos 
		//transacao==> na lista do inicio do codigo / uma lista privada 
		for(int j=0; j<transacao.size();j++){
			if(transacao.get(j).getDescricao().equals(novadescricao)){
				transacao.set(j, novadescricao);
				return true;//retorna true se for editado 
			     }
		}
		return false;
		}
	
	//excluir com base na descriçao 
	public boolean  ExcluirTransacao(String descricao ){
		return transacao.removeIf(t ->t.getDescricao().equals(descricao) );
		   }
	
	//calculando receita 
	public double  somarReceitas(){
		double totalReceitas = 0.0;
		//interar sobre todas as transaçoes 
		for(Transacao transacao : ListraTransacao()){
			if(transacao.getTipo()== Modelotrasacao.tipoTransacao.RECEITA){
				totalReceitas =+ transacao.getValor();
				System.out.println("receitas calculadas ");
			 }
		     }
		return totalReceitas;
	         }
	
	//calculando despesas 
	public double somarDespesas(){
		double totalDespesas=0.0;
		for(Transacao transacao : ListraTransacao()){
			if(transacao.getTipo()== Modelotrasacao.tipoTransacao.DESPESA){
				totalDespesas+=transacao.getValor();
				System.out.println("despesas calculadas ");
			}
		}
		return totalDespesas;
	    }
	
}
























