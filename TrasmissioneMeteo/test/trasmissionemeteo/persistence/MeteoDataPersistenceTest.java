/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trasmissionemeteo.persistence;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import trasmissionemeteo.domain.MeteoData;

/**
 *
 * @author herfost
 */
public class MeteoDataPersistenceTest {

    public MeteoDataPersistenceTest() {
    }

    /**
     * Test of getPersistence method, of class MeteoDataPersistence.
     */
    @Test
    public void testGetPersistence() {
        System.out.println("getPersistence");
    }

    @Test
    public void testRead() {
        System.out.println("read");
        MeteoDataPersistence p = new MeteoDataPersistence();
        MeteoData m = new MeteoData("A", 10, 10); 
        p.create(m);
        m.setTemperature(0);
        m.setUmidity(0);
        
        System.out.println(m);
        System.out.println(p.read(m.getKey()));
        
        if (m.equals(p.read(m.getKey()))) {
            fail("Clone non ha funzionato");
        }
    }

}
