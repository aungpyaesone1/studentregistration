package com.example.registration;

import com.example.registration.Config.CustomAnno;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.lang.annotation.Annotation;
import java.util.Set;

@SpringBootApplication
@EnableScheduling
public class RegistrationApplication{

	public static void main(String[] args) {
		SpringApplication.run(RegistrationApplication.class, args);
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
		scanner.addIncludeFilter(new AnnotationTypeFilter(CustomAnno.class));
		Set<BeanDefinition> definitions = scanner.findCandidateComponents("com.example.registration");
		for(BeanDefinition b: definitions){
			System.out.println(b.getBeanClassName());
			System.out.println(b.getAttribute("name"));
		}
		Reflections reflections1 = new Reflections("com.example.registration", new TypeAnnotationsScanner(), new SubTypesScanner());
		Set<Class<?>> allClasses = reflections1.getTypesAnnotatedWith(CustomAnno.class);
		System.out.println(allClasses.size());

		for (Class clazz : allClasses) {
			Annotation[] annotations = clazz.getAnnotations();
			for (Annotation annotation : annotations) {
				if (annotation instanceof CustomAnno) {
					CustomAnno myAnnotation = (CustomAnno) annotation;
					System.out.println("value: " + myAnnotation.name());
				}
			}
		}
	}

}
