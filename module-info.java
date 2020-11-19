module  MrJackPocket{
	requires javafx.graphics;
	requires javafx.controls;
	requires javafx.base;
	requires kotlin.stdlib; // pour le label  + englobe le module graphics
	exports src.InterfaceGraphique;
}