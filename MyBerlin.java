package com.ubs.opsit.interviews;

import java.util.Arrays;
import java.util.Collections;

public class MyBerlin implements TimeConverter {

	private String formattedTime;
	

	@Override
	public String convertTime(String aTime) {
		String[] times = aTime.split(":", 3);
		int hours, minutes, seconds = 0;
		try {
			hours = Integer.parseInt(times[0]);
			minutes = Integer.parseInt(times[1]);
			seconds = Integer.parseInt(times[2]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Bla ");
		}

		

		String line1 = (seconds % 2 == 0) ? "Y" : "0";
		String line2 = processRow(hours / 5, 4, "R");
		String line3 = processRow(hours % 5, 4, "R");
		String line4 = processRow(minutes / 5, 11, "Y").replaceAll("YYY", "YYR");
		String line5 = processRow(minutes % 5, 4, "Y");
		this.formattedTime = String.join(System.getProperty("line.separator"), Arrays.asList(line1, line2, line3, line4, line5));
		return this.formattedTime;

	}

	private String processRow(int litLights, int lightsInRow, String lampType) {

		int unlitLights = lightsInRow - litLights;
		String lit = String.join("", Collections.nCopies(litLights, lampType));
		String unlit = String.join("", Collections.nCopies(unlitLights, "0"));

		return lit + unlit;
	}

}
