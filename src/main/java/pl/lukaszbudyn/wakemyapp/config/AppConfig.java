package pl.lukaszbudyn.wakemyapp.config;

import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = { "pl.lukaszbudyn.wakemyapp.controller",
								"pl.lukaszbudyn.wakemyapp.entity",
								"pl.lukaszbudyn.wakemyapp.bean"})
@EnableWebMvc
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = {"pl.lukasz.sparepartmanager.repository"})
//@Import({ SecurityConfig.class })
public class AppConfig extends WebMvcConfigurerAdapter {
	
//	@Value("${spring.datasource.url}")
//	private String dbUrl;
	
//	@Bean
//	public DataSource dataSource() throws SQLException {
//		if (dbUrl == null || dbUrl.isEmpty()) {
//			return new HikariDataSource();
//		} else {
//			HikariConfig config = new HikariConfig();
//			config.setJdbcUrl(dbUrl);
//			return new HikariDataSource(config);
//		}
//	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

//	@Bean
//	public LocalEntityManagerFactoryBean entityManagerFactory() {
//		LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
//		emfb.setPersistenceUnitName("spare_part_manager2");
//		return emfb;
//	}
//
//	@Bean
//	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
//		JpaTransactionManager tm = new JpaTransactionManager(emf);
//		return tm;
//	}
	
	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}

}
