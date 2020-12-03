package com.javatech.tdd.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author baiyu
 * @Desc
 * @date 2020/12/1
 */
@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@WebMvcTest(AuthorizationController.class)
public class UserControllerMockMvcWithContextTest {
    /*
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UmsUserService umsUserService;

    @Autowired
    private JacksonTester<UmsUserDTO> jsonUserDTO;

    @Test
    void shouldReturnUsersWhenUsersExists() throws Exception {
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
    void shouldInsertedWhenUserDTOValid() throws Exception {
        UmsUserDTO umsUserDTO = new UmsUserDTO();
        umsUserDTO.setEmail("baiyu@miaozhen.com");
        umsUserDTO.setUsername("baiyu123");
        umsUserDTO.setPassword("baiyu123");

        UmsUser mockUmsUser = new UmsUser();
        mockUmsUser.setEmail(umsUserDTO.getEmail());
        mockUmsUser.setUsername(umsUserDTO.getUsername());
        mockUmsUser.setPassword(umsUserDTO.getPassword());
        mockUmsUser.setCreateTime(new Date());
        mockUmsUser.setStatus(Status.ENABLED);

        // given
        given(umsUserService.save(umsUserDTO)).willReturn(mockUmsUser);

        mvc.perform(post("/users").accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonUserDTO.write(umsUserDTO).getJson()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("2001"))
                .andExpect(jsonPath("$.message").value("创建成功"))
                .andExpect(jsonPath("$.data.username").value("baiyu123"))
                .andReturn();
    }

    @Test
    void shouldThrowExceptionWhenUserDTOEmailFormatInvalid() throws Exception {
        UmsUserDTO umsUserDTO = new UmsUserDTO();
        umsUserDTO.setEmail("baiyu");

        mvc.perform(post("/users").accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonUserDTO.write(umsUserDTO).getJson()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("4001"))
                .andExpect(jsonPath("$.message").value("参数校验失败"))
                .andExpect(jsonPath("$.data").value("邮箱格式不正确"))
                .andReturn();
    }

    @Test
    void shouldThrowExceptionWhenUsernameIsNull() throws Exception {
        UmsUserDTO umsUserDTO = new UmsUserDTO();
        umsUserDTO.setEmail("baiyu@miaozhen.com");

        mvc.perform(post("/users").accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonUserDTO.write(umsUserDTO).getJson()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("4001"))
                .andExpect(jsonPath("$.message").value("参数校验失败"))
                .andExpect(jsonPath("$.data").value("用户账号不能为空"))
                .andReturn();
    }

    @Test
    void shouldThrowExceptionWhenLengthOfUsernameIsSlow() throws Exception {
        UmsUserDTO umsUserDTO = new UmsUserDTO();
        umsUserDTO.setEmail("baiyu@miaozhen.com");
        umsUserDTO.setUsername("b");

        mvc.perform(post("/users").accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonUserDTO.write(umsUserDTO).getJson()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("4001"))
                .andExpect(jsonPath("$.message").value("参数校验失败"))
                .andExpect(jsonPath("$.data").value("账号长度必须是6-11个字符"))
                .andReturn();
    }

    @Test
    void shouldThrowExceptionWhenPasswordIsNull() throws Exception {
        UmsUserDTO umsUserDTO = new UmsUserDTO();
        umsUserDTO.setEmail("baiyu@miaozhen.com");
        umsUserDTO.setUsername("baiyu123");

        mvc.perform(post("/users").accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonUserDTO.write(umsUserDTO).getJson()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("4001"))
                .andExpect(jsonPath("$.message").value("参数校验失败"))
                .andExpect(jsonPath("$.data").value("用户密码不能为空"))
                .andReturn();
    }

    @Test
    void shouldThrowExceptionWhenLengthOfPasswordIsSlow() throws Exception {
        UmsUserDTO umsUserDTO = new UmsUserDTO();
        umsUserDTO.setEmail("baiyu@miaozhen.com");
        umsUserDTO.setUsername("baiyu123");
        umsUserDTO.setPassword("p");

        mvc.perform(post("/users").accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonUserDTO.write(umsUserDTO).getJson()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("4001"))
                .andExpect(jsonPath("$.message").value("参数校验失败"))
                .andExpect(jsonPath("$.data").value("密码长度必须是6-16个字符"))
                .andReturn();
    }

     */
}
