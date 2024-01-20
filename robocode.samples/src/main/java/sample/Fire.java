/*
 * Copyright (c) 2001-2023 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://robocode.sourceforge.io/license/epl-v10.html
 */
package sample;


import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RuleBuilder;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import static robocode.util.Utils.normalRelativeAngleDegrees;

import java.awt.*;


/**
 * Fire - a sample robot by Mathew Nelson, and maintained.
 * <p>
 * Sits still. Spins gun around. Moves when hit.
 *
 * @author Mathew A. Nelson (original)
 * @author Flemming N. Larsen (contributor)
 */
public class Fire extends Robot {
	int dist = 50; // distance to move when we're hit

	Facts facts1 = new Facts();
	RulesEngine rulesEngine = new DefaultRulesEngine();

	Rule weatherRule = new RuleBuilder()
			.name("weather rule")
			.description("if it rains then take an umbrella")
			.when(facts -> facts.get("rain").equals(true))
			.then(facts -> System.out.printf("XDDDDDDD"))
			.build();

	Rules rules = new Rules();

//	facts1.put("rain", false);
//		facts1.put("rain", true);

	/**
	 * run:  Fire's main run function
	 */
	public void run() {
//		logMessage("NORMALNIE!");
//		Facts facts1 = new Facts();

//
//
		setBodyColor(Color.orange);
		rules.register(weatherRule);




		System.out.println("It rains, take an umbrella XDDDDD!");



		// fire rules on known facts




		// Set colors
//		setBodyColor(Color.orange);
		setGunColor(Color.orange);
		setRadarColor(Color.red);
		setScanColor(Color.red);
		setBulletColor(Color.red);

		// Spin the gun around slowly... forever
		while (true) {
			turnGunRight(5);
		}
	}

	/**
	 * onScannedRobot:  Fire!
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// If the other robot is close by, and we have plenty of life,
		// fire hard!
//		if (e.getDistance() < 50 && getEnergy() > 50) {
//			fire(3);
//		} // otherwise, fire 1.
//		else {
//			fire(1);
//		}
		// Call scan again, before we turn the gun
		facts1.put("rain", true);
//		rulesEngine.fire(rules, facts1);
		scan();
	}

	/**
	 * onHitByBullet:  Turn perpendicular to the bullet, and move a bit.
	 */
	public void onHitByBullet(HitByBulletEvent e) {
//		turnRight(normalRelativeAngleDegrees(90 - (getHeading() - e.getHeading())));
//
//		ahead(dist);
//		dist *= -1;

		System.out.println("MHMMHMHMHMHMHMHMMMHHM");
		facts1.put("rain", true);
		rulesEngine.fire(rules, facts1);

		scan();
	}

	/**
	 * onHitRobot:  Aim at it.  Fire Hard!
	 */
	public void onHitRobot(HitRobotEvent e) {
//		double turnGunAmt = normalRelativeAngleDegrees(e.getBearing() + getHeading() - getGunHeading());
//
//		turnGunRight(turnGunAmt);
//		fire(3);
	}
}
