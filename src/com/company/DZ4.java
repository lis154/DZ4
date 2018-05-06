package com.company;

import java.util.Random;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class DZ4 {

    public static  char[][]map;
    public static final int SIZE = 3;
    public static final int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '.';
    public static final char DOT_X = 'X';
    public static final char DOT_0 = '0';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
	initMap();
	printMAP();
	while (true)
        {
            humanTurn();
            printMAP();
            if (checkWin(DOT_X))
            {
                System.out.println("Победил игрок");
                break;
            }
            if (isMapFull())
            {
                System.out.println("Ничья");
                break;
            }
           // printMAP();
            computerTurn();
            printMAP();
            if (checkWin(DOT_0))
            {
                System.out.println("Победил компьютер");
                break;
            }
            if (isMapFull())
            {
                System.out.println("Ничья");
                break;
            }
           // printMAP();
        }
        printMAP();
        System.out.println("GAME OVER");
    }

    public static void initMap()
    {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMAP()
    {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println("");
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static boolean isCEllValid(int x, int y)
    {
        if (x < 0 || x >= SIZE || y < 0 || y >+ SIZE) return false;
        if (map[x][y] == DOT_EMPTY) return true;
        return false;
    }

    public static void humanTurn()
    {
        int x, y;
        do {

                System.out.println("Введите свой ход X and Y");
                x = sc.nextInt()-1;
                y = sc.nextInt()-1;
        } while (!isCEllValid(x,y));
        map[y][x] = DOT_X;
    }

    public static void computerTurn()
    {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        }while (!isCEllValid(x,y));
        System.out.println("Компьютер сходил: x=" + (x+1) + " y=" + (y+1));
        map[y][x] = DOT_0;
    }

    public static boolean checkWin(char symb) {
        if(map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
        if(map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
        if(map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;
        if(map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
        if(map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;
        if(map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;
        if(map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
        if(map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;
        return false;
    }

    public static boolean isMapFull()
    {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

}
