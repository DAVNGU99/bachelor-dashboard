package com.example.dashboardapp.security;

import com.example.dashboardapp.domain.entities.User;
import com.example.dashboardapp.repositories.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Getter
@RequiredArgsConstructor
public class DashBoardUserDetailService implements UserDetailsService


{

    private final UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByName(name).orElseThrow( () -> new UsernameNotFoundException("Bruker ikke funnet" + name));


        return new DashBoardUserDetails(user);
    }
}
