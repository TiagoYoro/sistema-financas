package pag002Testes;

import java.time.LocalDate;
import pag01.DAOService;
import pag01.Modelotrasacao;
import pag01.Transacao;

public class TesteDAOService {
	public static void main(String[] args) {
		System.out.println("--------------------------------------------------------------------");
		//System.out.println("saldo atual"+ valor);
		System.out.println("--------------------------------------------------------------------");
		DAOService daoservico=new DAOService();
		//adicionando itens 
		//01
		Transacao transacao1= new Transacao("salario", 1.412, "renda", 
		LocalDate.of(2024, 12, 1),Modelotrasacao.tipoTransacao.RECEITA);
		//02
		Transacao transacao02=new Transacao("aluguel", 450, "despesa", 
		LocalDate.of(2024,12,2), Modelotrasacao.tipoTransacao.DESPESA);
		//03
		Transacao transacao3 = new Transacao("Compra Supermercado", 500.00, "despesa", 
		LocalDate.of(2024, 12, 5), Modelotrasacao.tipoTransacao.DESPESA);
		System.out.println("00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
		//editando  transacao01 
		transacao1.setValor(1412);
		System.out.println("transacao"+transacao1.ResumoObjetos());
		System.out.println("00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
		//editando  transacao01 
		// Atualizar a descrição da transação
		transacao02.setDescricao("investimento do mês");
		transacao02.setValor(500);
		transacao02.setCategoria("renda");
		transacao02.setData(LocalDate.of(2024, 12, 10));
		transacao02.setTipo(Modelotrasacao.tipoTransacao.RECEITA);
		// Verificar se a descrição foi alterada
		System.out.println("Descrição atualizada: " + transacao02.getDescricao());
		System.out.println("**********************************************************************");
		System.out.println("descriçao "+transacao02.ResumoObjetos());
		System.out.println("**********************************************************************");
		
		//adicionando a lista 
		daoservico.AdicionarTransacao(transacao1);
		daoservico.AdicionarTransacao(transacao02);
		daoservico.AdicionarTransacao(transacao3);
		System.out.println("/////////////////////////////////////////////////////////////////////////////");
		System.out.println("************************CALCULANDO SALDO **********************************************");
		// Calcular e imprimir o saldo
        double saldo = daoservico.CalcularSaldo();
        System.out.println("Saldo atual: R$ " + saldo);
		
		System.out.println("**********************************************************************");
		//04
				Transacao transacao4 = new Transacao("dinheiro extra ", 2000, "receita", 
				LocalDate.of(2024, 12, 11), Modelotrasacao.tipoTransacao.RECEITA);
				daoservico.AdicionarTransacao(transacao4);
		System.out.println("--------------------------------------------------------------------");
		System.out.println("**********************************************************************");
		System.out.println("00000000000000000000000000000 CALCULANDO RECEITA 00000000000000000000000000000000000000");
		System.out.println("**********************************************************************");
		// Somando todas as receitas
		double totalReceitas = daoservico.somarReceitas();
		System.out.println("total receita "+totalReceitas);
		System.out.println("**********************************************************************");
		System.out.println("**********************************************************************");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("**********************************************************************");
		System.out.println("00000000000000000000000000000 CALCULANDO DESPESAS 00000000000000000000000000000000000000");
		System.out.println("**********************************************************************");
		// Somando todas as despesas
	    double totalDespesas = daoservico.somarDespesas();
	    System.out.println("total das despesas "+totalDespesas);
	    System.out.println("**********************************************************************");
	    
	    ////// TESTE DE EXCLUSAO ///////////////////////////////////////////////////////
	    System.out.println("excluindo compra supermercado ");
	    
	    
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	///////////////////////////////////PARTE DO METODOS//////////////////////////////////////////////////////////////	
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Listar todas as transações
		System.out.println("\nTransações registradas:");
		for(Transacao t : daoservico.ListraTransacao()){
			System.out.println(t.getDescricao()+" | "+t.getValor()+
			" | "+t.getCategoria()+" | "+t.getData()+" | "+t.getTipo());
		}
		// Filtrar transações por período
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\nTransações após edição e exclusão:");
		System.out.println("--------------------------------------------------------------------");
		for (Transacao t : daoservico.FiltrarPouPeriudo(LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 10))){
			 System.out.println(t.getDescricao()+" | "+t.getValor() +" | "+t.getCategoria() 
			 + " | " + t.getData() + " | " + t.getTipo());
		}
		// Editar uma transação
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("\nEditando transação 'Compra Supermercado' para 'Compra Alimentação'");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");
		// Criar uma nova transação com os dados atualizados
		Transacao novaTransacao = new Transacao("Compra Alimentação", 550.00, "Alimentação", 
		LocalDate.of(2024, 12, 5), Modelotrasacao.tipoTransacao.DESPESA);
		System.out.println("------------------------------------------------------------------------------------------");
		// Variável para verificar se a transação foi editada com sucesso
		boolean sucesso = false;

		// aIterar sobre todas as transações no banco de dados
		for (int i = 0; i < daoservico.ListraTransacao().size(); i++) {
		    Transacao transacaoExistente = daoservico.ListraTransacao().get(i);
		    // Verificar se a descrição da transação existente corresponde à descrição que desejamos editar
		    if (transacaoExistente.getDescricao().equals("Compra Supermercado")) {
		        // Editar a transação, substituindo pela nova
		        daoservico.ListraTransacao().set(i, novaTransacao); // Substituindo o objeto
		        sucesso = true; // Marca como sucesso
		        break; // Interrompe o laço, pois a transação foi encontrada e editada
		        }
		}
		// Exibir o resultado do processo de edição APÓS o laço
		if (sucesso) {
			System.out.println("--------------------------------------------------------------------");
		    System.out.println("Transação editada com sucesso!");
		    System.out.println("Lista atualizada de transações:");
		    System.out.println("--------------------------------------------------------------------");
		    for(int i=0; i< daoservico.ListraTransacao().size();++i){
		    	Transacao t =daoservico.ListraTransacao().get(i);
		    	System.out.println("--------------------------------------------------------------------");
		    	System.out.printf("Descrição: %s | Valor: %.2f | Categoria: %s | Data: %s | Tipo: %s\n",
		    	t.getDescricao(), t.getValor(), t.getCategoria(),t.getData(),t.getTipo());
		    	System.out.println("--------------------------------------------------------------------");
		    }
		    
		} else {
		    System.out.println("Falha ao editar transação.nao encontrada ");
		}
        }
	
	}
