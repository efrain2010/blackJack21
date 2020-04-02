
public class InitGame {
	
	private Model modelObject;
	private Controller controllerObject;

	public InitGame() {
		this.modelObject = new Model();
		this.controllerObject = new Controller(this.modelObject);
	}
	
	public Model getModelObject() {
		return this.modelObject;
	}
	
	public Controller getControllerObject() {
		return this.controllerObject;
	}
	
}
