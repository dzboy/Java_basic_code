package com.ysoyso.control;

import java.util.Scanner;

/**
 * 1. 地图棋盘
 * 2. 棋子
 * 3. 游戏胜负规则(5个相同颜色的棋子连成1行、1列、斜线连成5个)
 * 4. 输入输出，落子位置
 * 5. 处理特殊情况
 */
public class ChessDemo {
    /**
     * 白棋
     */
    public static final int WHITE = -1;
    /**
     * 黑棋
     */
    public static final int BLACK = 1;
    /**
     * 空位
     */
    public static final int BLANK = 0;

    public static int winner;
    public static void main(String[] args) {
        int[][] map = new int[10][10];
        boolean run = true;
        boolean isWhite = true;
        Scanner scanner = new Scanner(System.in);
        while (run) {
            if (isWhite) {
                System.out.println("请白棋输入位置如：3 4");
            } else {
                System.out.println("请黑棋输入位置如：3 4");
            }
            String str = scanner.nextLine();
            String[] strings = str.split(" ");
            if (strings.length < 2) {
                System.out.println("请输入两个数字，如：3 4");
                continue;
            }
            int x = -1;
            int y = -1;
            try {
                x = Integer.parseInt(strings[0]);
                y = Integer.parseInt(strings[1]);
            } catch (NumberFormatException e) {
                System.out.println("请输入棋盘坐标数字");
                continue;
            }
            if (x < 0 || y < 0 || x >= 10 || y >= 10) {
                System.out.println("请输入 0 ~ 9 的数字");
                continue;
            }
            map[x][y] = isWhite ? WHITE : BLACK;
            draw(map);
            boolean isWin1 = checkColumn(map);
            boolean isWin2 = checkRow(map);
            boolean isWin3 = checkLineLeft(map);
            boolean isWin4 = checkLineRight(map);
            isWhite = !isWhite;
            if (isWin1 || isWin2 || isWin3 || isWin4) {
                String win = winner == WHITE ? "白方" : "黑方";
                System.out.println("赢家：" + win);
                System.out.println("是否继续游戏？s:重新开始，任意键退出");
                String restart = scanner.nextLine();
                if ("s".equals(restart)) {
                    isWhite = true;
                    map = new int[10][10];
                } else {
                    run = false;
                }
            }

        }

    }

    public static boolean checkLineLeft(int[][] map) {
        int[][] newMap = rotateLineMap(map);
        return checkRow(newMap);
    }

    public static boolean checkLineRight(int[][] map) {
        int[][] newMap = rotateMap(map);
        return checkLineLeft(newMap);
    }

    public static int[][] rotateLineMap(int[][] map) {
        int[][] newMap = new int[19][10];
        int line = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10 && j + i < 10; j++) {
                newMap[line][j] = map[j][j + i];
            }
            line++;
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9 && i + j + 1 < 10; j++) {
                newMap[line][j] = map[i + j + 1][j];
            }
            line++;
        }
        return newMap;
    }
    public static boolean checkColumn(int[][] map) {
        int[][] newMap = rotateMap(map);
        return checkRow(newMap);
    }
    public static boolean checkRow(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            int lastValue = BLANK;
            int count = 0;
            for (int j = 0; j < map[i].length; j++) {
                int value = map[i][j];
                if (value == BLANK) {
                    count = 0;
                    lastValue = BLANK;
                    continue;
                }
                if (lastValue == value) {
                    count++;
                } else {
                    lastValue = value;
                    count = 0;
                }
                if (count >= 4) {
                    winner = value;
                    return true;
                }
            }
        }
        return false;
    }

    public static int[][] rotateMap(int[][] map) {
        int[][] newMap = new int[10][10];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                newMap[map.length - 1 - j][i] = map[i][j];
            }
        }
        return newMap;
    }
    public static void draw(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            if (i == 0) {
                for (int j = 0; j < map[i].length; j++) {
                    if (j == map[i].length - 1) {
                        System.out.print("  " + j);
                    } else {
                        System.out.print("  " + j + "  ");
                    }
                }
                System.out.println("");
            }
            for (int j = 0; j < map[i].length; j++) {
                String piece = getPiece(map[i][j]);
                if (j == 0) {
                    System.out.print(i + " " + piece + "——");
                } else if (j == map[i].length - 1) {
                    System.out.print("——" + piece);
                } else {
                    System.out.print("——" + piece + "——");
                }
            }
            System.out.println("");
            if (i < map.length - 1) {
                for (int j = 0; j < map[i].length; j++) {
                    if (j == map[i].length - 1) {
                        System.out.print("  |");
                    } else {
                        System.out.print("  |  ");
                    }
                }
            }
            System.out.println("");
        }
    }

    public static String getPiece(int value) {
        if (value == WHITE) {
            return "■";
        } else if (value == BLACK) {
            return "□";
        } else {
            return "*";
        }
    }


}
