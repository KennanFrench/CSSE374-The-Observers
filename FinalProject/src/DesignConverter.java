import java.util.ArrayList;

public class DesignConverter {
	ArrayList<UMLElement> design;
	Visibility runViz;
	String diagramName;
	String graphVisRep;
	
	public DesignConverter(ArrayList<UMLElement> design, Visibility runViz, String diagramName) {
		this.design = design;
		this.runViz = runViz;
		this.diagramName = diagramName;
	}
	
	public void convert() {
		StringBuilder runningString = new StringBuilder();
		ConverterFactory factory = new ConverterFactory();
		
		runningString.append("digraph " + this.diagramName + "{\nrankdir=BT;");
		
		for (UMLElement element : this.design) {
			Converter converter = factory.createConverter(element, this.runViz);
			converter.convert();
			runningString.append("\n");
			runningString.append(converter.getGraphVizRep());
		}
		
		runningString.append("\n}");
		this.graphVisRep = runningString.toString();
	}
	
	public String getGraphVizRep() {
		return this.graphVisRep;
	}
}
