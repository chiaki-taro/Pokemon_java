package com.example.pokemonapp.model;

/**
 * このクラスはポケモンが使用する技を表します。
 * 技には名前、タイプ、威力、命中率が含まれます。
 */
public class Move {

    /** 技の名前 */
    private String name;

    /** 技のタイプ (例: ほのお, みず, くさなど) */
    private String type;

    /** 技の威力 */
    private int power;

    /** 技の命中率 */
    private int accuracy;

    /**
     * 指定された名前、タイプ、威力、命中率を持つ技を作成。
     *
     * @param name 技の名前
     * @param type 技のタイプ
     * @param power 技の威力
     * @param accuracy 技の命中率
     */
    public Move(String name, String type, int power, int accuracy) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
    }

    /**
     * 技の名前を取得。
     *
     * @return 技の名前
     */
    public String getName() {
        return name;
    }

    /**
     * 技のタイプを取得。
     *
     * @return 技のタイプ
     */
    public String getType() {
        return type;
    }

    /**
     * 技の威力を取得。
     *
     * @return 技の威力
     */
    public int getPower() {
        return power;
    }

    /**
     * 技の命中率を取得。
     *
     * @return 技の命中率
     */
    public int getAccuracy() {
        return accuracy;
    }
}
