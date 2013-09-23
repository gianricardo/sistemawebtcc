package br.com.sistemaWebTCC.start;

public class Start implements Runnable{

    public void run() {
    	try {
			Thread.sleep(Long.parseLong("1000"));
			System.out.println("TESTE ");
			
			//consultar no banco se tem algum horario igual ao horario atual e se tiver alimentar o bixinho
			
			//pesquisar como chamar um servlet de uma classe Java
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
