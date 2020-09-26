package diana.springframework.config;

import diana.springframework.examplebeans.FakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
//indicate that those datasource properties are to be used, from my properties file
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

    //spring expression language = ${smth} = value of expression
    @Value("${diana.username}")
    String user;

    @Value("${diana.password}")
    String password;

    @Value("${diana.dburl}")
    String url;

    //setting the properties to the fake data source
    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    //this allows us to wire up by value - it matches up our properties by values
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
