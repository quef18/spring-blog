package com.example.ltw_nhom20.service.bean;

import com.example.ltw_nhom20.entity.MyUserDetails;
import com.example.ltw_nhom20.entity.User;
import com.example.ltw_nhom20.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserDetailsServiceBean implements UserDetailsService {
    private final UserRepo userRepo;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found!"));
        return new MyUserDetails(user);
    }
}
