//package com.cg;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThrows;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.cg.entity.Developer;
//import com.cg.entity.Feed;
//import com.cg.entity.Response;
//import com.cg.entity.Users;
//import com.cg.repository.DeveloperRepository;
//import com.cg.repository.FeedRepository;
//import com.cg.repository.ResponseRepository;
//import com.cg.repository.UserRepository;
//import com.cg.service.DeveloperService;
//import com.cg.service.FeedService;
//import com.cg.service.ResponseService;
//import com.cg.service.UserService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class DeveloperCommunityApplicationTests {
//
//	@Autowired
//	private DeveloperService developerService;
//
//	@MockBean
//	private DeveloperRepository developerRepository;
//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private FeedService feedService;
//	
//	@MockBean
//	private FeedRepository feedRepository;
//	@MockBean
//	private UserRepository userRepository;
//	@Autowired
//	private ResponseService responseService;
//	
//	@MockBean
//	private ResponseRepository responseRepository;
//
//
//	@Test
//	public void getAllUsersTest() {
//		when(userRepository.findAll())
//				.thenReturn(Stream.of(new Users("poo", "Poo@21", "Admin"), new Users("poo", "Pooja@21", "Developer"))
//						.collect(Collectors.toList()));
//		assertEquals(2, userService.getAllUsers().size());
//	}
//
//	@Test
//	public void saveUsersTest() {
//		Users users = new Users("p", "Prachi", "Admin");
//		when(userRepository.save(users)).thenReturn(users);
//		assertEquals(users, userService.saveUsers(users));
//	}
//
//	@Test
//	public void registerTest() {
//		Users users = new Users("p", "Pooja", "Admin");
//		boolean res = this.userService.register(users);
//		assertTrue(res);
//	}
//	@Test
//	public void testRegistrationFail()
//	{
//		String userId="pooja@21";
//		String	password="Poo1233";
//		Users users1 =new Users();
//		users1.setUserId(userId);
//		Mockito.when( userRepository.getById( userId)).thenReturn(users1);
//		Users users =new Users();
//		 users.setUserId(userId);
//		users.setPassword(password);
//		assertThrows(ResourceNotFoundException.class, ()->userService.register(users));
//	}
//	
//	@Test
//	public void testRegistrationSuccess()
//	{
//		String userId="pooja@21";
//		String	password="Poo1233";
//		Mockito.when(userRepository.getById(userId)).thenReturn(null);
//		Users users =new Users();
//		users.setUserId(userId);
//		users.setPassword(password);
//		assertTrue( userService.register(users));
//	}
//
//	@Test
//	public void getAllDeveloperTest() {
//		when(developerRepository.findAll()).thenReturn(Stream
//				.of(new Developer(2, "developer", "poorna1@gmail.com", "verygoodd", "10-10-2020", 1, 1, true, false),
//						new Developer(1, "admin", "poornaa@gmail.com", "goodd", null, 1, 1, true, false))
//				.collect(Collectors.toList()));
//		assertEquals(2, developerService.getAllDevelopers().size());
//	}
//
//	@Test
//	public void getByIdTest1() {
//		int devId = 2;
//		when(developerRepository.getById(devId)).thenReturn((Developer) Stream
//				.of(new Developer(2, "developer", "poorna1@gmail.com", "verygoodd", "10-10-2020", 1, 1, true, false))
//				.collect(Collectors.toList()));
//		assertEquals(1, ((List<Developer>) developerService.getById(devId)).size());
//	}
//
//	@Test
//	public void saveDeveloperTest() {
//		Developer developer = new Developer(2, "developer", "poorna1@gmail.com", "verygoodd", "10-10-2020", 1, 1, true,
//				false);
//		when(developerRepository.save(developer)).thenReturn(developer);
//		assertEquals(developer, developerService.saveDeveloper(developer));
//	}
//
//	@Test
//	public void editDeveloperTest() {
//		Developer developer = new Developer(2, "developer", "poorna1@gmail.com", "verygoodd", "10-10-2020", 1, 1, true,
//				false);
//		when(developerRepository.save(developer)).thenReturn(developer);
//		assertEquals(developer, developerService.editDeveloper(developer));
//	}
//	@Test
//	public void getAllFeedTest() {
//		
//		when(feedRepository.findAll()).thenReturn(Stream.of(
//				new Feed(1,"Stop Project 1.5","java",11,4,"18-06-2021","12:06:00",
//				"Liked"),new Feed(2,"Start Project 1.5","java",11,4,"18-06-2021","12:06:00",
//						"Liked")).collect(Collectors.toList()));
//		assertEquals(2, feedService.getAllFeeds().size());
//	}
//	
//	@Test
//	public void saveFeedTest() {
//		Feed feed=new Feed(1,"Stop Project 1.5","java",11,4,"18-06-2021","12:06:00",
//				"Liked");
//		when(feedRepository.save(feed)).thenReturn(feed);
//		assertEquals(feed, feedService.saveFeed(feed));
//	}
//	
//	
//	@Test
//	public void getByIdTest2() {
//		int feedId=1;
//		when(feedRepository.getById(feedId)).thenReturn((Feed) Stream.of(new Feed(1,"Stop Project 1.5","java",11,4,"18-06-2021","12:06:00",
//				"Liked")).collect(Collectors.toList()));
//		assertEquals(1,((List<Feed>)feedService.getById(feedId)).size());
//	}
//	
//	
//	@Test
//	public void editFeedTest() {
//		Feed feed=new Feed(1,"Stop Project 1.5","java",11,4,"18-06-2021","12:06:00",
//				"Liked");
//		when(feedRepository.save(feed));
//		assertEquals(feed, feedService.editFeed(feed));
//	}
//
//	
//	
//	
//	@Test
//	public void deleteFeedTest() {
//		Feed feed=new Feed(1,"Stop Project 1.5","java",11,4,"18-06-2021","12:06:00",
//				"Liked");
//		verify(feedRepository,times(1)).delete(feed);
//	}
//	
//	@Test
//	public void getAllResponseTest() {
//		when(responseRepository.findAll()).thenReturn(Stream.of(new Response(2,"Stop Project 1.5","18-06-2021","12:06:00",12,"Liked"),new Response(1,"Stop Project 1.5","18-06-2021","12:06:00",12,"Liked")).collect(Collectors.toList()));
//		assertEquals(1, responseService.getAllResponses().size());
//	}
//	
//	@Test
//	public void getByIdTest() {
//		int respId=2;
//		
//		when(responseRepository.getById(respId)).thenReturn((Response)Stream.of(new Response(2,"Stop Project 1.5","18-06-2021","12:06:00",12,"Liked"),new Response(1,"Stop Project 1.5","18-06-2021","12:06:00",12,"Liked")).collect(Collectors.toList()));
//		assertEquals(1, ((List<Response>)responseService.getById(respId)).size());
//	}
//	
//	@Test
//	public void saveResponseTest() {
//		when(responseRepository.findAll()).thenReturn(Stream
//				.of(new Response(2,"Stop Project 1.5","18-06-2021","12:06:00",12,"Liked"),new Response(1,"Stop Project 1.5","18-06-2021","12:06:00",12,"Liked"),
//						new Response(2,"Stop Project 1.5","18-06-2021","12:06:00",12,"Liked"),new Response(1,"Stop Project 1.5","18-06-2021","12:06:00",12,"Liked"))
//				.collect(Collectors.toList()));
//		assertEquals(2, responseService.getAllResponses().size());
//	}
//	
//	@Test
//	public void editResponseTest() {
//		Response response=new Response(2,"Stop Project 1.5","18-06-2021","12:06:00",12,"Liked");
//		
//		when(responseRepository.save(response)).thenReturn(response);
//		assertEquals(response, responseService.editResponse(response));
//	}
//	
//	@Test
//	public void deleteResponseTest() {
//		Response response=new Response(2,"Stop Project 1.5","18-06-2021","12:06:00",12,"Liked");
//		verify(responseRepository,times(1)).delete(response);
//	
//	}
//
//
//}