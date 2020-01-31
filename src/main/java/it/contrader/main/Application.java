package it.contrader.main;

import it.contrader.dao.PlayerDAO;
import it.contrader.model.Player;

/*
 * Ogni applicazione java necessita di una funzione main() 
 * Essa sar� di fatto la prima funzione chiamata dalla JVM, la sua mancanza verr� infatti notata dall'interprete che 
 * quindi non permetter� l'avvio del programma.
 * Banalmente qualsiasi applicazione a cascata ( stile C ) potrebbe essere interamente scritta all'interno del main
 * ma questo non avrebbe senso all'interno di un linguaggio di programmazione ad oggetti.
 * Per ulteriori dettagli GUIDA SEZIONE 1.
*/
public class Application {

    public static void main(String[] args) {
//    	Player player= new Player(1, "h", "s", 1, 2,4, "e");

//    	PlayerDAO playerDAO=new PlayerDAO();
//    	playerDAO.insertPlayer(player);

   // 	PlayerDAO playerDAO=new PlayerDAO();
   //	playerDAO.insertPlayer(player);
   //	System.out.println("---------------------");

//    	System.out.println(playerDAO.readPlayer(0));;
//    	System.out.println(playerDAO.getAllPlayers());
    	
    	MainDispatcher.getInstance().callAction("Login", "doControl", null);
    }

}
