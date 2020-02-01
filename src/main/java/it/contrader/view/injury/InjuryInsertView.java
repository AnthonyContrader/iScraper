package it.contrader.view.injury;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class InjuryInsertView extends AbstractView{
	
		private Request request;

		private int player_id;
		private int severity;
		private Date date;
		private int duration; //questo campo indica le presenze in questa stagione in campionato
		private String description;
		private final String mode = "INSERT";

		public InjuryInsertView() {
		}
		/**
		 * Se la request non � nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
		 * l'esito dell'operazione
		 */
		@Override
		public void showResults(Request request) {
			if (request!=null) {
				System.out.println("Inserimento andato a buon fine.\n");
				MainDispatcher.getInstance().callView("Injury", null);
			}
		}

		/**
		 * Chiede all'utente di inserire gli attributi dell'utente da inserire
		 */
		@Override
		public void showOptions() {
				System.out.println("Inserisci playerID:");
				player_id = Integer.parseInt(getInput());
				System.out.println("Inserisci severity:");
				severity = Integer.parseInt(getInput());
				System.out.println("Inserisci data formato yyyy-mm-dd:");
				
				 date =Date.valueOf(getInput());
				
				System.out.println("Inserisci durata infortunio:");
				duration = Integer.parseInt(getInput());
				System.out.println("Inserisci tipo infortunio:");
				description=getInput();
				
		}

		/**
		 * Impacchetta la request con i dati inseriti nel metodo showOption()
		 */
		@Override
		public void submit() {
			request = new Request();
			request.put("player_id", player_id);
			request.put("severity", severity);
			request.put("date", date);
			request.put("duration", duration);
			request.put("description", description);
			request.put("mode", mode);
			MainDispatcher.getInstance().callAction("Injury", "doControl", request);
		}


	}