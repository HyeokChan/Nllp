# nllp 계약관리시스템

### 개발환경
Project : Gradle Project
Spring Boot : 2.3
Language : Java
Pajaging : Jar
Java : 11
Database : Oracle
Render : Thymeleaf

### gateway 라우팅처리
#### route 프로젝트
1. api gateway를 통해 url별 라우팅 처리를 위한 프로젝트
2. 프로젝트 별 filter 적용

#### nllp 프로젝트
1. 재산관리 업무 로직 처리 프로젝트
2. 계약관리 업무 로직 처리 프로젝트

#### user 프로젝트
1. 로그인, 로그아웃 처리
2. 사용자관련 정보 업무 로직 처리 프로젝트

#### 소스 및 처리 설명
~~~
server:
  # 기본 포트 8080 설정
  port: 8080
---
spring:
  cloud:
    # gateway 설정
    gateway:
      httpclient:
        connect-timeout: 5000
        response-timeout: 50s
      # gateway를 통한 처리 시 기본 동작하는 global filter
      default-filters:
        - name: GlobalFilter
          args:
            baseMessage: Spring Cloud Gateway GlobalFilter
            preLogger: true
            postLogger: true
      # 각 routes 기술
      routes:
        # nllp 프로젝트
        - id: nllp
          uri: http://localhost:8081/
          # 해당 요청이 있을 때, 8081 포트로 처리
          predicates:
          - Path=/nllp/**, /user/**, /**
#           특정날짜 이전/이후/사이에 호출 가능한 설정
#          - Before=2050-05-15T20:20:20.126+09:00[Asia/Seoul]
#          - After=2021-05-15T20:20:20.126+09:00[Asia/Seoul]
#          - Between=2021-05-15T20:20:20.126+09:00[Asia/Seoul], 2050-05-15T20:20:20.126+09:00[Asia/Seoul]
#           route의 group 별 가중치 설정
#          - Weight=group-nllp, 5
          # nllp 요청 시 동작하는 filter
          filters:
            - name: NllpFilter
              args:
                baseMessage: Spring Cloud Gateway NllpFilter
                preLogger: true
                postLogger: true
~~~

### 로그인 처리
#### 주요 화면

<img width="703" alt="스크린샷 2022-12-31 오후 9 07 10" src="https://user-images.githubusercontent.com/48059565/210136217-23c9f40b-f969-407a-b148-eb9a4d453920.png">

<img width="921" alt="스크린샷 2022-12-31 오후 9 10 43" src="https://user-images.githubusercontent.com/48059565/210136257-4088509c-5873-489f-a85a-bde40cc95b26.png">

#### 회원가입 시 비밀번호 암호화 적용
1. 회원가입 처리 시 oracle 사용자 정보에 저장되는 사용자 비밀번호 암호화
2. BCryptPasswordEncoder를 사용하여 단방향 암호화 적용
  ~~~
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    // 회원가입 처리
    @Override
    public int instUserInfo(RegisterVO inVO) throws Exception {
        inVO.setUserPw(passwordEncoder.encode(inVO.getUserPw()));
        int rst = this.userMapper.instUserInfo(inVO);
        return rst;
    }
  ~~~

#### 로그인 시 스프링 시큐리티 적용
1. 시큐리티 설정 파일 생성
2. @EnableWebSecurity 어노테이션을 통해 설정 파일 지정
3. WebSecurityConfigurerAdapter 시큐리티 클래스 상속
4. 소스 및 처리 설명
    ~~~
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/user/login", "/user/register", "/css/**", "/js/**", "/assets/**").permitAll() // 위 경로 호출들은 인증(로그인) 없이 허용
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/user/login") // 로그인 페이지를 열때, /user/login GET 호출 -> UserController에서 loginForm.html 호출
                .loginProcessingUrl("/user/login")  // loginForm.html에서 로그인 버튼 클릭 시 /user/login POST 호출
                .usernameParameter("userId")    // spring security 처리 시 username를 변수로 사용하는데 인자로 userId 사용
                .passwordParameter("userPw")    // spring security 처리 시 password를 변수로 사용하는데 인자로 userPw 사용
                .successHandler(authenticationSuccessHandler)   // 인증 성공시 호출되는 핸들러
                .failureHandler(authenticationFailureHandler)   // 인증 실패시 호출되는 핸들러
                .and()
                .logout()   // 로그아웃 설정
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))    // /user/logout이 호출되었을 때 로그아웃 처리, bodyHeader.html에서 호출
                .logoutSuccessUrl("/user/login")    // 로그아웃 성공시 호출하는 경로, UserController에 의해 loginForm.html로 이동
                .invalidateHttpSession(true);
    }
    ~~~
5. Provider에서 비밀번호 비교를 위해 BCryptPasswordEncoder 사용
6. matches 메소드를 통해 암호화된 비밀번호 비교 가능
    ~~~
    /***
     * @description 인증 처리 로직
     * @param authentication 전달된 username(userId), password(userPw)에 대한 데이터 VO
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        CustomUserDetails customUserDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(username);
        // 넘겨받은 password와 암호화된 password 비교, 일치하지 않으면 예외처리
        if(!passwordEncoder.matches(password, customUserDetails.getPassword())){
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 로그인 성공시 USER 권한 부여
        authorities.add(new SimpleGrantedAuthority("USER"));
        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }
    ~~~

### 업무 처리
#### 목록 화면

<img width="1423" alt="스크린샷 2022-12-31 오후 9 19 08" src="https://user-images.githubusercontent.com/48059565/210136494-1d7d356e-e2a0-42a6-8a36-445a45951ea1.png">

1. 세션을 통해 로그인한 사용자 정보 유지
    - 마지막 접근 시간 기준으로 세션 타임아웃 체크
2. thymeleaf를 활용하여 화면 렌더링
    - 사이드바, footer, bodyHeader 등 기본요소들의 fragment 처리로 코드 간소화
    - 서버 접근이 불가해도 기본 텍스트 안내 제공
    - th:object, th:field 기능 활용
3. datatables로 그리드 데이터 구현 및 자료 조회 및 페이징 처리 개발

#### 상세조회와 Valid 체크

<img width="1423" alt="스크린샷 2022-12-31 오후 9 26 36" src="https://user-images.githubusercontent.com/48059565/210136718-d93d9468-85fb-4fab-b897-c6902c80e1aa.png">

1. @Valid 어노테이션으로 입력값 체크
    ~~~
    /***
     * @description 재산자료 수정처리
     * @param inVO
     * @return 재산자료 재조회
     * @throws Exception
     */
    @PostMapping("/updtNllpInfo/{itemId}")
    public String updtNllpInfo(@PathVariable("itemId") String nllpAcbKey, @Valid @ModelAttribute("nllpInfo") NllpUpdtVO inVO, BindingResult result, Model model) throws Exception{
        if (result.hasErrors()) {
            inVO.setCodes(this.codeService.findCodes(Arrays.asList("biz0001", "biz0002", "biz0003")));
            model.addAttribute("nllpInfo", inVO);
            return "operation/nllp/nllpInfoUpdtForm";
        }
        inVO.setNllpAcbKey(nllpAcbKey);
        int rst = this.nllpService.updtNllpInfo(inVO);
        return "redirect:/nllp/findNllpInfo/" + nllpAcbKey;
    }
    ~~~
    
    - bindingResult를 통해 Valid 오류 처리
    - 
2. VO 처리
    ~~~
    @Setter
    @ToString
    @Alias("nllpUpdtVO")
    public class NllpUpdtVO extends DefaultVO {
        private String nllpAcbKey;
        @NotBlank(message = "기본주소를 입력해주세요")
        @Size(max = 300, message = "기본주소 길이를 확인해주세요(300)")
        private String lotnoBacAddr;
        @Size(max = 300, message = "상세주소 길이를 확인해주세요(300)")
        private String lotnoDaddr;
        @NotBlank(message = "산을 입력해주세요")
        @Size(max = 2, message = "산 길이를 확인해주세요(2)")
        private String mtnSeCd;
        @NotBlank(message = "본번 입력해주세요")
        @Size(max = 4, message = "본번 길이를 확인해주세요(4)")
        private String mno;
        @Size(max = 4, message = "부번 길이를 확인해주세요(4)")
        private String sno;
    ~~~
    
    - @NotBlank, @Size 등 어노테이션을 통해 입력값 오류 체크 설정
