package service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.annotation.RequestMap;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ma.resto.config.CategoryLocal;
import ma.resto.config.RestoImageLocal;
import ma.resto.models.Category;
import ma.resto.models.RestoImage;

@Path("/api/restoImage")
@Stateless
public class RestoImageRest {

	@EJB
	private RestoImageLocal service;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public void addCategory(@RequestMap RestoImage data) {
		service.add(data);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public RestoImage getCompte(@PathParam(value = "id") int id) {
		return service.findById(id);
	}

	
	@GET
	@Path("/getImagesByRestoId/{restoId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RestoImage> getImagesByRestoId(@PathParam(value = "restoId") int restoId)   {
		return service.finbyrestoId(restoId);
	}

	@GET
	@Path("/getImage/{name}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getFullImage(@PathParam(value = "name") String name) throws IOException  {

		File file =new File("C:\\Users\\Lol\\eclipse-workspace\\restoJsp\\src\\main\\webapp\\images\\"+name);
		  return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
			      .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) //optional
			      .build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<RestoImage> listComptes() {
		return service.finddAll();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCompte(@PathParam(value = "id") int id) {
		 service.deleteCategory(id);
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
