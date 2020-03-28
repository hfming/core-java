package com.hfm.relationship;


/**
 * 类与类之间的关系
 * 聚合（has-a）Demo
 *
 * @author hfm
 * @version 1.01 2020-03-26 18:51
 * @date 2020/3/26
 */
public class HasATest {
    public static void main(String[] args) {
        // 创建球员
        Player player1 = new Player(1, "hfm");
        Player player2 = new Player(1, "tnt");
        Player player3 = new Player(1, "AOA");
        // 创建球队
        Team team = new Team("曼联", player1, player2, player3);
        team.startPlay();
    }
}

/**
 * 球队类
 * 整体与部分中的整体类
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
class Team {
    /**
     * 球队的名字
     */
    String name;
    /**
     * 球员 1
     */
    Player p1;
    /**
     * 球员 1
     */
    Player p2;
    /**
     * 球员 1
     */
    Player p3;

    /**
     * 整体类包含多个部分类对象
     */
    public Team(String name, Player p1, Player p2, Player p3) {
        this.name = name;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    /**
     * 开赛
     */
    public void startPlay() {
        System.out.println(name + "开赛了...");
    }
}

/**
 * 球员类
 * 整体与部分的关系 has a 关系
 * 整体由部分组成，可以分为可拆分型与不可拆分型
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
class Player {
    int num;
    String name;

    public Player(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public void play() {
        System.out.println(name + "开始训练...");
    }
}