package com.example.pokemonapp.service;

import com.example.pokemonapp.model.Pokemon;

/**
 * ポケモン関連のサービスを提供するクラス。
 */
public class PokemonService {
    
    /**
     * 新しいポケモンを作成する。
     *
     * @param name ポケモンの名前
     * @param type ポケモンのタイプ
     * @param hp ポケモンのHP
     * @param attack ポケモンの攻撃力
     * @param defense ポケモンの防御力
     * @param speed ポケモンの素早さ
     * @return 作成されたポケモン
     */
    public Pokemon createPokemon(String name, String type, int hp, int attack, int defense, int speed) {
        return new Pokemon(name, type, hp, attack, defense, speed);
    }

}
