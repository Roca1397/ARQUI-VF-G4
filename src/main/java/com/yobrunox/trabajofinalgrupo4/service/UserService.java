package com.yobrunox.trabajofinalgrupo4.service;

import com.yobrunox.trabajofinalgrupo4.dto.User.LoginDTO;
import com.yobrunox.trabajofinalgrupo4.dto.User.RegisterDTO;
import com.yobrunox.trabajofinalgrupo4.dto.User.UserResponse;
import com.yobrunox.trabajofinalgrupo4.models.City;
import com.yobrunox.trabajofinalgrupo4.models.Role;
import com.yobrunox.trabajofinalgrupo4.models.Users;
import com.yobrunox.trabajofinalgrupo4.repository.CityRepository;
import com.yobrunox.trabajofinalgrupo4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CityRepository cityRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public UserResponse login(LoginDTO loginDTO){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
        UserDetails user = userRepository.findByUser(loginDTO.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return UserResponse.builder()
                .token(token)
                .build();
    }
    public UserResponse register(RegisterDTO registerDTO){
        City city = cityRepository.findById(registerDTO.getCityId()).orElse(null);
        System.out.println(registerDTO.getDni());
        System.out.println(registerDTO.getPassword());
        Users user = Users.builder()
                .name(registerDTO.getName())
                .lastName(registerDTO.getLastName())
                .dni(registerDTO.getDni())
                .email(registerDTO.getEmail())
                .username(registerDTO.getUsername())
                .password(passwordEncoder.encode(registerDTO.getPassword()))
                .registerDate(new Date())
                .address(registerDTO.getAddress())
                .phone(registerDTO.getPhone())
                .balance(0.0)
                .city(city)
                .role(Role.USER)
                .build();
        userRepository.save(user);
        return UserResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
    public RegisterDTO actualizarDatosUsuario(Integer id, RegisterDTO registerDTO) {
        Users usuario = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
        City city = cityRepository.findById(registerDTO.getCityId()).orElse(null);
        usuario.setName(registerDTO.getName());
        usuario.setLastName(registerDTO.getLastName());
        usuario.setDni(registerDTO.getDni());
        usuario.setEmail(registerDTO.getEmail());
        usuario.setUsername(registerDTO.getUsername());
        usuario.setPassword(registerDTO.getPassword());
        usuario.setAddress(registerDTO.getAddress());
        usuario.setPhone(registerDTO.getPhone());
        usuario.setCity(city);

        usuario = userRepository.save(usuario);

        return new RegisterDTO(
                usuario.getName(),
                usuario.getLastName(),
                usuario.getDni(),
                usuario.getEmail(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getAddress(),
                usuario.getPhone(),
                usuario.getCity().getId()
        );
    }
}