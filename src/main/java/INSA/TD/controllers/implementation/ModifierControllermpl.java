package INSA.TD.controllers.implementation;

public class ModifierControllermpl /*implements InitController*/{

    public void ModifierControllermpl(boolean modifiable /*, préciser le type de la classe de l'interphace*/){
        String message;
        if (modifiable == true){
            message = "modifier";
            //implémenter le moyen de sauvegarder qui dépend du tyoe entrer
            // passer à l'inteface de classe spécifique avec modifiable = False
        } else if (modifiable==false) {
            message = "sauvegarder";
            // passer à l'inteface de classe spécifique avec modifiable = False
        }
    }
    //on pourras ajouter pour les classes où il y a un modifier qui fonctionne différemment

}
