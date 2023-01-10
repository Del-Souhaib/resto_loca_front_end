package service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

import ma.resto.config.CategoryLocal;
import ma.resto.config.RestoLocal;
import ma.resto.models.Category;
import ma.resto.models.Resto;

@Path("/api/restos")
@Stateless
public class RestoRest {

	@EJB
	private RestoLocal service;

	@EJB
	private CategoryLocal categoryService;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public void addResto(@RequestMap Resto data ) {
		/*
		Resto resto=new Resto();
		resto.setName(data.getName());
		resto.setDescription(data.getDescription());
		resto.setAdresse(data.getAdresse());
		resto.setLong0(data.getLong0());
		resto.setLat(data.getLat());
		resto.setRank(data.getRank());
		resto.setOpenTime(data.getOpenTime());
		resto.setCloseTime(data.getCloseTime());
		resto.setOpenWeekEnd(data.isOpenWeekEnd());
		resto.setZone_id(data.getZone_id());
		resto.setSerie_id(data.getSerie_id());
		
		resto.getCategories().addAll(data.getCategories().stream().map(
				v ->{
				Category c=categoryService.findById(v.getId());
				c.getRestos().add(re0sto);
				return v;
				}).collect(Collectors.toList()));

       */
		service.add(data);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Resto getResto(@PathParam(value = "id") int id) {
		return service.findById(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Resto> listResto() {
		return service.finddAll();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteResto(@PathParam(value = "id") int id) {
		 service.deleteResto(id);
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/recherche/{zone_id}")
	public List<Resto> listRestoFilter(@PathParam(value = "zone_id") int zone_id) {
		return service.recherche(zone_id);
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
