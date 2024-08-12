package com.example.pokemonapp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("ポケモンを選んで下さい。");
        System.out.println("1:ニャオハ　2:ホゲータ　3:クワッス");
        String choice = scanner.nextLine();
        
        scanner.close();
        

    }
         

}
