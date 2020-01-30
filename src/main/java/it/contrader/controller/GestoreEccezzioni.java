package it.contrader.controller;



public class GestoreEccezzioni {
    private static GestoreEccezzioni ourInstance = new GestoreEccezzioni();

    public static GestoreEccezzioni getInstance() {
        return ourInstance;
    }

    private GestoreEccezzioni() {
    }

    public void gestisciEccezione(Throwable e){
        e.printStackTrace();
    }
}
