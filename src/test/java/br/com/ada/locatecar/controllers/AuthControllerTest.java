@InjectMocks
private AuthController authController;

private MockMvc mockMvc;

@BeforeEach
void setup() {
    MockitoAnnotations.openMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
}

@Test
void testRegisterUserSuccess() throws Exception {
    SignupRequest signupRequest = new SignupRequest();
    signupRequest.setEmail("test@example.com");
    signupRequest.setDocument("123456");
    signupRequest.setPassword("password");

    doNothing().when(authService).registerUser(any(SignupRequest.class));

    mockMvc.perform(post("/api/auth/signup")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"email\":\"test@example.com\",\"document\":\"123456\",\"password\":\"password\"}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message").value("User registered successfully"));

    verify(authService, times(1)).registerUser(any(SignupRequest.class));
}

@Test
void testRegisterUserFailure() throws Exception {
    SignupRequest signupRequest = new SignupRequest();
    signupRequest.setEmail("test@example.com");
    signupRequest.setDocument("123456");
    signupRequest.setPassword("password");

    doThrow(new RuntimeException("Email is already in use")).when(authService).registerUser(any(SignupRequest.class));

    mockMvc.perform(post("/api/auth/signup")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"email\":\"test@example.com\",\"document\":\"123456\",\"password\":\"password\"}"))
