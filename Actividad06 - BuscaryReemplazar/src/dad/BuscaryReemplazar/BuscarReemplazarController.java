package dad.BuscaryReemplazar;

public class BuscarReemplazarController {
	
	private BuscarReemplazarView brView;
	
	
	public BuscarReemplazarController() {
		this.brView = new BuscarReemplazarView();
	}


	public BuscarReemplazarView getRoot(){
		return brView;
	}
}
