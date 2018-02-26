package dao;

import model.Hero;

import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.List;

@Stateless
public class HeroDAO extends AbstractJpaDAO<Hero> {

    public HeroDAO(){
        setClazz(Hero.class );
    }

    public List< Hero > search(String queryText){
        return entityManager.createQuery( "from Hero where name like :queryText").setParameter("queryText", "%" +queryText+ "%" )
                .getResultList();
    }

}
