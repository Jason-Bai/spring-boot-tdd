package com.javatech.tdd.service.impl;

import com.javatech.tdd.dto.AuthorizationDTO;
import com.javatech.tdd.dto.UmsAdminDTO;
import com.javatech.tdd.mbg.mapper.UmsAdminMapper;
import com.javatech.tdd.mbg.model.UmsAdmin;
import com.javatech.tdd.mbg.model.UmsAdminExample;
import com.javatech.tdd.service.AuthorizationService;
import com.javatech.tdd.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author baiyu
 * @Desc
 * @date 2020/12/3
 */
@Slf4j
@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Override
    public UmsAdmin register(UmsAdminDTO umsAdminDTO) {
        UmsAdmin umsAdmin = new UmsAdmin();

        umsAdmin.setEmail(umsAdminDTO.getEmail());
        umsAdmin.setUsername(umsAdminDTO.getUsername());
        umsAdmin.setPassword(umsAdminDTO.getPassword());
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(true);

        //查询是否有相同用户名的用户
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(umsAdmin.getUsername());
        List<UmsAdmin> umsAdminList = umsAdminMapper.selectByExample(example);

        if (umsAdminList.size() > 0) {
            return null;
        }

        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);

        umsAdminMapper.insert(umsAdmin);

        return umsAdmin;
    }

    @Override
    public String login(String username, String password) {
        String token = null;

        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }

        return token;
    }
}
