package fr.crampi.memoirekurt.main;

import fr.crampi.memoirekurt.twit.Remember;

/**
 * Created by crampi on 08/04/17.
 */
public class Launcher {

	public static void main(String[] args) throws Exception {
		Remember twitSearch = new Remember();
		twitSearch.start();
		return;
	}

}
