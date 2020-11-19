module HelloJavaFX {
	//requires javafx.graphics;
	requires javafx.controls;
	//requires javafx.base; // pour le label  + englobe le module graphics 
	exports InterfaceGraphique;
}