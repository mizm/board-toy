package spring.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
import java.util.UUID;

@EnableJpaAuditing
@Configuration
public class JpaConfig {

    @Bean
	public AuditorAware<String> auditorProvider() {
		//security를 통해 유저아이디를 꺼내오자.
		return () -> Optional.of(UUID.randomUUID().toString());
	}
}
