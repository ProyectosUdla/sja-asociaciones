package mx.com.gm.sga.cliente.ciclovida;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class PersistirObjetoJPA {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //Inicia la transaccion
       
        //Paso 1. Crea nuevo objeto
        //Objeto en estado transitivo
        Persona persona1 = new Persona("Pedro", "Luna", null, "pluna4@mail.com", "19292943");

        //Paso 2. Inicia transaccion
        tx.begin();
        
        //Paso 3. Ejecuta SQL
        em.persist(persona1);

        //Paso 4. Commit/rollback
        tx.commit();

        //Objeto en estado detached
        log.debug("Objeto persistido:" + persona1);

        //Cerramos el Entity Manager
        em.close();
    }
}