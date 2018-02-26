package heroes;

import dao.HeroDAO;
import model.Hero;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("heroes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HeroService {

    @Inject
    HeroDAO dao;

      private  List<Hero> heroes = Arrays.asList(
       new Hero(1,"Fatih"),
        new Hero(2,"Murat"),
        new Hero(3,"Omer"),
        new Hero(4,"Ali"),
        new Hero(5,"Serkan"),
        new Hero(6,"Cemal"),
        new Hero(7,"Eray"),
        new Hero(8,"Isa"));

    @GET
    public List<Hero> getAll(){
        return dao.findAll();
       // return heroes;
    }

    @GET
    @Path("/{id}")
    public Hero getOne(@PathParam("id") Integer id){
        return dao.findOne(id);
        // return heroes;
    }

    @POST
    public Hero save(Hero hero){
        return dao.update(hero);//TODO fix
    }

    @PUT
    public void update(Hero hero){
        dao.update(hero);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id){
        dao.deleteById(id);
    }

    @GET
    @Path("/search")
    public List<Hero> search(@QueryParam("text")String text){
        List<Hero> result = dao.search(text);
         return result;
    }
}
