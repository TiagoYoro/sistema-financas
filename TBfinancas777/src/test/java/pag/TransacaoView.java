package pag;

import java.util.ArrayList;

import pag01.DAOService;
import pag01.Transacao;

public class TransacaoView {
	
	// Método para listar transações
	public static void listarTransacoes01(DAOService servico){
		System.out.println("\n=== Lista de Transações ===");
		ArrayList<Transacao>ListraTransacao=servico.ListraTransacao();

		if(ListraTransacao.size() ==0) {
			System.out.println();
		}else {
			System.out.println();
		}
	}

}
 