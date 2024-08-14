package com.example.pokemonapp;

import java.util.Random;
import java.util.Scanner;

import com.example.pokemonapp.model.Battle;
import com.example.pokemonapp.model.Pokemon;
import com.example.pokemonapp.model.Trainer;
import com.example.pokemonapp.service.BattleService;
import com.example.pokemonapp.service.PokemonService;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        PokemonService pokemonService = new PokemonService();
        BattleService battleService = new BattleService();
        
        // 3匹のポケモンを用意
        Pokemon nyaoha = pokemonService.createPokemon("ニャオハ", "くさ", 40, 61, 54, 65);
        Pokemon hogator = pokemonService.createPokemon("ホゲータ", "ほのお", 67, 45, 59, 36);
        Pokemon kuwassu = pokemonService.createPokemon("クワッス", "みず", 55, 65, 45, 50);
        
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
        
        // ランダムに対戦相手のポケモンを選ぶ
        Pokemon[] cpuPokemonList = {nyaoha, hogator, kuwassu};
        Random random = new Random();
        Pokemon cpuPokemon = cpuPokemonList[random.nextInt(cpuPokemonList.length)];

        while (cpuPokemon == playerPokemon) {
            cpuPokemon = cpuPokemonList[random.nextInt(cpuPokemonList.length)];
        }

        // トレーナーの作成
        Trainer playerTrainer = new Trainer("プレイヤー");
        Trainer cpuTrainer = new Trainer("CPU");
        
        playerTrainer.addPokemon(playerPokemon);
        cpuTrainer.addPokemon(cpuPokemon);
        
        // バトルの作成と開始
        Battle battle = new Battle(playerTrainer, cpuTrainer, playerPokemon, cpuPokemon);
        battleService.simulateBattle(battle);
        
        scanner.close();
        
    }
         

}
