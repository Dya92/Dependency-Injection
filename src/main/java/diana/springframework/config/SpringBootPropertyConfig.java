package diana.springframework.config;

import diana.springframework.examplebeans.FakeDataSource;
import diana.springframework.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootPropertyConfig {

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

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
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
}
