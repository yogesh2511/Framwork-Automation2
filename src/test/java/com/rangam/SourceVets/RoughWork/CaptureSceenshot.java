package com.rangam.SourceVets.RoughWork;

import java.util.Date;

public class CaptureSceenshot {
	public static void main(String args[]) {

		Date d = new Date();
		System.out.println(d);

		String name = d.toString().replace(":", "_").replace(" ", "_");

		System.out.println(name);

	}

}
