package diana.springframework.config;

import diana.springframework.examplebeans.FakeDataSource;
import diana.springframework.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
//indicate that those datasource properties are to be used, from my properties file
//@PropertySource("classpath:datasource.properties")
//can take a list of values => @PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
//a never version of doing it
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

    //@Autowire but spring wants constructor for environment
    Environment env;

    public PropertyConfig(Environment env) {
        this.env = env;
    }

    //spring expression language = ${smth} = value of expression
    @Value("${diana.username}")
    String user;

    @Value("${diana.password}")
    String password;

    @Value("${diana.dburl}")
    String url;

    @Value("${diana.jms.username}")
    String jmsUsername;

    @Value("${diana.jms.password}")
    String jmsPassword;

    @Value("${diana.jms.url}")
    String jmsUrl;

    //setting the properties to the fake data source
    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        //get the user properties that I manually set in Edit Configuration -> Environment Variables
        //because the name of the system variable is USERNAME
        //if it were DIANA_USERNAME, this wouldn't be necessary as is sorta matches the property name from datasource.properties
        fakeDataSource.setUser(env.getProperty("USERNAME"));
        //fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUser(jmsUsername);
        fakeJmsBroker.setPass(jmsPassword);
        fakeJmsBroker.setUrl(jmsUrl);
        return fakeJmsBroker;
    }

    //this allows us to wire up by value - it matches up our properties by values
    //works just fine without this bean
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
