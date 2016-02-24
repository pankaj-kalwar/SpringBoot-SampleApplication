package com.beyondalgo.app;


/*@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=AuthServerApp.class)
@WebIntegrationTest(randomPort = true)*/
public class AuthServerAppTest {

	/*@Autowired
	WebApplicationContext context;

	@Autowired
	FilterChainProxy filterChain;

	private MockMvc mvc;

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Before
	public void setUp() {
		this.mvc = webAppContextSetup(this.context).addFilters(this.filterChain).build();
		SecurityContextHolder.clearContext();
	}

	@Test
	public void everythingIsSecuredByDefault() throws Exception {
		this.mvc.perform(get("/").accept(MediaTypes.HAL_JSON))
				.andExpect(status().isUnauthorized()).andDo(print());
		this.mvc.perform(get("/flights").accept(MediaTypes.HAL_JSON))
				.andExpect(status().isUnauthorized()).andDo(print());
		this.mvc.perform(get("/flights/1").accept(MediaTypes.HAL_JSON))
				.andExpect(status().isUnauthorized()).andDo(print());
		this.mvc.perform(get("/alps").accept(MediaTypes.HAL_JSON))
				.andExpect(status().isUnauthorized()).andDo(print());
	}

	@Test
	@Ignore
	public void accessingRootUriPossibleWithUserAccount() throws Exception {
		String header = "Basic " + new String(Base64.encode("greg:turnquist".getBytes()));
		this.mvc.perform(
				get("/").accept(MediaTypes.HAL_JSON).header("Authorization", header))
				.andExpect(
						header().string("Content-Type", MediaTypes.HAL_JSON.toString()))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void useAppSecretsPlusUserAccountToGetBearerToken() throws Exception {
		String header = "Basic " + new String(Base64.encode("foo:bar".getBytes()));
		MvcResult result = this.mvc
				.perform(post("/oauth/token").header("Authorization", header)
						.param("grant_type", "password").param("scope", "read")
						.param("username", "greg").param("password", "turnquist"))
				.andExpect(status().isOk()).andDo(print()).andReturn();
		Object accessToken = this.objectMapper
				.readValue(result.getResponse().getContentAsString(), Map.class)
				.get("access_token");
		MvcResult usersAction = this.mvc
				.perform(get("/user/1").accept(MediaTypes.HAL_JSON)
						.header("Authorization", "Bearer " + accessToken))
				.andExpect(
						header().string("Content-Type", MediaTypes.HAL_JSON.toString()))
				.andExpect(status().isOk()).andDo(print()).andReturn();

		User user = this.objectMapper.readValue(
				usersAction.getResponse().getContentAsString(), User.class);
		

		assertThat(user.getName(), is("pankaj"));
	}*/

}