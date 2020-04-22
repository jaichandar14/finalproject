package niit.middleware.configuration;

import javax.servlet.Filter;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import niit.middleware.filter.CFilter;



public class WebappInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {RestConfigmw.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}
	
	protected Filter[] gwtServletFilters() {
		Filter[] singleton =  { new CFilter() };
		return singleton;
	}

}
