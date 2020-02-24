package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.dto.PlayerDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Player;
import it.contrader.service.PlayerService;

import java.util.ArrayList;
import java.util.List;


public class PlayerView extends AbstractView{
	
		private Request request;
		private String choice;
		private PlayerService service;
		public PlayerView() {
			service= new PlayerService();
		}

		/**
		 * Mostra la lista utenti
		 */
		@Override
		public void showResults(Request request) {

				System.out.println("\n--------------------------------------------------------- Players Section -------------------------------------------------------\n");
				System.out.println("Player Id-----------Nome------------Cognome-----------Eta----------Valore Attuale Mercato--------Valore Precedente Mercato--------Ruolo");
				ArrayList<Player> lista= new ArrayList<Player>(service.getAllPlayers());
				for(Player player:lista) {
					System.out.println(player);
				}
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