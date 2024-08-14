package com.example.pokemonapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * トレーナーを表すクラス。
 * 各トレーナーは名前とポケモンのリストを持つ。
 */
public class Trainer {
    
    private String name;
    private List<Pokemon> pokemonList;
    
    /**
     * Trainerクラスのコンストラクタ。
     * 新しいトレーナーを作成し、空のポケモンリストを初期化する。
     *
     * @param name トレーナーの名前
     */
    public Trainer(String name) {
        this.name = name;
        this.pokemonList = new ArrayList<>();
    }
    
     /**
     * トレーナーの名前を取得する。
     *
     * @return トレーナーの名前
     */
    public String getName() {
        return name;
    }

     /**
     * トレーナーの名前を設定する。
     *
     * @param name 設定する名前
     */
    public void setName(String name) {
        this.name = name;
    }
        
    /**
     * トレーナーにポケモンを追加する。
     *
     * @param pokemon 追加するポケモン
     */
    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);   
    }
    
    /**
     * トレーナーの特定のポケモンを取得する。
     *
     * @param index ポケモンのインデックス
     * @return 指定されたインデックスのポケモン
     */
    public Pokemon getPokemon(int index) {
        return pokemonList.get(index);
    }
    
    /**
     * トレーナーの所持しているポケモンの数を取得する。
     *
     * @return ポケモンの数
     */
    public int getPokemonCount() {
        return pokemonList.size();
        
    }
}
