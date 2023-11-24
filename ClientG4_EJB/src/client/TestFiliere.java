package client;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.IDao;
import entities.Filiere;

public class TestFiliere {
	public static IDao<Filiere> lookUpFiliereRemote() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (IDao<Filiere>) context.lookup("ejb:/ServeurG4_EJB/FILIERE_EJB!dao.IDao");

	}

	public static void main(String[] args) {
		try {
			IDao<Filiere> dao = lookUpFiliereRemote();
			dao.create(new Filiere("A1", "Java"));
			dao.create(new Filiere("A2", "Python"));
			dao.create(new Filiere("A3", "C++"));
			
			for(Filiere f: dao.findAll())
				System.out.println(f.getName());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
