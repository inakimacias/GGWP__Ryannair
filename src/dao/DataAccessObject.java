package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import data.Vuelo;

public class DataAccessObject {
	private static Logger LOGGER;
	private static DataAccessObject instance = new DataAccessObject();
	private List<Vuelo> listaVuelos = new ArrayList<>();
	
	public DataAccessObject() {
		BasicConfigurator.configure();
		LOGGER = Logger.getLogger("Logger");
		Vuelo v1 = new Vuelo("001", "ryannair", "17:30/23/03/2020", "18:30/23/03/2020", "Barcelona", "Madrid", 250,30);
		Vuelo v2 = new Vuelo("002", "ryannair", "18:30/24/03/2020", "19:30/24/03/2020", "Bilbao", "Madrid", 140,20);
		Vuelo v3 = new Vuelo("003", "ryannair", "17:30/25/03/2020", "18:30/25/03/2020", "Madrid", "Bilbao", 220,40);
		Vuelo v4 = new Vuelo("004", "ryannair", "20:30/26/03/2020", "22:00/26/03/2020", "Valencia", "Barcelona", 80,50);
		Vuelo v5 = new Vuelo("005", "ryannair", "17:00/27/03/2020", "18:30/27/03/2020", "Valencia", "Barcelona", 100,20);
		Vuelo v6 = new Vuelo("006", "ryannair", "18:00/28/03/2020", "19:00/28/03/2020", "Barcelona", "Valencia", 105,30);
		listaVuelos.add(v1);
		listaVuelos.add(v2);
		listaVuelos.add(v3);	
		listaVuelos.add(v4);
		listaVuelos.add(v5);
		listaVuelos.add(v6);
	}
	
	public static DataAccessObject getInstance() {
		return instance;
	}

	public List<Vuelo> getListaVuelos(String o, String d){
		LOGGER.info("Buscando vuelos con origen en "+o+" y destino en "+d);
		List<Vuelo> lista =new ArrayList<>();
		for(int i= 0; i<listaVuelos.size();i++){
			if(listaVuelos.get(i).getOrigen().equals(o))
				if(listaVuelos.get(i).getDestino().equals(d))
						lista.add(listaVuelos.get(i));
		}
		
		return lista;
	}
	
	
	
	public void setListaVuelos(List<Vuelo> listaVuelos) {
		this.listaVuelos = listaVuelos;
	}

	public List<Vuelo> getListaVuelos() {
		LOGGER.info("Buscando todos los vuelos");
		return listaVuelos;
	}
}
