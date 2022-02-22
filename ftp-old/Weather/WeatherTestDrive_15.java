package Weather;

import Weather.*;
public class WeatherTestDrive_15 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client c1 = new Client();
		Client c2 = new Client();
		Client c3 = new Client();
		CM cm = new CM();
		WC wc = new WC();
		WeatherSystem.CM= cm;
		WeatherSystem.WC = wc;
		//Init
		WeatherSystem.CM.connect(c1);
		//c1.getFail();
		c1.getSuccess();
		//c1.useFail();
		c1.useSuccess();
		WeatherSystem.CM.connect(c2);
		c2.getSuccess();
		c2.useSuccess();
		WeatherSystem.CM.connect(c3);
		c3.getSuccess();
		c3.useSuccess();

		//Upd
		//GetNewWthr -> S,F,F
		//UseOldWthr -> S,S,F
		cm.performUpdate();
		c1.getSuccess();
		c2.getFail();
		c3.getFail();
		cm.progress();
		c1.useSuccess();
		c2.useSuccess();
		c3.useFail();
		cm.progress();
	}

}
