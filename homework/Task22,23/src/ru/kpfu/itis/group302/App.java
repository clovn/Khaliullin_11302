package ru.kpfu.itis.group302;

import java.util.Scanner;
import ru.kpfu.itis.group302.games.*;

public class App{
	public static void main(String[] args) {
		Game game = new GameWithHuman(10);
		game.go();
	}
}