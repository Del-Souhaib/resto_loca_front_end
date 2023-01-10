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

import ma.resto.config.ZoneLocal;
import ma.resto.models.Zone;

@Path("/api/zones")
@Stateless
public class ZoneRest {

	@EJB
	private ZoneLocal service;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public void addZone(@RequestMap Zone data) {
		service.add(data);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Zone getCompte(@PathParam(value = "id") int id) {
		return service.findById(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Zone> listComptes() {
		return service.finddAll();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCompte(@PathParam(value = "id") int id) {
		 service.deleteZone(id);
	}
	
/*
	@PUT
	@Path("/comptes/verser")
	@Produces(MediaType.APPLICATION_JSON)
	public void verser(@FormParam(value = "code") Long c, @FormParam(value = "montant") double mt) {
		service.verser(c, mt);
	}
*/
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/recherche/{ville_id}")
	public List<Zone> finddByVille(@PathParam(value = "ville_id") int ville_id) {
		return service.finddByVille(ville_id);
	}
	

}
