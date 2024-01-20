package offensive;
import robocode.AdvancedRobot;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;
import java.util.Random;


public class OffensiveRobot extends AdvancedRobot {

  private int moveDirection = 1;
  private long moveDirectionChangeTime;

  public void run() {
      moveDirectionChangeTime = getTime();
      while (true) {
          turnRadarRightRadians(Double.POSITIVE_INFINITY);
          setAdjustGunForRobotTurn(true);
          setMaxVelocity(40);
      }
  }

  public void onScannedRobot(ScannedRobotEvent enemy) {
      setTurnRadarLeftRadians(getRadarTurnRemainingRadians());

      double absoluteBearing = enemy.getBearingRadians() + getHeadingRadians();
      double latencyCorrection = (enemy.getVelocity() * Math.sin(enemy.getHeadingRadians() - absoluteBearing)) / 22;
      double gunTurnAmt;

      if (enemy.getDistance() > 70) {
          gunTurnAmt = robocode.util.Utils.normalRelativeAngle(absoluteBearing - getGunHeadingRadians() + latencyCorrection);
      } else {
          gunTurnAmt = robocode.util.Utils.normalRelativeAngle(absoluteBearing - getGunHeadingRadians());
      }
      setTurnGunRightRadians(gunTurnAmt);

      if (getVelocity() < 1 && getTime() - moveDirectionChangeTime > 10) {
          moveDirection *= -1;
          moveDirectionChangeTime = getTime();
      }

      if (getTime() % 40 > 20) {
          setTurnLeft(20 + new Random().nextInt(20));
      } else {
          setTurnRight(20 + new Random().nextInt(20));
      }

      setAhead(80 * moveDirection);
      setFire(3);
  }

  public void onHitWall(HitWallEvent e) {
      moveDirection = -moveDirection;
      moveDirectionChangeTime = getTime() + 30;
  }

  @Override
  public String toString() {
      return "OffensiveBot";
  }
}												

