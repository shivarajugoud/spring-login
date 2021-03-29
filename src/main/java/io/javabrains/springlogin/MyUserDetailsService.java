package io.javabrains.springlogin;
import io.javabrains.springlogin.models.User;
import io.javabrains.springlogin.models.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
    {
        System.out.println(userName+" is userName");
       Optional<User> user1 = userRepository.findByUserName(userName);
       for(int i=0;i<10;i++)
       System.out.println("reached HERE");
       System.out.println(user1);
       user1.orElseThrow(() -> new UsernameNotFoundException("Not found : "+userName));
       return user1.map(MyUserDetails::new).get();
    }
}
