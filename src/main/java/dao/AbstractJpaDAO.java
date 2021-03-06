package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;


public abstract class AbstractJpaDAO< T extends Serializable> {
 
   private Class< T > clazz;

   @PersistenceContext(name = "mysql-hero")
   EntityManager entityManager;
 
   public final void setClazz( Class< T > clazzToSet ){
      this.clazz = clazzToSet;
   }
 
   public T findOne( Integer id ){
      return entityManager.find( clazz, id );
   }
   public List< T > findAll(){
      return entityManager.createQuery( "from " + clazz.getName() )
       .getResultList();
   }
 
   public void create( T entity ){
      entityManager.persist( entity );
   }
 
   public T update( T entity ){
      return entityManager.merge( entity );
   }
 
   public void delete( T entity ){
      entityManager.remove( entity );
   }
   public void deleteById( Integer entityId ){
      T entity = findOne( entityId );
      delete( entity );
   }

}