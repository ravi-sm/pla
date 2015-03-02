package org.nthdimenzion.security.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nthdimenzion.security.domain.UserLoginDetailDto;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 2/13/15
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class SMEAuthenticationProvider extends  AbstractUserDetailsAuthenticationProvider{


    public SMEAuthenticationProvider(){
    }

    @Override
    protected final UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        UserDetails loadedUser;
        try {
            RestTemplate restTemplate = new RestTemplate();
            String uri = new String("http://127.0.0.1:9090/partymgr/control/getUserDetail?userLoginId="+username);
            String response = restTemplate.getForObject(uri, String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            UserLoginDetailDto userLoginDetailDto = objectMapper.readValue(response, UserLoginDetailDto.class);
            userLoginDetailDto.populateAuthorities(userLoginDetailDto.getRoles());
            loadedUser = userLoginDetailDto;
        } catch (UsernameNotFoundException notFound) {
            if(authentication.getCredentials() != null) {
                throw new InternalAuthenticationServiceException(
                        "User Name not found");
            }
            throw notFound;
        } catch (Exception repositoryProblem) {
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }

        if (loadedUser == null) {
            throw new InternalAuthenticationServiceException(
                    "UserDetailsService returned null, which is an interface contract violation");
        }
        return loadedUser;
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}
