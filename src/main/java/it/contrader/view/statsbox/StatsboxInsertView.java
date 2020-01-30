package it.contrader.view.statsbox;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class StatsboxInsertView extends AbstractView{
	private Request request;

	private int playerId;
	private String season;
	private String team;
	private int caps; //questo campo indica le presenze in questa stagione in campionato
	private float contributions; //questo campo indica le contribuzioni (gol o assist, che valgono rispettivamente 1 e 0.5) per 90 minuti di quel giocatore
	private float shotsper; //questo campo indica la percentuale di tiri in porta su tiri totali del giocatore, su 90 minuti
	private float keypass; //questo campo indica i passaggi chiave effettuati, su 90 minuti
	private float passprec; //questo campo indica la precisione dei passaggi (passaggi riusciti/passaggi effettuati)
	private float dribbling; //questo campo indica il numero di dribbling riusciti per partita
	private float foulssub; //falli subiti a partita
	private float foulscomm; //falli fatti a partita
	private float tackles; //contrasti effettuati a partita
	private float tacklesper; //percentuale di contrasti riusciti a partita
	private float breaks;
	private final String mode = "INSERT";

	public StatsboxInsertView() {
	}
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Statsbox", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci playerID:");
			playerId = Integer.parseInt(getInput());
			System.out.println("Inserisci stagione:");
			season = getInput();
			System.out.println("Inserisci squadra:");
			team = getInput();
			System.out.println("Inserisci presenze:");
			caps = Integer.parseInt(getInput());
			System.out.println("Inserisci contribuzioni:");
			contributions = Float.parseFloat(getInput());
			System.out.println("Inserisci percentuale tiri:");
			shotsper = Float.parseFloat(getInput());
			System.out.println("Inserisci passaggi chiave:");
			keypass = Float.parseFloat(getInput());
			System.out.println("Inserisci precisione passaggi:");
			passprec = Float.parseFloat(getInput());
			System.out.println("Inserisci dribbling:");
			dribbling = Float.parseFloat(getInput());
			System.out.println("Inserisci falli subiti:");
			foulssub = Float.parseFloat(getInput());
			System.out.println("Inserisci falli commessi:");
			foulscomm = Float.parseFloat(getInput());
			System.out.println("Inserisci tackles:");
			tackles = Float.parseFloat(getInput());
			System.out.println("Inserisci percentuale tackles riusciti:");
			tacklesper = Float.parseFloat(getInput());
			System.out.println("Inserisci breaks:");
			breaks = Float.parseFloat(getInput());
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("playerId", playerId);
		request.put("season", season);
		request.put("team", team);
		request.put("caps", caps);
		request.put("contributions", contributions);
		request.put("shotsper", shotsper);
		request.put("keypass", keypass);
		request.put("passprec", passprec);
		request.put("dribbling", dribbling);
		request.put("foulssub", foulssub);
		request.put("foulscomm", foulscomm);
		request.put("tackles", tackles);
		request.put("tacklesper", tacklesper);
		request.put("breaks", breaks);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Statsbox", "doControl", request);
	}


}