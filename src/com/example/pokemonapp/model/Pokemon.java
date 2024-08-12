package com.example.pokemonapp.model;

/**
 * ポケモンを表すクラス。
 * 各ポケモンは名前、タイプ、HP、攻撃力、防御力を持つ。
 */
public class Pokemon {
    
    private String name;
    private String type;
    private int hp;
    private int attack;
    private int defense;
    
    /**
     * Pokemonクラスのコンストラクタ。
     *
     * @param name    ポケモンの名前
     * @param type    ポケモンのタイプ
     * @param hp      ポケモンの体力（HP）
     * @param attack  ポケモンの攻撃力
     * @param defense ポケモンの防御力
     */
    public Pokemon(String name, String type, int hp, int attack, int defense) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }
    

}
