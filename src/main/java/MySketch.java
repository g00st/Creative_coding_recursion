import processing.core.PApplet;
import processing.opengl.PShader;
import controlP5.*;


public class MySketch extends PApplet {
	ControlP5 cp5;
	private int recursionDepth;
	private float decay;
	public void setup() {
		this.getSurface().setResizable(true);
		cp5 = new ControlP5(this);
		cp5.addSlider("recursionDepth")
				.setPosition(10, 10)
				.setRange(1, 10)
				.setValue(5)
				.setSize(100, 20);
		cp5.addSlider("decay")
				.setPosition(10, 40)
				.setRange(0.5f, 1f)
				.setValue(5)
				.setSize(100, 20);
	}

	public void settings() {
		size(500, 500);
	}

	public void frameResized(int w, int h) {

	}


	public void draw(){
		background(64);
		ellipse(mouseX, mouseY, 20, 20);
		background(0);
		pushMatrix();
		translate(width / 2, height );
		stroke(255);
		fractal(recursionDepth, 100);
		popMatrix();


	}

	public void fractal(int depth, float length){
		if (depth == 0){
			return;
		}
		strokeWeight(depth);
		line(0, 0, 0, -length);
		translate(0, -length);
		pushMatrix();
		rotate(PI / 4 + sin(frameCount * 0.01f)) ;
		fractal(depth - 1, length * decay);
		popMatrix();
		pushMatrix();
		rotate(-PI / 4 + cos(frameCount * 0.01f));
		fractal(depth - 1, length * decay);
		popMatrix();
	}
}
