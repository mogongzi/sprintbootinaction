package spring.chapter3.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;

@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;
    private ResourceLoader loader;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void outputResult() {
        System.out.println("Bean name: " + beanName);

        Resource resource = loader.getResource("classpath:demo/chapter3/aware/test.txt");
        try {
            System.out.println("ResourceLoader loads file content is: " + IOUtils.toString(resource.getInputStream(), Charset.defaultCharset()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
