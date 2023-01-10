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

import ma.resto.config.VilleLocal;
import ma.resto.models.Ville;

@Path("/api/villes")
@Stateless
public class VilleRest {

	@EJB
	private VilleLocal service;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public void addVille(@RequestMap Ville data) {
		service.add(data);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Ville getCompte(@PathParam(value = "id") int id) {
		return service.findById(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Ville> listComptes() {
		return service.finddAll();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCompte(@PathParam(value = "id") int id) {
		 service.deleteVille(id);
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
