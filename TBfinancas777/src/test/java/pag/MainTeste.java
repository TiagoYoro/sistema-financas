package pag;

import java.time.LocalDate;

import pag01.DAOService;
import pag01.Modelotrasacao.tipoTransacao;
import pag01.Transacao;

public class MainTeste {
	public static void main(String[] args) {
		
		DAOService servico =new DAOService();
		  // Adicionar algumas transações
        System.out.println("=== Adicionando Transações ===");
       
        servico.AdicionarTransacao(new Transacao("Salário", 1.412, "Receitas", LocalDate.of(2024, 12, 1),tipoTransacao.RECEITA));
        servico.AdicionarTransacao(new Transacao("Aluguel", 1200.00, "Despesas", LocalDate.of(2024, 12, 2),tipoTransacao.DESPESA));
        servico.AdicionarTransacao(new Transacao("Supermercado", 400.00, "Alimentação", LocalDate.of(2024, 12, 3), tipoTransacao.DESPESA));
        
     
     // Listar transações
        System.out.println("\n=== Listando Transações ===");
        //listarTransacoes(servico);
        
        
        
        
        
	}
	
	
	
}
