public class DrawFractal {
	private Double x1 = 0.0;
	private Double y1 = 0.0;
	private Double drawingDir = 0.0;
	private Double length = 1.0;
	private Double angle;
	private Double scalingFactor;
	private Double x2, y2;
	private final static int DEFAULT = 1000;
	private LineInfo[] lines;
	private Integer lineCount = 0;
	private CurrentPointInfo CP;
	private Double Xmin = 0.0;
	private Double Xmax = 0.0;
	private Double Ymin = 0.0;
	private Double Ymax = 0.0;
	private String symbol;
	private String fractalString;

	public DrawFractal(String fractalString, double scalingFactor, double angle) {
		this.fractalString = fractalString;
		this.scalingFactor = scalingFactor;
		this.angle = angle;
	}

	public void computeLines() {
angle*=Math.PI/180.0; // convert to radians
// Array of line objects
lines=new LineInfo[DEFAULT];
Double mag;

StackADT<CurrentPointInfo> s = new LinkedStack<CurrentPointInfo>();

// Process fractalString character by character
for(int i=0;i<fractalString.length();i++) 
    {
    symbol=fractalString.substring(i,i+1);
    System.out.println("i=" + i + " symbol=" + symbol);

/*************************************/
    if (symbol.equals("[")){
    	//Pushes current point if [ character is encountered
    	CP = new CurrentPointInfo(x1, y1, drawingDir, length);
    	s.push(CP);
    } else if (symbol.equals("]")){
    	CP = s.pop();
    	//Pops and gets values if ] character is encountered
    	x1 = CP.getX();
    	y1 = CP.getY();
    	drawingDir = CP.getCurrentDrawingDirection();
    } else if (symbol.equals("+")){
    	//Adds angle if + character is encountered
    	drawingDir = drawingDir + angle;  
    } else if (symbol.equals("-")){
    	//Subtracts angle if - character is encountered
    	drawingDir = drawingDir - angle;}
    //Sets the value of the second set of coordinates for next time F or G is encountered
    x2 = x1 + length*Math.cos(drawingDir);
    y2 = y1 + length*Math.sin(drawingDir);	
    if (symbol.equals("F")||symbol.equals("G")){
    	//Expands line array if too large
    	if (lines.length==lineCount){
        	this.expandCapacity();
    	}
    	//Creates new line object for every F and G
    	lines[lineCount]= new LineInfo(x1,y1,x2,y2);
    	this.UpdateXminYminXmaxYmax(x1,y1,x2,y2);
    	lineCount ++;
    	//Sets the starting coordinates for the next point
        x1 = x2;
        y1 = y2;
    }
    }
/*************************************/
	}

	public void printAllLines() {
		int i = 0;
		for (i = 0; i < lineCount; i++) {
			System.out.println("i=" + i + " (x1,y1)=(" + lines[i].getX1() + ","
					+ lines[i].getY1() + ") to" + " (x2,y2)=("
					+ lines[i].getX2() + "," + lines[i].getY2() + ")");
		}
	}

	public void drawAllLines(Canvas canvas, int lowerX, int lowerY, int upperX,
			int upperY) {
		Double xOffset = 0.1 * upperX;
		Double yOffset = 0.1 * upperY;
		lowerX += xOffset;
		lowerY += yOffset;
		upperX -= xOffset;
		upperY -= yOffset;
		int intX1, intX2;
		int intY1, intY2;
		double xFractalLimit = (Xmax - Xmin);
		double yFractalLimit = (Ymax - Ymin);
		double xImageLimit = upperX - lowerX;
		double yImageLimit = upperY - lowerY;
		Double xRatio = (xImageLimit / xFractalLimit);
		Double yRatio = (yImageLimit / yFractalLimit);
		System.out.println("In drawAllLines:");
		System.out.println("xOffset=" + xOffset + " yOffset=" + yOffset);
		System.out.println("lowerX=" + lowerX + " lowerY=" + lowerY);
		System.out.println("upperX=" + upperX + " upperY=" + upperY);
		System.out.println("(Xmin,Ymin)=(" + Xmin + "," + Ymin + ")");
		System.out.println("(Xmax,Ymax)=(" + Xmax + "," + Ymax + ")");
		System.out.println("xRatio=" + xRatio + " yRatio=" + yRatio);
		System.out.println(" ");
		for (int i = 0; i < lineCount; i++) {
			intX1 = (int) (upperX + xRatio * (lines[i].getX1() - Xmax));
			intY1 = (int) (upperY + yRatio * (lines[i].getY1() - Ymax));
			intX2 = (int) (upperX + xRatio * (lines[i].getX2() - Xmax));
			intY2 = (int) (upperY + yRatio * (lines[i].getY2() - Ymax));
			System.out.println("Line " + i + " from (intX1,intY1)=(" + intX1
					+ "," + intY1 + ")  " + "to (intX2,intY2)=(" + intX2 + ","
					+ intY2 + ")");
			// draw black line on canvas
			System.out.println(intX1);
			System.out.println(intY1);
			System.out.println(intX2);
			System.out.println(intY2);
			canvas.drawLine(intX1, intY1, intX2, intY2, 255, 0, 0);
		}
		canvas.show();
	}

	public void UpdateXminYminXmaxYmax(Double x1, Double y1, Double x2,
			Double y2) {
		if (x1 < Xmin)
			Xmin = x1;
		if (x2 < Xmin)
			Xmin = x2;
		if (x1 > Xmax)
			Xmax = x1;
		if (x2 > Xmax)
			Xmax = x2;
		if (y1 < Ymin)
			Ymin = y1;
		if (y2 < Ymin)
			Ymin = y2;
		if (y1 > Ymax)
			Ymax = y1;
		if (y2 > Ymax)
			Ymax = y2;
	}

	public void expandCapacity() {
		LineInfo newLines[] = new LineInfo[lines.length * 2];
		for (int i = 0; i < lines.length; i++) {
			newLines[i] = lines[i];
		}
		lines = newLines;
	}

} // DrawFractal

