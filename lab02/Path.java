/** A class that represents a path via pursuit curves.
 *  @author You!
 */
public class Path {

    /** What to do, what to do... */
	
	private Point currPoint = new Point();
	private Point nextPoint = new Point();
	
	public Path(double x, double y){
		this.nextPoint.setX(x);
		this.nextPoint.setY(y);
	}

	public double getCurrX(){
		return currPoint.getX();
	}
	
	public double getCurrY(){
		return currPoint.getY();
	}
	
	public double getNextX(){
		return nextPoint.getX();
	}
	
	public double getNextY(){
		return nextPoint.getY();
	}
	
	public void iterate(double dx, double dy){
		this.currPoint.setX(this.nextPoint.getX());
		this.currPoint.setY(this.nextPoint.getY());
		this.nextPoint.setX(this.nextPoint.getX()+dx);
		this.nextPoint.setY(this.nextPoint.getY()+dy);
	}
}
