package it.polito.tdp.crimes.model;

import java.util.LinkedList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.crimes.db.EventsDao;

public class Model {
	
	EventsDao dao;
	List<String> reati; 
	Graph<String, DefaultWeightedEdge> grafo; 

	public Model() {
		dao= new EventsDao(); 
	}

	public List<String> getReati() {
		return dao.listReati();
	}
	
	public String creaGrafo(int m, String cat) {
		this.grafo= new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(this.grafo, dao.getVertici(m, cat)); 
		
		for(Adiacenza a: dao.getArchi(m, cat)) {
			Graphs.addEdge(this.grafo, a.getA1(), a.getA2(), a.getPeso());
		}
		return "Grafo creato!\n# Vertici:"+grafo.vertexSet().size()+ "\n# Archi: "+grafo.edgeSet().size();
				
	}
	
	public List<Adiacenza> getArchiSup(){
		List<Adiacenza> adiacenti= new LinkedList<>(); 
		
		
		for (DefaultWeightedEdge a: grafo.edgeSet() ) {
			 double p=grafo.getEdgeWeight(a);
			 if(p>this.getMedio()) {
				 adiacenti.add(new Adiacenza(grafo.getEdgeSource(a), grafo.getEdgeTarget(a),(int)p ));
			 }
		}
		return adiacenti;
	}
	
	public double getMedio() {
		List<Adiacenza> archisup;
		double somma=0;
		double medio;
		
		for (DefaultWeightedEdge a: grafo.edgeSet() ) {
			 somma+= this.grafo.getEdgeWeight(a);
			 }
		medio= somma/grafo.edgeSet().size();
		return medio;
	}
	
	
	
	
}
