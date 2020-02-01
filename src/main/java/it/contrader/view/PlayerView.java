package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.dto.PlayerDTO;
import it.contrader.main.MainDispatcher;

import java.util.List;


public class PlayerView extends AbstractView{
	
		private Request request;
		private String choice;

		public PlayerView() {
			
		}

		/**
		 * Mostra la lista utenti
		 */
		@Override
		public void showResults(Request request) {
//			if (request != null) {
				System.out.println("\n--------------------------------------------------------- Players Section -------------------------------------------------------\n");
//		
//				
//				
//				@SuppressWarnings("unchecked")
//				List<PlayerDTO> players = (List<PlayerDTO>) request.get("player");
//				for (PlayerDTO p: players)
//					System.out.println(p);
//				System.out.println();
		//	}
		}

		/**
		 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi UserController). 
		 * Mette la modalit� GETCHOICE nella mode.
		 */
		@Override
		public void showOptions() {
			System.out.println("          Scegli l'operazione da effettuare:");
			System.out.println("[L]eggiPlayer [I]nserisci player [V]edi Lista interra [U]pdate player [C]ancella [B]ack [E]sci");

			this.choice = getInput();

			
		}
		
		/**
		 * Impacchetta la request e la manda allo UserController.
		 */
		@Override
		public void submit() {
			request = new Request();
			request.put("choice", choice);
			request.put("mode", "GETCHOICE");
			MainDispatcher.getInstance().callAction("Player", "doControl", this.request);
		}

		
		
	}