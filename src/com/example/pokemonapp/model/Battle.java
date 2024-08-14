package com.example.pokemonapp.model;

/**
 * ポケモンバトルを表すクラス。
 * プレイヤーとCPU、それぞれのポケモンを保持する。
 */
public class Battle {
    private Trainer playerTrainer;
    private Trainer cpuTrainer;
    private Pokemon playerPokemon;
    private Pokemon cpuPokemon;

    /**
     * Battleクラスのコンストラクタ。
     *
     * @param playerTrainer プレイヤーのトレーナー
     * @param cpuTrainer    CPUのトレーナー
     * @param playerPokemon プレイヤーのポケモン
     * @param cpuPokemon    CPUのポケモン
     */
    public Battle(Trainer playerTrainer, Trainer cpuTrainer, Pokemon playerPokemon, Pokemon cpuPokemon) {
        this.playerTrainer = playerTrainer;
        this.cpuTrainer = cpuTrainer;
        this.playerPokemon = playerPokemon;
        this.cpuPokemon = cpuPokemon;
    }

    /**
     * プレイヤーのトレーナーを取得する。
     *
     * @return プレイヤーのトレーナー
     */
    public Trainer getPlayerTrainer() {
        return playerTrainer;
    }

    /**
     * プレイヤーのトレーナーを設定する。
     *
     * @param playerTrainer 設定するプレイヤーのトレーナー
     */
    public void setPlayerTrainer(Trainer playerTrainer) {
        this.playerTrainer = playerTrainer;
    }

    /**
     * CPUのトレーナーを取得する。
     *
     * @return CPUのトレーナー
     */
    public Trainer getCpuTrainer() {
        return cpuTrainer;
    }

    /**
     * CPUのトレーナーを設定する。
     *
     * @param cpuTrainer 設定するCPUのトレーナー
     */
    public void setCpuTrainer(Trainer cpuTrainer) {
        this.cpuTrainer = cpuTrainer;
    }

    /**
     * プレイヤーのポケモンを取得する。
     *
     * @return プレイヤーのポケモン
     */
    public Pokemon getPlayerPokemon() {
        return playerPokemon;
    }

    /**
     * プレイヤーのポケモンを設定する。
     *
     * @param playerPokemon 設定するプレイヤーのポケモン
     */
    public void setPlayerPokemon(Pokemon playerPokemon) {
        this.playerPokemon = playerPokemon;
    }

    /**
     * CPUのポケモンを取得する。
     *
     * @return CPUのポケモン
     */
    public Pokemon getCpuPokemon() {
        return cpuPokemon;
    }

    /**
     * CPUのポケモンを設定する。
     *
     * @param cpuPokemon 設定するCPUのポケモン
     */
    public void setCpuPokemon(Pokemon cpuPokemon) {
        this.cpuPokemon = cpuPokemon;
    }
}