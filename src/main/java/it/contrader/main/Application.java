package it.contrader.main;

import java.sql.Date;

import it.contrader.dao.InjuryDAO;
import it.contrader.dao.PlayerDAO;
import it.contrader.dto.InjuryDTO;
import it.contrader.model.Injury;
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

<<<<<<< HEAD
    public static void main(String[] args) {
//   	Player player= new Player(1, "h", "i",23,33,232,"ss");
////
//
//   	PlayerDAO playerDAO=new PlayerDAO();
//   	playerDAO.updatePlayer(player);
=======
   public static void main(String[] args) {
//	Player player= new Player(10, "h", "s", 1, 2,4, "e");
//

//  PlayerDAO playerDAO=new PlayerDAO();
//	playerDAO.updatePlayer(player);
>>>>>>> 9790dad1efa7b837c78b5f514b343ff3f87be021

   // 	PlayerDAO playerDAO=new PlayerDAO();
   //	playerDAO.insertPlayer(player);
   //	System.out.println("---------------------");
<<<<<<< HEAD


//    	System.out.println(playerDAO.readPlayer(0));;
  // 	System.out.println(playerDAO.getAllPlayers());
=======
//   	PlayerDAO playerDAO=new PlayerDAO();
//   	playerDAO.insertPlayer(player);
// 	PlayerDAO playerDAO=new PlayerDAO();
//	playerDAO.insertPlayer(player);
//	System.out.println("---------------------");


//    	System.out.println(playerDAO.readPlayer(0));;
//   	System.out.println(playerDAO.getAllPlayers());
>>>>>>> 9790dad1efa7b837c78b5f514b343ff3f87be021
//    	Date date= new Date(2000-12-22);
// //   
//    	Injury injury=new Injury(12, "weww", date,2, 12);
//    	//severity, description, date, duration, player_id
//    	InjuryDAO injuryDAO=new InjuryDAO();
//    	injuryDAO.insert(injury);
//    	
//    	System.out.println(injuryDAO.getAllInjury());
//   // 	System.out.println(injuryDAO.read(2));
    	
//    	
//    	
    	
    	MainDispatcher.getInstance().callAction("Login", "doControl", null);
    }

}
