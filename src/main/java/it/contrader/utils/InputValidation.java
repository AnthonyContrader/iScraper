package it.contrader.utils;

import java.util.regex.Pattern;

public class InputValidation {
	
	public static String intValidation(String num) {
	    boolean possibleMaxValue = false;
	    boolean negative = false;
	    //Se la stringa è vuota ritorna il messaggio d'errore
	    if (num == null) {
	        return "Campo valore vuoto";
	    }
	    String trimmedNum = num.trim();
	    int length = trimmedNum.length();
	    if (length == 0) {
	        return "Campo valore vuoto";
	    }
	    int i = 0;
	    //Controlla se il primo carattere della stringa è un -, in caso positivo
	    //modifica il punto d'inizio dei controlli e flagga il controllo per
	    //numeri negativi da eseguire nel caso si rischi l'overflow
	    if (trimmedNum.charAt(0) == '-') {
	        if (length == 1) {
	            return "Valore non valido";
	        }
	        i = 1;
	        negative = true;
	    }
	    //Se la stringa ha 10 valori flagga un controllo per l'overflow,
	    //se ne ha di più ritorna il messaggio d'errore
	    if (length >= 10) {
	    	if (negative) {
		    	if (length > 11) {
		    		return "Valore non valido";
		    	}
	    	}
	    	else {
	    		if (length > 10) {
	    			return "Valore non valido";
	    		}
	    	}
	    	possibleMaxValue = true;
	    }
	    //Se è un possibile valore massimo controlla che ogni singolo carattere non
	    //superi un determinato valore
	    //In qualunque momento il valore controllato non pone il valore complessivo
	    //al limite dell'overflow esce e continua con il controllo normale
	    if (possibleMaxValue) {
	    	if (negative) {
	    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '2') return "Inserire un numero valido";
	    		else if (trimmedNum.charAt(i)=='2'){
	    			i++;
		    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '1') return "Inserire un numero valido";
		    		else if (trimmedNum.charAt(i)=='1') {
		    			i++;
		    			if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '4') return "Inserire un numero valido";
		    			else if (trimmedNum.charAt(i)=='4') {
			    			i++;
				    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '7') return "Inserire un numero valido";
				    		else if(trimmedNum.charAt(i)=='7') {
					    		i++;
					    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '4') return "Inserire un numero valido";
					    		else if(trimmedNum.charAt(i)=='4') {
						    		i++;
						    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '8') return "Inserire un numero valido";
						    		else if(trimmedNum.charAt(i)=='8') {
						    			i++;
							    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '3') return "Inserire un numero valido";
							    		else if(trimmedNum.charAt(i)=='3') {
								    		i++;
								    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '6') return "Inserire un numero valido";
								    		else if(trimmedNum.charAt(i)=='6') { 
									    		i++;
									    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '4') return "Inserire un numero valido";
									    		else if(trimmedNum.charAt(i)=='4') {
										    		i++;
										    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '8') return "Inserire un numero valido";
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
			    	char c = trimmedNum.charAt(i);
			    	if (c < '0' || c > '9') {
			    		return "Inserire un numero";
			    	}
		    	}
		    	return "ok";
	    	} else {
	    		//Funziona come il controllo del blocco precedente, ma controlla un valore positivo
	    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '2') return "Inserire un numero valido";
	    		else if (trimmedNum.charAt(i)=='2'){
	    			i++;
		    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '1') return "Inserire un numero valido";
		    		else if (trimmedNum.charAt(i)=='1') {
		    			i++;
		    			if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '4') return "Inserire un numero valido";
		    			else if (trimmedNum.charAt(i)=='4') {
			    			i++;
				    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '7') return "Inserire un numero valido";
				    		else if(trimmedNum.charAt(i)=='7') {
					    		i++;
					    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '4') return "Inserire un numero valido";
					    		else if(trimmedNum.charAt(i)=='4') {
						    		i++;
						    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '8') return "Inserire un numero valido";
						    		else if(trimmedNum.charAt(i)=='8') {
						    			i++;
							    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '3') return "Inserire un numero valido";
							    		else if(trimmedNum.charAt(i)=='3') {
								    		i++;
								    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '6') return "Inserire un numero valido";
								    		else if(trimmedNum.charAt(i)=='6') { 
									    		i++;
									    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '4') return "Inserire un numero valido";
									    		else if(trimmedNum.charAt(i)=='4') {
										    		i++;
										    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '7') return "Inserire un numero valido";
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
			    	char c = trimmedNum.charAt(i);
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
		        char c = trimmedNum.charAt(i);
		        if (c < '0' || c > '9') {
		            return "Inserire un numero";
		        }
		    }
		    return "ok";
	    }
	}

	public static String unsignedIntValidation(String num) {
		boolean possibleMaxValue = false;
		//Se la stringa è vuota ritorna il messaggio d'errore
	    if (num == null) {
	        return "Campo valore vuoto";
	    }
	    String trimmedNum = num.trim();
	    int length = trimmedNum.length();
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
	    	if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '4') return "Inserire un numero valido";
	   		else if (trimmedNum.charAt(i)=='4'){
	   			i++;
	    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '2') return "Inserire un numero valido";
	    		else if (trimmedNum.charAt(i)=='2') {
	    			i++;
	    			if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '9') return "Inserire un numero valido";
	    			else if (trimmedNum.charAt(i)=='9') {
			    		i++;
				    	if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '4') return "Inserire un numero valido";
				    	else if(trimmedNum.charAt(i)=='4') {
					   		i++;
					   		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '9') return "Inserire un numero valido";
					   		else if(trimmedNum.charAt(i)=='9') {
					    		i++;
					    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '6') return "Inserire un numero valido";
					    		else if(trimmedNum.charAt(i)=='6') {
					    			i++;
						    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '7') return "Inserire un numero valido";
						    		else if(trimmedNum.charAt(i)=='7') {
							    		i++;
							    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '2') return "Inserire un numero valido";
							    		else if(trimmedNum.charAt(i)=='2') { 
								    		i++;
								    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '9') return "Inserire un numero valido";
								    		else if(trimmedNum.charAt(i)=='9') {
									    		i++;
									    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '5') return "Inserire un numero valido";
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
			   	char c = trimmedNum.charAt(i);
			   	if (c < '0' || c > '9') {
			   		return "Inserire un numero";
			   	}
		    }
		    return "ok";
	    } else {
	    	//Il valore non rischia l'overflow, si verifica solamente che ci siano
	    	//solo numeri nella stringa
	    	for (; i < length; i++) {
		        char c = trimmedNum.charAt(i);
		        if (c < '0' || c > '9') {
		            return "Inserire un numero";
		        }
		    }
		    return "ok";
	    }
	}

	public static String shortValidation(String num) {
	    boolean possibleMaxValue = false;
	    boolean negative = false;
	    //Se la stringa è vuota ritorna il messaggio d'errore
	    if (num == null) {
	        return "Campo valore vuoto";
	    }
	    String trimmedNum = num.trim();
	    int length = trimmedNum.length();
	    if (length == 0) {
	        return "Campo valore vuoto";
	    }
	    int i = 0;
	    //Controlla se il primo carattere della stringa è un -, in caso positivo
	    //modifica il punto d'inizio dei controlli e flagga il controllo per
	    //numeri negativi da eseguire nel caso si rischi l'overflow
	    if (trimmedNum.charAt(0) == '-') {
	        if (length == 1) {
	            return "Valore non valido";
	        }
	        i = 1;
	        negative = true;
	    }
	    //Se la stringa ha 10 valori flagga un controllo per l'overflow,
	    //se ne ha di più ritorna il messaggio d'errore
	    if (length >= 5) {
	    	if (negative) {
		    	if (length > 6) {
		    		return "Valore non valido";
		    	}
	    	}
	    	else {
	    		if (length > 10) {
	    			return "Valore non valido";
	    		}
	    	}
	    	possibleMaxValue = true;
	    }
	    //Se è un possibile valore massimo controlla che ogni singolo carattere non
	    //superi un determinato valore
	    //In qualunque momento il valore controllato non pone il valore complessivo
	    //al limite dell'overflow esce e continua con il controllo normale
	    if (possibleMaxValue) {
	    	if (negative) {
	    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '3') return "Inserire un numero valido";
	    		else if (trimmedNum.charAt(i)=='3'){
	    			i++;
		    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '2') return "Inserire un numero valido";
		    		else if (trimmedNum.charAt(i)=='2') {
		    			i++;
		    			if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '7') return "Inserire un numero valido";
		    			else if (trimmedNum.charAt(i)=='7') {
			    			i++;
				    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '6') return "Inserire un numero valido";
				    		else if(trimmedNum.charAt(i)=='6') {
					    		i++;
					    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '8') return "Inserire un numero valido";
					    		return "ok";
							}
		    			}
		    		}
	    		}
	    		//In una delle if innestate si è scoperto che un valore era inferiore a quello
	    		//che rischiava di mandare l'int in overflow, per cui il controllo riprende
	    		//normalmente dal valore successivo
		    	i++;
		    	for (; i < length; i++) {
			    	char c = trimmedNum.charAt(i);
			    	if (c < '0' || c > '9') {
			    		return "Inserire un numero";
			    	}
		    	}
		    	return "ok";
	    	} else {
	    		//Funziona come il controllo del blocco precedente, ma controlla un valore positivo
	    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '3') return "Inserire un numero valido";
	    		else if (trimmedNum.charAt(i)=='2'){
	    			i++;
		    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '2') return "Inserire un numero valido";
		    		else if (trimmedNum.charAt(i)=='1') {
		    			i++;
		    			if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '7') return "Inserire un numero valido";
		    			else if (trimmedNum.charAt(i)=='4') {
			    			i++;
				    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '6') return "Inserire un numero valido";
				    		else if(trimmedNum.charAt(i)=='7') {
					    		i++;
					    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '8') return "Inserire un numero valido";
					    		return "ok";
				    		}
		    			}
		    		}
	    		}
		    	i++;
		    	for (; i < length; i++) {
			    	char c = trimmedNum.charAt(i);
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
		        char c = trimmedNum.charAt(i);
		        if (c < '0' || c > '9') {
		            return "Inserire un numero";
		        }
		    }
		    return "ok";
	    }
	}
	
	public static String unsignedShortValidation(String num) {
		boolean possibleMaxValue = false;
		//Se la stringa è vuota ritorna il messaggio d'errore
	    if (num == null) {
	        return "Campo valore vuoto";
	    }
	    String trimmedNum = num.trim();
	    int length = trimmedNum.length();
	    if (length == 0) {
	        return "Campo valore vuoto";
	    }
	    //Se la stringa ha 10 valori flagga un controllo per l'overflow,
	    //se ne ha di più ritorna il messaggio d'errore
	    if (length >= 5) {
	    	if (length > 5) {
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
	    	if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '6') return "Inserire un numero valido";
	   		else if (trimmedNum.charAt(i)=='6'){
	   			i++;
	    		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '5') return "Inserire un numero valido";
	    		else if (trimmedNum.charAt(i)=='5') {
	    			i++;
	    			if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '5') return "Inserire un numero valido";
	    			else if (trimmedNum.charAt(i)=='5') {
			    		i++;
				    	if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '3') return "Inserire un numero valido";
				    	else if(trimmedNum.charAt(i)=='3') {
					   		i++;
					   		if (trimmedNum.charAt(i) < '0' || trimmedNum.charAt(i) > '5') return "Inserire un numero valido";
					   		return "ok";
				    	}
		    		}
	    		}
	    	}
	    	i++;
		    for (; i < length; i++) {
			   	char c = trimmedNum.charAt(i);
			   	if (c < '0' || c > '9') {
			   		return "Inserire un numero";
			   	}
		    }
		    return "ok";
	    } else {
	    	//Il valore non rischia l'overflow, si verifica solamente che ci siano
	    	//solo numeri nella stringa
	    	for (; i < length; i++) {
		        char c = trimmedNum.charAt(i);
		        if (c < '0' || c > '9') {
		            return "Inserire un numero";
		        }
		    }
		    return "ok";
	    }
	}

	public static String floatValidation(String num) {
		String trimmedNum = num.trim();
		final String Digits     = "(\\p{Digit}+)";
		final String HexDigits  = "(\\p{XDigit}+)";
		  // an exponent is 'e' or 'E' followed by an optionally
		  // signed decimal integer.
		final String Exp        = "[eE][+-]?"+Digits;
		final String fpRegex    =
		      ("[\\x00-\\x20]*"+  // Optional leading "whitespace"
		       "[+-]?(" + // Optional sign character
		       "NaN|" +           // "NaN" string
		       "Infinity|" +      // "Infinity" string

		       // A decimal floating-point string representing a finite positive
		       // number without a leading sign has at most five basic pieces:
		       // Digits . Digits ExponentPart FloatTypeSuffix
		       //
		       // Since this method allows integer-only strings as input
		       // in addition to strings of floating-point literals, the
		       // two sub-patterns below are simplifications of the grammar
		       // productions from section 3.10.2 of
		       // The Java Language Specification.

		       // Digits ._opt Digits_opt ExponentPart_opt FloatTypeSuffix_opt
		       "((("+Digits+"(\\.)?("+Digits+"?)("+Exp+")?)|"+

		       // . Digits ExponentPart_opt FloatTypeSuffix_opt
		       "(\\.("+Digits+")("+Exp+")?)|"+

		       // Hexadecimal strings
		       "((" +
		        // 0[xX] HexDigits ._opt BinaryExponent FloatTypeSuffix_opt
		        "(0[xX]" + HexDigits + "(\\.)?)|" +

		        // 0[xX] HexDigits_opt . HexDigits BinaryExponent FloatTypeSuffix_opt
		        "(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +

		        ")[pP][+-]?" + Digits + "))" +
		       "[fFdD]?))" +
		       "[\\x00-\\x20]*");// Optional trailing "whitespace"
		  
		if (Pattern.matches(fpRegex, trimmedNum)) {
			if (Double.valueOf(trimmedNum)<Float.MIN_VALUE || Double.valueOf(trimmedNum)>Float.MAX_VALUE) {
				return "Valore troppo grande o troppo piccolo";
			}
		    return "ok";
		}
		else {
		    return "Il valore inserito non è un numero valido";
		}
	}
}