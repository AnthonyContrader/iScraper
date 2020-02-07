package it.contrader.utils;

public class InputValidation {
	
	public static String intValidation(String num, String destination) {
	    boolean possibleMaxValue = false;
	    boolean negative = false;
		//Se la stringa è vuota ritorna il messaggio d'errore
	    if (num == null) {
	        return "Campo valore vuoto";
	    }
	    int length = num.length();
	    if (length == 0) {
	        return "Campo valore vuoto";
	    }
	    //Se la stringa ha 10 valori flagga un controllo per l'overflow,
	    //se ne ha di più ritorna il messaggio d'errore
	    if (length >= 10) {
	    	if (length > 10) {
	    		return "Valore non valido";
	    	}
	    	possibleMaxValue = true;
	    }
	    int i = 0;
	    //Controlla se il primo carattere della stringa è un -, in caso positivo
	    //modifica il punto d'inizio dei controlli e flagga il controllo per
	    //numeri negativi da eseguire nel caso si rischi l'overflow
	    if (num.charAt(0) == '-') {
	        if (length == 1) {
	            return "Valore non valido";
	        }
	        i = 1;
	        negative = true;
	    }
	    //Se è un possibile valore massimo controlla che ogni singolo carattere non
	    //superi un determinato valore
	    //In qualunque momento il valore controllato non pone il valore complessivo
	    //al limite dell'overflow esce e continua con il controllo normale
	    if (possibleMaxValue) {
	    	if (negative) {
	    		if (num.charAt(i) < '0' || num.charAt(i) > '2') return "Inserire un numero valido";
	    		else if (num.charAt(i)=='2'){
	    			i++;
		    		if (num.charAt(i) < '0' || num.charAt(i) > '1') return "Inserire un numero valido";
		    		else if (num.charAt(i)=='1') {
		    			i++;
		    			if (num.charAt(i) < '0' || num.charAt(i) > '4') return "Inserire un numero valido";
		    			else if (num.charAt(i)=='4') {
			    			i++;
				    		if (num.charAt(i) < '0' || num.charAt(i) > '7') return "Inserire un numero valido";
				    		else if(num.charAt(i)=='7') {
					    		i++;
					    		if (num.charAt(i) < '0' || num.charAt(i) > '4') return "Inserire un numero valido";
					    		else if(num.charAt(i)=='4') {
						    		i++;
						    		if (num.charAt(i) < '0' || num.charAt(i) > '8') return "Inserire un numero valido";
						    		else if(num.charAt(i)=='8') {
						    			i++;
							    		if (num.charAt(i) < '0' || num.charAt(i) > '3') return "Inserire un numero valido";
							    		else if(num.charAt(i)=='3') {
								    		i++;
								    		if (num.charAt(i) < '0' || num.charAt(i) > '6') return "Inserire un numero valido";
								    		else if(num.charAt(i)=='6') { 
									    		i++;
									    		if (num.charAt(i) < '0' || num.charAt(i) > '4') return "Inserire un numero valido";
									    		else if(num.charAt(i)=='4') {
										    		i++;
										    		if (num.charAt(i) < '0' || num.charAt(i) > '8') return "Inserire un numero valido";
										    		return "ok";
									    		}
								    		}
							    		}
						    		}
					    		}
				    		}
		    			}
		    		}
	    		}
	    		//In una delle if innestate si è scoperto che un valore era inferiore a quello
	    		//che rischiava di mandare l'int in overflow, per cui il controllo riprende
	    		//normalmente dal valore successivo
		    	i++;
		    	for (; i < length; i++) {
			    	char c = num.charAt(i);
			    	if (c < '0' || c > '9') {
			    		return "Inserire un numero";
			    	}
		    	}
		    	return "ok";
	    	} else {
	    		//Funziona come il controllo del blocco precedente, ma controlla un valore positivo
	    		if (num.charAt(i) < '0' || num.charAt(i) > '2') return "Inserire un numero valido";
	    		else if (num.charAt(i)=='2'){
	    			i++;
		    		if (num.charAt(i) < '0' || num.charAt(i) > '1') return "Inserire un numero valido";
		    		else if (num.charAt(i)=='1') {
		    			i++;
		    			if (num.charAt(i) < '0' || num.charAt(i) > '4') return "Inserire un numero valido";
		    			else if (num.charAt(i)=='4') {
			    			i++;
				    		if (num.charAt(i) < '0' || num.charAt(i) > '7') return "Inserire un numero valido";
				    		else if(num.charAt(i)=='7') {
					    		i++;
					    		if (num.charAt(i) < '0' || num.charAt(i) > '4') return "Inserire un numero valido";
					    		else if(num.charAt(i)=='4') {
						    		i++;
						    		if (num.charAt(i) < '0' || num.charAt(i) > '8') return "Inserire un numero valido";
						    		else if(num.charAt(i)=='8') {
						    			i++;
							    		if (num.charAt(i) < '0' || num.charAt(i) > '3') return "Inserire un numero valido";
							    		else if(num.charAt(i)=='3') {
								    		i++;
								    		if (num.charAt(i) < '0' || num.charAt(i) > '6') return "Inserire un numero valido";
								    		else if(num.charAt(i)=='6') { 
									    		i++;
									    		if (num.charAt(i) < '0' || num.charAt(i) > '4') return "Inserire un numero valido";
									    		else if(num.charAt(i)=='4') {
										    		i++;
										    		if (num.charAt(i) < '0' || num.charAt(i) > '7') return "Inserire un numero valido";
										    		return "ok";
									    		}
								    		}
							    		}
						    		}
					    		}
				    		}
		    			}
		    		}
	    		}
		    	i++;
		    	for (; i < length; i++) {
			    	char c = num.charAt(i);
			    	if (c < '0' || c > '9') {
			    		return "Inserire un numero";
			    	}
		    	}
		    	return "ok";
	    	}
	    } else {
	    	//Il valore non rischia l'overflow, si verifica solamente che ci siano
	    	//solo numeri nella stringa
	    	for (; i < length; i++) {
		        char c = num.charAt(i);
		        if (c < '0' || c > '9') {
		            return "Inserire un numero";
		        }
		    }
		    return "ok";
	    }
	}

	public static String unsignedIntValidation(String num, String destination) {
		boolean possibleMaxValue = false;
		//Se la stringa è vuota ritorna il messaggio d'errore
	    if (num == null) {
	        return "Campo valore vuoto";
	    }
	    int length = num.length();
	    if (length == 0) {
	        return "Campo valore vuoto";
	    }
	    //Se la stringa ha 10 valori flagga un controllo per l'overflow,
	    //se ne ha di più ritorna il messaggio d'errore
	    if (length >= 10) {
	    	if (length > 10) {
	    		return "Valore non valido";
	    	}
	    	possibleMaxValue = true;
	    }
	    int i = 0;
	    //Se è un possibile valore massimo controlla che ogni singolo carattere non
	    //superi un determinato valore
	    //In qualunque momento il valore controllato non pone il valore complessivo
	    //al limite dell'overflow esce e continua con il controllo normale
	    if (possibleMaxValue) {
	    	if (num.charAt(i) < '0' || num.charAt(i) > '4') return "Inserire un numero valido";
	   		else if (num.charAt(i)=='4'){
	   			i++;
	    		if (num.charAt(i) < '0' || num.charAt(i) > '2') return "Inserire un numero valido";
	    		else if (num.charAt(i)=='2') {
	    			i++;
	    			if (num.charAt(i) < '0' || num.charAt(i) > '9') return "Inserire un numero valido";
	    			else if (num.charAt(i)=='9') {
			    		i++;
				    	if (num.charAt(i) < '0' || num.charAt(i) > '4') return "Inserire un numero valido";
				    	else if(num.charAt(i)=='4') {
					   		i++;
					   		if (num.charAt(i) < '0' || num.charAt(i) > '9') return "Inserire un numero valido";
					   		else if(num.charAt(i)=='9') {
					    		i++;
					    		if (num.charAt(i) < '0' || num.charAt(i) > '6') return "Inserire un numero valido";
					    		else if(num.charAt(i)=='6') {
					    			i++;
						    		if (num.charAt(i) < '0' || num.charAt(i) > '7') return "Inserire un numero valido";
						    		else if(num.charAt(i)=='7') {
							    		i++;
							    		if (num.charAt(i) < '0' || num.charAt(i) > '2') return "Inserire un numero valido";
							    		else if(num.charAt(i)=='2') { 
								    		i++;
								    		if (num.charAt(i) < '0' || num.charAt(i) > '9') return "Inserire un numero valido";
								    		else if(num.charAt(i)=='9') {
									    		i++;
									    		if (num.charAt(i) < '0' || num.charAt(i) > '5') return "Inserire un numero valido";
									    		return "ok";
								    		}
							    		}
						    		}
					    		}
					   		}
				    	}
		    		}
	    		}
	    	}
	    	i++;
		    for (; i < length; i++) {
			   	char c = num.charAt(i);
			   	if (c < '0' || c > '9') {
			   		return "Inserire un numero";
			   	}
		    }
		    return "ok";
	    } else {
	    	//Il valore non rischia l'overflow, si verifica solamente che ci siano
	    	//solo numeri nella stringa
	    	for (; i < length; i++) {
		        char c = num.charAt(i);
		        if (c < '0' || c > '9') {
		            return "Inserire un numero";
		        }
		    }
		    return "ok";
	    }
	}
}