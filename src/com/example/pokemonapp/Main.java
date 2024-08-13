package com.example.pokemonapp;

import java.util.Scanner;

import com.example.pokemonapp.model.Pokemon;
import com.example.pokemonapp.service.PokemonService;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        PokemonService pokemonService = new PokemonService();
        
        // 3匹のポケモンを用意
        Pokemon nyaoha = pokemonService.createPokemon("ニャオハ", "くさ", 40, 61, 54);
        Pokemon hogator = pokemonService.createPokemon("ホゲータ", "ほのお", 67, 45, 59);
        Pokemon kuwassu = pokemonService.createPokemon("クワッス", "みず", 55, 65, 45);
        
        System.out.println("ポケモンを選んで下さい。");
        System.out.println("1:ニャオハ　2:ホゲータ　3:クワッス");
        
        String choice;
        Pokemon playerPokemon;
           
        while (true) {
            choice = scanner.nextLine();
            if (choice.matches("^[1-3]$")) {
                break;
            } else {
                System.out.println("1,2,3いずれかの数字を半角数字を入力してください。");
            }
        }
        
        switch (choice) {
        case "1":
            playerPokemon = nyaoha;
            break;
        case "2":
            playerPokemon = hogator;
            break;
        case "3":
            playerPokemon = kuwassu;
            break;
        default:
            playerPokemon = nyaoha; // デフォルトはニャオハ
        }
        
        System.out.println(playerPokemon.getName() + "を選びました！");
        
        scanner.close();
        
    }
         

}
