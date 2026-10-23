package gui;


import business.Auto;
import business.AutovermietungModel;
import javafx.stage.Stage;

public class AutovermietungControl {
	private AutovermietungView autovermietungView;
	private AutovermietungModel autovermietungModel=new AutovermietungModel();
	
	
	
	
	 public AutovermietungControl(Stage primaryStage) {
		
		this.autovermietungView = new AutovermietungView( primaryStage, this,autovermietungModel );
	}

	 public void nehmeAutoAuf(String kennzeichen, String typ, String modell,
		       	float tagespreis, String[] vermietetVonBis){
	    	try{ 
	    		autovermietungModel.setAuto(new Auto(kennzeichen, typ, modell, tagespreis, vermietetVonBis));
	    		autovermietungView.zeigeInformationsfensterAn("Das Auto wurde aufgenommen!");
	       	}
	       	catch(Exception exc){
	       		autovermietungView.zeigeFehlermeldungsfensterAn(exc.getMessage());
	     	}
	    }
	   
	    public void zeigeAutosAn(){
	    	if(autovermietungModel.getAuto() != null){
	    		autovermietungView.zeigeAn(autovermietungModel.getAuto().gibAutoZurueck(' '));
	    	}
	    	else{
	    		autovermietungView.zeigeInformationsfensterAn("Bisher wurde kein Auto aufgenommen!");
	    	}
	    }    
			  
	    public void leseAusDatei(String typ){
	    	try {
	      		if("csv".equals(typ)){
	      			autovermietungModel.leseAusDatei(typ);
	      				autovermietungView.zeigeInformationsfensterAn(
	      	  	   			"Das Auto wurde gelesen!");
	      		}
	       		else{
	       			autovermietungView.zeigeInformationsfensterAn(
		   				"Noch nicht implementiert!");
		   		}
			}
			
			catch(Exception exc){
				autovermietungView.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Lesen!");
			}
		}
			
		public void schreibeAutoInCsvDatei() {
			try {
				autovermietungModel.schreibeAutoInCsvDatei();
				autovermietungView.zeigeInformationsfensterAn(
		   			"Die Autos wurden gespeichert!");
			}	
			
			catch(Exception exc){
				autovermietungView.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Speichern!");
			}
		}
}
