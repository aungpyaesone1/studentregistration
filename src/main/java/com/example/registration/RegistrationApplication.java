package com.example.registration;

import com.example.registration.Config.CustomAnno;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.lang.annotation.Annotation;
import java.util.Set;

@SpringBootApplication
@EnableScheduling
public class RegistrationApplication{

	public static void main(String[] args) {
		SpringApplication.run(RegistrationApplication.class, args);
		Logger log = LoggerFactory.getLogger(RegistrationApplication.class);
		Reflections reflections1 = new Reflections("com.example.registration", new TypeAnnotationsScanner(), new SubTypesScanner());
		Set<Class<?>> allClasses = reflections1.getTypesAnnotatedWith(CustomAnno.class);
		for (Class clazz : allClasses) {
			Annotation[] annotations = clazz.getAnnotations();
			for (Annotation annotation : annotations) {
				if (annotation instanceof CustomAnno) {
					CustomAnno myAnnotation = (CustomAnno) annotation;
					log.info(String.format("[name=%s, className=%s]",myAnnotation.name(),clazz.getName()));
				}
			}
		}
	}

}
