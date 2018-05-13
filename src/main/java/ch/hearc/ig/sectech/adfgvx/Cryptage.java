/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.sectech.adfgvx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bastien.mittempe
 */
public class Cryptage extends ADFGVX {
    static ADFGVX tab = new ADFGVX();
    
    /**
     * Cette méthode va scinder le texte à chiffrer dans un tableau (une case un caractère),
     * elle va ensuite parcourir le tableau de substitution et tester la correspondance des valeurs.
     * Quand le test passe, ajoute le couple de clef au tableau de retour.
     * @param text Texte à chiffrer
     * @return ArrayList de string correspondant au texte chiffré intermédiaire
     */
    public static ArrayList<String> getTexteIntermediaire (String text){
        // Récupération du tableau de substitution
        ArrayList<String> tabTI = new ArrayList<>();
        HashMap<String, HashMap<String, String>> tabSub = new HashMap<>(tab.getTableau_substitution());
        
        // Sépaaration du texte en tableau de String[]
        String[] tabSplit = text.split("");
        
        // Parcours du tableau de String[]
        for (int i = 0; i < tabSplit.length; i++) {
            String current = tabSplit[i];
            
            // Parcours du tableau de substitution
            for (Map.Entry<String, HashMap<String, String>> en : tabSub.entrySet()) {
            Object key = en.getKey();
            Object value = en.getValue();
            
            // Récupération de la ligne du tableau de substitution
            HashMap<String, String> tabSubLine = new HashMap<>(tabSub.get(key));
            
                // Parcours de la ligne du tableau de substitution
                for (Map.Entry<String, String> entry : tabSubLine.entrySet()) {
                    String key1 = entry.getKey();
                    String value1 = entry.getValue();
                    
                    // Test de la valeur du String courrent et de la valeur de la case
                    if(value1.equals(current)){
                        
                        // Ajout du couple de clefs correspondant dans le tableau de retour
                        tabTI.add((String) key);
                        tabTI.add(key1);                      
                    } 
                }               
            }     
        }        
        return tabTI;
    }
    
    /**
     * Reçoit le TCI et le mot de passe, et remplis le tableau 
     * @param TCI Texte chiffré intermédiaire à passer dans le tableau
     * @param pwd Mot de passe pour le cryptage
     * @return 
     */
    public ArrayList<ArrayList<String>> getTableOrdered(ArrayList<String> TCI, String pwd){
        // Déclaration des lignes du tableau
        ArrayList<ArrayList<String>> tableOrdered = new ArrayList<>();
        ArrayList<String> tableLine0 = new ArrayList<>();
        ArrayList<String> tableLine1 = new ArrayList<>();
        ArrayList<String> tableLine2 = new ArrayList<>();
        ArrayList<String> tableLine3 = new ArrayList<>();
        ArrayList<String> tableLine4 = new ArrayList<>();
        ArrayList<String> tableLine5 = new ArrayList<>();
        ArrayList<String> tableLine6 = new ArrayList<>();
        
        // Séparation du mot de passe
        String[] tabSplit = pwd.split("");
        
        // Ajout des lettres dans les lignes
        for (int i = 0; i < tabSplit.length; i++) {
            if(!TCI.get(i).isEmpty()){
                tableLine0.add(tabSplit[i]);
            }
        }
        for (int i = 0; i < 6; i++) {
            if(!TCI.get(i).isEmpty()){
                tableLine1.add(TCI.get(i));
            }
        }
        for (int i = 6; i < 12; i++) {
            if(!TCI.get(i).isEmpty()){
                tableLine2.add(TCI.get(i));
            }
            
        }
        for (int i = 12; i < 18; i++) {
            if(!TCI.get(i).isEmpty()){
                tableLine3.add(TCI.get(i));
            }
            
        }
        for (int i = 18; i < 24; i++) {
            if(!TCI.get(i).isEmpty()){
                tableLine4.add(TCI.get(i));
            }
            
        }
        for (int i = 24; i < 30; i++) {
            if(!TCI.get(i).isEmpty()){
                tableLine5.add(TCI.get(i));
            }
            
        }
        for (int i = 30; i < 36; i++) {
            if(!TCI.get(i).isEmpty()){
                tableLine6.add(TCI.get(i));
            }
            
        }
        
        // Ajout des ligne dans le tableau pour le retour
        tableOrdered.add(tableLine0);
        tableOrdered.add(tableLine1);
        tableOrdered.add(tableLine2);
        tableOrdered.add(tableLine3);
        tableOrdered.add(tableLine4);
        tableOrdered.add(tableLine5);
        tableOrdered.add(tableLine6);
        
        return tableOrdered;
    }
    
}