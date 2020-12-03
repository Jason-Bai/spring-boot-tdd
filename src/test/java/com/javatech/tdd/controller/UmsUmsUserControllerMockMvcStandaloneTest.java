package com.javatech.tdd.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author baiyu
 * @Desc
 * @date 2020/11/30
 */
@ExtendWith(MockitoExtension.class)
public class UmsUmsUserControllerMockMvcStandaloneTest {
    /*
    private MockMvc mvc;

    @Mock
    private UmsUserService umsUserService;

    @InjectMocks
    private UmsUserController umsUserController;


    @BeforeEach
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
        mvc = MockMvcBuilders.standaloneSetup(umsUserController)
                .setControllerAdvice(new ExceptionControllerAdvice(), new ResponseControllerAdvice())
                .build();
    }

    @Test
    @DisplayName("should return users when users exists")
    public void shouldReturnUsersWhenUsersExists() throws Exception {
        UmsUserItem james = new UmsUserItem();
        james.setId(101);
        james.setUsername("James");
        james.setPhone("12345678911");
        james.setGender(Gender.MALE);
        james.setBirthday(new Date());
        james.setCreateTime(new Date());
        james.setStatus(Status.ENABLED);

        UmsUserItem lily = new UmsUserItem();
        lily.setId(102);
        lily.setUsername("lily");
        lily.setPhone("12345678911");
        lily.setGender(Gender.FEMALE);
        lily.setBirthday(new Date());
        lily.setCreateTime(new Date());
        lily.setStatus(Status.ENABLED);


        List<UmsUserItem> mockUmsUsers = Arrays.asList(james, lily);

        // given
        given(umsUserService.getUmsUserList(null, null, "id", 0)).willReturn(mockUmsUsers);

        // when and then
        mvc.perform(get("/users").accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("2000"))
                .andExpect(jsonPath("$.message").value("请求成功"))
                .andExpect(jsonPath("$.data[0].username").value("James"))
                .andReturn();
    }

    @Test
    void shouldReturnUserWhenUserExists() throws Exception {

        UserDTO mockUser = new UserDTO(101, "James", "James", Gender.MALE, "james@xxx.com", new Date());

        // given
        given(userService.findById(Mockito.anyInt())).willReturn(mockUser);

        // when and then
        mvc.perform(get("/users/101").accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("2000"))
                .andExpect(jsonPath("$.message").value("请求成功"))
                .andExpect(jsonPath("$.data.username").value("James"))
                .andReturn();


    }

    @Test
    void shouldReturnUserWhenUserNotExists() throws Exception {

        // given
        given(userService.findById(Mockito.anyInt())).willThrow(
                new APIException(ResponseStatusCode.NOT_FOUND)
        );

        // when and then
        mvc.perform(get("/users/102").accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("4004"))
                .andExpect(jsonPath("$.message").value("不存在"))
                .andReturn();


    }

  */
}
