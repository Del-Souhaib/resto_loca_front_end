package service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.annotation.RequestMap;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ma.resto.config.SerieLocal;
import ma.resto.models.Serie;

@Path("/api/series")
@Stateless
public class SerieRest {

	@EJB
	private SerieLocal service;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public void addSerie(@RequestMap Serie data) {
		service.add(data);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Serie getSerie(@PathParam(value = "id") int id) {
		return service.findById(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Serie> listSerie() {
		return service.finddAll();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteSerie(@PathParam(value = "id") int id) {
		 service.deleteSerie(id);
	}
	
/*
	@PUT
	@Path("/comptes/verser")
	@Produces(MediaType.APPLICATION_JSON)
	public void verser(@FormParam(value = "code") Long c, @FormParam(value = "montant") double mt) {
		service.verser(c, mt);
	}
*/
}
