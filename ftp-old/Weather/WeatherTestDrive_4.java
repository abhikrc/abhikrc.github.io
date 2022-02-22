package Weather;

import Weather.*;
public class WeatherTestDrive_4 {

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
		//GetNewWthr -> F,S,F
		//UseOldWthr -> F,S,S
		cm.performUpdate();
		c1.getFail();
		c2.getSuccess();
		c3.getFail();
		cm.progress();
		c1.useFail();
		c2.useSuccess();
		c3.useSuccess();
		cm.progress();
	}

}
