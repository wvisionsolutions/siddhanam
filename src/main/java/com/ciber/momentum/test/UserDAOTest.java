package com.ciber.momentum.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ciber.momentum.dao.impl.UserDAOImpl;
import com.ciber.momentum.entity.Address;
import com.ciber.momentum.entity.Phone;
import com.ciber.momentum.entity.User;
import com.ciber.momentum.handler.UserResponse;

@RunWith(MockitoJUnitRunner.class)
public class UserDAOTest {

	private static final Logger logger = Logger.getLogger(UserDAOTest.class);

	private UserDAOImpl userDAOImpl;
	@Mock
	private SessionFactory sessionFactory;

	private List<UserResponse> userResponseList = null;
	private String searchUser;
	private UserResponse userResponse;
	private String expectedSearchFirstName;
	private String notExpectedSearchFirstName;
	private String actualSearchFirstName;
	private User addUser;
	private User addUserUnvalid;
	private User updateUser;
	private User updateUserUnvalid;
	private int deleteIdValid;
	private int deleteIdInValid;
	private Address addAddress;
	private Address addInvalidAddress;
	private Phone addPhone;
	private Phone addInvalidPhone;
	List<Address> addAddressList = null;
	List<Address> addInvalidAddressList = null;
	List<Phone> addPhoneList = null;
	List<Phone> addInvalidPhoneList = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.info("******TestUserServiceTest::Start******");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.info("******TestUserServiceTest::End******");
	}

	/*
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		System.out.println("-- Before setUp --");

		final Configuration configuration = new Configuration();
		configuration.configure().setProperty("hibernate.show_sql", "false");
		final ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		ThreadLocalSessionContext.bind(sessionFactory.openSession());

		userDAOImpl = new UserDAOImpl(sessionFactory);

		// ------------------------ Search user data - Start ----------------------
		
		  searchUser = "krish"; 
		  expectedSearchFirstName="Krishna";
		  notExpectedSearchFirstName="testk"; 
		  //To get the list of users when we search with the given value 
		  userResponseList = userDAOImpl.searchUsers(searchUser); 
		  Iterator<UserResponse> itr = userResponseList.iterator(); 
		  while(itr.hasNext()) { userResponse = itr.next(); 
		  actualSearchFirstName=userResponse.getFirstName();
		  System.out.println("actualSearchFirstName ---- "+actualSearchFirstName);
		  logger.info("list of values:"+actualSearchFirstName);
		  }
		 
		addUser = new User();
		addUser.setFirstName("sunee");
		addUser.setLastName("p");
		addUser.setGender("F");
		addUser.setPassword("sasdsd");
		addUser.setSsn("111-22-444");
		addUser.setName("suneetha");
		addUser.setEmail("A@gmail.com");
		addUser.setRole("Basic");

		// Adding address
		addAddress = new Address();
		addAddressList = new ArrayList<Address>();
		addAddress.setAddressType(1);
		addAddress.setCity("Bang");
		addAddress.setState("KA");
		addAddress.setZip("522616");
		addAddressList.add(addAddress);
		addUser.setUserAddresses(addAddressList);

		// Adding Phoneset
		addPhone = new Phone();
		addPhone.setPhoneNumber("1234567890");
		addPhone.setPhoneType(1);
		addPhone.setCountryId(4);
		addPhoneList = new ArrayList<Phone>();
		addPhoneList.add(addPhone);
		addUser.setUserPhoneSet(addPhoneList);

		// for invalid user
		addUserUnvalid = new User();
		addUserUnvalid.setFirstName("sunee");
		addUserUnvalid.setLastName("p");
		addUserUnvalid.setGender("F");
		addUserUnvalid.setPassword("sasdsd");
		addUserUnvalid.setName("suneetha");
		addUserUnvalid.setEmail("A@gmail.com");
		addUserUnvalid.setRole("Basic");

		addInvalidAddress = new Address();
		addInvalidAddressList = new ArrayList<Address>();
		addInvalidAddress.setAddressType(1);
		addInvalidAddress.setCity("Bang");
		addInvalidAddress.setState("KA");
		addInvalidAddress.setZip("522616");
		addInvalidAddressList.add(addInvalidAddress);
		addUserUnvalid.setUserAddresses(addAddressList);

		// Adding Phoneset
		addInvalidPhone = new Phone();
		addInvalidPhone.setPhoneNumber("1234567890");
		addInvalidPhone.setPhoneType(1);
		addInvalidPhone.setCountryId(4);
		addInvalidPhoneList = new ArrayList<Phone>();
		addPhoneList.add(addPhone);
		addUserUnvalid.setUserPhoneSet(addPhoneList);

		
		  //to edit the user 
		  updateUser = new User();
		  updateUser.setFirstName("sunee"); updateUser.setLastName("p");
		  updateUser.setGender("F"); updateUser.setPassword("sasdsd");
		  updateUser.setSsn("111-22-444"); updateUser.setName("suneetha");
		  updateUser.setEmail("A@gmail.com"); updateUser.setRole("Basic");
		  
		  updateUserUnvalid = new User();
		  updateUserUnvalid.setFirstName("sunee");
		  updateUserUnvalid.setLastName("p"); updateUserUnvalid.setGender("F");
		  updateUserUnvalid.setPassword("sasdsd");
		  updateUserUnvalid.setSsn("111-22-444");
		  updateUserUnvalid.setName("suneetha");
		  updateUserUnvalid.setEmail("A@gmail.com");
		  updateUserUnvalid.setRole("Basic");
		 
		  deleteIdValid = 63;
		  deleteIdInValid = 70;
		
		System.out.println("-- After setUp --");

	}

	/*
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

		System.out.println("-------- In Tear Down Method -------");
		sessionFactory.close();

	}

	/*
	 * Case 1 - Testing whether response is null or not
	 */
	@Test
	public void testUserDataNotEmpty() throws Exception {

		System.out.println(" --- In testUserDataNotEmpty ---- ");

		userResponseList = new ArrayList<UserResponse>();
		userResponseList = userDAOImpl.searchUsers(searchUser);
		System.out.println("size is ---- " + userResponseList.size());
		boolean assertValue = !userResponseList.isEmpty();
		logger.info("testUserDataNotEmpty :: testUserDataNotEmpty.testUserDataNotEmpty(): "
				+ userResponseList);
		logger.info("assertTrue(!userResponseList.isEmpty()) :: " + assertValue);
		assertTrue(assertValue);
	}

	/*
	 * Case 2- Testing whether the user data selected data is correct
	 */
	@Test
	public void testSearchDataResultIsValid() {

		logger.info("expectedSearchFirstName :: actualSearchFirstName 	: "
				+ expectedSearchFirstName);

		assertEquals(expectedSearchFirstName, actualSearchFirstName);
	}
	
	/*
	 * Case 3- Testing whether the user searched data and selected data is not correct
	 */
	@Test
	public void testSearchDataResultIsNotValid() {

		logger.info("notExpectedSearchFirstName :: actualSearchFirstName 	: "
				+ notExpectedSearchFirstName);

		assertEquals(notExpectedSearchFirstName, actualSearchFirstName);
	}

	/*
	 * Case 4- Testing Add user Valid data
	 */
	@Test
	public void testAddUserValidData() throws Exception {

		logger.info("Add user");
		boolean thrown;

		thrown = userDAOImpl.addUser(addUser);

		System.out.println("User added !!");
		assertTrue(thrown);
	}

	/*
	 *  * Case 5- Testing Add user NotValid data
	 */
	@Test
	public void testAddUserNotValidData() throws Exception {

		logger.info("Add user Unvalid");
		boolean thrown;
		thrown = userDAOImpl.addUser(addUserUnvalid);

		assertTrue(thrown);
	}

	/*
	 * Case 6- Testing edit user Valid data
	 */
	@Test
	public void testEditUserValidData() throws Exception {

		logger.info("Edit user");
		System.out.println("-- In Edit User --");
		boolean thrown;

		thrown = userDAOImpl.updateUser(updateUser);
		assertTrue(thrown);

	}

	/*
	 * Case 7- Testing edit user NotValid data
	 */

	@Test
	public void testEditUserNotValidData() throws Exception {

		logger.info("Edit user Unvalid");
		boolean thrown;
		thrown = userDAOImpl.updateUser(updateUserUnvalid);
		assertTrue(thrown);

	}

	/*
	 * Case 8- Testing delete user Valid data
	 */

	@Test
	public void testDeleteUserValidData() throws Exception {

		logger.info("Delete user");
		System.out.println("user to be deleted ---  " + deleteIdValid);
		boolean thrown;

		thrown = userDAOImpl.deleteUser(deleteIdValid);

		assertTrue(thrown);
	}

	/*
	 * Case 9- Testing delete user NotValid data
	 */

	@Test
	public void testDeleteUserNotValidData() throws Exception {

		logger.info("Delete user Unvalid");

		boolean thrown;

		thrown = userDAOImpl.deleteUser(deleteIdInValid);

		assertTrue(thrown);
	}
	
}
