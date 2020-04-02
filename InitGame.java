
public class InitGame {
	
	private Model modelObject;
	private Controller controllerObject;

	public InitGame() {
		this.modelObject = new Model();
		Dealer dealer = new Dealer("Dealer", 0);
		// this.controllerObject = new Controller(this.modelObject, dealer);
	}
	
	public Model getModelObject() {
		return this.modelObject;
	}
	
	public Controller getControllerObject() {
		return this.controllerObject;
	}
	
}
