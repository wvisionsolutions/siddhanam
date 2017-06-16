package com.ciber.momentum.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ciber.momentum.entity.Address;
import com.ciber.momentum.entity.Phone;
import com.ciber.momentum.entity.User;

/**
 * Main class for testing.
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {

		System.out.println("Sample TWC DB Application!");
		Session session = HibernateUtil.getSessionFactory().openSession();
		
	   //addUser(session);
	   //listUser(session);
		
		session.close();
    }
    
    private static void addUser(Session session) {
    	
    	// Setting the data
    			session.beginTransaction();

    			System.out.println("In add user method!");
    			User user = new User();
    			
    			user.setFirstName("ArbindKJain");
    			user.setLastName("Jain");
    			user.setEmail("jain@gmail.com");
    			user.setGender("M");
    			user.setPassword("pws");
    			user.setSsn("11-111-11177");
    			user.setRole("admin");
    			user.setName("Arbind");
    			session.save(user);	

    			Address address1 = new Address();
    			address1.setAddressType(1);
    			address1.setCity("Lucknow");
    			address1.setLine1("main 1");
    			address1.setLine2("cross 2");
    			address1.setState("UP");
    			address1.setZip("333333");
    			
    			Address address2 = new Address();
    			address2.setAddressType(2);
    			address2.setCity("Delhi");
    			address2.setLine1("main 6");
    			address2.setLine2("cross 7");
    			address2.setState("BR");
    			address2.setZip("676767");
    			
    			address1.setUserObject(user);
    			address2.setUserObject(user);

    			session.save(address1);
    			session.save(address2);
    			
    			Phone phone1 = new Phone();
    			phone1.setPhoneNumber("99999999999");
    			phone1.setCountryId(1);
    			phone1.setPhoneType(2);
    			
    			Phone phone2 = new Phone();
    			phone2.setPhoneNumber("9999999999");
    			phone2.setCountryId(2);
    			phone2.setPhoneType(3);
    			
    	        List<Phone> phones = new ArrayList<Phone>();
    			phones.add(phone1);
    			phones.add(phone2);
    			user.setUserPhoneSet(phones);
    			
    			session.save(user);	
    			System.out.println("User is added!");
    			
    	        session.getTransaction().commit();
    	
    }
    
    private static void listUser(Session session) {
    	
    	System.out.println("In list user method!");
    			
    		//	List<User> userList = (List<User>)session.createQuery("from User").list();
    			Criteria cr = session.createCriteria(User.class);
    			cr.add(Restrictions.eq("name", "Rajesh"));
    			List<User> userList = cr.list();
    			
    			
    			for(User ul:userList){
    				System.out.println("First Name - "+ul.getFirstName()+", Last Name - "+ul.getLastName());
    				System.out.println("The size of addresslist is -- "+ul.getUserAddresses().size());
    				
    				List<Address> addressSet = ul.getUserAddresses();
    				Iterator<Address> iter = addressSet.iterator();
    				while (iter.hasNext()) {
    				   Address userAddress = iter.next();
    				   System.out.println("address is --- "+userAddress.getCity());
    				   System.out.println("Address Type is --- "+userAddress.getAdrsObject().getDescription());
    				}
    				
    				List<Phone> userPhoneSet = ul.getUserPhoneSet();
    				Iterator<Phone> iter1 = userPhoneSet.iterator();
    				while (iter1.hasNext()) {
    				   Phone usrPh = iter1.next();
    				   System.out.println("User Phone is --- "+usrPh.getPhoneNumber());
    				   System.out.println("User Country is --- "+usrPh.getCountryId());
    				   /*System.out.println("Phone Record Id is -- "+usrPh.getPhType().getRecordId());
    				   System.out.println("Phone Type is -- "+usrPh.getPhType().getDescription());
    				   System.out.println("Country code is ---- "+usrPh.getCountry().getCountryCode());
    				   System.out.println("Country description is ---- "+usrPh.getCountry().getDescription());*/
    				}
    				
    			}
    			
    }
}
