package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        Solution obj= new Solution();
        // obj.init(helper)
        obj.addCharacter(1, 0, 'g', "Cambria", 17, true, true);
        obj.addCharacter(0, 1, 'y', "Century Gothic", 14, true, true);
        obj.addCharacter(0, 1, 'd', "Century Gothic", 14, true, true);

        System.out.println( obj.getStyle(0,0));// returns 'g-Cambria-17-b-i'
    }
}