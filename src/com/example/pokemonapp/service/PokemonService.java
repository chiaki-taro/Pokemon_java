package com.example.pokemonapp.service;

import java.util.List;

import com.example.pokemonapp.model.Move;
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
     * @param moves ポケモンの技リスト
     * @return 作成されたポケモン
     */
    public Pokemon createPokemon(String name, String type, int hp, int attack, int defense, int speed, List<Move> moves) {
        return new Pokemon(name, type, hp, attack, defense, speed, moves);
    }

}
